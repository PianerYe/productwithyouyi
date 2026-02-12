package com.yepianer.demo;


import com.yepianer.product.ProductInfo;
import com.yepianer.untils.EasyExcelUtil;
import com.yepianer.untils.ExcelValueUtils;
import com.yepianer.untils.UUIDUntils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelExample {

//    public static void main(String[] args) {
//        String fileName = "D:\\java\\javafx\\demo\\src\\main\\java\\com\\yepianer\\excel\\产品表.xlsx";
////        //s
////        String fileName = "D:\\java\\javafx\\demo\\src\\main\\java\\com\\yepianer\\excel\\产品表.xlsx";
////        List<Map<Integer, String>> productinfo = EasyExcelUtil.syncRead(fileName);
////        System.out.println(productinfo);
////        ArrayList<ProductInfo> producatInfoes= new ArrayList<>();
////
////        for (Map<Integer,String> row : productinfo ){
////            if (row == null || row.isEmpty()) continue;
////
////            ProductInfo productInfo = mapRowToProductInfo(row);
////            producatInfoes.add(productInfo);
////                ProductInfo productInfo = new ProductInfo();
//
////            System.out.println(row.toString());
//
////            String id = row.getOrDefault(0,"").trim();
////            if (id.isEmpty() || "null".equalsIgnoreCase(id)){
////                id = UUIDUntils.generateUUIDWithoutHyphens();
////            }
////            productInfo.setId(id);
////
////            String stringProductId = row.getOrDefault(1, "").trim();
////            Integer productId = null;
////            if (!stringProductId.isEmpty() && !"null".equalsIgnoreCase(stringProductId)){
////                try {
////                    // 如果 Excel 里可能是 "1.0"，先转成整数
////                    if (stringProductId.contains(".")){
////                        productId = (int) Double.parseDouble(stringProductId);
////                    }else {
////                        productId = Integer.parseInt(stringProductId);
////                    }
////                }catch (NumberFormatException e){
////                    productId = null;
////                }
////            }
////            productInfo.setProductId(productId);
////
////            String productNameFirst = row.getOrDefault(2,"").trim();
////            if (productNameFirst.isEmpty() || "null".equalsIgnoreCase(productNameFirst)){
////                productNameFirst = null;
////            }
////            productNameFirst = ExcelValueUtils.emptyToNull(row.getOrDefault(2,"").trim());
////            productInfo.setProductNameFirst(productNameFirst);
////
////            String productNameSecond = ExcelValueUtils.emptyToNull(row.getOrDefault(3, "").trim());
////            productInfo.setProductNameSecond(productNameSecond);
//
//
////           productInfo.setProductNameFirst(ExcelValueUtils.cellString(row,2));
////
////           productInfo.setProductNameSecond(ExcelValueUtils.cellString(row,3));
////
////           productInfo.setProductType(ExcelValueUtils.cellString(row,4));
////
////           productInfo.setProductTypeOld(ExcelValueUtils.cellString(row,5));
////
////           productInfo.setImages(ExcelValueUtils.cellString(row,6));
////
////           productInfo.setSupplierName(ExcelValueUtils.cellString(row,7));
////
////           productInfo.setRemarks(ExcelValueUtils.cellString(row,8));
//
////            System.out.println(productInfo);
////           producatInfoes.add(productInfo);
////            System.out.println("输出的对象数组=================" + producatInfoes + "==================");
//
////        }
////        System.out.println(producatInfoes);
//        List<ProductInfo> productInfos = GetProductInfos(fileName);
//        System.out.println(productInfos);
//    }

    /* 导入文件进行读取放置于类中 */
    public static  List<ProductInfo> GetProductInfos (String fileName){
        List<Map<Integer, String>> productinfo = EasyExcelUtil.syncRead(fileName);
        System.out.println(productinfo);
        ArrayList<ProductInfo> producatInfoes= new ArrayList<>();

        for (Map<Integer,String> row : productinfo ) {
            if (row == null || row.isEmpty()) continue;

            ProductInfo productInfo = mapRowToProductInfo(row);
            producatInfoes.add(productInfo);
        }
        return producatInfoes;
    }

    private static ProductInfo mapRowToProductInfo(Map<Integer, String> row) {
        ProductInfo productInfo = new ProductInfo();

        String id = row.getOrDefault(0,"").trim();
        if (id.isEmpty() || "null".equalsIgnoreCase(id)){
            id = UUIDUntils.generateUUIDWithoutHyphens();
        }
        productInfo.setId(id);

        String stringProductId = row.getOrDefault(1, "").trim();
        Integer productId = null;
        if (!stringProductId.isEmpty() && !"null".equalsIgnoreCase(stringProductId)){
            try {
                // 如果 Excel 里可能是 "1.0"，先转成整数
                if (stringProductId.contains(".")){
                    productId = (int) Double.parseDouble(stringProductId);
                }else {
                    productId = Integer.parseInt(stringProductId);
                }
            }catch (NumberFormatException e){
                productId = null;
            }
        }
        productInfo.setProductId(String.valueOf(productId));

        productInfo.setProductNameFirst(ExcelValueUtils.cellString(row,2));

        productInfo.setProductNameSecond(ExcelValueUtils.cellString(row,3));

        productInfo.setProductType(ExcelValueUtils.cellString(row,4));

        productInfo.setProductTypeOld(ExcelValueUtils.cellString(row,5));

        productInfo.setImages(ExcelValueUtils.cellString(row,6));

        productInfo.setSupplierName(ExcelValueUtils.cellString(row,7));

        productInfo.setRemarks(ExcelValueUtils.cellString(row,8));

        return productInfo;
    }
}
