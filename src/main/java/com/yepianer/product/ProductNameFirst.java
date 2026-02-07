package com.yepianer.product;

import java.util.Objects;

public class ProductNameFirst {

    private String nameFirstId;
    private String nameFirstCode;

    public String getNameFirstId() {
        return nameFirstId;
    }

    public void setNameFirstId(String nameFirstId) {
        this.nameFirstId = nameFirstId;
    }

    public String getNameFirstCode() {
        return nameFirstCode;
    }

    public void setNameFirstCode(String nameFirstCode) {
        this.nameFirstCode = nameFirstCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductNameFirst that = (ProductNameFirst) o;
        return Objects.equals(nameFirstId, that.nameFirstId) && Objects.equals(nameFirstCode, that.nameFirstCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameFirstId, nameFirstCode);
    }

    @Override
    public String toString() {
        return "ProductNameFirst{" +
                "nameFirstId='" + nameFirstId + '\'' +
                ", nameFirstCode='" + nameFirstCode + '\'' +
                '}';
    }
}
