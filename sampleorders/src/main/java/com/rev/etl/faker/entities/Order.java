package com.rev.etl.faker.entities;


import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlAttribute(name = "order_id")
    private String id;

    @XmlElement(name = "Address")
    private Address address;

    @XmlElementWrapper(name="Items")
    @XmlElement(name = "Item")
    private List<Item> items;

    @XmlAttribute(name = "order_time")
    private String time;

    public Order(String id, Address address, List<Item> items, String time) {
        this.id = id;
        this.address = address;
        this.items = items;
        this.time = time;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
