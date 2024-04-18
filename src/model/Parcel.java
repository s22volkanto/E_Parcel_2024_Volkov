package model;

import model.Enum.ParcelSize;

import java.time.LocalDateTime;

public class Parcel {
    private LocalDateTime orderCreated;
    private LocalDateTime plannedDelivery;
    private ParcelSize size;
    private float price;
    private boolean isFragile;
    private Driver driver;
    private Address deliveryAddress;

    // Constructors
    public Parcel(LocalDateTime plannedDelivery, ParcelSize size, boolean isFragile, Driver driver) {}

    public Parcel(LocalDateTime plannedDelivery, ParcelSize size, boolean isFragile, Driver driver, Address deliveryAddress) {
        this.orderCreated = LocalDateTime.now();
        this.plannedDelivery = plannedDelivery;
        this.size = size;
        this.isFragile = isFragile;
        this.driver = driver;
        this.deliveryAddress = deliveryAddress; // Initialize delivery address
        calculatePrice();
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    // Getters and setters
    public LocalDateTime getOrderCreated() {
        return orderCreated;
    }

    public void setOrderCreated(LocalDateTime orderCreated) {
        this.orderCreated = orderCreated;
    }

    public LocalDateTime getPlannedDelivery() {
        return plannedDelivery;
    }

    public void setPlannedDelivery(LocalDateTime plannedDelivery) {
        this.plannedDelivery = plannedDelivery;
    }

    public ParcelSize getSize() {
        return size;
    }

    public void setSize(ParcelSize size) {
        this.size = size;
        calculatePrice(); // Recalculate price when size changes
    }

    public float getPrice() {
        return price;
    }

    private void setPrice(float price) {
        this.price = price;
    }

    public boolean isFragile() {
        return isFragile;
    }

    public void setFragile(boolean isFragile) {
        this.isFragile = isFragile;
        calculatePrice(); // Recalculate price when fragility changes
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    // Calculate price based on size and fragility
    private void calculatePrice() {
        float basePrice;
        switch (size) {
            case X:
                basePrice = 1.99f;
                break;
            case S:
                basePrice = 1.99f;
                break;
            case M:
                basePrice = 1.99f;
                break;
            case L:
                basePrice = 1.99f;
                break;
            case XL:
                basePrice = 1.99f;
                break;
            default:
                basePrice = 0;
                break;
        }
        if (isFragile) {
            basePrice += 2.99f;
        }
        setPrice(basePrice);
    }

    // Override toString()
    @Override
    public String toString() {
        return "Parcel{" +
                "orderCreated=" + orderCreated +
                ", plannedDelivery=" + plannedDelivery +
                ", size=" + size +
                ", price=" + price +
                ", isFragile=" + isFragile +
                ", driver=" + driver +
                '}';
    }
}
