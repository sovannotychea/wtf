package com.example.wtf.repo;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.wtf.model.Item;


/**
 * @author sovannoty
 *
 */
@RepositoryRestResource(collectionResourceRel = "item", path = "item")
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

	List<Item> findByNameContainingIgnoreCase( String name);
}

