package com.revature.controllers;

import com.revature.daos.CartItemDAO;
import com.revature.models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartItemController {
    private final CartItemDAO cartItemDao;

    @Autowired
    public CartItemController(CartItemDAO cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartItemDao.findAll();
    }

    @PostMapping
    public void addToCart(@RequestBody CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartItemDao.deleteById(id);
    }

}
