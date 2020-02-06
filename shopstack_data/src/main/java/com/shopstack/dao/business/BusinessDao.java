package com.shopstack.dao.business;

import com.shopstack.entities.business.Business;

public interface BusinessDao {

	public void saveBusiness(Business newBusiness);
	
	public void deleteBusiness(int shopId);
	
	public void updateBusiness();
	

}
