package service;
import model.app.App;
import model.account.*;
import model.order.Order;
import model.product.Product;

import java.sql.SQLOutput;
import java.util.*;


public class DriverService{
    private static final DriverService instance = new DriverService();

    private DriverService() {

    }

    public static DriverService getInstance(){
        return instance;
    }

    private UserService userService = UserService.getInstance();

    public void driverMneu(Driver driver, App app) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Driver Menu");
            System.out.println("2. User Menu");
            System.out.println("0. Exit");
            int x = scanner.nextInt();

            switch (x) {
                case 1:
                    while (true) {
                        System.out.println("1. View current delivery");
                        System.out.println("0. Back");

                        int choice = scanner.nextInt();

                        if (choice == 1) {
                            if(driver.getCurrentDelivery() == null){
                                System.out.println("You have no delivery in progress.");
                            }
                            else {
                                System.out.println(driver.getCurrentDelivery());
                            }
                        }

                    }

                case 2:
                    userService.userMenu(driver, app);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Option not available");
            }
        }
    }
}
