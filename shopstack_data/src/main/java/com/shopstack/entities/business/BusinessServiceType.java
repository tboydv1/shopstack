package com.shopstack.entities.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author oluwatobi
 *
 */
@Entity
@Table(name="business_services")
public class BusinessServiceType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="biz_service_id")
	private int bizServiceId;
	
	@Column(name="biz_service_name")
	private String bizServiceName;
	
	public BusinessServiceType() {
		
	}
	
	public BusinessServiceType(String businessService) {
		
		this.bizServiceName = businessService;
	}

	public int getBizServiceId() {
		return bizServiceId;
	}

	public void setBizServiceId(int bizServiceId) {
		this.bizServiceId = bizServiceId;
	}

	public String getBizServiceName() {
		return bizServiceName;
	}

	public void setBizServiceName(String bizServiceName) {
		this.bizServiceName = bizServiceName;
	}

	@Override
	public String toString() {
		return "BusinessService [bizServiceId=" + bizServiceId + ", bizServiceName=" + bizServiceName + "]";
	}
	
	
	
	
	
}
