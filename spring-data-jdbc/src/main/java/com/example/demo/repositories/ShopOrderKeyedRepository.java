package com.example.demo.repositories;

import com.example.demo.model.ShopOrderKeyed;
import org.springframework.data.repository.CrudRepository;

public interface ShopOrderKeyedRepository extends CrudRepository<ShopOrderKeyed, Long> {
}
