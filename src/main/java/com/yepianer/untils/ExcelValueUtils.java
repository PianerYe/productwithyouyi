package com.yepianer.untils;

import java.util.Map;

public class ExcelValueUtils {
    private ExcelValueUtils() {}
    /**
     * 空 / "null" / 空白字符串 → null
     */
    public static String emptyToNull(String val) {
        if (val == null){
            return null;
        }
        String v = val.trim();
        return v.isEmpty() || "null".equalsIgnoreCase(v) ? null : v;
    }

    public static String cellString(Map<Integer, String> row, int index) {
        if (row == null) return null;
        String val = row.get(index);
        return emptyToNull(val);
    }
}
