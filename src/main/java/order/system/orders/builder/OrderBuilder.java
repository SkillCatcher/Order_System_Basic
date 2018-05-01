package order.system.orders.builder;

import order.system.orders.domain.Order;
import order.system.orders.domain.Product;

public class OrderBuilder {

    private Order order;

    public OrderBuilder(Order order) {
        this.order = order;
    }

    public OrderBuilder withExtraPosition(Product product, int quantity) {
        order.addPosition(product, quantity);
        return this;
    }
}
