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
    
}
