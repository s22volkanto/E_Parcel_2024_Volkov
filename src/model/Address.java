package model;

import model.Enum.City;

public class Address {
    private City city;
    private String streetOrHouseTitle;
    private int houseNo;

    // Constructors
    public Address() {}

    public Address(City city, String streetOrHouseTitle, int houseNo) {
        this.city = city;
        this.streetOrHouseTitle = streetOrHouseTitle;
        this.houseNo = houseNo;
    }

    // Getters and setters
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getStreetOrHouseTitle() {
        return streetOrHouseTitle;
    }

    public void setStreetOrHouseTitle(String streetOrHouseTitle) {
        this.streetOrHouseTitle = streetOrHouseTitle;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    // Override toString() method for better representation
    @Override
    public String toString() {
        return "Address{" +
                "city=" + city +
                ", streetOrHouseTitle='" + streetOrHouseTitle + '\'' +
                ", houseNo=" + houseNo +
                '}';
    }
}
