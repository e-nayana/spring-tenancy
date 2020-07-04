package com.tenancy.main.controller;

import pac.test.engine.TenantDBContext;
import com.tenancy.main.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @author Houston(Nayana)
 */
@RestController
@RequestMapping("/api/product")
public class ProductController implements Serializable {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllProduct() {

        TenantDBContext.setCurrentDb("tenant_1");
        return new ResponseEntity<>(productService.getAllProduct(),HttpStatus.OK);
    }

}
