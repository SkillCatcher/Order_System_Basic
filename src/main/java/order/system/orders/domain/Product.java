package order.system.orders.domain;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;
    private ProductCategory productCategory;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
        this.productCategory = ProductCategory.OTHER;
    }

    public Product(String name, BigDecimal price, ProductCategory productCategory) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }
}
