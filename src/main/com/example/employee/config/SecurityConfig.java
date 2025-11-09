package com.example.employee.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(NoOpPasswordEncoder.getInstance())
            .withUser("hr").password("hrpass").roles("HR")
            .and()
            .withUser("employee").password("emppass").roles("EMPLOYEE");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/employees/new", "/employees/delete/**", "/employees/edit/**").hasRole("HR")
                .antMatchers("/employees/**").authenticated()
                .and()
            .formLogin()
                .defaultSuccessUrl("/employees", true)
                .and()
            .logout()
                .and()
            .csrf().disable()
            .headers().frameOptions().disable();
    }
}
