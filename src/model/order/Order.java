package model.order;

import model.account.Driver;
import model.account.User;
import model.company.Local;
import model.product.Product;

import java.util.*;

public class Order {
    private final String id = UUID.randomUUID().toString();
    private User user;
    private Driver driver;
    private Local local;
    private List<Product> products;

    public Order(User user, Local local) {
        this.user = user;
        this.local = local;
        products = new ArrayList<Product>();
    }

    public Order(User user, Driver driver, Local local) {
        this.user = user;
        this.driver = driver;
        this.local = local;
        products = new ArrayList<Product>();
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProductToOrder(Product product){

        products.add(product);

        products.sort((o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
    }

    public void viewOrder() {
        System.out.println("Products ordered: ");
        for(int i = 0; i < products.size(); i++) {
            System.out.println(i + ". " + products.get(i).getName() + " " + products.get(i).getPrice());
        }
        System.out.println("\nTotal order price: " + getOrderPrice() + "\n");
        System.out.println("Delivered by: ");
        if(driver != null) {
            System.out.println(driver.getName()+"\n");
        }
        else{
            System.out.println("No driver chosen yet\n");
        }

    }

    public double getOrderPrice() {
        double sum = 0;
        for(int i = 0; i < products.size(); i++) {
            sum = sum + products.get(i).getPrice();
        }
        return sum;
    }


    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", driver=" + "no driver" +
                ", local=" + local +
                ", products=" + products +
                '}';
    }

}
