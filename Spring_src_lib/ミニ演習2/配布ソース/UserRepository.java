package jp.co.sss.shop.lesson02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.sss.shop.lesson02.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByIdAndPassword(Integer id, String password);

}
