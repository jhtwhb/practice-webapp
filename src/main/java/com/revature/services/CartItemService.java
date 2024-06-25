package com.revature.services;

import com.revature.daos.CartItemDAO;
import com.revature.models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private CartItemDAO cartItemDao;

    public List<CartItem> getCartItems() {
        return cartItemDao.findAll();
    }

    public void addToCart(CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    public void removeFromCart(Long id) {
        cartItemDao.deleteById(id);
    }

}
