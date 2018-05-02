package order.system.orders.factory;

import order.system.orders.domain.Client;
import order.system.orders.domain.Order;

public interface OrderFactory {

    Order createNewOrder(Client client, int id);
}
