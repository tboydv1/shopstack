package com.shopstack.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			
		auth.jdbcAuthentication().dataSource(securityDataSource)
								.usersByUsernameQuery("select ss_email, ss_password, ss_enabled "
							        + "from ss_user "
							        + "where ss_email = ?")
								.authoritiesByUsernameQuery("select role, user_email"
							        + "from role "
							        + "where user_email = ?");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http
	        .authorizeRequests()
	        .antMatchers("/**").permitAll()
		.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.defaultSuccessUrl("/shop-owner/dashboard")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		
//	    web.ignoring().antMatchers("/");
	}

	
	
	
	
}
