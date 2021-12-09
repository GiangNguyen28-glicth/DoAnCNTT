package com.example.projectshoes.model;

import com.example.projectshoes.model.ProductModel;

import java.text.NumberFormat;

public class LineItem {
    private ProductModel product;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private int quantity;

    public ProductModel getProduct() {
        return product;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }
    public float getTotal(){
        return product.getPrice()*quantity;
    }
    public LineItem(){ }
    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}
