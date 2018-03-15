package com.maddy.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maddy.entities.ShoeEntity;
import com.maddy.exceptions.SpringbootServiceException;
import com.maddy.repositories.ShoeRepository;
import com.maddy.utils.APPMessages;
import com.maddy.utils.SpringbootDemoMapper;
import com.maddy.webtos.ShoeDto;

@Service
public class ShoeService {

	@Autowired
	ShoeRepository shoeRepository;
	
	@Autowired
	APPMessages appMessages;
	
	@Transactional(readOnly=true)
	public List<ShoeDto>  getAllShoes(Pageable pageable){
		Stream<ShoeEntity> bagEntityStream = StreamSupport.stream(shoeRepository.findAll(pageable).spliterator(), false);
		List<ShoeDto> bagDTOs =bagEntityStream.parallel().map(SpringbootDemoMapper::mapShoeEntityToDto).collect(Collectors.toList());
		return bagDTOs;
	}
	
	@Transactional(readOnly=true)
	public ShoeDto  getShoe(Integer id){
	  ShoeEntity bag = shoeRepository.findOne(id); 
      System.out.println("BBBB"+bag);  
	  if(null==bag){
		  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.bagNotFound+":"+id));	
        }else{
            return SpringbootDemoMapper.mapShoeEntityToDto(bag);	
        }
	}
	
	@Transactional
	public ShoeDto createShoe(ShoeDto bagDto){
		ShoeEntity bagEntity = SpringbootDemoMapper.mapShoeDtoToEntity(bagDto);
		System.out.println(bagEntity.getVersion());
		return SpringbootDemoMapper.mapShoeEntityToDto(shoeRepository.save(bagEntity));
	}
	
	@Transactional
	public ShoeDto updateShoe(ShoeDto bagDto){
		ShoeEntity bagEntity = SpringbootDemoMapper.mapShoeDtoToEntity(bagDto);
		return SpringbootDemoMapper.mapShoeEntityToDto(shoeRepository.save(bagEntity));
	}
	
	@Transactional
	public Boolean deleteShoe(Integer id){
	     shoeRepository.delete(id);
	     return !shoeRepository.exists(id);
	}
}
