# 무신사 Backend 과제 테스트

## 프로젝트 개요

이 프로젝트는 브랜드, 카테고리 및 상품을 관리하는 시스템입니다. 브랜드와 카테고리를 기반으로 상품을 생성, 조회, 수정, 삭제할 수 있으며, 카테고리별 최소/최대 가격 상품 조회와 브랜드별 최소 가격 상품 조회 기능을 제공합니다.

## 패키지 구조

```
src
└── main
    ├── java
    │   └── com
    │       └── tikim
    │           └── org
    │               └── musinsa
    │                   ├── domain
    │                   │   ├── brand
    │                   │   ├── category
    │                   │   └── product
    │                   ├── global
    │                   │   ├── application
    │                   │   ├── exception
    │                   │   └── swagger  
    │                   └── integration
    │                       ├── brand
    │                       ├── category
    │                       └── product
    └── resources
        └── application.yml
        └── application-{env}.yml
└── test
    ├── java
    │   └── com
    │       └── tikim
    │           └── org
    │               └── musinsa
    │                   ├── integration
    │                   │   ├── brand
    │                   │   ├── category
    │                   │   └── product
    │                   └── unit
    │                       ├── brand
    │                       ├── category
    │                       └── product
```

## 개발 환경

- **언어**: Java
- **프레임워크**: Spring Boot
- **빌드 도구**: Gradle
- **데이터베이스**: H2 (테스트용)
- **Flyway**: 데이터베이스 마이그레이션 도구
- **Swagger UI**: API 문서를 확인할 수 있습니다.
- **Thymeleaf**: 서버사이드 템플릿 엔진

### Gradle 설정

```groovy
plugins {
    id 'java'
    id 'org.springframework.boot' version '3.3.2'
    id 'io.spring.dependency-management' version '1.1.6'
}

group = 'com.tikim.org'
version = '0.0.1-SNAPSHOT'

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom annotationProcessor
    }
    all {
        // 기본 로깅 라이브러리인 spring-boot-starter-logging 제외: Log4j 사용을 위해 제외
        exclude group: 'org.springframework.boot', module: 'spring-boot-starter-logging'
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-validation'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.flywaydb:flyway-core'
    implementation 'org.springframework.boot:spring-boot-starter-log4j2' // Log4j2 사용
    implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0' // Springdoc OpenAPI 3 사용
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'com.h2database:h2'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'

    // Apple Silicon 환경에 따라 netty-resolver-dns-native-macos 라이브러리를 조건부로 추가
    if (System.getProperty("os.arch") == "aarch64" && System.getProperty("os.name").toLowerCase().contains("mac")) {
        runtimeOnly("io.netty:netty-resolver-dns-native-macos:4.1.109.Final:osx-aarch_64")
    }
}

tasks.named('test') {
    useJUnitPlatform()
}
```

### application.yml

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

## 구현 내용

### 브랜드 관리

- **생성**: 새로운 브랜드를 생성합니다.
- **조회**: 모든 브랜드를 조회하거나 특정 브랜드를 ID로 조회합니다.
- **수정**: 기존 브랜드를 수정합니다.
- **삭제**: 브랜드를 삭제합니다.

### 카테고리 관리

- **생성**: 새로운 카테고리를 생성합니다.
- **조회**: 모든 카테고리를 조회하거나 특정 카테고리를 ID로 조회합니다.
- **수정**: 기존 카테고리를 수정합니다.
- **삭제**: 카테고리를 삭제합니다.

### 상품 관리

- **생성**: 새로운 상품을 생성합니다.
- **조회**: 모든 상품을 조회하거나 특정 상품을 ID로 조회합니다.
- **수정**: 기존 상품을 수정합니다.
- **삭제**: 상품을 삭제합니다.
- **카테고리별 최소/최대 가격 조회**: 특정 카테고리 내에서 최소 및 최대 가격의 상품을 조회합니다.
- **브랜드별 최소 가격 조회**: 브랜드별 최소 가격의 상품을 조회합니다.

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