package jp.co.sss.shop.lesson02.form;

import java.util.Date;

public class CommentForm {

	private Integer id;
	private Date createdTime;

	//TODO アノテーション
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

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "CommentForm [id=" + id + ", createdTime=" + createdTime + ", text=" + text + "]";
	}

	public CommentForm() {
	}

}
