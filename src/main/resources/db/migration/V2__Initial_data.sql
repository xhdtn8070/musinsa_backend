-- 초기 데이터 입력 스크립트

--`V2__initial_data.sql`

-- 브랜드 데이터
INSERT INTO brand (name) VALUES ('A');
INSERT INTO brand (name) VALUES ('B');
INSERT INTO brand (name) VALUES ('C');
INSERT INTO brand (name) VALUES ('D');
INSERT INTO brand (name) VALUES ('E');
INSERT INTO brand (name) VALUES ('F');
INSERT INTO brand (name) VALUES ('G');
INSERT INTO brand (name) VALUES ('H');
INSERT INTO brand (name) VALUES ('I');

-- 카테고리 데이터
INSERT INTO category (name) VALUES ('상의');
INSERT INTO category (name) VALUES ('아우터');
INSERT INTO category (name) VALUES ('바지');
INSERT INTO category (name) VALUES ('스니커즈');
INSERT INTO category (name) VALUES ('가방');
INSERT INTO category (name) VALUES ('모자');
INSERT INTO category (name) VALUES ('양말');
INSERT INTO category (name) VALUES ('액세서리');

-- 상품 데이터
-- A 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='상의'), 11200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='아우터'), 5500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='바지'), 4200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='스니커즈'), 9000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='가방'), 2000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='모자'), 1700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='양말'), 1800);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='A'), (SELECT id FROM category WHERE name='액세서리'), 2300);

-- B 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='상의'), 10500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='아우터'), 5900);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='바지'), 3800);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='스니커즈'), 9100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='가방'), 2100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='모자'), 2000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='양말'), 2000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='B'), (SELECT id FROM category WHERE name='액세서리'), 2200);

-- C 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='상의'), 10000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='아우터'), 6200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='바지'), 3300);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='스니커즈'), 9200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='가방'), 2200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='모자'), 1900);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='양말'), 2200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='C'), (SELECT id FROM category WHERE name='액세서리'), 2100);

-- D 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='상의'), 10100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='아우터'), 5100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='바지'), 3000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='스니커즈'), 9500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='가방'), 2500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='모자'), 1500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='양말'), 2400);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='D'), (SELECT id FROM category WHERE name='액세서리'), 2000);

-- E 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='상의'), 10700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='아우터'), 5000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='바지'), 3800);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='스니커즈'), 9900);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='가방'), 2300);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='모자'), 1800);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='양말'), 2100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='E'), (SELECT id FROM category WHERE name='액세서리'), 2100);

-- F 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='상의'), 11200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='아우터'), 7200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='바지'), 4000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='스니커즈'), 9300);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='가방'), 2100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='모자'), 1600);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='양말'), 2300);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='F'), (SELECT id FROM category WHERE name='액세서리'), 1900);

-- G 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='상의'), 10500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='아우터'), 5800);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='바지'), 3900);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='스니커즈'), 9000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='가방'), 2200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='모자'), 1700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='양말'), 2100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='G'), (SELECT id FROM category WHERE name='액세서리'), 2000);

-- H 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='상의'), 10800);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='아우터'), 6300);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='바지'), 3100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='스니커즈'), 9700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='가방'), 2100);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='모자'), 1600);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='양말'), 2000);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='H'), (SELECT id FROM category WHERE name='액세서리'), 2000);

-- I 브랜드
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='상의'), 11400);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='아우터'), 6700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='바지'), 3200);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='스니커즈'), 9500);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='가방'), 2400);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='모자'), 1700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='양말'), 1700);
INSERT INTO product (brand_id, category_id, price) VALUES ((SELECT id FROM brand WHERE name='I'), (SELECT id FROM category WHERE name='액세서리'), 2400);

--- 설명

-- - **브랜드 데이터**: 각 브랜드 이름을 `brand` 테이블에 삽입합니다.
-- - **카테고리 데이터**: 각 카테고리 이름을 `category` 테이블에 삽입합니다.
-- - **상품 데이터**: 각 브랜드의 상품 데이터를 `product` 테이블에 삽입합니다. 여기서 브랜드와 카테고리는 이름으로 조회하여 각각의 ID를 사용합니다.

