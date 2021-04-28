package model.company;

import model.account.Driver;
import model.product.Product;

import java.util.*;

public class Local {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String address;
    private List<Product> menu;

    public Local() {
        menu = new ArrayList<Product>();
    }

    public Local(String name, String address){
        this.name = name;
        this.address = address;
        this.menu = new ArrayList<Product>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getMenu() {
        return menu;
    }

    public void setMenu(List<Product> menu) {
        this.menu = menu;
    }

    public void addProductToMenu(Product product) {
        this.menu.add(product);
    }

    public void showMenu() {
        System.out.println("Menu: ");
        for(int i = 0; i < menu.size(); i++) {
            System.out.println(i + ". " + menu.get(i).getName());
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Local{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", menu=" + menu +
                '}';
    }
}
