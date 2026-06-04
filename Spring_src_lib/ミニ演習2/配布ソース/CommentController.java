
package jp.co.sss.shop.lesson02.controller;

import java.util.List;

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

@Controller
public class CommentController {

	@Autowired
	CommentRepository commentRepository;

	@Autowired
	HttpSession session;

	/**
	 * コメントの全件表示
	 * 
	 * @param model
	 * @return top.html
	 */
	@RequestMapping(path = "/top-comment")
	public String showComment(Model model, @ModelAttribute CommentForm commentForm) {
		User loginUser = (User) session.getAttribute("loginUser");

		List<Comment> commentList = commentRepository.findByUser(loginUser);
		model.addAttribute("commentList", commentList);

		return "lesson02/top";
	}

	/**
	 * コメントの並び替え
	 * 
	 * @param model
	 * @param commentId
	 * @return top
	 */
	@RequestMapping(path = "/top-comment/date-desc")
	public String orderByCreatedDateDesc(Model model, @ModelAttribute CommentForm commentForm) {

		User loginUser = (User) session.getAttribute("loginUser");

		model.addAttribute("commentList", commentRepository.findByUserOrderByCreatedTimeDesc(loginUser));
		return "lesson02/top";
	}

	/**
	 * コメントのあいまい検索
	 * 
	 * @param model
	 * @param searchText
	 * @return
	 */
	@RequestMapping(path = "/top-comment/search-comment")
	public String searchComments(Model model, String searchText, @ModelAttribute CommentForm commentForm) {

		//TODO あいまい検索

		return "lesson02/top";
	}

	/**
	 * コメントの登録機能
	 * 
	 * @param text
	 * @return redirect:/top-comment 全件表示
	 */
	@RequestMapping(path = "/addComment", method = RequestMethod.POST)
	public String addComment(@Valid @ModelAttribute CommentForm commentForm, BindingResult result) {

		//TODO エラー判定と登録処理

		return "redirect:/top-comment";
	}

	/**
	 * コメント編集画面遷移
	 * 
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/top-comment/edit/{id}")
	public String editComment(Model model, @PathVariable Integer id, @ModelAttribute CommentForm commentForm) {

		//TODO 更新前のデータ検索とスコープ登録

		return "lesson02/edit_comment";
	}

	/**
	 * コメント変更実施
	 * 
	 * @param model
	 * @param form
	 * @return
	 */
	@RequestMapping(path = "/top-comment/exe-update")
	public String editExe(@Valid @ModelAttribute CommentForm form, BindingResult result) {

		//TODO エラー判定と更新処理

		return "redirect:/top-comment";
	}

	/**
	 * 削除画面に遷移
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(path = "/top-comment/check-delete")
	public String checkDeleteComment(Model model) {
		User loginUser = (User) session.getAttribute("loginUser");

		model.addAttribute("commentList", commentRepository.findByUser(loginUser));
		return "lesson02/delete_check_comment";
	}

	/**
	 * コメントの削除機能
	 * 
	 * @param model
	 * @param checkIds 複数のIDを受け取るため配列型
	 * @return
	 */
	@RequestMapping(path = "/top-comment/exe-delete")
	public String exeDelete(Model model, String[] checkIds) {

		if (checkIds != null && checkIds.length != 0) {
			for (String id : checkIds) {
				commentRepository.deleteById(Integer.parseInt(id));
			}
		}
		return "redirect:/top-comment";
	}

}
