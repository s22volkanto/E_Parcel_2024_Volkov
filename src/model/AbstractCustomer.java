package model;

import java.util.ArrayList;
import java.util.List;

public class AbstractCustomer {
    private static long counter = 0;
    private long cID;
    private Address address;
    private String phoneNo;
    private List<Parcel> parcels;
    private String customerCode;

    public AbstractCustomer() {
        this.cID = ++counter;
        parcels = new ArrayList<>();
    }

    public AbstractCustomer(Address address, String phoneNo) {
        this();
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public long getcID() {
        return cID;
    }

    public void setcID(long cID) {
        this.cID = cID;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void addNewParcel(Parcel parcel) {
        parcels.add(parcel);
    }

    @Override
    public String toString() {
        return "AbstractCustomer{" +
                "cID=" + cID +
                ", address=" + address +
                ", phoneNo='" + phoneNo + '\'' +
                ", parcels=" + parcels +
                ", customerCode='" + customerCode + '\'' +
                '}';
    }
}
