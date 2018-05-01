package order.system.orders.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private int id;
    private Client client;
    private List<OrderPosition> positions;

    public Order(int id, Client client) {
        this.id = id;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
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

}
