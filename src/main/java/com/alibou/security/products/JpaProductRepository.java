package com.alibou.security.products;

import org.springframework.data.repository.CrudRepository;

public interface JpaProductRepository extends CrudRepository<Products, Long> {
}
