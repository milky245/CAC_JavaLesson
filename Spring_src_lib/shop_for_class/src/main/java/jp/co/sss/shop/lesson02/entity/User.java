package jp.co.sss.shop.lesson02.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * ユーザー情報を表すEntityクラスです。
 *
 * usersテーブルの1レコードに対応し、ログインID、ユーザー名、パスワードを保持します。
 */
@Entity
@Table(name = "users")
public class User {

	/** ログインにも利用するユーザーIDです。 */
	@Id
	private Integer id;

	/** 画面に表示するユーザー名です。 */
	private String userName;

	/** ログイン認証に利用するパスワードです。 */
	private String password;

	public Integer getId() {
		return id;
	}

	/**
	 * ユーザーIDを設定します。
	 *
	 * @param id ユーザーID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	/**
	 * ユーザー名を設定します。
	 *
	 * @param userName ユーザー名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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

	/*以下は記述がなくても可*/
	//ユーザは複数のコメントを保持できる（一対多）
	/** ユーザーが投稿したコメント一覧です。 */
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", comments=" + comments + "]";
	}

	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * ユーザーに紐づくコメント一覧を設定します。
	 *
	 * @param comments コメント一覧
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}
