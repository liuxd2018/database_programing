package com.example.demo.repositories;

import com.example.demo.model.ShopOrder;
import org.springframework.data.repository.CrudRepository;

// one-to-many(set)
public interface ShopOrderRepository extends CrudRepository<ShopOrder, Long> {
}
