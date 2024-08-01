# Musinsa 프로젝트 구조

## 프로젝트 구조

```
src/main/java/com/tikim/org/musinsa/
    ├── MusinaApplication.java
    ├── global/
    │   ├── exception/
    │   │   ├── handler/
    │   │   │   └── GlobalExceptionHandler.java
    │   │   ├── enums/
    │   │   │   ├── CriticalLevel.java
    │   │   │   └── ErrorMessage.java
    │   │   ├── interfaces/
    │   │   │   └── ErrorInfo.java
    │   │   └── exceptions/
    │   │       ├── BaseException.java
    │   │       └── UndefinedException.java
    │   └── swagger/
    │       └── SwaggerConfig.java
    ├── domain/
    │   ├── brand/
    │   │   ├── controller/
    │   │   │   └── BrandController.java
    │   │   ├── entity/
    │   │   │   └── Brand.java
    │   │   ├── exception/
    │   │   │   └── BrandException.java
    │   │   ├── repository/
    │   │   │   └── BrandRepository.java
    │   │   └── service/
    │   │       └── BrandService.java
    │   ├── category/
    │   │   ├── controller/
    │   │   │   └── CategoryController.java
    │   │   ├── entity/
    │   │   │   └── Category.java
    │   │   ├── exception/
    │   │   │   └── CategoryException.java
    │   │   ├── repository/
    │   │   │   └── CategoryRepository.java
    │   │   └── service/
    │   │       └── CategoryService.java
    │   └── product/
    │       ├── controller/
    │       │   └── ProductController.java
    │       ├── entity/
    │       │   └── Product.java
    │       ├── exception/
    │       │   └── ProductException.java
    │       ├── repository/
    │       │   └── ProductRepository.java
    │       └── service/
    │           └── ProductService.java
```
