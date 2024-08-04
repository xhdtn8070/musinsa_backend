package com.tikim.org.musinsa.domain.product.repository;

import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByCategory;
import com.tikim.org.musinsa.domain.product.repository.dto.response.MinPriceProductByBrand;
import com.tikim.org.musinsa.domain.product.repository.dto.response.CategoryMinMaxPrice;
import jakarta.annotation.Nonnull;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tikim.org.musinsa.domain.product.entity.Product;

import java.util.List;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "WITH MinPricePerCategory AS ( " +
        "    SELECT category_id, MIN(price) AS min_price " +
        "    FROM product " +
        "    GROUP BY category_id), " +
        "RankedProducts AS ( " +
        "    SELECT p.id, ROW_NUMBER() OVER (PARTITION BY p.category_id ORDER BY p.price ASC, p.id DESC) as r " +
        "    FROM product p " +
        "    JOIN MinPricePerCategory mpc ON p.category_id = mpc.category_id AND p.price = mpc.min_price) " +
        "SELECT c.name AS categoryName, b.name AS brandName, p.price AS price " +
        "FROM product p " +
        "JOIN RankedProducts rp ON p.id = rp.id AND rp.r = 1 " +
        "JOIN brand b ON p.brand_id = b.id " +
        "JOIN category c ON p.category_id = c.id " +
        "ORDER BY c.id ASC;", nativeQuery = true)
    List<MinPriceProductByCategory> findMinPriceProductsByCategory();

    @Query(value = "WITH CategoryMinPrices AS ( " +
        "    SELECT p.category_id, p.brand_id, MIN(p.price) AS min_price " +
        "    FROM product p " +
        "    GROUP BY p.category_id, p.brand_id), " +
        "BrandPriceRanking AS ( " +
        "    SELECT cmp.brand_id, ROW_NUMBER() OVER (ORDER BY SUM(cmp.min_price) ASC, cmp.brand_id) as r " +
        "    FROM CategoryMinPrices cmp " +
        "    GROUP BY cmp.brand_id) " +
        "SELECT b.name AS brandName, c.name AS categoryName, cmp.min_price AS price " +
        "FROM CategoryMinPrices cmp " +
        "JOIN BrandPriceRanking bpr ON cmp.brand_id = bpr.brand_id AND bpr.r = 1 " +
        "JOIN brand b ON cmp.brand_id = b.id " +
        "JOIN category c ON cmp.category_id = c.id " +
        "ORDER BY c.id ASC;", nativeQuery = true)
    List<MinPriceProductByBrand> findMinPriceProductsByBrand();

    @Query(value = "WITH MinPricePerCategory AS ( " +
        "    SELECT p.brand_id, MIN(p.price) AS min_price " +
        "    FROM product p WHERE p.category_id = :categoryId " +
        "    GROUP BY p.brand_id " +
        "    ORDER BY min_price ASC " +
        "    LIMIT 1) " +
        "SELECT b.name AS brandName, mpc.min_price AS price " +
        "FROM MinPricePerCategory mpc " +
        "JOIN brand b ON mpc.brand_id = b.id", nativeQuery = true)
    Optional<CategoryMinMaxPrice> findMinPriceByCategory(@Param("categoryId") Long categoryId);

    @Query(value = "WITH MaxPricePerCategory AS ( " +
        "    SELECT p.brand_id, MAX(p.price) AS max_price " +
        "    FROM product p WHERE p.category_id = :categoryId " +
        "    GROUP BY p.brand_id " +
        "    ORDER BY max_price DESC " +
        "    LIMIT 1) " +
        "SELECT b.name AS brandName, xpc.max_price AS price " +
        "FROM MaxPricePerCategory xpc " +
        "JOIN brand b ON xpc.brand_id = b.id", nativeQuery = true)
    Optional<CategoryMinMaxPrice> findMaxPriceByCategory(@Param("categoryId") Long categoryId);

    boolean existsByBrandId(@Nonnull Long brandId);

    boolean existsByCategoryId(@Nonnull Long categoryId);

}
