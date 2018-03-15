
package com.maddy.resources;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maddy.webtos.BaseDto;

@RestController
public class GreetResources {

	@GetMapping()
    public BaseDto greet() {
		BaseDto sks= new BaseDto();
		Pageable pageable =null;
		sks.add(linkTo(methodOn(SkusResources.class).getAllSkus(pageable)).withRel("skus"));
		sks.add(linkTo(methodOn(ShoeResources.class).getAllShoes(pageable)).withRel("shoes"));
		sks.add(linkTo(methodOn(BagResources.class).getAllBags(pageable)).withRel("bags"));
		return sks;
	}
	
	
	
	
}
