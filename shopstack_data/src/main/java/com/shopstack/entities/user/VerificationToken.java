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
	@Column(name="id")
	private int id;
		
	@Column(name="token")
	private String token;
	
	@OneToOne(targetEntity=User.class)
	@JoinColumn(nullable = false, name="user_id", foreignKey = @ForeignKey(name="fk_VerificationToken_user"))
	private User user;
	
	@Column(name="expiry_date")
	private Date expiryDate;
	
	public VerificationToken() {
		
	}
	
	public VerificationToken(final String token) {
		
		this.token = token;
		this.expiryDate = calculateExpiryDate(Expiration);
	}
	
	
	public VerificationToken(final String token, final User user) {
			
		this.token = token;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		return "VerificationToken [id=" + id + ", token=" + token + ", user=" + user + ", expiryDate=" + expiryDate
				+ "]";
	}
	
	
	
	
	
	
	
}
