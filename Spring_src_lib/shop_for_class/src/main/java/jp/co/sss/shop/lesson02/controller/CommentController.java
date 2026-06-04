package jp.co.sss.shop.lesson02.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.lesson02.entity.Comment;
import jp.co.sss.shop.lesson02.entity.User;
import jp.co.sss.shop.lesson02.form.CommentForm;
import jp.co.sss.shop.lesson02.repository.CommentRepository;

/**
 * コメント機能を担当するコントローラクラスです。
 *
 * ログインユーザーに紐づくコメントの一覧表示、検索、登録、更新、削除を行います。
 */
@Controller
public class CommentController {

	/** コメントテーブルへアクセスするためのRepositoryです。 */
	@Autowired
	CommentRepository commentRepository;

	/** ログインユーザー情報を取得するためのセッションです。 */
	@Autowired
	HttpSession session;

	/**
	 * ログインユーザーのコメント一覧を表示します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param commentForm コメント入力フォーム
	 * @return コメント一覧画面、未ログインの場合はログイン画面へのリダイレクト
	 */
	@RequestMapping(path = "/top-comment")
	public String showComment(Model model, @ModelAttribute CommentForm commentForm) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		model.addAttribute("commentList", commentRepository.findByUser(loginUser));
		return "lesson02/top";
	}

	/**
	 * ログインユーザーのコメント一覧を投稿日時の降順で表示します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param commentForm コメント入力フォーム
	 * @return コメント一覧画面、未ログインの場合はログイン画面へのリダイレクト
	 */
	@RequestMapping(path = "/top-comment/date-desc")
	public String orderByCreatedDateDesc(Model model, @ModelAttribute CommentForm commentForm) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		model.addAttribute("commentList", commentRepository.findByUserOrderByCreatedTimeDesc(loginUser));
		return "lesson02/top";
	}

	/**
	 * 入力された文字列を含むコメントをあいまい検索します。
	 *
	 * 検索文字列が未入力の場合は、ログインユーザーのコメントをすべて表示します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param searchText 検索キーワード
	 * @param commentForm コメント入力フォーム
	 * @return コメント一覧画面、未ログインの場合はログイン画面へのリダイレクト
	 */
	@RequestMapping(path = "/top-comment/search-comment", method = RequestMethod.GET)
	public String searchComments(Model model, String searchText, @ModelAttribute CommentForm commentForm) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		List<Comment> commentList;
		if (searchText == null || searchText.isBlank()) {
			// 検索文字列が空の場合は、通常の一覧表示と同じ内容を取得します。
			commentList = commentRepository.findByUser(loginUser);
		} else {
			commentList = commentRepository.findByUserAndTextContaining(loginUser, searchText);
		}
		model.addAttribute("commentList", commentList);
		model.addAttribute("searchText", searchText);

		return "lesson02/top";
	}

	/**
	 * 入力されたコメントを登録します。
	 *
	 * 入力チェックエラーがある場合は、コメント一覧画面に戻してエラーを表示します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param commentForm 登録対象のコメントフォーム
	 * @param result 入力チェック結果
	 * @return 登録成功時は一覧画面へリダイレクト、エラー時は一覧画面
	 */
	@RequestMapping(path = "/addComment", method = RequestMethod.POST)
	public String addComment(Model model, @Valid @ModelAttribute CommentForm commentForm, BindingResult result) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		if (result.hasErrors()) {
			model.addAttribute("commentList", commentRepository.findByUser(loginUser));
			model.addAttribute("formMessage", "コメントを登録できませんでした。入力内容を確認してください。");
			return "lesson02/top";
		}

		Comment comment = new Comment();
		// 入力内容、投稿日時、投稿者をEntityに設定して保存します。
		comment.setText(commentForm.getText());
		comment.setCreatedTime(new Date());
		comment.setUser(loginUser);
		commentRepository.save(comment);

		return "redirect:/top-comment";
	}

	/**
	 * 指定されたコメントの編集画面へ遷移します。
	 *
	 * 他ユーザーのコメントIDが指定された場合は、一覧画面へ戻します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param id 編集対象コメントID
	 * @param commentForm 編集画面へ渡すコメントフォーム
	 * @return コメント編集画面、またはコメント一覧画面へのリダイレクト
	 */
	@RequestMapping(path = "/top-comment/edit/{id}", method = RequestMethod.POST)
	public String editComment(Model model, @PathVariable Integer id, @ModelAttribute CommentForm commentForm) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		Optional<Comment> commentOptional = commentRepository.findByIdAndUser(id, loginUser);
		if (commentOptional.isEmpty()) {
			return "redirect:/top-comment";
		}

		copyToForm(commentOptional.get(), commentForm);
		model.addAttribute("commentForm", commentForm);

		return "lesson02/edit_comment";
	}

	/**
	 * 編集画面で入力された内容でコメントを更新します。
	 *
	 * 入力チェックエラーがある場合は、編集画面に戻してエラーを表示します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param form 更新対象のコメントフォーム
	 * @param result 入力チェック結果
	 * @return 更新成功時は一覧画面へリダイレクト、エラー時は編集画面
	 */
	@RequestMapping(path = "/top-comment/exe-update", method = RequestMethod.POST)
	public String editExe(Model model, @Valid @ModelAttribute CommentForm form, BindingResult result) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		Optional<Comment> commentOptional = commentRepository.findByIdAndUser(form.getId(), loginUser);
		if (commentOptional.isEmpty()) {
			return "redirect:/top-comment";
		}

		Comment comment = commentOptional.get();
		// エラー時にも投稿日時を画面に再表示できるよう、既存の値をフォームへ戻します。
		form.setCreatedTime(comment.getCreatedTime());

		if (result.hasErrors()) {
			model.addAttribute("commentForm", form);
			model.addAttribute("formMessage", "コメントを更新できませんでした。入力内容を確認してください。");
			return "lesson02/edit_comment";
		}

		comment.setText(form.getText());
		commentRepository.save(comment);

		return "redirect:/top-comment";
	}

	/**
	 * コメント削除確認画面を表示します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @return コメント削除確認画面、未ログインの場合はログイン画面へのリダイレクト
	 */
	@RequestMapping(path = "/top-comment/check-delete", method = RequestMethod.GET)
	public String checkDeleteComment(Model model) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		model.addAttribute("commentList", commentRepository.findByUser(loginUser));
		return "lesson02/delete_check_comment";
	}

	/**
	 * 選択されたコメントを削除します。
	 *
	 * 削除対象はログインユーザー本人のコメントだけに限定します。
	 *
	 * @param model 画面へ渡すデータを格納するModel
	 * @param checkIds 削除対象として選択されたコメントID配列
	 * @return コメント一覧画面へのリダイレクト
	 */
	@RequestMapping(path = "/top-comment/exe-delete", method = RequestMethod.POST)
	public String exeDelete(Model model, String[] checkIds) {
		User loginUser = getLoginUser();
		if (loginUser == null) {
			return "redirect:/login-page";
		}

		if (checkIds != null && checkIds.length != 0) {
			for (String id : checkIds) {
				commentRepository.findByIdAndUser(Integer.parseInt(id), loginUser)
						.ifPresent(commentRepository::delete);
			}
		}
		return "redirect:/top-comment";
	}

	/**
	 * セッションからログインユーザー情報を取得します。
	 *
	 * @return ログインユーザー、未ログインの場合はnull
	 */
	private User getLoginUser() {
		return (User) session.getAttribute("loginUser");
	}

	/**
	 * コメントEntityの内容をフォームへコピーします。
	 *
	 * @param comment コピー元のコメントEntity
	 * @param form コピー先のコメントフォーム
	 */
	private void copyToForm(Comment comment, CommentForm form) {
		form.setId(comment.getId());
		form.setCreatedTime(comment.getCreatedTime());
		form.setText(comment.getText());
	}
}
