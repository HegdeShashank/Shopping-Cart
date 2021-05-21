package helper;

import model.Product;
import model.Products;

import java.util.List;

public class CartHelper {

    public static Products getCartItemToBeAdded(int productID,int noOfItems) {
        Products inventoryItem = ProductHelper.findProductWithID(productID);
        assert inventoryItem != null;
        Product product = inventoryItem.getProduct();
        int totalAvailableItems = inventoryItem.getNumberOfAvailableItems();
        if(totalAvailableItems < noOfItems) {
            System.out.println("Maximum "+totalAvailableItems+" can be added to the cart.");
        }
        return new Products(product,Math.min(noOfItems,inventoryItem.getNumberOfAvailableItems()));
    }


    public static double getTotalValueOfItemsInTheCart(List<Products> productsList) {
        double sum =0.0;
        for(Products products: productsList) {
            double productPrice = products.getPrice() * products.getNumberOfAvailableItems();
            sum+=productPrice;
        }
        return sum;
    }
}
