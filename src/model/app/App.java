package model.app;

import model.account.*;
import model.company.*;
import java.util.*;

public class App {
    private static App instance = null;

    private ArrayList<Company> companies;
    private ArrayList<User> users;
    private ArrayList<Driver> drivers;
    private ArrayList<Admin> admins;

    public App() {
        companies = new ArrayList<Company>();
        users = new ArrayList<User>();
        drivers = new ArrayList<Driver>();
        admins = new ArrayList<Admin>();
        Admin admin = new Admin("admin", "adminpass", "Admin Name", "07namcartela", "email@admin.ro", "admin address" );
    }

    public static App App(){
        if (instance == null){
            instance = new App();
        }
        return instance;
    }

    public ArrayList<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<Company> companies) {
        this.companies = companies;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        this.drivers = drivers;
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<Admin> admins) {
        this.admins = admins;
    }

    public void addCompany(Company company){
        companies.add(company);
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addDriver(Driver driver){
        drivers.add(driver);
    }


    public void addAdmin(Admin admin){ admins.add(admin); }

    public void showAllCompanies(){
        for(int i = 0; i < companies.size(); i++) {
            System.out.println(i + ". " + companies.get(i).getName());
        }
    }

    public void viewAvailableDrivers(){
        System.out.println("Drivers available:");
        for(int i = 0; i < drivers.size(); i++) {
            if(drivers.get(i).getCurrentDelivery() == null) {
                System.out.println(i + ". " + drivers.get(i).getName());
            }
        }
    }

}
