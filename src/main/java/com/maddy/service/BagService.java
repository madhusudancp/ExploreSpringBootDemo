package com.maddy.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maddy.entities.BagEntity;
import com.maddy.exceptions.SpringbootServiceException;
import com.maddy.repositories.BagRepository;
import com.maddy.utils.APPMessages;
import com.maddy.utils.SpringbootDemoMapper;
import com.maddy.webtos.BagDto;

@Service
public class BagService {

	@Autowired
	private BagRepository bagRepository;
	
	@Autowired
	APPMessages appMessages;
	
	@Transactional(readOnly=true)
	public List<BagDto>  getAllBags(Pageable pageable){
		Stream<BagEntity> bagEntityStream = StreamSupport.stream(bagRepository.findAll(pageable).spliterator(), false);
		List<BagDto> bagDTOs =bagEntityStream.parallel().map(SpringbootDemoMapper::mapBagEntityToDto).collect(Collectors.toList());
		return bagDTOs;
	}
	
	@Transactional(readOnly=true)
	public BagDto  getBag(Integer id){
	  BagEntity bag = bagRepository.findOne(id); 
      System.out.println("BBBB"+bag);  
	  if(null==bag){
		  throw new SpringbootServiceException(SpringbootDemoMapper.getExceptionDto(appMessages.bagNotFoundErrorCode,appMessages.bagNotFound+":"+id));	
        }else{
            return SpringbootDemoMapper.mapBagEntityToDto(bag);	
        }
	}
	
	@Transactional
	public BagDto createBag(BagDto bagDto){
		BagEntity bagEntity = SpringbootDemoMapper.mapBagDtoToEntity(bagDto);
		System.out.println(bagEntity.getVersion());
		return SpringbootDemoMapper.mapBagEntityToDto(bagRepository.save(bagEntity));
	}
	
	@Transactional
	public BagDto updateBag(BagDto bagDto){
		BagEntity bagEntity = SpringbootDemoMapper.mapBagDtoToEntity(bagDto);
		return SpringbootDemoMapper.mapBagEntityToDto(bagRepository.save(bagEntity));
	}
	
	@Transactional
	public Boolean deleteBag(Integer id){
	     bagRepository.delete(id);
	     return !bagRepository.exists(id);
	}
}
