package helper;

import constants.NotificationMessages;
import model.Cart;
import model.Product;
import model.Products;
import model.User;

import java.util.Scanner;

public class UserHelper {
    static Scanner in = new Scanner(System.in);
    public static void performUserActions(User user) {
        while (user.isCurrentlyLoggedIn()) {
            System.out.println(NotificationMessages.PURCHASE_ACTION_GUIDANCE);
            int userAction = in.nextInt();
            switch (userAction) {
                case 1 -> ProductHelper.displayAllProducts();
                case 2 -> addProductToCart(user);
                case 3 -> viewCart(user);
                case 4 -> user.checkoutCart();
                default -> user.Logout();
            }
        }

    }

    static void addProductToCart(User user) {
        System.out.println(NotificationMessages.ADD_PRODUCT_TO_CART);
        int productId = in.nextInt();
        System.out.println(NotificationMessages.NO_OF_ITEMS_TO_ADD);
        int numberOfItems = in.nextInt();
        user.addProductToCart(productId,numberOfItems);
        System.out.println("_____ Item added to the cart successfully________");
    }


    static void viewCart(User user) {
        Cart cartItem = user.getCart();
        for(Products products: cartItem.getProducts()) {
            Product prd = products.getProduct();
            System.out.println("Product Description: "+ prd.getDescription()+" -- Available Items: "+products.getNumberOfAvailableItems());
        }
    }
}
