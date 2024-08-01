package com.tikim.org.musinsa.domain.product.repository;

import com.tikim.org.musinsa.domain.product.dto.MinPriceProductByCategory;
import com.tikim.org.musinsa.domain.product.dto.MinPriceProductByBrand;
import com.tikim.org.musinsa.domain.product.dto.CategoryMinMaxPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.tikim.org.musinsa.domain.product.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "WITH MinPricePerCategory AS ( " +
                   "    SELECT category_id, MIN(price) AS min_price " +
                   "    FROM product " +
                   "    GROUP BY category_id), " +
                   "RankedProducts AS ( " +
                   "    SELECT p.id, p.brand_id, p.category_id, p.price, ROW_NUMBER() OVER (PARTITION BY p.category_id ORDER BY p.price ASC, p.id DESC) as r " +
                   "    FROM product p " +
                   "    JOIN MinPricePerCategory mpc ON p.category_id = mpc.category_id AND p.price = mpc.min_price) " +
                   "SELECT p.id AS id, p.brand_id AS brandId, p.category_id AS categoryId, p.price AS price " +
                   "FROM product p " +
                   "JOIN RankedProducts rp ON p.id = rp.id AND rp.r = 1 " +
                   "ORDER BY p.category_id ASC", nativeQuery = true)
    List<MinPriceProductByCategory> findMinPriceProductsByCategory();

    @Query(value = "WITH CategoryMinPrices AS ( " +
                   "    SELECT category_id, brand_id, MIN(price) AS min_price " +
                   "    FROM product " +
                   "    GROUP BY category_id, brand_id), " +
                   "BrandPriceRanking AS ( " +
                   "    SELECT cmp.brand_id, ROW_NUMBER() OVER (ORDER BY SUM(cmp.min_price) ASC, cmp.brand_id) as r " +
                   "    FROM CategoryMinPrices cmp " +
                   "    GROUP BY cmp.brand_id) " +
                   "SELECT cmp.id AS id, cmp.brand_id AS brandId, cmp.category_id AS categoryId, cmp.min_price AS price " +
                   "FROM CategoryMinPrices cmp " +
                   "JOIN BrandPriceRanking bpr ON cmp.brand_id = bpr.brand_id AND bpr.r = 1", nativeQuery = true)
    List<MinPriceProductByBrand> findMinPriceProductsByBrand();

    @Query(value = "WITH MinPricePerCategory AS ( " +
                   "    SELECT p.brand_id, MIN(p.price) AS min_price, ROW_NUMBER() OVER (ORDER BY MIN(p.price) ASC, p.brand_id) AS min_r, MAX(p.price) AS max_price, ROW_NUMBER() OVER (ORDER BY MAX(p.price) DESC, p.brand_id) AS max_r " +
                   "    FROM product p WHERE p.category_id = ?1 " +
                   "    GROUP BY p.brand_id) " +
                   "SELECT b.name AS brandName, mpc.min_price AS price " +
                   "FROM MinPricePerCategory mpc " +
                   "JOIN brand b ON mpc.brand_id = b.id " +
                   "WHERE mpc.min_r = 1 " +
                   "UNION ALL " +
                   "SELECT b.name AS brandName, mpc.max_price AS price " +
                   "FROM MinPricePerCategory mpc " +
                   "JOIN brand b ON mpc.brand_id = b.id " +
                   "WHERE mpc.max_r = 1", nativeQuery = true)
    List<CategoryMinMaxPrice> findCategoryMinMaxPrice(Long categoryId);
}
