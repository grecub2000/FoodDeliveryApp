package service;

import model.app.App;
import model.account.*;
import model.order.Order;
import model.product.Product;
import repository.UserRepository;

import java.sql.SQLOutput;
import java.util.*;

public class AdminService{
    private static final AdminService instance = new AdminService();
    private UserService userService = UserService.getInstance();
    private AuditService audit = AuditService.getInstance();
    private ProductService productService = ProductService.getInstance();
    private IngredientService ingredientService = IngredientService.getInstance();
    private DefaultService defaultService = DefaultService.getInstance();

    private AdminService() {

    }

    public static AdminService getInstance(){
        return instance;
    }


    public void adminMenu(Admin admin, App app) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("1. Add Ingredient");
            System.out.println("2. Add Product");
            System.out.println("3. User menu");
            System.out.println("4. Logout");
            System.out.println("0. Exit");
            int x = scanner.nextInt();

            switch (x) {
                case 1:
                    ingredientService.addIngredient();
                    break;
                case 2:
                    productService.addProduct();
                    break;
                case 3:
                    userService.userMenu(admin, app);
                case 4:
                    defaultService.startMenu(app);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Option not available");


            }
        }
    }
}
