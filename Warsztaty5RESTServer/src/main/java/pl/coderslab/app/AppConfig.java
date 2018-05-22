package pl.coderslab.app;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
//@EnableJpaRepositories(basePackages = "pl.coderslab.repositories") //wyrzucamy to i poniższe entity managery - nie będą nam potrzebne bo połączenie z bazą jest nam zbędne
@EnableTransactionManagement
public class AppConfig implements WebMvcConfigurer {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
//	@Bean
//	public LocalEntityManagerFactoryBean entityManagerFactory() {
//	LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//	emfb.setPersistenceUnitName("bookstorePersistenceUnit");
//	return emfb; }
//	
//	
//	
//	@Bean
//	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//	JpaTransactionManager tm = new JpaTransactionManager(emf);
//	return tm; }
	
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/WEB-INF/resources/").setCachePeriod(31056926);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("http://localhost");
	}
	
	
	
}



