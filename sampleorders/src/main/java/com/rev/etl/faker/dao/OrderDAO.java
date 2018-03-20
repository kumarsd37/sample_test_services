package com.rev.etl.faker.dao;

import com.rev.etl.faker.entities.Address;
import com.rev.etl.faker.entities.Item;
import com.rev.etl.faker.entities.Order;
import com.rev.etl.faker.utils.requestid.RequestIdUtils;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.rev.etl.faker.utils.FakeDataGenerator.*;

public class OrderDAO {
    private static final Random random = new Random();
    private static final int minimum = 1;
    private static final int maximum = 20;
    private List<Item> itemList;
    private String machineIP;

    public OrderDAO(List<Item> itemList, String machineIP) {
        this.itemList = itemList;
        this.machineIP = machineIP;
    }

    public Order getOrder(){
        String requestId = null;
        List<Item> lineItems = null;
        try {
            requestId = RequestIdUtils.buildRequestId(machineIP);
            int itemsCount = random.nextInt(30);
            lineItems = new ArrayList<>();
            for(int i =0 ; i< itemsCount; i++){
                Item item = getItem();
                int quat = minimum + (int)(Math.random() * maximum);
                item.setQuantity(quat);
                lineItems.add(item);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        DateTime dateTime = new DateTime();
        Order order = new Order(requestId, getAddress(), lineItems, dateTime.toDateTimeISO().toString());
        return order;
    }

    public Address getAddress(){
        Address address = new Address(getFirstName(), getLastName(), getStreetAddress(), getCity(), getCountry(),getZipcode(), getPhoneNumber(), getLongitude(), getLatitude());
        return address;
    }

    public Item getItem(){
        return itemList.get(random.nextInt(itemList.size()-1));
    }

    public int getRandomInt(){
        return random.nextInt(20);
    }
}
