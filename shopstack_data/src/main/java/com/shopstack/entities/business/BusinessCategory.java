package com.shopstack.entities.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="business_category")
public class BusinessCategory {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="biz_category_id")
	private int bizCategoryid;
	
	@NotNull
	@Column(name="biz_category_name")
	private String bizCategoryName;
	
	public BusinessCategory() {
		
	}
	
	public BusinessCategory(String categoryName) {
		
		
		this.bizCategoryName = categoryName;
	}

	public int getBizCategoryid() {
		return bizCategoryid;
	}

	public void setBizCategoryid(int bizCategoryid) {
		this.bizCategoryid = bizCategoryid;
	}

	public String getBizCategoryName() {
		return bizCategoryName;
	}

	public void setBizCategoryName(String bizCategoryName) {
		this.bizCategoryName = bizCategoryName;
	}

	@Override
	public String toString() {
		return "BusinessCategory [bizCategoryid=" + bizCategoryid + ", bizCategoryName=" + bizCategoryName + "]";
	}
	
	
	
	
}
