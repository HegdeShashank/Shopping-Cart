package model;

import helper.ProductHelper;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    int userID;

    public List<Products> getProducts() {
        return productsList;
    }

    List<Products> productsList;

    public Cart(int userID) {
        this.userID = userID;
        this.productsList = new ArrayList<>();
    }

    void addCartItem(int productID,int noOfItems) {
        Products inventoryItem = ProductHelper.findProductWithID(productID);
        assert inventoryItem != null;
        Product product = inventoryItem.getProduct();
        Products products = new Products(product,Math.min(noOfItems,inventoryItem.getNumberOfAvailableItems()));
        productsList.add(products);
    }

    public void removeAllFromCart() {
        this.productsList = new ArrayList<>();
    }

    public double getTotalValueOfCart() {
        double sum =0.0;
        for(Products products: productsList) {
            double productPrice = products.getPrice() * products.getNumberOfAvailableItems();
            sum+=productPrice;
        }
        return sum;
    }
}
