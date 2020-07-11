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
	

	@Override
	public void run(String... strings) throws Exception {
		Category food = this.categoryRepository.save(new Category("food"));
		Category drink = this.categoryRepository.save(new Category("drink"));
		Category sweet = this.categoryRepository.save(new Category("sweet"));
		Customer owner = this.customerRepository.save(new Customer("owner001", "owner0001", "test"));
		Deliver deliver = this.deliverRepository.save(new Deliver("deliver001", "deliver0001", "test"));
		
		
		this.customerRepository.save(new Customer("tester01", "Frodo", "Baggins"));
		this.customerRepository.save(new Customer("admin", "Sovannoty", "Chea"));
		
		
		List<Item> items = new ArrayList();
		Item item01 = new Item();
		item01.setName("coke");
		item01.setCategory(drink);
		Item item02 = new Item();
		item02.setName("7Up");
		item02.setCategory(drink);
		items.add(item01);
		items.add(item02);
		
		Shop shop = new Shop();
		shop.setAddress("#67Eo st 454 Phnone Penh");
		shop.setName("Tasty shop");
		shop.setPhoneNumber("01101010101");
		shop.setOwner(owner);
		shop.setItems(items);
		this.shopRepository.save(shop);
		
	}
}
