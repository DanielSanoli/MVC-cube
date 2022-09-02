package br.com.metasix.mvcube.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	ImplementsUserDetailsService userDetailsService;
	
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/usuario/formCidadao").permitAll()
				.antMatchers(HttpMethod.GET, "/usuario/editUsuario").hasRole("ADMIN")
				.anyRequest().authenticated()
			.and()
			.formLogin(form -> form
	            .loginPage("/login")
	            .permitAll()
        )
		.logout(logout -> logout.logoutUrl("/logout")
		).csrf().disable();
	}
	 	
}
