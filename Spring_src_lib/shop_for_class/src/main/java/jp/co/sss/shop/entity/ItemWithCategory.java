package jp.co.sss.shop.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items_with_categories")
@NamedQuery(name="findByIdNamedQuery",
		query="SELECT i FROM ItemWithCategory i WHERE i.id = :id")
public class ItemWithCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
			"seq_items_with_categories_gen")
	@SequenceGenerator(name = "seq_items_with_categories_gen", sequenceName =
			"seq_items_with_categories", allocationSize = 1)

	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Integer price;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	private Category category;

	//getter and setter methods
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
