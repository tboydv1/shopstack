package com.shopstack.service.shop;

import java.util.List;

import com.shopstack.entities.shop.Shop;

public interface ShopService {

	public void addShop(Shop theShop);
	
	public List<Shop> getShops();
}
