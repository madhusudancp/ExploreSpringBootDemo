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

import com.maddy.service.ShoeService;
import com.maddy.webtos.ShoeDto;

@RestController
@RequestMapping(value="/shoes")
public class ShoeResources {

	@Autowired
	ShoeService shoeService;
	
	/*
	*Get All Shoe 
	*/
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<ShoeDto>> getAllShoes(Pageable pageable){
		Collection<ShoeDto> skus= shoeService.getAllShoes(pageable);
		return ResponseEntity.ok(skus);
	}
	
	/*
	*Get a Shoe
	*/
	@GetMapping("/{id}")
    public ResponseEntity<ShoeDto> getShoe(@PathVariable(value = "id") Integer id) {
		ShoeDto bagDto= shoeService.getShoe(id);
		return ResponseEntity.ok(bagDto);
	}

	/*
	*Create a Shoe
	*/
	@PostMapping
	public ResponseEntity<ShoeDto> post(@RequestBody final ShoeDto bagFromRequest) {		
		
		return new ResponseEntity<ShoeDto>(shoeService.createShoe(bagFromRequest),HttpStatus.CREATED);
	}

	/*
	*Update a Shoe
	*/
	@PutMapping("/{id}")
	public ResponseEntity<ShoeDto> put(@PathVariable("id") final long id,@RequestBody final ShoeDto bagFromRequest) {		    
		return new ResponseEntity<ShoeDto>(shoeService.updateShoe(bagFromRequest),HttpStatus.ACCEPTED);
	}
	
	/*
	*Delete a Shoe
	*/
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") final Integer id) {		    
		return new ResponseEntity<Boolean>(shoeService.deleteShoe(id),HttpStatus.FOUND);
	}



	
	
	
	
	
	
	
}
