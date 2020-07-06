package com.tenancy.main.service;

import com.spring.houston.tenant.engine.tenant.TenantTransaction;
import com.tenancy.main.entity.Product;
import com.tenancy.main.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Houston(Nayana)
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    @TenantTransaction
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
}
