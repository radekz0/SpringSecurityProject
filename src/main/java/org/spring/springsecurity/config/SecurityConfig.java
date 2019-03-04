package org.spring.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    //Configuring security of web paths in application (login, logout etc.)
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()    //Restrict access based on the HttpServletRequest comming in
                .antMatchers("/managers/**").hasRole("MANAGER") //Only managers can access this url ** means every subdirectory
                .antMatchers("/admins/**").hasRole("ADMIN")
                .anyRequest().authenticated()   //For any request comming to the app it must be authenticated (user must be logged in)
                .and()
                .formLogin()    //Customizing the login form
                .loginPage("/showMyLoginPage")  //Custom form for the logging page
                .loginProcessingUrl("/authenticateTheUser") //Login form will post the data to this url for processing, this is where spring will go and check user id and password
                .permitAll()    //Allow for everyone to see the login page
                .and()
                .logout()   //Adding logout support (default url /logout)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}
