package com.shopstack.entities.employee;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class ShopEmployee {

		private int employeeId;
		//reference shop_id column
		private String first_name;
		private String last_name;
		private String email;
		private String address;
		private String role;
		private int contactNumber;
		private String userName;
		private String password;
		private Date date_added;
}
