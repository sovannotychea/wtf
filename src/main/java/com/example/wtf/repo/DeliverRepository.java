package com.example.wtf.repo;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.wtf.model.Deliver;
import com.example.wtf.model.Shop;


/**
 * @author sovannoty
 *
 */
@RepositoryRestResource(collectionResourceRel = "deliver", path = "deliver")
public interface DeliverRepository extends PagingAndSortingRepository<Deliver, Long> {


}

