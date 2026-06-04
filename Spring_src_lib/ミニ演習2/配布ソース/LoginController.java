package jp.co.sss.shop.lesson02.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.shop.lesson02.entity.User;
import jp.co.sss.shop.lesson02.form.LoginForm;
import jp.co.sss.shop.lesson02.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository repository;

	@RequestMapping("/login-page")
	public String showLogin(@ModelAttribute LoginForm loginForm) {

		return "lesson02/login";
	}

	@RequestMapping(path = "/top", method = RequestMethod.POST)
	public String doLogin(@Valid @ModelAttribute LoginForm loginForm, BindingResult result,
			HttpSession session,
			Model model) {
		String path = "lesson02/login";

		if (result.hasErrors()) {
			return path;//ログイン画面に戻る
		}

		User loginUser = repository.findByIdAndPassword(loginForm.getId(), loginForm.getPassword());

		if (loginUser != null) {
			path = "redirect:/top-comment";
			session.setAttribute("loginUser", loginUser);

		} else {
			model.addAttribute("errMsg", "IDまたはパスワードが違います");
		}

		return path;
	}

	@RequestMapping("/do-logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/login-page";
	}

	@RequestMapping("/detail")
	public String showDetail() {

		return "lesson02/detail";
	}

	//参考 /shop/remove-userと打つとユーザーとコメントの両方が消えます。
	//ユーザとコメントを両方をcascade削除（OneToManyの使用例）
	//	@RequestMapping("/remove-user")
	//	public String doRemove(HttpSession session) {
	//		Integer id = (Integer) session.getAttribute("id");
	//		repository.deleteById(id);
	//		session.invalidate();
	//		return "login";
	//	}

}
