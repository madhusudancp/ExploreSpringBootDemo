package com.maddy.resources;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.maddy.service.BagService;
import com.maddy.webtos.BagDto;


@RunWith(SpringRunner.class)
@WebMvcTest(BagResources.class)
public class TestBagsResoures {

    
    private BagDto mockBag1 = new BagDto();
    private BagDto mockBag2 = new BagDto();
    private List<BagDto> mockBagList = new ArrayList<>(); 
    
    
    
    

    @Autowired
    private BagResources bagResources;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BagService bagService;

    
    @Before
    public void setUp() {
       mockBag1.setBagId(1);
       mockBag1.setRefName("WC");
       mockBag1.setType("XL");
       mockBag1.setVersion("1.0");
       mockBag2.setBagId(2);
       mockBag2.setRefName("WC");
       mockBag2.setType("XXL");
       mockBag2.setVersion("1.0");
       mockBagList.add(mockBag1);
       mockBagList.add(mockBag2);
    }
    
    
    @Test
    public void getAllBags() throws Exception {

    	Mockito.when(bagService.getAllBags(Mockito.any())).thenReturn(mockBagList);
    	RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/bags/1");
    	MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
    	System.out.println(mvcResult.getResponse());
    	
    	
    }

    

    
}

