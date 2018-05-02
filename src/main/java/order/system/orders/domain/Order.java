package order.system.orders.domain;

import order.system.orders.exceptions.WrongOrderStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private int id;
    private Client client;
    private Date creationDate;
    private Date modificationDate;
    private OrderStatus status;
    private List<OrderPosition> positions;

    public Order(int id, Client client, Date creationDate, Date modificationDate, OrderStatus status) {
        this.id = id;
        this.client = client;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderPosition> getPositions() {
        return positions;
    }

    public void addPosition(Product product, int quantity) {
        if(positions == null) {
            positions = new ArrayList<OrderPosition>();
        }
        positions.add(new OrderPosition(product, quantity));
    }

    public int getOrderSize() {
        return (positions == null) ? 0 : positions.size();
    }

    public BigDecimal getOrderCost() {
        BigDecimal totalCost = BigDecimal.ZERO;
        if (positions != null) {
            for(OrderPosition position : positions) {
                totalCost = totalCost.add(position.getCost());
            }
        }
        return totalCost;
    }

    public void confirm() throws WrongOrderStatusException {
        if(status.equals(OrderStatus.NEW)) {
            System.out.println("Confirming...");
            this.status = OrderStatus.CONFIRMED;
            this.modificationDate = new Date();
        } else {
            throw new WrongOrderStatusException("Error: Order status is not NEW");
        }
    }

    public void pay() throws WrongOrderStatusException {
        if (status.equals(OrderStatus.CONFIRMED)) {
            System.out.println("Create Transaction - integration with external transaction system.....");
            this.status = OrderStatus.PAID;
            this.modificationDate = new Date();
        } else {
            throw new WrongOrderStatusException("Error: Order status is not CONFIRMED");
        }
    }

    public void deliver() throws WrongOrderStatusException {
        if (status.equals(OrderStatus.PAID)) {
            System.out.println("Delivering - integration with external deliver system.....");
            this.status = OrderStatus.DELIVERED;
            this.modificationDate = new Date();
        } else {
            throw new WrongOrderStatusException("Error: Order status is not PAID");
        }
    }

}
