package model;

public class CustomerAsPerson extends AbstractCustomerAsPerson{
    public CustomerAsPerson() {}

    public CustomerAsPerson(String name, String surname, String personCode, Address address, String phone) {
        super(name, surname, personCode, address, phone);
    }

    @Override
    public String toString() {
        return "CustomerAsPerson{} " + super.toString();
    }
}
