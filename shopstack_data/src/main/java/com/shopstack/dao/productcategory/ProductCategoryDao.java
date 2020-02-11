package com.shopstack.dao.productcategory;

import java.util.List;
/**
 * @author RAY-ABEL
 *
 */

import com.shopstack.entities.productcategory.ProductCategory;

public interface ProductCategoryDao {

	public List<ProductCategory> getProductCategory();
	
	public void saveUser(ProductCategory newProductCategory);
}
