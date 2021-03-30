package model.account;

import model.order.Order;

import java.util.ArrayList;
import java.util.Arrays;

public class Driver extends User {
    private double[] ratings = new double[100];
    private Order currentDelivery;
    private ArrayList<Order> deliveryHistory;

    public Driver() {

    }

    public Driver(String username, String password, String name, String phoneNumber, String email, String address)  {
        super(username, password, name, phoneNumber, email, address);
    }

    public double[] getRatings() {
        return ratings;
    }

    public void setRatings(double[] ratings) {
        this.ratings = ratings;
    }

    public Order getCurrentDelivery() {
        return currentDelivery;
    }

    public void setCurrentDelivery(Order currentDelivery) {
        this.currentDelivery = currentDelivery;
    }

    public ArrayList<Order> getDeliveryHistory() {
        return deliveryHistory;
    }

    public void setDeliveryHistory(ArrayList<Order> deliveryHistory) {
        this.deliveryHistory = deliveryHistory;
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
                ", orderHistory=" + orderHistory +
                ", ratings=" + Arrays.toString(ratings) +
                ", currentDelivery=" + currentDelivery +
                ", deliveryHistory=" + deliveryHistory +
                '}';
    }
}
