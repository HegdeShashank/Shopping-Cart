package model;

import java.util.ArrayList;
import java.util.Date;

public class User {
    private int userID;
    private String name;
    private String address;
    private Date DOB;
    private UserLogin login;

    public Cart getCart() {
        return cart;
    }

    private Cart cart;

    public User(int userID, String name, String address, Date DOB, UserLogin login) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.DOB = DOB;
        this.cart = new Cart(userID);
        this.login = login;
    }

    public boolean authenticateUser(String password) {
        if (login.getPassword().equals(password)) {
            login.setIsCurrentlyActive(true);
            return true;
        }
        return false;
    }

    public String getUserName() {
        return login.getUserName();
    }
    public void addProductToCart(int productID,int numberOfItems) {
        cart.addCartItem(productID,numberOfItems);
    }

    public void checkoutCart() {
        System.out.println(cart.getTotalValueOfCart());
        cart.removeAllFromCart();
    }

    public boolean isCurrentlyLoggedIn() {
        return login.isCurrentlyActive();
    }
    public void Logout() {
        login.setIsCurrentlyActive(false);
    }
}
