package jp.co.sss.shop.controller;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.shop.form.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import jp.co.sss.shop.form.LoginFormWithValidation;
import jp.co.sss.shop.form.LoginFormWithAnnotation;

@Controller
public class SessionController {

	// 4章 ソースコード4-1 作成
	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		return "session/login";
	}

	// 4章 ソースコード4-1 作成
	@RequestMapping(path = "/doLogin", method = RequestMethod.GET)
	public String doLoginGet(Integer userId) {
		System.out.println("user ID:" + userId);
		return "session/login";
	}

	// 4章 ソースコード4-3 追加
	@RequestMapping(path = "/doLogin",method = RequestMethod.POST)
	public String doLoginPost(Integer userId) {
		System.out.println("user ID:" + userId);
		return "session/login";
	}

	// 4章 ソースコード4-6 追加
	@RequestMapping(path = "/loginUsingForm",method = RequestMethod.GET)
	public String loginUsingForm() {
		return "session/login_using_form";
	}

	@RequestMapping(path = "/doLoginUsingForm",method = RequestMethod.POST)
	public String doLoginUsingForm(LoginForm form) {
		System.out.println("ユーザ ID:" + form.getUserId());
		System.out.println("パスワード:" + form.getPassword());
		return "session/login_using_form";
	}

	// 5章 ソースコード5-1 追加
	@RequestMapping(path = "/loginOnRequest",method = RequestMethod.GET)
	public String loginOnRequest() {
		return "session/login_on_request";
	}

	@RequestMapping(path = "/doLoginOnRequest",method = RequestMethod.POST)
	public String doLoginOnRequest(LoginForm form, Model model) {
		model.addAttribute("userId",form.getUserId());
		return "session/login_on_request";
	}

	// 5章 ソースコード5-3 追加
	@RequestMapping(path = "/loginOnSession",method = RequestMethod.GET)
	public String loginOnSession() {
		return "session/login_on_session";
	}

	@RequestMapping(path = "/doLoginOnSession",method = RequestMethod.POST)
	public String doLoginOnSession(LoginForm form, HttpSession session) {
		if (form.getUserId() == 123) {
//入力したユーザID をセッション属性 userId としてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/login_on_session";
		}
	}

	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
//セッションの破棄
		session.invalidate();
		return "redirect:/";
	}

	// 9章 ソースコード9-2 追加
	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.GET)
	public String loginWithValidation(@ModelAttribute LoginFormWithValidation form) {
		return "session/login_with_validation";
	}
	@RequestMapping(path = "/loginWithValidation", method = RequestMethod.POST)
	public String doLoginWithValidation(
			@Valid @ModelAttribute LoginFormWithValidation form,
			BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			return "session/login_with_validation";
		}
		if (form.getUserId() == 123) {
			//入力したユーザID をセッション属性 userId としてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/login_with_validation";
		}
	}

	// 10章 ソースコード10-4 追加
	@RequestMapping(path = "/loginWithAnnotation", method = RequestMethod.GET)
	public String loginWithAnnotation(@ModelAttribute LoginFormWithAnnotation form) {
		return "session/login_with_annotation";
	}
	@RequestMapping(path = "/loginWithAnnotation", method = RequestMethod.POST)
	public String doLoginWithAnnotation(@Valid @ModelAttribute LoginFormWithAnnotation form,
	                                    BindingResult result,HttpSession session) {
		if (result.hasErrors()) {
			return "session/login_with_annotation";
		}
		if (form.getUserId() == 123) {
			//入力したユーザID をセッション属性userId としてセッションスコープに保存
			session.setAttribute("userId", form.getUserId());
			return "redirect:/";
		} else {
			return "session/login_with_annotation";
		}
	}

	// 13章 ソースコード13-1 追加
	//	@RequestMapping(path = "/loginOnFlash", method = RequestMethod.GET)
	//	public String loginOnFlash(Model model) {
	//		//スコープ中に「loginForm」という名前のデータがなかったら(入力エラーがなかったら) 
	//		// 新規に Form クラスのデータを作成して、リクエストスコープに保存する。
	//		if (!model.containsAttribute("loginFormWithValidation")) {
	//			model.addAttribute("loginFormWithValidation", new LoginFormWithValidation());
	//		}
	//		return "session/loginOnFlash";
	//	}

	// 13章 ソースコード13-1 追加
	//	@RequestMapping(path = "/doLoginOnFlash", method = RequestMethod.POST)
	//	public String doLoginOnFlash(@Valid @ModelAttribute LoginFormWithValidation form,
	//			BindingResult result, HttpSession session, RedirectAttributes redirectAttributes) {
	//		if (result.hasErrors()) {
	//			// 入力チェック結果の情報をフラッシュスコープに保存
	//			redirectAttributes.addFlashAttribute(
	//					"org.springframework.validation.BindingResult.loginFormWithValidation", result);
	//			// Form クラスの情報をフラッシュスコープに保存
	//			redirectAttributes.addFlashAttribute("loginFormWithValidation", form);
	//			System.out.println("redirect");
	//			return "redirect:/loginOnFlash";
	//		}
	//		if (form.getUserId() == 123) {
	//			//入力したユーザIDをセッション属性userIdとしてセッションスコープに保存
	//			session.setAttribute("userId", form.getUserId());
	//			return "redirect:/";
	//		} else {
	//			return "session/loginOnFlash";
	//		}
	//	}

}
