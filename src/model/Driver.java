package model;

import java.util.Random;

public class Driver extends Person {
    private static long counter = 0;
    private long dID;
    private String licenseNo;
    private float experienceInYears;

    public Driver() {
        super();
        this.dID = ++counter;
    }

    public Driver(String name, String surname, String licenseNo, float experienceInYears) {
        super(name, surname); // Call the Person constructor to set name and surname
        this.licenseNo = licenseNo;
        this.experienceInYears = experienceInYears;
        this.dID = ++counter;
        setPersonCode(); // Automatically generates and sets the person code
    }

    public long getdID() {
        return dID;
    }

    public void setdID(long dID) {
        this.dID = dID;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public float getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(float experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "dID=" + dID +
                ", licenseNo='" + licenseNo + '\'' +
                ", experienceInYears=" + experienceInYears +
                ", personCode='" + getPersonCode() + '\'' +
                '}';
    }
}
