package com.tikim.org.musinsa.integration.product.util;

import com.tikim.org.musinsa.domain.brand.entity.Brand;
import com.tikim.org.musinsa.domain.brand.repository.BrandRepository;
import com.tikim.org.musinsa.domain.category.entity.Category;
import com.tikim.org.musinsa.domain.category.repository.CategoryRepository;
import com.tikim.org.musinsa.domain.product.entity.Product;
import com.tikim.org.musinsa.domain.product.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestSetupUtil {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        productRepository.deleteAll();
        brandRepository.deleteAll();
        categoryRepository.deleteAll();

        productRepository.flush();
        brandRepository.flush();
        categoryRepository.flush();

        // 브랜드 데이터 삽입
        Brand brandA = brandRepository.save(Brand.builder().name("A").build());
        Brand brandB = brandRepository.save(Brand.builder().name("B").build());
        Brand brandC = brandRepository.save(Brand.builder().name("C").build());
        Brand brandD = brandRepository.save(Brand.builder().name("D").build());
        Brand brandE = brandRepository.save(Brand.builder().name("E").build());
        Brand brandF = brandRepository.save(Brand.builder().name("F").build());
        Brand brandG = brandRepository.save(Brand.builder().name("G").build());
        Brand brandH = brandRepository.save(Brand.builder().name("H").build());
        Brand brandI = brandRepository.save(Brand.builder().name("I").build());

        // 카테고리 데이터 삽입
        Category categoryTop = categoryRepository.save(Category.builder().name("상의").build());
        Category categoryOuter = categoryRepository.save(Category.builder().name("아우터").build());
        Category categoryPants = categoryRepository.save(Category.builder().name("바지").build());
        Category categorySneakers = categoryRepository.save(Category.builder().name("스니커즈").build());
        Category categoryBag = categoryRepository.save(Category.builder().name("가방").build());
        Category categoryHat = categoryRepository.save(Category.builder().name("모자").build());
        Category categorySocks = categoryRepository.save(Category.builder().name("양말").build());
        Category categoryAccessory = categoryRepository.save(Category.builder().name("액세서리").build());

        // 상품 데이터 삽입
        productRepository.save(Product.builder().brand(brandA).category(categoryTop).price(11200).build());
        productRepository.save(Product.builder().brand(brandA).category(categoryOuter).price(5500).build());
        productRepository.save(Product.builder().brand(brandA).category(categoryPants).price(4200).build());
        productRepository.save(Product.builder().brand(brandA).category(categorySneakers).price(9000).build());
        productRepository.save(Product.builder().brand(brandA).category(categoryBag).price(2000).build());
        productRepository.save(Product.builder().brand(brandA).category(categoryHat).price(1700).build());
        productRepository.save(Product.builder().brand(brandA).category(categorySocks).price(1800).build());
        productRepository.save(Product.builder().brand(brandA).category(categoryAccessory).price(2300).build());

        productRepository.save(Product.builder().brand(brandB).category(categoryTop).price(10500).build());
        productRepository.save(Product.builder().brand(brandB).category(categoryOuter).price(5900).build());
        productRepository.save(Product.builder().brand(brandB).category(categoryPants).price(3800).build());
        productRepository.save(Product.builder().brand(brandB).category(categorySneakers).price(9100).build());
        productRepository.save(Product.builder().brand(brandB).category(categoryBag).price(2100).build());
        productRepository.save(Product.builder().brand(brandB).category(categoryHat).price(2000).build());
        productRepository.save(Product.builder().brand(brandB).category(categorySocks).price(2000).build());
        productRepository.save(Product.builder().brand(brandB).category(categoryAccessory).price(2200).build());

        productRepository.save(Product.builder().brand(brandC).category(categoryTop).price(10000).build());
        productRepository.save(Product.builder().brand(brandC).category(categoryOuter).price(6200).build());
        productRepository.save(Product.builder().brand(brandC).category(categoryPants).price(3300).build());
        productRepository.save(Product.builder().brand(brandC).category(categorySneakers).price(9200).build());
        productRepository.save(Product.builder().brand(brandC).category(categoryBag).price(2200).build());
        productRepository.save(Product.builder().brand(brandC).category(categoryHat).price(1900).build());
        productRepository.save(Product.builder().brand(brandC).category(categorySocks).price(2200).build());
        productRepository.save(Product.builder().brand(brandC).category(categoryAccessory).price(2100).build());

        productRepository.save(Product.builder().brand(brandD).category(categoryTop).price(10100).build());
        productRepository.save(Product.builder().brand(brandD).category(categoryOuter).price(5100).build());
        productRepository.save(Product.builder().brand(brandD).category(categoryPants).price(3000).build());
        productRepository.save(Product.builder().brand(brandD).category(categorySneakers).price(9500).build());
        productRepository.save(Product.builder().brand(brandD).category(categoryBag).price(2500).build());
        productRepository.save(Product.builder().brand(brandD).category(categoryHat).price(1500).build());
        productRepository.save(Product.builder().brand(brandD).category(categorySocks).price(2400).build());
        productRepository.save(Product.builder().brand(brandD).category(categoryAccessory).price(2000).build());

        productRepository.save(Product.builder().brand(brandE).category(categoryTop).price(10700).build());
        productRepository.save(Product.builder().brand(brandE).category(categoryOuter).price(5000).build());
        productRepository.save(Product.builder().brand(brandE).category(categoryPants).price(3800).build());
        productRepository.save(Product.builder().brand(brandE).category(categorySneakers).price(9900).build());
        productRepository.save(Product.builder().brand(brandE).category(categoryBag).price(2300).build());
        productRepository.save(Product.builder().brand(brandE).category(categoryHat).price(1800).build());
        productRepository.save(Product.builder().brand(brandE).category(categorySocks).price(2100).build());
        productRepository.save(Product.builder().brand(brandE).category(categoryAccessory).price(2100).build());

        productRepository.save(Product.builder().brand(brandF).category(categoryTop).price(11200).build());
        productRepository.save(Product.builder().brand(brandF).category(categoryOuter).price(7200).build());
        productRepository.save(Product.builder().brand(brandF).category(categoryPants).price(4000).build());
        productRepository.save(Product.builder().brand(brandF).category(categorySneakers).price(9300).build());
        productRepository.save(Product.builder().brand(brandF).category(categoryBag).price(2100).build());
        productRepository.save(Product.builder().brand(brandF).category(categoryHat).price(1600).build());
        productRepository.save(Product.builder().brand(brandF).category(categorySocks).price(2300).build());
        productRepository.save(Product.builder().brand(brandF).category(categoryAccessory).price(1900).build());

        productRepository.save(Product.builder().brand(brandG).category(categoryTop).price(10500).build());
        productRepository.save(Product.builder().brand(brandG).category(categoryOuter).price(5800).build());
        productRepository.save(Product.builder().brand(brandG).category(categoryPants).price(3900).build());
        productRepository.save(Product.builder().brand(brandG).category(categorySneakers).price(9000).build());
        productRepository.save(Product.builder().brand(brandG).category(categoryBag).price(2200).build());
        productRepository.save(Product.builder().brand(brandG).category(categoryHat).price(1700).build());
        productRepository.save(Product.builder().brand(brandG).category(categorySocks).price(2100).build());
        productRepository.save(Product.builder().brand(brandG).category(categoryAccessory).price(2000).build());

        productRepository.save(Product.builder().brand(brandH).category(categoryTop).price(10800).build());
        productRepository.save(Product.builder().brand(brandH).category(categoryOuter).price(6300).build());
        productRepository.save(Product.builder().brand(brandH).category(categoryPants).price(3100).build());
        productRepository.save(Product.builder().brand(brandH).category(categorySneakers).price(9700).build());
        productRepository.save(Product.builder().brand(brandH).category(categoryBag).price(2100).build());
        productRepository.save(Product.builder().brand(brandH).category(categoryHat).price(1600).build());
        productRepository.save(Product.builder().brand(brandH).category(categorySocks).price(2000).build());
        productRepository.save(Product.builder().brand(brandH).category(categoryAccessory).price(2000).build());

        productRepository.save(Product.builder().brand(brandI).category(categoryTop).price(11400).build());
        productRepository.save(Product.builder().brand(brandI).category(categoryOuter).price(6700).build());
        productRepository.save(Product.builder().brand(brandI).category(categoryPants).price(3200).build());
        productRepository.save(Product.builder().brand(brandI).category(categorySneakers).price(9500).build());
        productRepository.save(Product.builder().brand(brandI).category(categoryBag).price(2400).build());
        productRepository.save(Product.builder().brand(brandI).category(categoryHat).price(1700).build());
        productRepository.save(Product.builder().brand(brandI).category(categorySocks).price(1700).build());
        productRepository.save(Product.builder().brand(brandI).category(categoryAccessory).price(2400).build());
    }
}
