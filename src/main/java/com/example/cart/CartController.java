package com.example.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping
    public ResponseEntity<List<CartItem>> getCartDetails(){

        return ResponseEntity.ok(cartService.getCartDetails());

    }

    @PostMapping(value = "{Id}")
    public ResponseEntity<String> addToCart(@PathVariable String Id){
        return ResponseEntity.ok(cartService.addToCart(Id));
    }

    @GetMapping(value = "cartValue")
    public ResponseEntity<Double> getCartValue(){
        return ResponseEntity.ok(cartService.calculateCartValue());
    }

}
