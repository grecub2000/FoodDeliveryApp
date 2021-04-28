package model.account;

import model.order.Order;

import java.util.*;

public class User {
    protected String id = UUID.randomUUID().toString();
    protected String username;
    protected String password;
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String address;
    protected Order currentOrder;
    protected List<Order> orderHistory;


    public User(){
    }

    public User(String username, String password, String name, String phoneNumber, String email, String address)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.currentOrder = null;
    }

    public User(String id, String username, String password, String name, String phoneNumber, String email, String address)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.currentOrder = null;

    }


    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", currentOrder=" + currentOrder +
                ", orderHistory=" + orderHistory +
                '}';
    }
}
