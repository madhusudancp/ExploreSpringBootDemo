package com.maddy;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	 	@Bean
	    public Filter filter(){
	        ShallowEtagHeaderFilter filter=new ShallowEtagHeaderFilter();
	        return filter;
	    }
	 	
	 	
	 	
}
