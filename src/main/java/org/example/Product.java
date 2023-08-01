package org.example;

public class Product {
    String productName;
    double productCode;
    String productBrand;
    double productPrice;


    public Product(String productName, double productCode, String productBrand, double productPrice) {
        this.productName = productName;
        this.productCode = productCode;
        this.productBrand = productBrand;
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "{"+"product name: "+ productName + ", " + "product code: " + productCode + ", " +"product brand: "+ productBrand+ ", product price"+ productPrice + "}\n";
    }
}
