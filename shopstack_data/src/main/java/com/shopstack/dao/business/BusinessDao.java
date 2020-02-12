package com.shopstack.dao.business;

import java.util.List;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.businessuser.BusinessUser;



/**
 * @author oluwatobi
 *
 */
public interface BusinessDao {

	public void saveBusiness(Business newBusiness);
	
	public List<Business> findByOwner(BusinessUser businessUser);
	
	public void deleteBusiness(int shopId);
	
	public Business findByEmail(String bizEmail);
	
	public void updateBusiness();
	
	public Business findById(int businessId);
	
}
