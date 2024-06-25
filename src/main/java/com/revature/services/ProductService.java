package com.revature.services;

import com.revature.daos.ProductDAO;
import com.revature.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductDAO ProductDao;

    @Autowired
    private ProductDAO productDao;

    public List<Product> getAllProducts() {
        // Check user role
        // TODO : Role check

        return productDao.findAll();
    }

    public Product getProductById(Long id) {
        // Check user role
        // TODO : Role check

        return productDao.findById(id).orElse(null);
    }

    public boolean addProduct(Product product) {
        // Check user role
        // TODO : Role check

        // Check if item exists
        Optional<Product> p = productDao.findById(product.getId());
        if (p.isPresent()) {
            // Item exists
            return false;
        }

        // Add Item
        productDao.save(product);
        return true;
    }

    public boolean deleteProduct(Long id) {
        // Check user role
        // TODO : Role check

        // Check if item exists
        Optional<Product> p = productDao.findById(id);
        if (p.isEmpty()) {
            // Item doesn't exist
            return false;
        }

        // Delete Item
        productDao.delete(p.get());
        return true;
    }

    public boolean updateProduct(Product product) {
        // Check user role
        // TODO : Role check

        // Check if item exists
        Optional<Product> p = productDao.findById(product.getId());
        if (p.isEmpty()) {
            // Item does not exist
            return false;
        }
        Product newProduct = p.get();

        // Check each value and update accordingly
        if (!product.getName().isBlank()) {
            newProduct.setName(product.getName());
        }

        if (!product.getDescription().isBlank()) {
            newProduct.setDescription(product.getDescription());
        }

        if (product.getPrice() != 0 && product.getPrice() != newProduct.getPrice()) {
            newProduct.setPrice(product.getPrice());
        }

        if (!product.getImageUrl().isBlank()) {
            newProduct.setImageUrl(product.getImageUrl());
        }

        productDao.save(newProduct);
        return true;
    }
}
