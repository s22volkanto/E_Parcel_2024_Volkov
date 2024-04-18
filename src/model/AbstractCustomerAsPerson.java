package model;

public class AbstractCustomerAsPerson extends AbstractCustomer{
    private Person person;

    public AbstractCustomerAsPerson() {}

    public AbstractCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) {
        this.person = new Person(name, surname, personCode);
        setAddress(address);
        setPhoneNo(phone);
    }

    @Override
    public String toString() {
        return "AbstractCustomerAsPerson{" +
                "person=" + person +
                '}';
    }
}
