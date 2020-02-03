package com.shopstack.dao.shop;

import java.util.List;

import com.shopstack.entities.shop.Shop;

public interface ShopDao {

	public void addShop(Shop tempShop);
	
	public void deleteShop(int shopId);
	
	public void updateShop();
	
	public List<Shop> getShops();

}
