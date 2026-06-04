package jp.co.sss.shop.lesson02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.lesson02.entity.Comment;
import jp.co.sss.shop.lesson02.entity.User;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	/** ユーザごとのコメント一覧検索
	 * 
	 *  メソッド名のポイント
	 *  外部参照キーを検索する際は結合するEntityクラスを指定する
	 *  	findBy / User (User user)
	 *  
	 *  【参考】UserクラスのユーザIDへのアクセスの仕方は以下の通りになる。これでもOK
	 *    Comment.user.id(Commentクラス内のuser内のid、という意味)
	 *  上記に対するメソッドの記述は
	 *    findBy / User / Id (Integer userId)
	 *  となる
	 *  
	 *  */
	List<Comment> findByUser(User user);

	/** 投稿順並び替え */
	List<Comment> findByUserOrderByCreatedTimeDesc(User user);

	/** TODO　ユーザーごとのコメントあいまい検索 */

}
