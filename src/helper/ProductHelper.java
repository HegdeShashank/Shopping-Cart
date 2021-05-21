package helper;

import model.Product;
import model.Products;
import utils.CommonUtil;

import java.util.List;

public class ProductHelper {
    static List<Products> getAllProducts() {
        return CommonUtil.inventory;
    }

    static void displayAllProducts() {
        List<Products> products = getAllProducts();

        System.out.println("----------------------------------");
        System.out.println("List of all products");
        System.out.println("----------------------------------");
        for(Products product: products) {
            System.out.println("Product ID:"+product.getID()+ " Name:"+product.getName()+" Description:"+product.getDescription()+" Price:"+product.getPrice()+ " Availability:"+ product.getNumberOfAvailableItems());
        }
        System.out.println("----------------------------------");
    }

    public static Products findProductWithID(int productID) {
        List<Products> products = getAllProducts();
        for(Products product: products) {
           if(product.getID()== productID)
               return product;
        }
        return null;
    }

    public static void removeProductItemsFromInventory(int productId, int noOfItems) {
        Products prd = findProductWithID(productId);
        assert prd != null;
        int availableInvItems = prd.getNumberOfAvailableItems();
        if (availableInvItems == noOfItems) {
            deleteProductFromInventory(productId);
        } else {
            prd.setNumberOfAvailableItems(availableInvItems - noOfItems);
        }

    }

    public static void deleteProductFromInventory(int productId) {
        List<Products> inventory = getAllProducts();
        inventory.remove(findProductWithID(productId));
    }

}
