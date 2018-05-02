package order.system.orders.factory;

import order.system.orders.domain.Client;
import order.system.orders.domain.Order;
import order.system.orders.domain.OrderStatus;

import java.util.Date;

public class OrderFactoryImplementation implements OrderFactory {

    public Order createNewOrder(Client client, int id) {
        return new Order(id, client, new Date(), null, OrderStatus.NEW);
    }

}
