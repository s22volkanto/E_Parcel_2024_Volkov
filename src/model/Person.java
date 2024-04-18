package model;

import java.util.Random;

public class Person {
    private String name;
    private String surname;
    private String personCode;

    public Person() {
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.personCode = setPersonCode();
    }

    public Person(String name, String surname, String personCode) {
        this.name = name;
        this.surname = surname;
        this.personCode = personCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPersonCode() {
        return personCode;
    }

    public String setPersonCode() {
        // Extract the first three letters of the name and surname
        String namePrefix = name.substring(0, Math.min(name.length(), 3));
        String surnamePrefix = surname.substring(0, Math.min(surname.length(), 3));

        // Generate three random numbers between 100 and 999
        Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;

        // Concatenate the prefixes and random number to form the person code
        return namePrefix.toUpperCase() + surnamePrefix.toUpperCase() + randomNumber;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", personCode='" + personCode + '\'' +
                '}';
    }
}
