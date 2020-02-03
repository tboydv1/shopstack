package com.shopstack.service.shopowner;

import java.util.List;

import com.shopstack.entities.shopowner.ShopOwner;

public interface ShopOwnerService {

	public ShopOwner addShopOwner(ShopOwner shopOwner);
	
	public List<ShopOwner> findByEmail(String email);
}
