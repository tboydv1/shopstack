package com.shopstack.entities.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import com.shopstack.entities.businessuser.BusinessUser;


/**
 * @author oluwatobi
 *
 */

@Entity
@Table(name="ss_business")
public class Business {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="biz_id")
	private int bizId;
	
	@NotNull
	@Column(name="biz_name")
	private String bizName;
	
	@Column(name="biz_logo")
	private String bizLogoUri;
	
	@NotNull
	@Column(name="biz_email")
	private String bizEmail;
	
	@Column(name="biz_website")
	private String bizWebsite;
	
	@Column(name="biz_phone")
	private String bizPhone;
	
	@CreationTimestamp
	@Column(name="date_created")
	private Date dateAdded;
	
	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="biz_category_id")
	@LazyToOne(LazyToOneOption.NO_PROXY)
	private BusinessCategory bizCategory;
	
	@NotNull()
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="biz_service_id")
	private BusinessServiceType bizService;
	
	@OneToMany(mappedBy="businessId", cascade=CascadeType.ALL)
	private List<BusinessOutlet> businessOutlets;
	
	@NotNull
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="biz_creator")
	private BusinessUser creator;
	
	public Business() {
		
	}

	public Business(String bizName, @NotNull String email, @NotNull BusinessCategory bizCategory,
			@NotNull BusinessServiceType bizService, @NotNull BusinessUser creator) {
		
		this.bizName = bizName;
		this.bizEmail = email;
		this.bizCategory = bizCategory;
		this.bizService = bizService;
		this.creator = creator;
	}





	public int getBizId() {
		return bizId;
	}

	public void setBizId(int bizId) {
		this.bizId = bizId;
	}


	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizLogoUri() {
		return bizLogoUri;
	}

	public void setBizLogoUri(String bizLogoUri) {
		this.bizLogoUri = bizLogoUri;
	}

	public String getBizEmail() {
		return bizEmail;
	}

	public void setBizEmail(String bizEmail) {
		this.bizEmail = bizEmail;
	}

	public String getBizWebsite() {
		return bizWebsite;
	}

	public void setBizWebsite(String bizWebsite) {
		this.bizWebsite = bizWebsite;
	}

	public String getBizPhone() {
		return bizPhone;
	}

	public void setBizPhone(String bizPhone) {
		this.bizPhone = bizPhone;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	public void addBusinessOutlet(BusinessOutlet tempBusinessOutlet) {
		
		if(businessOutlets == null) {
			businessOutlets = new ArrayList<>();
		}
		businessOutlets.add(tempBusinessOutlet);
	}
	
	
	

	public BusinessCategory getBizCategory() {
		return bizCategory;
	}

	public void setBizCategory(BusinessCategory bizCategory) {
		this.bizCategory = bizCategory;
	}

	public BusinessServiceType getBizService() {
		return bizService;
	}

	public void setBizService(BusinessServiceType bizService) {
		this.bizService = bizService;
	}

	public List<BusinessOutlet> getBusinessOutlets() {
		return businessOutlets;
	}

	public void setBusinessOutlets(List<BusinessOutlet> businessOutlets) {
		this.businessOutlets = businessOutlets;
	}
	
	

	public BusinessUser getCreator() {
		return creator;
	}

	public void setCreator(BusinessUser creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Business [bizId=" + bizId + ", bizName=" + bizName + ", bizLogoUri=" + bizLogoUri + ", bizEmail="
				+ bizEmail + ", bizWebsite=" + bizWebsite + ", bizPhone=" + bizPhone + ", dateAdded=" + dateAdded
				+ ", bizCategory=" + bizCategory + ", bizService=" + bizService + ", businessOutlets=" + businessOutlets
				+ ", creator=" + creator + "]";
	}

	
	
	

	
}