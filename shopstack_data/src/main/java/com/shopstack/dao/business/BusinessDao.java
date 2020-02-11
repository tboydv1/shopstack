package com.shopstack.dao.business;

import java.util.List;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.user.BusinessUser;



/**
 * @author oluwatobi
 *
 */
public interface BusinessDao {

	public void saveBusiness(Business newBusiness);
	
	public List<Business> getBusinessByOwner(BusinessUser businessUser);
	
	public void deleteBusiness(int shopId);
	
	public Business getBusinessByEmail(String bizEmail);
	
	public void updateBusiness();
	
	public Business getBusinessById(int businessId);
	
}
