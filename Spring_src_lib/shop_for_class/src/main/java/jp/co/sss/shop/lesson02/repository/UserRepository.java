package jp.co.sss.shop.lesson02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.lesson02.entity.User;

/**
 * ユーザー情報へアクセスするRepositoryインターフェースです。
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	/**
	 * ログインIDとパスワードに一致するユーザーを検索します。
	 *
	 * @param id ログインID
	 * @param password パスワード
	 * @return 認証できたユーザー。存在しない場合はnull
	 */
	User findByIdAndPassword(Integer id, String password);

}
