package com.revature.controllers;

import com.revature.models.Product;
import com.revature.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // View all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // View a product by id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Add Product
    @PostMapping("/add")
    public boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // Delete Product
    @DeleteMapping("/delete/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }

    // Edit Product
    @PutMapping("/{id}")
    public boolean updateProduct(@PathVariable Product p) {
        return productService.updateProduct(p);
    }

}

