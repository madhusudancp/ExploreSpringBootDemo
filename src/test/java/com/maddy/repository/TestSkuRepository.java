package com.maddy.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.maddy.entities.BagEntity;
import com.maddy.entities.ShoeEntity;
import com.maddy.entities.SkuEntity;
import com.maddy.repositories.BagRepository;
import com.maddy.repositories.ShoeRepository;
import com.maddy.repositories.SkuRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
//@TransactionConfiguration(defaultRollback = false)
public class TestSkuRepository {


   @Autowired
   private SkuRepository skuRepository;
   
   @Autowired
   private BagRepository bagRepository;
   
   @Autowired
   private ShoeRepository shoeRepository;
   
   @Test
   //@Rollback(false)
   @Commit
   public void testInsertToSku(){
	   
	   BagEntity bag = new BagEntity();
	   bag.setRefName("WC");
	   bag.setType("XL");
	   bag.setVersion("1.0");
	   //bagRepository.save(bag);

	   BagEntity bag2 = new BagEntity();
	   bag2.setRefName("WC");
	   bag2.setType("XL");
	   bag2.setVersion("1.0");
	   //bagRepository.save(bag2);

	   
	   
	   
	   ShoeEntity shoe = new ShoeEntity();
	   shoe.setRefName("WC");
	   shoe.setType("XL");
	   shoe.setVersion("1.0");
	   //shoeRepository.save(shoe);
	   

	   ShoeEntity shoe2 = new ShoeEntity();
	   shoe2.setRefName("WC");
	   shoe2.setType("XL");
	   shoe2.setVersion("1.0");
	   //shoeRepository.save(shoe2);
	   
	   
	   SkuEntity sku = new SkuEntity();
	   sku.setActive(true);
	   sku.setPurchaseLink("abded");
	   sku.setBag(bag);
	   //sku.setShoe(shoe);
	   
	  /* bag.getSkus().add(sku);
	   shoe.getSkus().add(sku);*/
	   skuRepository.save(sku);
	   skuRepository.flush();
	   
	   SkuEntity sku2=skuRepository.getOne(1);
	   sku2.setBag(bag2);
	   skuRepository.save(sku2);
	   
	   System.out.println("SKU  :::"+skuRepository.exists(1));
	   
	   skuRepository.delete(1);
	   
	   
	  /* SkuEntity sku2 = skuRepository.getOne(1);
	   sku2.setPurchaseLink("MADDY");
	   sku2.setBag(bag2);
	   sku2.setShoe(shoe2);
	   bag2.getSkus().add(sku);
	   shoe2.getSkus().add(sku);
	   
	   
	   skuRepository.save(sku2);
	   skuRepository.flush();*/
	   //skuRepository.delete(1);
	   //System.out.println(skuRepository.getOne(1));
   }
   
   
	
	
	
}
