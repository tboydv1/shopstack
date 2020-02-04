package com.shopstack.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopstack.dao.shop.ShopDao;
import com.shopstack.entities.shop.Shop;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDao shopDaoImpl;
	
	@Override
	public void addShop(Shop tempShop) {
	
		shopDaoImpl.addShop(tempShop);
		
	}

	@Override
	public List<Shop> getShops() {
		// TODO Auto-generated method stub
		
		return shopDaoImpl.getShops();
	}

	
}
