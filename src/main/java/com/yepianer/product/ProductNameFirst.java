package com.yepianer.product;

import java.util.Objects;

public class ProductNameFirst {

    private String productNameFirstId;
    private String productNameFirst;
    private String productNameFirstCode;

    @Override
    public String toString() {
        return "ProductNameFirst{" +
                "productNameFirstId=" + productNameFirstId +
                ", productNameFirst='" + productNameFirst + '\'' +
                ", productNameFirstCode='" + productNameFirstCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductNameFirst that = (ProductNameFirst) o;
        return Objects.equals(productNameFirstId, that.productNameFirstId) && Objects.equals(productNameFirst, that.productNameFirst) && Objects.equals(productNameFirstCode, that.productNameFirstCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productNameFirstId, productNameFirst, productNameFirstCode);
    }

    public ProductNameFirst(String productNameFirstId, String productNameFirst, String productNameFirstCode) {
        this.productNameFirstId = productNameFirstId;
        this.productNameFirst = productNameFirst;
        this.productNameFirstCode = productNameFirstCode;
    }

    public String getProductNameFirstId() {
        return productNameFirstId;
    }

    public void setProductNameFirstId(String productNameFirstId) {
        this.productNameFirstId = productNameFirstId;
    }

    public String getProductNameFirst() {
        return productNameFirst;
    }

    public void setProductNameFirst(String productNameFirst) {
        this.productNameFirst = productNameFirst;
    }

    public String getProductNameFirstCode() {
        return productNameFirstCode;
    }

    public void setProductNameFirstCode(String productNameFirstCode) {
        this.productNameFirstCode = productNameFirstCode;
    }
}
