package jp.co.sss.shop.repository;

import java.util.List;
import jp.co.sss.shop.entity.Category;
import org.jspecify.annotations.Nullable;
import org.springframework.data.jpa.repository.JpaRepository;
import jp.co.sss.shop.entity.ItemWithCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemWithCategoryRepository extends JpaRepository<ItemWithCategory, Integer> {

    List<ItemWithCategory> findByCategory(Category category);
    @Query("SELECT i FROM ItemWithCategory i WHERE i.id = :id")
    List<ItemWithCategory> findByIdQuery(@Param("id") Integer id);

    @Query("SELECT i FROM ItemWithCategory i WHERE i.price >= "+
            "(SELECT AVG(i2.price) FROM ItemWithCategory i2)")
    List<ItemWithCategory> findByPriceGreaterThanEqualAVGPriceQuery();
}

