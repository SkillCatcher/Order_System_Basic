package order.system.orders.domain;

import order.system.orders.exceptions.WrongOrderStatusException;
import order.system.orders.factory.OrderFactory;
import order.system.orders.factory.OrderFactoryImplementation;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OrderTest {

    @Test
    public void should_Confirm_New_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);

        //WHEN
        order.confirm();

        //THEN
        assertEquals(OrderStatus.CONFIRMED, order.getStatus());
    }

    @Test(expected = WrongOrderStatusException.class)
    public void should_Not_Confirm_Order_Twice() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);

        //WHEN
        order.confirm();
        order.confirm();
    }

    @Test
    public void should_Pay_For_Confirmed_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);
        order.confirm();

        //WHEN
        order.pay();

        //THEN
        assertEquals(OrderStatus.PAID, order.getStatus());
    }

    @Test(expected = WrongOrderStatusException.class)
    public void should_Not_Pay_For_Not_Confirmed_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);

        //WHEN
        order.pay();
    }

    @Test(expected = WrongOrderStatusException.class)
    public void should_Not_Pay_For_Paid_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);
        order.confirm();
        order.pay();

        //WHEN
        order.pay();
    }

    @Test
    public void should_Deliver_Paid_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);
        order.confirm();
        order.pay();

        //WHEN
        order.deliver();

        //THEN
        assertEquals(OrderStatus.DELIVERED, order.getStatus());
    }

    @Test(expected = WrongOrderStatusException.class)
    public void should_Not_Deliver_New_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);

        //WHEN
        order.deliver();
    }

    @Test(expected = WrongOrderStatusException.class)
    public void should_Not_Deliver_Confirmed_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);
        order.confirm();

        //WHEN
        order.deliver();
    }

    @Test(expected = WrongOrderStatusException.class)
    public void should_Not_Deliver_Delivered_Order() throws WrongOrderStatusException {
        //GIVEN
        Client client = new Client(1, "Jack", "Reacher");
        OrderFactory orderFactory = new OrderFactoryImplementation();
        Order order = orderFactory.createNewOrder(client, 1);
        order.confirm();
        order.pay();
        order.deliver();

        //WHEN
        order.deliver();
    }
}
