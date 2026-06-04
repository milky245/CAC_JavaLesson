package jp.co.sss.shop.lesson02.form;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * コメント登録・更新画面で利用するフォームクラスです。
 *
 * 画面入力値を受け取り、入力チェックを行います。
 */
public class CommentForm {

	/** 更新対象のコメントIDです。登録時は未設定です。 */
	private Integer id;

	/** コメントの投稿日時です。編集画面で表示するために利用します。 */
	private Date createdTime;

	/** コメント本文です。未入力不可、255文字以内の入力チェックを行います。 */
	@NotBlank
	@Size(max = 255)
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * 投稿日時を設定します。
	 *
	 * @param createdTime 投稿日時
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getText() {
		return text;
	}

	/**
	 * コメント本文を設定します。
	 *
	 * @param text コメント本文
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "CommentForm [id=" + id + ", createdTime=" + createdTime + ", text=" + text + "]";
	}

	/** フォーム生成用のデフォルトコンストラクタです。 */
	public CommentForm() {
	}

}
