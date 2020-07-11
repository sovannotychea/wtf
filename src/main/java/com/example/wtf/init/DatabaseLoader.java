package com.example.wtf.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.wtf.model.Category;
import com.example.wtf.model.Customer;
import com.example.wtf.model.Deliver;
import com.example.wtf.model.Item;
import com.example.wtf.model.Shop;
import com.example.wtf.model.User;
import com.example.wtf.repo.CategoryRepository;
import com.example.wtf.repo.DeliverRepository;
import com.example.wtf.repo.ItemRepository;
import com.example.wtf.repo.ShopRepository;
import com.example.wtf.repo.CustomerRepository;

/**
 * @author sovannoty
 *
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;
	
	 @Autowired
	 private ShopRepository shopRepository;
	 
	 @Autowired
	 private CategoryRepository categoryRepository;
	 @Autowired
	 private DeliverRepository deliverRepository;
	 
	 @Autowired
	 private ItemRepository itemRepository;
	

	@Override
	public void run(String... strings) throws Exception {
		Category food = this.categoryRepository.save(new Category("food"));
		Category drink = this.categoryRepository.save(new Category("drink"));
		Category sweet = this.categoryRepository.save(new Category("sweet"));
		Customer owner01 = this.customerRepository.save(new Customer("owner001", "owner0001", "test"));
		Customer owner02 = this.customerRepository.save(new Customer("owner002", "owner0002", "test"));
		Deliver deliver = this.deliverRepository.save(new Deliver("deliver001", "deliver0001", "test"));
		
		
		this.customerRepository.save(new Customer("tester01", "Frodo", "Baggins"));
		this.customerRepository.save(new Customer("admin", "Sovannoty", "Chea"));
		
		Shop shop01 = new Shop();
		shop01.setAddress("#67Eo st 454 Phnone Penh");
		shop01.setName("Tasty 01 shop");
		shop01.setPhoneNumber("01101010101");
		shop01.setOwner(owner01);
		shop01 = this.shopRepository.save(shop01);
	
		Shop shop02 = new Shop();
		shop02.setAddress("#67Eo st 454 Battambang");
		shop02.setName("Tasty 02 shop");
		shop02.setPhoneNumber("02202020202");
		shop02.setOwner(owner01);
		shop02 = this.shopRepository.save(shop02);
		
		List<Item> items01 = new ArrayList();
		
		Item item01 = new Item();
		item01.setName("coke");
		item01.setCategory(drink);
		item01.setShop(shop01);
		item01 = this.itemRepository.save(item01);
		
		Item item02 = new Item();
		item02.setName("sprite");
		item02.setCategory(drink);
		item02.setShop(shop01);
		item02 = this.itemRepository.save(item02);
		
		Item item05 = new Item();
		item05.setName("Tuma sendwich");
		item05.setCategory(food);
		item05.setShop(shop01);
		item05 = this.itemRepository.save(item05);
		
		items01.add(item01);
		items01.add(item02);
		items01.add(item05);
		
		shop01.setItems(items01);
		this.shopRepository.save(shop01);
		
		List<Item> items02 = new ArrayList();
		
		Item item03 = new Item();
		item03.setName("pepsi");
		item03.setCategory(drink);
		item03.setShop(shop02);
		item03 = this.itemRepository.save(item03);
		
		Item item04 = new Item();
		item04.setName("7Up");
		item04.setCategory(drink);
		item04.setShop(shop02);
		item04 = this.itemRepository.save(item04);
		
		Item item06 = new Item();
		item06.setName("Egg sendwich");
		item06.setCategory(food);
		item06.setShop(shop02);
		item06 = this.itemRepository.save(item06);
		
		items02.add(item03);
		items02.add(item04);
		items02.add(item06);
		
	
		shop02.setItems(items02);
		this.shopRepository.save(shop02);
		
	}
}
