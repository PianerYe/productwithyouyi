package com.yepianer.product;

import java.util.Objects;

/**
 * @author Administrator
 * @descripiton 供应商代码
 * @since 2026/2/11
 */
public class Suppiler {

    private String supplierId;
    private String supplierName;
    private String supplierCode;

    public Suppiler(String supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Suppiler{" +
                "supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", supplierCode='" + supplierCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Suppiler suppiler = (Suppiler) o;
        return Objects.equals(supplierId, suppiler.supplierId) && Objects.equals(supplierName, suppiler.supplierName) && Objects.equals(supplierCode, suppiler.supplierCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName, supplierCode);
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }
}
