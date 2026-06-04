package jp.co.sss.shop.lesson02.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.lesson02.entity.Comment;
import jp.co.sss.shop.lesson02.entity.User;

/**
 * コメント情報へアクセスするRepositoryインターフェースです。
 *
 * Spring Data JPAのメソッド名ルールを利用して検索処理を定義します。
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {

	/**
	 * ユーザごとのコメント一覧検索
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
	 * @param user 検索対象のユーザー
	 * @return ユーザーに紐づくコメント一覧
	 *  */
	List<Comment> findByUser(User user);

	/**
	 * ユーザーに紐づくコメントを投稿日時の降順で検索します。
	 *
	 * @param user 検索対象のユーザー
	 * @return 投稿日時の新しい順に並んだコメント一覧
	 */
	List<Comment> findByUserOrderByCreatedTimeDesc(User user);

	/**
	 * ユーザーに紐づくコメントの中から、本文に指定文字列を含むものを検索します。
	 *
	 * @param user 検索対象のユーザー
	 * @param text 検索キーワード
	 * @return 検索キーワードを含むコメント一覧
	 */
	List<Comment> findByUserAndTextContaining(User user, String text);

	/**
	 * コメントIDとユーザーを条件に、コメントを1件検索します。
	 *
	 * 他ユーザーのコメントを編集・削除しないための確認にも利用します。
	 *
	 * @param id コメントID
	 * @param user 検索対象のユーザー
	 * @return 条件に一致するコメント。存在しない場合は空のOptional
	 */
	Optional<Comment> findByIdAndUser(Integer id, User user);

}
