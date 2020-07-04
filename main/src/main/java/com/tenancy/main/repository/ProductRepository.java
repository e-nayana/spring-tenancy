package com.tenancy.main.repository;

import org.springframework.stereotype.Repository;
import com.tenancy.main.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Houston(Nayana)
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
