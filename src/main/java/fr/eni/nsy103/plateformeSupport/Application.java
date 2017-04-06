package fr.eni.nsy103.plateformeSupport;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @author tosmont2016
 *
 */
@SpringBootApplication
@EnableJpaRepositories("fr.eni.nsy103.plateformeSUpport.repository")
@ComponentScan
public class Application extends WebMvcConfigurerAdapter {
	
	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		if(! registry.hasMappingForPattern("/static/**")) {
			LOG.info("Ajout des resources statiques (css, js...)");
			registry.addResourceHandler("/static/**")
				.addResourceLocations("/WEB-INF/static/");
		}
	}
}
