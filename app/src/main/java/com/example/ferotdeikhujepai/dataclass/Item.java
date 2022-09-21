package com.example.ferotdeikhujepai.dataclass;

public class Item {
    private String ProductName;
    private String ProductDescription;
    private int ProductImage;

    public Item(String productName, String productDescription, int image) {
        ProductName = productName;
        ProductDescription = productDescription;
        this.ProductImage = image;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        ProductDescription = productDescription;
    }

    public int getImage() {
        return ProductImage;
    }

    public void setImage(int image) {
        this.ProductImage = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", image=" + ProductImage +
                '}';
    }
}
