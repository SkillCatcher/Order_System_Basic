package order.system.orders.exceptions;

public class WrongOrderStatusException extends Exception {

    public WrongOrderStatusException(String errorMessage) {
        super(errorMessage);
    }

}
