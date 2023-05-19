package com.example.cart;

import com.example.topic.Topic;

public class CartItem {
    private Topic topic;
    private int quantity;
    private Double price;

    public CartItem(Topic topic, int quantity, Double price) {
        this.topic = topic;
        this.quantity = quantity;
        this.price = price;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
