package D.D.Agenda.Digital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import D.D.Agenda.Digital.Services.StudentService;

@Configuration
public class SecurityConiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	StudentService studentService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	
	}
	
	//Permite acceder al aplicativo con usuarios registrados en la memoria, esto permitiria de manera local acceder al sistema
	//siempre y cuando se encuentren conectados a la red de la empresa
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//			.inMemoryAuthentication()
//			.withUser("user")
//				.password("user")
//				.roles("USER")
//				.and()
//			.withUser("admin")
//				.password("admin")
//				.roles("USER", "ADMIN");
//	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}
	
}
