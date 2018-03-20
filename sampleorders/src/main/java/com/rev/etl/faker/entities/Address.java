package com.rev.etl.faker.entities;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Address")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"firstName", "lastName", "streeAddress", "city", "country", "zipcode", "phoneNumber", "longitude", "latitude"})
public class Address {

    @XmlElement(name = "firstName")
    private String firstName;

    @XmlElement(name = "lastName")
    private String lastName;

    @XmlElement(name = "streeAddress")
    private String streeAddress;

    @XmlElement(name = "city")
    private String city;

    @XmlElement(name = "country")
    private String country;

    @XmlElement(name = "zipcode")
    private String zipcode;

    @XmlElement(name = "phoneNumber")
    private String phoneNumber;

    @XmlElement(name = "longitude")
    private String longitude;

    @XmlElement(name = "latitude")
    private String latitude;


    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Address(String firstName, String lastName, String streeAddress, String city, String country, String zipcode, String phoneNumber, String longitude, String latitude) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streeAddress = streeAddress;
        this.city = city;
        this.country = country;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Address() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreeAddress() {
        return streeAddress;
    }

    public void setStreeAddress(String streeAddress) {
        this.streeAddress = streeAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
