package com.metacube.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/Image/**","/css/**","/js/**");
    }
	
	/**
	 * This used inbuilt login form of spring security
	 */
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/welcome")
//            .hasAnyRole("USER", "ADMIN").antMatchers("/index")
//            .hasAnyRole("USER", "ADMIN").antMatchers("/getStudents").hasAnyRole("USER", "ADMIN")
//            .antMatchers("/Image/**","/css/**","/js/**").permitAll()
//            .antMatchers("/addStudent").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin()
//            and().logout().permitAll();
//
//        http.csrf().disable();
//    }
//	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/welcome")
            .hasAnyRole("USER", "ADMIN").antMatchers("/index")
            .hasAnyRole("USER", "ADMIN").antMatchers("/getStudents").hasAnyRole("USER", "ADMIN")
            .antMatchers("/Image/**","/css/**","/js/**").permitAll()
            .antMatchers("/addStudent").hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().loginPage("/login")
            .permitAll().defaultSuccessUrl("/welcome").failureUrl("/login?error=true").
            and().logout().permitAll();

        http.csrf().disable();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
        authenticationMgr.inMemoryAuthentication().withUser("user").password("{noop}user")
            .authorities("ROLE_USER").and().withUser("admin").password("{noop}admin")
            .authorities("ROLE_USER", "ROLE_ADMIN");
    }
}
