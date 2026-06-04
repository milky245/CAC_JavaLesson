package jp.co.sss.shop.lesson02.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class LoginForm {

	@NotNull
	@Max(value = 9999)
	private Integer id;

	@NotBlank
	@Size(max = 16)
	private String password;

	public LoginForm(Integer id, String password) {
		this.id = id;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
