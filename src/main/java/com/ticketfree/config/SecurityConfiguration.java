package com.ticketfree.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired private DataSource dataSource;

    @Autowired
    private void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, 1 from user where username=?")
                .authoritiesByUsernameQuery("select username, 'ROLE_USER' from user where username=?");
    }


//    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("USER");
////        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
////        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");//dba have two roles.
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/", "/home", "/index").permitAll()
                .antMatchers("/resources/**").permitAll()
//                .antMatchers("/admin/**").access("hasRole('ADMIN')")
                .antMatchers("/**").access("hasRole('USER')")
//                .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .and().formLogin().successForwardUrl("/mainPage")
                .and().exceptionHandling().accessDeniedPage("/Access_Denied")
                .and().csrf().disable();

    }
}
