/**
 * 
 */
package com.shopstack.entities.productcategory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author RAY-ABEL
 *
 */
@Entity
@Table(name="category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int categoryId;
	
	@NotNull
	@Column(name="category_name")
	private String categoryName;
	
	public ProductCategory() {
		
	}
	
	
	public ProductCategory(@NotNull String categoryName) {
		this.categoryName = categoryName;
	}


   
	public String getCategoryName() {
		return categoryName;
	}
 
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getCategory_id() {
		return categoryId;
	}
	
	
}
