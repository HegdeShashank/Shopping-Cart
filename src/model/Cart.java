package model;

import helper.CartHelper;
import helper.ProductHelper;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    int userID;
    List<Products> productsList;

    public List<Products> getProducts() {
        return productsList;
    }

    public Cart(int userID) {
        this.userID = userID;
        this.productsList = new ArrayList<>();
    }

    void addCartItem(int productID,int noOfItems) {
        Products products = CartHelper.getCartItemToBeAdded(productID,noOfItems);
        productsList.add(products);
    }

    public void removeAllFromCart() {
        for(Products products: productsList) {
            ProductHelper.removeProductItemsFromInventory(products.getID(),products.getNumberOfAvailableItems());
        }
        this.productsList = new ArrayList<>();
    }

    public double getTotalValueOfCart() {
        return CartHelper.getTotalValueOfItemsInTheCart(productsList);
    }

}
