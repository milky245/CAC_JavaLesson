package jp.co.sss.shop.lesson02.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * ログイン画面で利用するフォームクラスです。
 *
 * ログインIDとパスワードを受け取り、入力チェックを行います。
 */
public class LoginForm {

	/** ログインIDです。未入力不可、最大9999までの入力チェックを行います。 */
	@NotNull
	@Max(value = 9999)
	private Integer id;

	/** パスワードです。未入力不可、16文字以内の入力チェックを行います。 */
	@NotBlank
	@Size(max = 16)
	private String password;

	/** フォーム生成用のデフォルトコンストラクタです。 */
	public LoginForm() {
	}

	/**
	 * ログインIDとパスワードを指定してフォームを生成します。
	 *
	 * @param id ログインID
	 * @param password パスワード
	 */
	public LoginForm(Integer id, String password) {
		this.id = id;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	/**
	 * ログインIDを設定します。
	 *
	 * @param id ログインID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定します。
	 *
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
