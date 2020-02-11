package com.shopstack.entities.user;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="verification_token")
public class VerificationToken {

	
	private static final int Expiration = 60 * 24;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="token_id")
	private int id;
		
	@Column(name="token")
	private String token;
	
	@OneToOne(targetEntity=BusinessUser.class)
	@JoinColumn(nullable = false, name="ss_user_id", foreignKey = @ForeignKey(name="fk_verification_token_ss_user1"))
	private BusinessUser businessUser;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	public VerificationToken() {
		
	}
	
	public VerificationToken(final String token) {
		
		this.token = token;
		this.expiryDate = calculateExpiryDate(Expiration);
	}
	
	
	public VerificationToken(final String token, final BusinessUser businessUser) {
			
		this.token = token;
		this.businessUser = businessUser;
		this.expiryDate = calculateExpiryDate(Expiration);
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		
		final Calendar cal = Calendar.getInstance();
			
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
			
		return new Date(cal.getTime().getTime());
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public BusinessUser getUser() {
		return businessUser;
	}

	public void setUser(BusinessUser businessUser) {
		this.businessUser = businessUser;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public static int getExpiration() {
		return Expiration;
	}

	@Override
	public String toString() {
		return "VerificationToken [id=" + id + ", token=" + token + ", user=" + businessUser + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
	
	
	
	
	
}
