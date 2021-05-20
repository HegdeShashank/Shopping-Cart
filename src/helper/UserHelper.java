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
            System.out.println("Enter 1 to view all products");
            System.out.println("Enter 2 to add product to cart");
            System.out.println("Enter 3 to view the cart");
            System.out.println("Enter 4 to purchase product that are in the cart");
            System.out.println("Press any key to logout");
            String userAction = in.nextLine();
            switch (userAction) {
                case "1" : ProductHelper.displayAllProducts(); break;
                case "2" : addProductToCart(user); break;
                case "3":  viewCart(user); break;
                case "4" : user.checkoutCart();break;
                default: user.Logout();
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
