package com.example.wtf.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.wtf.model.Shop;


/**
 * @author sovannoty
 *
 */
@RepositoryRestResource(collectionResourceRel = "shop", path = "shop")
public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {

	
	@Query("SELECT s FROM shop s INNER JOIN s.items i WHERE i.name LIKE %:name%")
	List<Shop> findByItemName(@Param("name") String name);


}

