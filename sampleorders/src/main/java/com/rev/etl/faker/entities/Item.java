package com.rev.etl.faker.entities;

import javax.xml.bind.annotation.*;
import java.util.Random;

@XmlRootElement(name="Item")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"name", "category", "price","quantity"})
public class Item {

    private String name;
    @XmlAttribute
    private String id;
    private String category;
    private double price;
    private int quantity;

    public Item() {
    }

    public Item(String name, String id, String category, double price) {
        this.name = name;
        this.id = id;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
