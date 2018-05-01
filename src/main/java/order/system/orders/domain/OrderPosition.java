package order.system.orders.domain;

import java.math.BigDecimal;

public class OrderPosition {

    private Product product;
    private int quantity;

    public OrderPosition(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getCost() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
