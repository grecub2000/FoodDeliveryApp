package main;

import model.account.*;
import model.app.*;
import model.company.*;
import model.order.*;
import model.product.*;
import service.DefaultService;
import service.UserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //
        DefaultService defaultService = new DefaultService();
        App app = new App();
        User userA = new User("usera", "parola", "User A", "numar", "email@email.com", "adresa");
        User userB = new User("userb", "parola", "User B", "numar", "email@email.com", "adresa");
        Driver driverA = new Driver("drivera", "parola", "Driver A", "numar", "email@email.com", "adresa");
        Driver driverB = new Driver("driverb", "parola", "Driver B", "numar", "email@email.com", "adresa");
        Company companyA = new Company("Company A");
        Company companyB = new Company("Company B");
        //adding things to app lists
        app.addDriver(driverA);
        app.addDriver(driverB);
        app.addUser(userA);
        app.addUser(userB);
        //locals
        Local localA1 = new Local("Local 1 of company A", "Address local 1 of company A");
        Local localA2 = new Local("Local 2 of company A", "Address local 2 of company A");
        Local localB1 = new Local("Local 1 of company B", "Address local 1 of company B");
        //adding ingredients
        Ingredient tomato = new Ingredient("Tomato", 100);
        Ingredient bread = new Ingredient("Bread", 50);
        Ingredient cucumber = new Ingredient("Cucumber", 50);
        Ingredient chicken = new Ingredient("Chicken", 200);
        Ingredient water = new Ingredient("Water", 20);
        Ingredient onion = new Ingredient("Onion", 70);
        //adding products
        ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();
        Ingredient[] auxList = new Ingredient[] {tomato, tomato, tomato, onion, water, cucumber, bread, bread};
        ingredientList.addAll(Arrays.asList(auxList));
        Product otcSoup = new Product("Onion, Tomato and Cucumber soup", 10, ingredientList);
        //System.out.println(otcSoup.getTotalCalories()+"\n");
        //otcSoup.showProductRecipee();
        //System.out.println();
        ingredientList.clear();
        auxList = new Ingredient[] {chicken, chicken, tomato, bread};
        ingredientList.addAll(Arrays.asList(auxList));
        Product chickenT = new Product("Chicken with roasted tomatoes", 20, ingredientList);
        //chickenT.showProductRecipee();
        //System.out.println();
        //creating menus
        localA1.addProductToMenu(chickenT);
        localA1.addProductToMenu(otcSoup);
        //localA1.showMenu();
        localA2.addProductToMenu(otcSoup);
        //System.out.println();
        //localA2.showMenu();
        localB1.addProductToMenu(chickenT);
        //localB1.showMenu();
        //adding an order
        //app.viewAvailableDrivers();
        Order order1 = new Order(userB, driverB, localB1);
        driverB.setCurrentDelivery(order1);
        //app.viewAvailableDrivers();

        //adding companies
        companyA.addLocal(localA1);
        companyA.addLocal(localA2);
        companyB.addLocal(localB1);
        app.addCompany(companyA);
        app.addCompany(companyB);
        defaultService.startMenu(app);
    }
}
