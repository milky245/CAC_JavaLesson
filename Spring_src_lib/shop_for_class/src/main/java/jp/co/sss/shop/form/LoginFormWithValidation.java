package jp.co.sss.shop.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
public class LoginFormWithValidation {
	@NotNull(message = "ユーザ IDは必須です")
	@Max(value = 999, message = "ユーザ IDは999以下でなければなりません")
	private Integer userId;

	@NotBlank(message = "パスワードは必須です")
	@Size(max = 16, message = "パスワードは16文字以下でなければなりません")
	@Pattern(regexp = "^[a-zA-Z0-9]+$")
	private String password;

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
