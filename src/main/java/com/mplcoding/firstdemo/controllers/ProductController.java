package com.mplcoding.firstdemo.controllers;

import com.mplcoding.firstdemo.models.Product;
import com.mplcoding.firstdemo.models.ResponseObject;
import com.mplcoding.firstdemo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/Products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/getAllProduct")
    //http://localhost:8080/api/v1/Products/getAllProduct
    List<Product> getAllProduct(){
        /*return List.of(
                new Product(1L, "iPhone 13 Pro Max 128GB", 2021, 2400.0, ""),
                new Product(2L, "Samsung Galaxy S22 Ultra", 2021, 2200.0, "")
        );*/
        return repository.findAll();
    }

    @GetMapping("/getProductByID/{id}")
    ResponseEntity<ResponseObject> getProductByID(@PathVariable long id){
        //return repository.findById(id);
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok", "Query product successfully", foundProduct)
        ) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed", "Can not find product with id = " + id, "")
        );
    }
}
