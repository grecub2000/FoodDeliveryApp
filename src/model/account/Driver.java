package model.account;

import model.order.Order;

import java.util.*;

public class Driver extends User {
    private String ratings;
    private String currentDelivery;

    public Driver() {

    }

    public Driver(String username, String password, String name, String phoneNumber, String email, String address, String currentOrder, String ratings, String currentDelivery) {
        super(username, password, name, phoneNumber, email, address, currentOrder);
        this.ratings = ratings;
        this.currentDelivery = currentDelivery;
    }

    public Driver(String id, String username, String password, String name, String phoneNumber, String email, String address, String currentOrder, String ratings, String currentDelivery)  {
        super(id, username, password, name, phoneNumber, email, address, currentOrder);
        this.ratings = ratings;
        this.currentDelivery = currentDelivery;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getCurrentDelivery() {
        return currentDelivery;
    }

    public void setCurrentDelivery(String currentDelivery) {
        this.currentDelivery = currentDelivery;
    }

    @Override
    public String toString() {
        return "Driver{" +

                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", currentOrder=" + currentOrder +
                ", ratings=" + ratings +
                ", currentDelivery=" + currentDelivery +
                '}';
    }
}
