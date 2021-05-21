package model;

public class Products {
    private Product product;
    private int numberOfAvailableItems;
    public Products(Product product, int noOfAvailableItems) {
        this.product = product;
        this.numberOfAvailableItems = noOfAvailableItems;
    }

    public Product getProduct() {
        return product;
    }

    public int getNumberOfAvailableItems() {
        return numberOfAvailableItems;
    }


    public void setNumberOfAvailableItems(int numberOfAvailableItems) {
        this.numberOfAvailableItems = numberOfAvailableItems;
    }
    public int getID() {
        return product.getID();
    }

    public String getName() {
        return product.getName();
    }

    public String getDescription() {
        return product.getDescription();
    }

    public double getPrice() {
        return product.getPrice();
    }

}
