package com.shivesh.flightreservation.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter	 {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(HttpSecurity http) {
		
		try {
			http.authorizeRequests().antMatchers("/showReg","/","/index.html","/registerUser",
					"/login","/showLogin","/login/*","/reservations/*","/css/**",
					"/resources/**","/img/*").permitAll()
			
			.antMatchers("/admin/showAddFlight").hasAnyAuthority("ADMIN").anyRequest().
			authenticated().and().csrf().disable();
			
			http.authorizeRequests().antMatchers("/showReg","/","/index.html","/registerUser",
					"/login","/showLogin","/login/*","/reservations/*","/css/**",
					"/resources/**","/img/*").permitAll().and()
			.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
		
	}

}