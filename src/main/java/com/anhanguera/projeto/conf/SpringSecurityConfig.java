package com.anhanguera.projeto.conf;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;

	 @Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
	            .dataSource(dataSource)
	            .usersByUsernameQuery("select username, password, enabled from users where username=?")
	            .authoritiesByUsernameQuery("select username, role from users where username=?")
	        ;
	    }
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/user/").hasRole("ADMIN")
		.antMatchers("/user").hasRole("ADMIN")
        .and()
        .httpBasic();
		
		http.csrf().disable();
	}	
	
}
