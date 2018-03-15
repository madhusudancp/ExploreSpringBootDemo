package com.maddy.utils;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;

import com.maddy.entities.BagEntity;
import com.maddy.entities.ShoeEntity;
import com.maddy.entities.SkuEntity;
import com.maddy.exceptions.SpringbootServiceException;
import com.maddy.resources.BagResources;
import com.maddy.webtos.BagDto;
import com.maddy.webtos.ExceptionDto;
import com.maddy.webtos.ShoeDto;
import com.maddy.webtos.SkuDto;

public class SpringbootDemoMapper {
	
	public static BagDto mapBagEntityToDto(BagEntity entity){
		BagDto bagDto = new BagDto();
		if(null!=entity){
		bagDto.setBagId(entity.getBagId());
		bagDto.setRefName(entity.getRefName());
		bagDto.setType(entity.getType());
		bagDto.setVersion(entity.getVersion());
		bagDto.add(linkTo(methodOn(BagResources.class).getBag(bagDto.getBagId())).withSelfRel());
		}
		return bagDto;
	}
	
	public static BagEntity mapBagDtoToEntity(BagDto bagDto){
		BagEntity bagEntity = new BagEntity();
		if(null!=bagDto){
			System.out.println(bagDto.getBagId());
			if(null!=bagDto.getBagId()){
				if(!bagDto.getBagId().equals(0)){
			        bagEntity.setBagId(bagDto.getBagId());
				}
			}
			bagEntity.setRefName(bagDto.getRefName());
			bagEntity.setType(bagDto.getType());
			bagEntity.setVersion(bagDto.getVersion());
		}
		return bagEntity;
	}
	
	public static ShoeEntity mapShoeDtoToEntity(ShoeDto bagDto){
		ShoeEntity shoeEntity = new ShoeEntity();
		if(null!=bagDto){
			System.out.println(bagDto.getShoeId());
			if(null!=bagDto.getShoeId()){
				if(!bagDto.getShoeId().equals(0)){
					shoeEntity.setShoeId(bagDto.getShoeId());
				}
			}
			shoeEntity.setRefName(bagDto.getRefName());
			shoeEntity.setType(bagDto.getType());
			shoeEntity.setVersion(bagDto.getVersion());
		}
		return shoeEntity;
	}
	
	public static ShoeDto mapShoeEntityToDto(ShoeEntity entity){
		ShoeDto shoeDto = new ShoeDto();
		if(null!=entity){
			shoeDto.setShoeId(entity.getShoeId());
			shoeDto.setRefName(entity.getRefName());
			shoeDto.setType(entity.getType());
			shoeDto.setVersion(entity.getVersion());
			shoeDto.add(linkTo(methodOn(BagResources.class).getBag(shoeDto.getShoeId())).withSelfRel());
		}
		return shoeDto;
	}
	
	public static SkuDto mapSkuEntityToDto(SkuEntity entity){
		SkuDto skuDto = new SkuDto();
		if(null!=entity){
			skuDto.setIsActive(entity.isActive());
			skuDto.setPurchaseLink(entity.getPurchaseLink());
			skuDto.setSkuId(entity.getSkuId());
			//skuDto.add(linkTo(methodOn(SkusResources.class).getSku(skuDto.getSkuId())).withSelfRel());
			if(null!=entity.getBag()){
            skuDto.setBagId(entity.getBag().getBagId());
			}
            //skuDto.add(linkTo(methodOn(BagResources.class).getBag(skuDto.getBagId())).withSelfRel());
            if(null!=entity.getShoe()){
			skuDto.setShoeId(entity.getShoe().getShoeId());
            }
            //skuDto.add(linkTo(methodOn(ShoeResources.class).getShoe(skuDto.getShoeId())).withSelfRel());
		}
		return skuDto;
	}
	
	public static SkuEntity mapSkuDtoToEntity(SkuDto skuDto){
		SkuEntity sku = new SkuEntity();
		  sku.setActive(skuDto.getIsActive());  
		  if(null!=skuDto.getPurchaseLink()){
			  sku.setPurchaseLink(skuDto.getPurchaseLink());
		  }else{
			  sku.setPurchaseLink("default Purchase link");
		  }
		  if(null!=skuDto.getSkuId()){
			  sku.setSkuId(skuDto.getSkuId());
		  }
		return sku;
	}
	
	
	
	public static ExceptionDto getExceptionDto(Integer errorCode,String errorMessage){
		 ExceptionDto exceptionObj =new ExceptionDto();
		  exceptionObj.setErrorCode(errorCode);
		  exceptionObj.setErrorMessage(errorMessage);
		  return exceptionObj;
	}
	
}
