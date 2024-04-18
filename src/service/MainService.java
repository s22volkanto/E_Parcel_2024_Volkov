package service;

import model.*;
import model.City;
import model.ParcelSize;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainService {
    private List<Driver> allDrivers = new ArrayList<>();
    private List<AbstractCustomer> allCustomers = new ArrayList<>();

    // Main method for user interaction
    public static void main(String[] args) {
        MainService mainService = new MainService();
        mainService.run();
    }

    // Create a new driver
    public void createNewDriver(String name, String surname, String licenseNo, float experienceInYears) {
        Driver driver = new Driver(name, surname, licenseNo, experienceInYears);

        // Validate the input (you can add more conditions as needed)
        if (driver.getName().isEmpty() || driver.getSurname().isEmpty() ||
                driver.getLicenseNo().isEmpty() || driver.getExperienceInYears() <= 0) {
            System.out.println("Invalid input. Please re-enter driver details.");
            return;
        }

        // Add the driver to the list
        allDrivers.add(driver);

        // Display driver details
        System.out.println("Driver added successfully:");
        System.out.println(driver);
    }

    // Find driver by person code
    public void findDriverByPersonCode(String personCode) {
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                System.out.println("Driver found:");
                System.out.println(driver);
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Update driver's license number by person code
    public void updateDriverLicenseNoByPersonCode(String personCode, String newLicenseNo) {
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                driver.setLicenseNo(newLicenseNo);
                System.out.println("Driver's license number updated successfully!");
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Update driver's experience by person code
    public void updateDriverExperienceByPersonCode(String personCode, float newExperienceInYears) {
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                driver.setExperienceInYears(newExperienceInYears);
                System.out.println("Driver's experience updated successfully!");
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

    // Remove driver by person code
    public void removeDriverByPersonCode(String personCode) {
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                allDrivers.remove(driver);
                System.out.println("Driver removed successfully!");
                return;
            }
        }
        System.out.println("Driver not found with person code: " + personCode);
    }

       // Retrieve all customers as company
    public void retrieveAllCustomersAsCompany() {
        List<CustomerAsCompany> companyCustomers = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            if (customer instanceof CustomerAsCompany) {
                companyCustomers.add((CustomerAsCompany) customer);
            }
        }
        System.out.println("All customers as company:");
        for (CustomerAsCompany customer : companyCustomers) {
            System.out.println(customer);
        }
    }

    // Retrieve all customers as person
    public void retrieveAllCustomersAsPerson() {
        List<CustomerAsPerson> individualCustomers = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            if (customer instanceof CustomerAsPerson) {
                individualCustomers.add((CustomerAsPerson) customer);
            }
        }
        System.out.println("All customers as person:");
        for (CustomerAsPerson customer : individualCustomers) {
            System.out.println(customer);
        }
    }

    // Create a new customer as person
    public void createNewCustomerAsPerson(String name, String surname, String personCode, Address address, String phone) {
        CustomerAsPerson customer = new CustomerAsPerson(name, surname, personCode, address, phone);
        allCustomers.add(customer);
        System.out.println("Customer added successfully!");
    }

    // Create a new customer as company
    public void createNewCustomerAsCompany(String title, String companyRegNo, Address address, String phone) {
        CustomerAsCompany customer = new CustomerAsCompany(address, phone, title, companyRegNo);
        allCustomers.add(customer);
        System.out.println("Company customer added successfully!");
    }

    // Create a new parcel for a customer
    public void createNewParcelForCustomer(LocalDateTime plannedDelivery, ParcelSize size, boolean isFragile, String driverPersonCode, String customerCode) {
        // Find driver by person code
        Driver driver = findDriverByPersonCode(driverPersonCode);
        if (driver == null) {
            System.out.println("Driver not found with person code: " + driverPersonCode);
            return;
        }

        // Find customer by code
        AbstractCustomer customer = findCustomerByCode(customerCode);
        if (customer == null) {
            System.out.println("Customer not found with code: " + customerCode);
            return;
        }

        Parcel parcel = new Parcel(plannedDelivery, size, isFragile, driver);
        customer.addNewParcel(parcel);
        System.out.println("Parcel created successfully!");
    }

    // Retrieve all parcels by customer code
    public void retrieveAllParcelsByCustomerCode(String customerCode) {
        AbstractCustomer customer = findCustomerByCode(customerCode);
        if (customer == null) {
            System.out.println("Customer not found with code: " + customerCode);
            return;
        }
        List<Parcel> parcels = customer.getParcels();
        System.out.println("All parcels for customer with code " + customerCode + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Retrieve all parcels by driver person code
    public void retrieveAllParcelsByDriverPersonCode(String personCode) {
        Driver driver = findDriverByPersonCode(personCode);
        if (driver == null) {
            System.out.println("Driver not found with person code: " + personCode);
            return;
        }

        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getDriver().getPersonCode().equals(personCode)) {
                    parcels.add(parcel);
                }
            }
        }
        System.out.println("All parcels for driver with person code " + personCode + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Retrieve all parcels by city
    public void retrieveAllParcelsByCity(City city) {
        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getDeliveryAddress().getCity() == city) {
                    parcels.add(parcel);
                }
            }
        }
        System.out.println("All parcels for city " + city + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Retrieve all parcels by size
    public void retrieveAllParcelsBySize(ParcelSize size) {
        List<Parcel> parcels = new ArrayList<>();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getSize() == size) {
                    parcels.add(parcel);
                }
            }
        }
        System.out.println("All parcels of size " + size + ":");
        for (Parcel parcel : parcels) {
            System.out.println(parcel);
        }
    }

    // Calculate price of all customer parcels by customer code
    public void calculatePriceOfAllCustomerParcels(String customerCode) {
        AbstractCustomer customer = findCustomerByCode(customerCode);
        if (customer == null) {
            System.out.println("Customer not found with code: " + customerCode);
            return;
        }

        float totalPrice = 0;
        for (Parcel parcel : customer.getParcels()) {
            totalPrice += parcel.getPrice();
        }
        System.out.println("Total price of all parcels for customer with code " + customerCode + ": $" + totalPrice);
    }

    // Retrieve statistics of customer parcels size by customer code
    public void retrieveStatisticsOfCustomerParcelsSize(String customerCode) {
        AbstractCustomer customer = findCustomerByCode(customerCode);
        if (customer == null) {
            System.out.println("Customer not found with code: " + customerCode);
            return;
        }

        int[] sizeCounts = new int[5]; // Array to store counts for each size (X, S, M, L, XL)
        for (Parcel parcel : customer.getParcels()) {
            switch (parcel.getSize()) {
                case X:
                    sizeCounts[0]++;
                    break;
                case S:
                    sizeCounts[1]++;
                    break;
                case M:
                    sizeCounts[2]++;
                    break;
                case L:
                    sizeCounts[3]++;
                    break;
                case XL:
                    sizeCounts[4]++;
                    break;
            }
        }
        System.out.println("Statistics of parcels size for customer with code " + customerCode + ":");
        System.out.println("X: " + sizeCounts[0] + ", S: " + sizeCounts[1] + ", M: " + sizeCounts[2] +
                ", L: " + sizeCounts[3] + ", XL: " + sizeCounts[4]);
    }

    // Sort drivers by experience
    public void sortDriversByExperience() {
        allDrivers.sort((d1, d2) -> Float.compare(d1.getExperienceInYears(), d2.getExperienceInYears()));
        System.out.println("Drivers sorted by experience:");
        for (Driver driver : allDrivers) {
            System.out.println(driver);
        }
    }

    // Calculate how many parcels today delivered to specific city
    public void calculateHowManyParcelsTodayDeliveredToSpecificCity(City city) {
        int count = 0;
        LocalDateTime today = LocalDateTime.now();
        for (AbstractCustomer customer : allCustomers) {
            for (Parcel parcel : customer.getParcels()) {
                if (parcel.getDeliveryAddress().getCity() == city &&
                        parcel.getPlannedDelivery().toLocalDate().isEqual(today.toLocalDate())) {
                    count++;
                }
            }
        }
        System.out.println("Number of parcels delivered today to city " + city + ": " + count);
    }

    // Generate customer as person and parcel
    public void generateCustomerAsPersonAndParcel() {
        // Implement generation of random customer and parcel
        System.out.println("Generating customer as person and parcel...");
    }

    // Generate customer as company and parcel
    public void generateCustomerAsCompanyAndParcel() {
        // Implement generation of random company customer and parcel
        System.out.println("Generating customer as company and parcel...");
    }

    // Helper method to find a driver by person code
    private Driver findDriverByPersonCode(String personCode) {
        for (Driver driver : allDrivers) {
            if (driver.getPersonCode().equals(personCode)) {
                return driver;
            }
        }
        return null;
    }

    // Helper method to find a customer by code
    private AbstractCustomer findCustomerByCode(String customerCode) {
        for (AbstractCustomer customer : allCustomers) {
            if (customer.getCustomerCode().equals(customerCode)) {
                return customer;
            }
        }
        return null;
    }
}
