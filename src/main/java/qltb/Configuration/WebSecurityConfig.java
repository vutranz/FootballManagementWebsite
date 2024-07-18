package qltb.Configuration;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import qltb.Service.UserDetailsServiceImpl;
 
@Configuration
@EnableWebSecurity
public class WebSecurityConfig{
 
    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
     
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        	.antMatchers("/login","/doLogout","/header.html","/loginerror","/register","/saveaccount").permitAll()
        	.antMatchers("/home","/changepassword","/bangdau/**","/trandau/**").hasAnyRole("USER","ADMIN")
        	.antMatchers("/admin/**").hasRole("ADMIN")
        	.antMatchers("/").hasRole("USER")
            .anyRequest().authenticated()   
            .and()
            .formLogin()
            	.permitAll()
            	.loginPage("/login")
            	.usernameParameter("username")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/home")
            	.failureUrl("/loginerror")
            .and()
            .logout()
            	.permitAll()
            	.logoutUrl("/doLogout")
            	.logoutSuccessUrl("/login")
        	.and().csrf().disable()
        	.exceptionHandling().accessDeniedPage("/403");
        	
        return http.build();
    }
}
