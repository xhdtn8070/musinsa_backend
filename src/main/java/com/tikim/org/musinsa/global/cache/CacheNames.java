package com.tikim.org.musinsa.global.cache;

public class CacheNames {
    public static final String BRAND_ONE = "BRAND::ONE";
    public static final String BRAND_ALL = "BRAND::ALL";
    public static final String CATEGORY_ONE = "CATEGORY::ONE";
    public static final String CATEGORY_ALL = "CATEGORY::ALL";
    public static final String PRODUCT_ONE = "PRODUCT::ONE";
    public static final String PRODUCT_ALL = "PRODUCT::ALL";

    public static String[] getCacheNames() {
        return new String[] {BRAND_ONE, BRAND_ALL, CATEGORY_ONE, CATEGORY_ALL, PRODUCT_ONE, PRODUCT_ALL};
    }
}
