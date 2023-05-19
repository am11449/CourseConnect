package com.example.cart;

import com.example.topic.Topic;
import com.example.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private TopicRepository topicRepository;
    private List<CartItem> cart;

    @Autowired
    public CartService(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
        cart = new ArrayList<>();
    }

    public String addToCart(String Id){
        Optional<Topic> topic = topicRepository.findById(Id);
        if (topic.isPresent()){

            cart.add(new CartItem(topic.get(), 10, 10.00));

        }
        else {
            throw new RuntimeException();
        }

        return Id;

    }

    public List<CartItem> getCartDetails(){
        return cart;
    }

    public double calculateCartValue(){

        double cartValue = 0.00;

        for(CartItem cartItem: cart){

            cartValue += cartItem.getPrice();

        }

        return cartValue;
    }


}
