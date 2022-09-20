package com.example.ferotdeikhujepai.dataclass;

public class Item {
    private String ProductName;
    private String ProductDescription;
    private int image;

    public Item(String productName, String productDescription, int image) {
        ProductName = productName;
        ProductDescription = productDescription;
        this.image = image;
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
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ProductName='" + ProductName + '\'' +
                ", ProductDescription='" + ProductDescription + '\'' +
                ", image=" + image +
                '}';
    }
}
