package service;

import model.app.App;
import model.account.*;
import java.util.Scanner;

public class DefaultService {

    public void startMenu(App app){
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("1. Login.");
            System.out.println("2. Register");
            System.out.println("0. Exit.");
            int x = scanner.nextInt();
            switch (x) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("username: ");
                    String username = scanner.next();
                    System.out.println("password: ");
                    String password = scanner.next();
                    User user = this.login(username, password, app);
                    if(user == null) {
                        System.out.println("Username or password incorrect. Try again by pressing 0, or register by pressing anything else.");
                        int y = scanner.nextInt();
                        if(y == 0) {
                            break;
                        }
                    }
                    if(user instanceof User) {
                        System.out.println("Logged in as a normal User");
                        UserService userService = new UserService();
                        userService.userMenu(user, app);
                        break;
                    }
                    if(user instanceof Driver) {
                        System.out.println("Logged in as a Driver");
                        DriverService driverService = new DriverService();
                        //DriverService.StartMenu(user, app);
                        break;
                    }
                    if(user instanceof Admin) {
                        System.out.println("Logged in as an Admin");
                        AdminService driverService = new AdminService();
                        //AdminService.StartMenu(user, app);
                        break;
                    }

                case 2:
                    System.out.println("1. Register as an User");
                    System.out.println("2. Register as a Driver");
                    System.out.println("0. Back");
                    int y = scanner.nextInt();
                    if(y == 1 || y == 2) {
                        register(y, app);
                    }
                default:
                    System.out.println("Option not available");
            }
        }
    }

    private User login(String username, String password, App app) {
        for(User user : app.getUsers()) {

            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        for(Driver driver : app.getDrivers()) {

            if(driver.getUsername().equals(username) && driver.getPassword().equals(password)) {
                return driver;
            }
        }

        for(Admin admin : app.getAdmins()) {

            if(admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                return admin;
            }
        }

        return null;
    }

    private void register(int userType, App app) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username");
        String username = scanner.next();
        String password;
        while(true) {
            System.out.println("Enter Password");
            password = scanner.next();
            System.out.println("Confirm Password");
            String cPassword = scanner.next();
            if(password.equals(cPassword)) {
                break;
            }
            else {
                System.out.println("Passwords do not match. Try again!");
            }
        }
        System.out.println("Name" );
        String name = scanner.next();
        System.out.println("Email");
        String email = scanner.next();
        System.out.println("Phone Number (Optional)");
        String phonenumber = scanner.next();
        System.out.println("Address");
        String address = scanner.next();

        switch (userType) {
            case 1:
                User user = new User(username, password, name, phonenumber, email, address);
                app.addUser(user);
                break;
            case 2:
                Driver driver = new Driver(username, password, name, phonenumber, email, address);
                app.addDriver(driver);
                break;
        }
    }
}

