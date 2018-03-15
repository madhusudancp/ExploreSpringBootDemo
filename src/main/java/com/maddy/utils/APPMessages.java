package com.maddy.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class APPMessages {

	public APPMessages(){
		
	}
	
	@Value("${spring.resource.application.error}")
	public  Integer applicationError;
	
	@Value("${spring.resource.notfound.code}")
	public  Integer bagNotFoundErrorCode;
	
	@Value("${spring.resource.notfound.bag}")
    public  String bagNotFound;
	
	
	@Value("${spring.resource.notfound.code}")
	public  Integer skuNotFoundErrorCode;
	
	@Value("${spring.resource.notfound.sku}")
    public  String skuNotFound;
	
	@Value("${spring.resource.notfound.shoe}")
    public  String shoeNotFound;
}
