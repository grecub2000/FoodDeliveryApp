package service;

import model.app.App;
import model.account.*;
import model.order.Order;
import model.product.Product;

import java.sql.SQLOutput;
import java.util.*;

public class UserService{
    private static final UserService instance = new UserService();

    private UserService() {

    }

    public static UserService getInstance(){
        return instance;
    }

    private DefaultService defaultService = DefaultService.getInstance();
    private AuditService audit = AuditService.getInstance();


    public void userMenu(User user, App app) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Place order");
            System.out.println("2. Log out");
            System.out.println("0. Exit");
            int x = scanner.nextInt();

            switch (x) {
                case 1:
                    boolean orderConfirmed = false;
                    System.out.println("Where would you like to order from?");
                    app.showAllCompanies();
                    int xCompany = scanner.nextInt();
                    System.out.println("Select a local");
                    app.getCompanies().get(xCompany).showAllLocals();
                    int xLocal = scanner.nextInt();
                    Order order = new Order(user, app.getCompanies().get(xCompany).getLocals().get(xLocal));

                    while(true) {
                        if (orderConfirmed == true) {
                            break;
                        }
                        System.out.println("1. View menu");
                        System.out.println("2. Add product to order");
                        System.out.println("3. View order");
                        System.out.println("4. Continue to driver selection");
                        System.out.println("0. Back");
                        int orderChoice = scanner.nextInt();
                        if (orderChoice == 1) {
                            app.getCompanies().get(xCompany).getLocals().get(xLocal).showMenu();
                        }
                        if (orderChoice == 2) {
                            System.out.println("Select product to add");
                            int prodIndex = scanner.nextInt();
                            Product product = app.getCompanies().get(xCompany).getLocals().get(xLocal).getMenu().get(prodIndex);
                            order.addProductToOrder(product);
                        }
                        if (orderChoice == 3){
                            order.viewOrder();

                        }
                        if(orderChoice == 4) {
                            System.out.println("Select driver to deliver your order:");
                            app.viewAvailableDrivers();
                            int driverChoice = scanner.nextInt();
                            Driver driverChosen = app.getDrivers().get(driverChoice);
                            order.setDriver(driverChosen);
                            System.out.println("Confirm order?");
                            int confirmOrder = scanner.nextInt();
                            if (confirmOrder == 1) {
                                app.getDrivers().get(driverChoice).setCurrentDelivery(order);
                                user.setCurrentOrder(order);
                                orderConfirmed = true;
                                System.out.println("Order confirmed. It will be delivered to you ASAP!");
                                System.out.println("Back to main menu");
                                audit.write(user.getUsername() + " placed an order");
                                userMenu(user, app);
                            }
                        }
                        if(orderChoice == 0){
                            break;
                        }
                    }
                case 2:
                    audit.write(user.getUsername() + " logged out");
                    defaultService.startMenu(app);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Option not available");


            }
        }
    }

}
