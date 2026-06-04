//package jp.co.sss.shop.lesson01.web;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import jakarta.servlet.http.HttpSession;
//import jp.co.sss.shop.lesson01.form.LoginForm;
//
//@Controller
//public class LoginController {
//
//	//ログイン画面表示
//	@RequestMapping("lesson01/login")
//	public String showLogin() {
//		return "lesson01/login";
//	}
//
//	//パラメータのIDとPASSWORDが
//	//	指定通りであればIDをセッションスコープに登録しトップ画面へ
//	//	間違っていればエラーメッセージをリクエストスコープに登録しログイン画面へ遷移する
//	@RequestMapping("lesson01/top")
//	public String doLogin(LoginForm loginForm, HttpSession session, Model model) {
//		if
//		(loginForm.getId() != null
//				&& loginForm.getId() == 1111
//				&& "aaa@123".equals(loginForm.getPassword()))
//		{
//			session.setAttribute("id", loginForm.getId());
//			return "lesson01/top";
//		} else {
//			model.addAttribute("errorMessage", "入力ミスです");
//			return "lesson01/login";
//		}
//	}
//
//	//詳細画面表示
//	@RequestMapping("lesson01/detail")
//	public String showDetail(Model model) {
//
//		String name = "Xue Zhihan";// 自分の名前を入れる
//		//名前をリクエストスコープに登録する
//		model.addAttribute("name", name);
//
//		return "lesson01/detail";
//	}
//
//}
