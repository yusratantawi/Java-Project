package com.htu.project;
 

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends  WebSecurityConfigurerAdapter implements ApplicationContextAware 
{
    // Details omitted for brevity
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
           .csrf().disable();
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
		  .withUser("doctor")
		  .password("{noop}cei@5!")
		  .roles("admin");
////		  .and()
////		  .withUser("user")
//		  .password("{noop}Ahm@d!@#@!")
//		  .roles("user");
		  	

    // Used by spring security if CORS is enabled.
	}
}
	