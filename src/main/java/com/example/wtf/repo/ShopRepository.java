package com.example.wtf.repo;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.wtf.model.Shop;


/**
 * @author sovannoty
 *
 */
@RepositoryRestResource(collectionResourceRel = "shop", path = "shop")
public interface ShopRepository extends PagingAndSortingRepository<Shop, Long> {


}

