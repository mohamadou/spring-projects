package com.prestadak.springsecurity.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.prestadak.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
				
		return resolver;
	}

	//--Create dynamically a controller and route /showLoginPage and assign view template login-form.jsp
	/*@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/showLoginPage").setViewName("login-form");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}*/
	
	 @Override
     public void addResourceHandlers(ResourceHandlerRegistry registry) {
             registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
     }
	 
	 
	 @Bean
	 public DataSource dataSourceSecurity() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		
		System.out.println("\nPROPERTIES URL:"+ env.getProperty("jdbc.url"));
		System.out.println("\nPROPERTIES USER:"+ env.getProperty("jdbc.user"));
		System.out.println("\nPROPERTIES Password:"+ env.getProperty("jdbc.password"));
		System.out.println("\n INITIAL POOL SIZE:"+env.getProperty("connection.pool.initialPoolSize"));
		System.out.println("\n INITIAL POOL SIZE:"+env.getProperty("connection.pool.initialPoolSize"));
		// Set connection pool
		dataSource.setInitialPoolSize(getPropertyInt("connection.pool.initialPoolSize"));
		dataSource.setInitialPoolSize(getPropertyInt("connection.pool.minPoolSize"));
		dataSource.setInitialPoolSize(getPropertyInt("connection.pool.maxPoolSize"));
		dataSource.setInitialPoolSize(getPropertyInt("connection.pool.maxIdleTime"));
		
		 return dataSource;
	 }
	 
	 private int getPropertyInt(String propertie) {
		 String poolVal = env.getProperty(propertie);
		 int value = Integer.parseInt(poolVal);
		 
		 return value;
	 }
	 
	 
	
	
}
