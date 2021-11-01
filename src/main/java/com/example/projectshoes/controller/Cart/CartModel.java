package com.example.projectshoes.controller.Cart;

import java.util.ArrayList;

public class CartModel {
    private ArrayList<LineItem> items;

    public CartModel() {
        items = new ArrayList<LineItem>();
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }

    public void addItem(LineItem item) {
        String code = item.getProduct().getName();
        int quantity = item.getQuantity();
        for (LineItem cartItem : items) {
            if (cartItem.getProduct().getName().equals(code)) {
                cartItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }

    public void removeItem(LineItem item) {
        String code = item.getProduct().getName();
        for (int i = 0; i < items.size(); i++) {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getName().equals(code)) {
                items.remove(i);
                return;
            }
        }
    }
    public double totalPrice(LineItem item){
        double total=0;
        for(int i=0;i<items.size();i++){
            LineItem lineItem=items.get(i);
            total+=lineItem.getTotal();
        }
        return total;
    }
}
