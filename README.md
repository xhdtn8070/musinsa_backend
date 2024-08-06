# 무신사 Backend 과제 테스트

## 프로젝트 개요

이 프로젝트는 브랜드, 카테고리 및 상품을 관리하는 시스템입니다. 브랜드와 카테고리를 기반으로 상품을 생성, 조회, 수정, 삭제할 수 있으며, 카테고리별 최소/최대 가격 상품 조회와 브랜드별 최소 가격 상품 조회 기능을 제공합니다.

## 패키지 구조

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── tikim
│   │           └── org
│   │               └── musinsa
│   │                   ├── domain
│   │                   │   ├── brand
│   │                   │   ├── category
│   │                   │   ├── product
│   │                   │   └── index
│   │                   └── global
│   │                       ├── application
│   │                       ├── exception
│   │                       └── swagger  
│   │                   
│   └── resources
│       ├── db
│       │   └── migration
│       │       └── V1__init.sql...
│       ├── static
│       ├── templates
│       │   ├── brand
│       │   ├── category
│       │   ├── product
│       │   └── index
│       ├── log4j2-{env}.xml
│       ├── application.yml
│       └── application-{env}.yml
└── test
    └── java
        └── com
            └── tikim
                └── org
                    └── musinsa
                        ├── integration
                        │   ├── brand
                        │   ├── category
                        │   └── product
                        └── unit
                            ├── brand
                            ├── category
                            └── product
```

## 개발 환경

- **언어**: Java(17)
- **프레임워크**: Spring Boot 3.3.2
- **빌드 도구**: Gradle
- **데이터베이스**: H2 (테스트용)
- **Flyway**: 데이터베이스 마이그레이션 도구
- **Swagger UI**: API 문서를 확인할 수 있습니다.
- **Thymeleaf**: 서버사이드 템플릿 엔진 + ajax



```yaml
# local 프로필 설정
logging:
  config: classpath:log4j2-develop.xml
  level:
    org.flywaydb: debug

spring:
  datasource:
    url: jdbc:h2:mem:testdb;MODE=MySQL
    driverClassName: org.h2.Driver
    username: sa
    password: password
  jpa:
    hibernate:
      ddl-auto: validate
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        show_sql: true
        use_sql_comments: true
  flyway:
    enabled: true
    locations: classpath:db/migration
  h2:
    console:
      enabled: true
      path: /h2-console

# Swagger UI 설정
springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html
```

---

## 구현 내용 - 메인 페이지(http://localhost:8080/html/index)

### 브랜드 관리 - 브랜드 페이지(http://localhost:8080/html/brand)
swagger-ui : http://localhost:8080/swagger-ui/index.html#/brand-controller
- **구현 4)**
- **생성**: 새로운 브랜드를 생성합니다.
- **조회**: 모든 브랜드를 조회하거나 특정 브랜드를 ID로 조회합니다.
- **수정**: 기존 브랜드를 수정합니다.
- **삭제**: 브랜드를 삭제합니다.

### 카테고리 관리 - 카테고리 페이지(http://localhost:8080/html/category)
swagger-ui : http://localhost:8080/swagger-ui/index.html#/category-controller
- **구현 4)**
- **생성**: 새로운 카테고리를 생성합니다.
- **조회**: 모든 카테고리를 조회하거나 특정 카테고리를 ID로 조회합니다.
- **수정**: 기존 카테고리를 수정합니다.
- **삭제**: 카테고리를 삭제합니다.

### 상품 관리 - 상품 페이지(http://localhost:8080/html/product)
swagger-ui : http://localhost:8080/swagger-ui/index.html#/product-controller
- **구현 1)**: 카테고리별 최저가격 브랜드와 상품 가격, 총액을 조회합니다.
- **구현 2)**: 단일 브랜드로 모든 카테고리 상품을 구매할 때 최저가격에 판매하는 브랜드와 카테고리의 상품가격, 총액을 조회합니다.
- **구현 3)**: 카테고리 이름으로 최저, 최고 가격 브랜드와 상품 가격을 조회합니다.
- **구현 4)**
- **생성**: 새로운 상품을 생성합니다.
- **조회**: 모든 상품을 조회하거나 특정 상품을 ID로 조회합니다.
- **수정**: 기존 상품을 수정합니다.
- **삭제**: 상품을 삭제합니다.
---

## 실행 방법

### Gradle 사용

1. **프로젝트 클론**:
   ```sh
   git clone https://github.com/your-repo/musinsa.git
   cd musinsa
   ```

2. **빌드 및 실행**:
   ```sh
   ./gradlew clean build
   ./gradlew bootRun
   ```

3. **Swagger UI 접속**:
   - 브라우저에서 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) 접속

4. **H2 콘솔 접속**:
   - 브라우저에서 [http://localhost:8080/h2-console](http://localhost:8080/h2-console) 접속

5. **웹 애플리케이션 접속**:
   - 브라우저에서 [http://localhost:8080/html/index](http://localhost:8080/html/index) 접속

---

## 테스트

### 통합 테스트

각 엔터티에 대해 CRUD 및 비즈니스 로직을 검증하는 통합 테스트를 제공합니다. 테스트 데이터는 `@BeforeEach` 메서드를 사용하여 설정됩니다.

#### 예시: Product 통합 테스트

```java
@SpringBootTest
@Transactional
public class ProductServiceIntegrationTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestSetupUtil testSetupUtil;

    @BeforeEach
    void setUp() {
        testSetupUtil.setUp();
    }

    @Test
    @DisplayName("브랜드별 최소 가격 상품 조회 통합 테스트")
    void testGetMinPriceByBrand() {
        ProductServiceMinPriceByBrandResponse response = productService.getMinPriceProductsByBrand();
        // 테스트 검증 로직
    }
}
```

---

이 README.md 파일은 프로젝트의 개요, 패키지 구조, 개발 환경 설정, 구현 내용, 실행 방법 및 테스트에 대한 정보를 제공합니다.