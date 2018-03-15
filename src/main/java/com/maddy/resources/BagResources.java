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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maddy.service.BagService;
import com.maddy.webtos.BagDto;

@RestController
@RequestMapping(value="/bags")
public class BagResources {

	
	 @Autowired
	 private BagService bagService;
	
	/*
	*Get All BAGS 
	*/
	@RequestMapping(method = RequestMethod.GET/*,params = { "offset", "limit","sortcolumn","ascending","q" }*/)
    public ResponseEntity<Collection<BagDto>> getAllBags(/*@RequestParam(value="offset",required=false)  Integer offset,
    		                                             @RequestParam(value="limit",required=false) Integer limit,
    		                                             @RequestParam(value="sortcolumn",required=false) String sortColumn,
    		                                             @RequestParam(value="ascending",required=false) Boolean ascending,
    		                                             @RequestParam(value="q",required=false) String filterBy,*/
    		                                             Pageable pageable){
		Collection<BagDto> skus= bagService.getAllBags(pageable);
		return ResponseEntity.ok(skus);
	}
	
	/*
	*Get a Bag
	*/
	@GetMapping("/{id}")
    public ResponseEntity<BagDto> getBag(@PathVariable(value = "id") Integer id) {
		BagDto bagDto= bagService.getBag(id);
		return ResponseEntity.ok(bagDto);
	}

	/*
	*Create a BAG
	*/
	@PostMapping
	public ResponseEntity<BagDto> post(@RequestBody final BagDto bagFromRequest) {		
		
		return new ResponseEntity<BagDto>(bagService.createBag(bagFromRequest),HttpStatus.CREATED);
	}

	/*
	*Update a BAG
	*/
	@PutMapping("/{id}")
	public ResponseEntity<BagDto> put(@PathVariable("id") final long id,@RequestBody final BagDto bagFromRequest) {		    
		return new ResponseEntity<BagDto>(bagService.updateBag(bagFromRequest),HttpStatus.ACCEPTED);
	}
	
	/*
	*Delete a BAG
	*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") final Integer id) {		    
		return new ResponseEntity<Boolean>(bagService.deleteBag(id),HttpStatus.FOUND);
	}




}
