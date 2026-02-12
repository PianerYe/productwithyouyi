package com.yepianer.product;

import java.util.Objects;

public class ProductInfo {

    private String id;
    private String productId;
    private String productNameFirst;
    private String productNameSecond;

    private String productType;
    private String productTypeOld;

    private String images;

    private String supplierName;

    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductNameFirst() {
        return productNameFirst;
    }

    public void setProductNameFirst(String productNameFirst) {
        this.productNameFirst = productNameFirst;
    }

    public String getProductNameSecond() {
        return productNameSecond;
    }

    public void setProductNameSecond(String productNameSecond) {
        this.productNameSecond = productNameSecond;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductTypeOld() {
        return productTypeOld;
    }

    public void setProductTypeOld(String productTypeOld) {
        this.productTypeOld = productTypeOld;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
      //  Productinfo that = (Productinfo) o;
        ProductInfo that = (ProductInfo) o;
        return id == that.id && productId == that.productId && Objects.equals(productNameFirst, that.productNameFirst) && Objects.equals(productNameSecond, that.productNameSecond) && Objects.equals(productType, that.productType) && Objects.equals(productTypeOld, that.productTypeOld) && Objects.equals(images, that.images) && Objects.equals(supplierName, that.supplierName) && Objects.equals(remarks, that.remarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, productNameFirst, productNameSecond, productType, productTypeOld, images, supplierName, remarks);
    }

    @Override
    public String toString() {
        return "productinfo{" +
                "id=" + id +
                ", productId=" + productId +
                ", productNameFirst='" + productNameFirst + '\'' +
                ", productNameSecond='" + productNameSecond + '\'' +
                ", productType='" + productType + '\'' +
                ", productTypeOld='" + productTypeOld + '\'' +
                ", images='" + images + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
