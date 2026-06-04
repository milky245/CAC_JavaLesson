package jp.co.sss.shop.lesson02.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * コメント情報を表すEntityクラスです。
 *
 * commentsテーブルの1レコードに対応し、投稿日時、本文、投稿者を保持します。
 */
@Entity
@Table(name = "comments")
public class Comment {

	/** コメントIDです。シーケンスを利用して自動採番されます。 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_comments_gen")
	@SequenceGenerator(name = "seq_comments_gen", sequenceName = "seq_comments", allocationSize = 1)
	private Integer id;

	/** コメントが投稿された日時です。 */
	private Date createdTime;

	/** コメント本文です。 */
	private String text;

	//コメントの投稿者は1人に決まる（多対一）
	/** コメントを投稿したユーザーです。 */
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	public User getUser() {
		return user;
	}

	/**
	 * コメント投稿者を設定します。
	 *
	 * @param user 投稿者ユーザー
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/** Entity生成用のデフォルトコンストラクタです。 */
	public Comment() {
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", createdTime=" + createdTime + ", text=" + text + ", user=" + user + "]";
	}

	public Integer getId() {
		return id;
	}

	/**
	 * コメントIDを設定します。
	 *
	 * @param id コメントID
	 */
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

}
