package helper;

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
}
