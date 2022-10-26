package D.D.Agenda.Digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class AgendaDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaDigitalApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {//"https://front-end-web-agenda-digital.herokuapp.com"
				registry.addMapping("/**").allowedHeaders("*").allowedMethods("*").allowedOrigins("https://front-end-web-agenda-digital.herokuapp.com");
			}
		};
	}
	
}
