package com.example.wtf.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.wtf.model.Category;
import com.example.wtf.model.Item;
import com.example.wtf.model.Privilege;
import com.example.wtf.model.Role;
import com.example.wtf.model.Shop;
import com.example.wtf.model.User;
import com.example.wtf.repo.CategoryRepository;
import com.example.wtf.repo.ItemRepository;
import com.example.wtf.repo.PrivilegeRepository;
import com.example.wtf.repo.RoleRepository;
import com.example.wtf.repo.ShopRepository;
import com.example.wtf.repo.UserRepository;

/**
 * @author sovannoty
 *
 */
@Component
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private ShopRepository shopRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PrivilegeRepository privilegeRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Override
	public void run(String... strings) throws Exception {

		Privilege readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilege writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

		List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

		Role adminRole = roleRepository.findByName("ROLE_ADMIN");
		Role userRole = roleRepository.findByName("ROLE_USER");
		Role deliverRole = roleRepository.findByName("ROLE_DELIVER");
		Role ownerRole = roleRepository.findByName("ROLE_OWNER");

		User user = new User();
		user.setFirstName("noty");
		user.setLastName("chea");
		user.setUserName("admin");
		user.setUserName("011202074");
		user.setEmail("n@g.c");
		user.setRoles(Arrays.asList(adminRole,userRole,deliverRole,ownerRole));
		user.setEnabled(true);
		userRepository.save(user);

		Category food = this.categoryRepository.save(new Category("food"));
		Category drink = this.categoryRepository.save(new Category("drink"));
		Category sweet = this.categoryRepository.save(new Category("sweet"));
		
		User owner01 = new User();
		owner01.setFirstName("owner001");
		owner01.setLastName("owner0001");
		owner01.setUserName("owner01");
		owner01.setUserName("099999999");
		owner01.setEmail("n@g.c");
		owner01.setRoles(Arrays.asList(userRole,deliverRole,ownerRole));
		owner01.setEnabled(true);
		userRepository.save(owner01);
		
		User deliver01 = new User();
		deliver01.setFirstName("deliver001");
		deliver01.setLastName("deliver0001");
		deliver01.setUserName("deliver01");
		deliver01.setUserName("088888888");
		deliver01.setEmail("n@g.c");
		deliver01.setRoles(Arrays.asList(userRole,deliverRole));
		deliver01.setEnabled(true);
		userRepository.save(deliver01);
		
		
		User customer01 = new User();
		customer01.setFirstName("customer001");
		customer01.setLastName("customer0001");
		customer01.setUserName("customer01");
		customer01.setUserName("077777777");
		customer01.setEmail("n@g.c");
		customer01.setRoles(Arrays.asList(userRole));
		customer01.setEnabled(true);
		userRepository.save(customer01);

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

		shop01.setItems(Arrays.asList(item01,item02,item05));
		this.shopRepository.save(shop01);

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
		
		shop02.setItems(Arrays.asList(item03,item04,item06));

		this.shopRepository.save(shop02);

	}

	@Transactional
	Privilege createPrivilegeIfNotFound(String name) {

		Privilege privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilege(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Transactional
	Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

		Role role = roleRepository.findByName(name);
		if (role == null) {
			role = new Role(name);
			role.setPrivileges(privileges);
			roleRepository.save(role);
		}
		return role;
	}
}
