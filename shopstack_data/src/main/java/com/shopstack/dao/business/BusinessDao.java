package com.shopstack.dao.business;

import java.util.List;

import com.shopstack.entities.business.Business;
import com.shopstack.entities.business.BusinessCategory;
import com.shopstack.entities.business.BusinessOutlet;
import com.shopstack.entities.business.BusinessServiceType;
import com.shopstack.entities.businessuser.BusinessUser;



/**
 * @author oluwatobi
 *
 */
public interface BusinessDao {

	public void saveBusiness(Business newBusiness);
	
	public List<Business> findByOwner(BusinessUser businessUser);
	
	public Business findByEmail(String bizEmail);
		
	public Business findById(int businessId);
	
	public List<BusinessCategory> findAllCategories();
	
	public List<BusinessServiceType> findAllServiceTypes();
	
	public BusinessOutlet findOutletById(int outletId);
	
}
