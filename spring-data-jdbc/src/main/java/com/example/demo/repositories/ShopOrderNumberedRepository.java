package com.example.demo.repositories;

import com.example.demo.model.ShopOrderNumbered;
import org.springframework.data.repository.CrudRepository;

public interface ShopOrderNumberedRepository extends CrudRepository<ShopOrderNumbered, Long> {
}
