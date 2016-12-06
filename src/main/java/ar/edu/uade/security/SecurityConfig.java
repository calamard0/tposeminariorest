package ar.edu.uade.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
        .authorizeRequests()
//        	.antMatchers("/controllers/**", "/images/**", "/json/**", "/libs/**", "/services/**").permitAll()
//            .antMatchers("/views/**", "/app.css", "/app.module.js", "/index.html").permitAll()
            .antMatchers("/resources/**").permitAll()
            .antMatchers("/procesos/**").permitAll()
            .antMatchers("/cursos/view", "/cursos/update").hasAuthority("COLEGIO")
            .and()
        .formLogin()
            .loginPage("/login").permitAll()
            .and()
        .logout()
            .permitAll();			
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
}