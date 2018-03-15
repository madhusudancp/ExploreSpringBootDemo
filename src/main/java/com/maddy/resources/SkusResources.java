package com.maddy.resources;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maddy.service.SkuService;
import com.maddy.webtos.SkuDto;

@RestController
@RequestMapping(value="/skus")
public class SkusResources {

//https://blog.novatec-gmbh.de/page-links-hateoas-spring-boot/
	
	@Autowired
	SkuService skuService;
	
	/*
	*Get All SKUS 
	*/
	@GetMapping
    public ResponseEntity<Collection<SkuDto>> getAllSkus(Pageable pageable) {
		Collection<SkuDto> skus= skuService.getAllSkus(pageable);
		return ResponseEntity.ok(skus);
		
	}
	/*
	*Get single SKUS 
	*/
	@GetMapping("/{id}")
    public ResponseEntity<SkuDto> getSku(@PathVariable(value = "id") Integer id) {
		
		SkuDto bagDto= skuService.getSku(id);
		return ResponseEntity.ok(bagDto);
	}
	
	/*
	*Create a SKU
	*/
	@PostMapping
	public ResponseEntity<SkuDto> post(@RequestBody final SkuDto skuFromRequest) {		    
		
		return new ResponseEntity<SkuDto>(skuService.createSku(skuFromRequest),HttpStatus.CREATED);
	}

	/*
	*Update a SKU
	*/
	@PutMapping("/{id}")
	public ResponseEntity<SkuDto> put(@PathVariable("id") final int id,@RequestBody final SkuDto skuFromRequest) {		    
		
		return new ResponseEntity<SkuDto>(skuService.updateSku(skuFromRequest,id),HttpStatus.ACCEPTED);
	}
	
	
	/*
	*Delete a SKU
	*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") final Integer id) {		    
		
		return new ResponseEntity<Boolean>(skuService.deleteSku(id),HttpStatus.OK);
	}

}
