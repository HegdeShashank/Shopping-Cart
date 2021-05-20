package helper;

import model.Product;
import model.Products;

public class CartHelper {

    public static Products getCartItemToBeAdded(int productID,int noOfItems) {
        Products inventoryItem = ProductHelper.findProductWithID(productID);
        assert inventoryItem != null;
        Product product = inventoryItem.getProduct();
        return new Products(product,Math.min(noOfItems,inventoryItem.getNumberOfAvailableItems()));
    }
}
