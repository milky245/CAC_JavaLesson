package jp.co.sss.shop.controller;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.ItemWithCategory;
import jp.co.sss.shop.repository.ItemWithCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable; //7章 ソースコード7-9 追加
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemWithCategoryController {
	@Autowired
    ItemWithCategoryRepository repository;

	@Autowired
    EntityManager entityManager;

	@RequestMapping("/items/findItemAndCategory")
	public String showItemAndCategoryList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_category_list";
	}


	//7章 ソースコード7-9 追加
	@RequestMapping("/items/searchByCategoryId/{categoryId}")
	public String searchByCategoryId(@PathVariable Integer categoryId, Model model) {
		//外部参照先テーブルに対応付けられたエンティティ Category のオブジェクトを生成
		Category category = new Category();
		//Category のオブジェクト内の id フィールドにパラメータの値を代入
		category.setId(categoryId);
		//Category のオブジェクト内の id フィールドを使用した条件検索を実行
		List<ItemWithCategory> items = repository.findByCategory(category);

		//検索結果をリクエストスコープに保存
		model.addAttribute("items", items);
		//商品一覧画面に遷移
		return "items/item_category_list";
	}

	//8章 ソースコード8-2 追加
	@RequestMapping("/items/searchWithNamedQuery/{id}")
	public String searchWithNamedQuery(@PathVariable Integer id, Model model) {
		Query query = entityManager.createNamedQuery("findByIdNamedQuery");
		query.setParameter("id", id);
		model.addAttribute("items", query.getResultList());
		return "items/item_category_list";
	}

	//8章 ソースコード8-5 追加
	@RequestMapping("/items/searchWithQuery/{id}")
	public String searchWithQuery(@PathVariable Integer id,Model model) {
		model.addAttribute("items", repository.findByIdQuery(id));
		return"items/item_category_list";
	}

	//8章 ソースコード8-7 追加
	@RequestMapping("/items/searchWithQuery")
	public String searchWithQuery(Model model) {
		model.addAttribute("items",
				repository.findByPriceGreaterThanEqualAVGPriceQuery());
		return"items/item_category_list";
	}

}
