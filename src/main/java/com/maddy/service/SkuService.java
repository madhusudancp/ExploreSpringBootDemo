package com.maddy.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maddy.entities.BagEntity;
import com.maddy.entities.ShoeEntity;
import com.maddy.entities.SkuEntity;
import com.maddy.exceptions.SpringbootServiceException;
import com.maddy.repositories.BagRepository;
import com.maddy.repositories.ShoeRepository;
import com.maddy.repositories.SkuRepository;
import com.maddy.resources.BagResources;
import com.maddy.resources.ShoeResources;
import com.maddy.resources.SkusResources;
import com.maddy.utils.APPMessages;
import com.maddy.utils.SpringbootDemoMapper;
import com.maddy.webtos.SkuDto;

@Service
public class SkuService {

	@Autowired
	private SkuRepository skuRepository;
	
	@Autowired
	private ShoeRepository shoeRepository;
	
	@Autowired
	private BagRepository bagRepository;
	
	@Autowired
	APPMessages appMessages;
	
	@Transactional(readOnly=true)
	public List<SkuDto>  getAllSkus(Pageable pageable){
		Stream<SkuEntity> skuEntityStream = StreamSupport.stream(skuRepository.findAll(pageable).spliterator(), false);
		List<SkuDto> skuDTOs =skuEntityStream.parallel().map(this::getMappedHyperLinks).collect(Collectors.toList());
		/*skuDTOs.forEach(skuDto->{
			   skuDto.add(linkTo(methodOn(SkusResources.class).getSku(skuDto.getSkuId())).withSelfRel());
	           skuDto.add(linkTo(methodOn(BagResources.class).getBag(skuDto.getBagId())).withRel("bagId"));
	           skuDto.add(linkTo(methodOn(ShoeResources.class).getShoe(skuDto.getShoeId())).withRel("shoeId"));
		});*/
		return skuDTOs;
	}
	
	
	
	@Transactional(readOnly=true)
	public SkuDto  getSku(Integer id){
	  SkuEntity sku = skuRepository.findOne(id); 
	  if(null==sku){
		  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.skuNotFound+":"+id));	
        }else{
           return  getMappedHyperLinks(sku);
        }
	}
	
	@Transactional
	public SkuDto createSku(SkuDto skuDto){
		//SkuEntity skuEntity = AvataarMapper.mapSkuDtoToEntity(skuDto);
		
		  validateSkuDto(skuDto);
		  SkuEntity sku = SpringbootDemoMapper.mapSkuDtoToEntity(skuDto);
		  if(!(Integer.valueOf(0).equals(skuDto.getBagId()))){
			  Optional<BagEntity> bagOptional =Optional.ofNullable(bagRepository.findOne(skuDto.getBagId()));
			  if(bagOptional.isPresent()){
				  sku.setBag(bagOptional.get());
			  }else{
				  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.bagNotFound+":"+skuDto.getBagId()));
			  }
		  }
		  if(!(Integer.valueOf(0).equals(skuDto.getShoeId()))){
			  Optional<ShoeEntity> shoeOptional =Optional.ofNullable(shoeRepository.findOne(skuDto.getShoeId()));
			  if(shoeOptional.isPresent()){
				  sku.setShoe(shoeOptional.get());
			  }else{
				  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.shoeNotFound+":"+skuDto.getShoeId()));
			  }
		  }
          return  getMappedHyperLinks(skuRepository.save(sku));
	}
	
	@Transactional
	public SkuDto updateSku(SkuDto skuDto,Integer skuId){
		
		Optional<SkuEntity> skuOptional =Optional.ofNullable(skuRepository.findOne(skuId));
		  if(skuOptional.isPresent()){
			  skuDto.setSkuId(skuId);
			  validateSkuDto(skuDto);
			  SkuEntity sku = SpringbootDemoMapper.mapSkuDtoToEntity(skuDto);
			  if(!(Integer.valueOf(0).equals(skuDto.getBagId()))){
				  Optional<BagEntity> bagOptional =Optional.ofNullable(bagRepository.findOne(skuDto.getBagId()));
				  if(bagOptional.isPresent()){
					  sku.setBag(bagOptional.get());
				  }else{
					  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.bagNotFound+":"+skuDto.getBagId()));
				  }
			  }
			  if(!(Integer.valueOf(0).equals(skuDto.getShoeId()))){
				  Optional<ShoeEntity> shoeOptional =Optional.ofNullable(shoeRepository.findOne(skuDto.getShoeId()));
				  if(shoeOptional.isPresent()){
					  sku.setShoe(shoeOptional.get());
				  }else{
					  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.shoeNotFound+":"+skuDto.getShoeId()));
				  }
			  }
			  System.out.println(sku.getSkuId()+"---"+sku.getPurchaseLink());
			  return getMappedHyperLinks(skuRepository.save(sku));  
		  }else{
			  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.skuNotFound+":"+skuId));
		  }
	}
	
	@Transactional
	public Boolean deleteSku(Integer skuId){
	     
		if(skuRepository.exists(skuId)){
			skuRepository.delete(skuId);	
			return !skuRepository.exists(skuId);
		}else{
		   throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.skuNotFound+":"+skuId));
		}
		 
	     
	}	
	
	private SkuDto getMappedHyperLinks(SkuEntity sku){
		SkuDto skuDto= SpringbootDemoMapper.mapSkuEntityToDto(sku);	
        skuDto.add(linkTo(methodOn(SkusResources.class).getSku(skuDto.getSkuId())).withSelfRel());
        if(null!=skuDto.getBagId()){
      	  skuDto.add(linkTo(methodOn(BagResources.class).getBag(skuDto.getBagId())).withRel("bagId"));  
        }
        if(null!=skuDto.getShoeId()){
      	  skuDto.add(linkTo(methodOn(ShoeResources.class).getShoe(skuDto.getShoeId())).withRel("shoeId"));  
        } 
        return  skuDto;
		
	}
	
	private void validateSkuDto(SkuDto skuDto){
		if(null==skuDto.getBagId()){
			skuDto.setBagId(0);
		}
		if(null==skuDto.getShoeId()){
			skuDto.setShoeId(0);
		}
		if(0==skuDto.getBagId() && 0==skuDto.getShoeId()){
			throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(1001,"UNABLE TO CREATE SKU REQUIRED ITEM ID"));
		}
      
		if(0!=skuDto.getBagId() && 0!=skuDto.getShoeId()){
			throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(1001,"UNABLE TO CREATE SKU REQUIRED ONLY ONE ITEM ID"));
		}
		System.out.println(skuDto.getBagId() +"------"+skuDto.getShoeId());
		
		if(!(Integer.valueOf(0).equals(skuDto.getBagId()))){
		   if(!bagRepository.exists(skuDto.getBagId())){
			   throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.bagNotFound+":"+skuDto.getBagId()));
		   }
		 }
		
		System.out.println("::::>SH>>"+Integer.valueOf(0).equals(skuDto.getShoeId()));
		if(!(Integer.valueOf(0).equals(skuDto.getShoeId()))){
			   if(!shoeRepository.exists(skuDto.getShoeId())){
				   throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.shoeNotFound+":"+skuDto.getShoeId()));
			   }
			 }
		
	}
}
