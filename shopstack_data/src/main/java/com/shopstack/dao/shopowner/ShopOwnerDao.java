package com.shopstack.dao.shopowner;

import java.util.List;
import com.shopstack.entities.shopowner.ShopOwner;


/**
 * @author oluwatobi
 *
 */
public interface ShopOwnerDao {
	
	public void saveShopOwner(ShopOwner shopOwner);
	
	public List<ShopOwner> getShopOwners();
	
	public List<ShopOwner> findByEmail(String email);

}
