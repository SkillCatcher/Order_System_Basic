package order.system.orders.domain;

public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private ClientType clientType;

    public Client(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientType = ClientType.REGULAR;
    }

    public Client(int id, String firstName, String lastName, ClientType clientType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientType = clientType;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ClientType getClientType() {
        return clientType;
    }
}
