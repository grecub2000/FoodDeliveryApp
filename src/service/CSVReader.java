package service;

import model.account.*;
import model.app.*;
import model.product.*;
import model.company.*;
import model.order.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CSVReader {
    private static CSVReader instance = null;
    private Map<String, Path> paths;

    private CSVReader() {
        paths = new HashMap<>();
        paths.put("User", Path.of("files/users.csv"));
        paths.put("Driver", Path.of("files/drivers.csv"));
        paths.put("Ingredient", Path.of("files/ingredients.csv"));
        paths.put("Product", Path.of("files/products.csv"));
        paths.put("Local", Path.of("files/locals.csv"));
        paths.put("Company", Path.of("files/companies.csv"));

        for (Path p : paths.values()) {
            if(!Files.exists(p)) {
                try{
                    Files.createFile(p);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }
        }
    }
    public static CSVReader getInstance() {
        if (instance == null) {
            instance = new CSVReader();
        }
        return instance;
    }


    public void readAll(App app) {
        List<User> users = new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();
        List<Ingredient> ingredients = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<Company> companies = new ArrayList<>();
        List<Local> locals = new ArrayList<>();

        List<List<String>> userInfo = getUserInfo();
        List<List<String>> driverInfo = getDriverInfo();


        if (!driverInfo.isEmpty()) {
            for (List<String> dInfo : driverInfo) {
                List<String> usInfo = new ArrayList<>();
                String id = dInfo.get(0);
                for (List<String> info : userInfo) {
                    if (info.get(0).equals(id)) {
                        usInfo = info;
                        userInfo.remove(info);
                        break;
                    }
                }

                String username = usInfo.get(1);
                String name = usInfo.get(2);
                String email = usInfo.get(3);
                String password = usInfo.get(4);
                String phoneNumber = usInfo.get(5);
                String adress = usInfo.get(6);

                Driver driver = new Driver(username, password, name, phoneNumber, email, adress);
                app.addDriver(driver);

            }


        }


        if (!userInfo.isEmpty()) {
            for (List<String> usInfo : userInfo) {

                String id = usInfo.get(0);
                String username = usInfo.get(1);
                String password = usInfo.get(2);
                String name = usInfo.get(3);
                String phoneNumber = usInfo.get(4);
                String email = usInfo.get(5);
                String adress = usInfo.get(6);

                User user = new User(id, username, password, name, phoneNumber, email, adress);
                app.addUser(user);

            }
        }
    }
    private List<List<String>> getUserInfo() {
        List<List<String>> users = new ArrayList<>();

        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Users"));
            String line = bufferedReader.readLine();
            while (line != null) {
                users.add(new ArrayList<String>(Arrays.asList(line.split(","))));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return users;
        }


    }

    private List<List<String>> getDriverInfo() {
        List<List<String>> drivers = new ArrayList<>();

        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Drivers"));
            String line = bufferedReader.readLine();
            while (line != null) {
                drivers.add(new ArrayList<String>(Arrays.asList(line.split(","))));
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return drivers;
        }


    }


    private List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        try {

            BufferedReader bufferedReader = Files.newBufferedReader(paths.get("Products"));
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] prod = line.split(",");
                String id = prod[0];
                String name = prod[1];
                Double price = Double.parseDouble(prod[2]);
                List<String> ingredients = new ArrayList<String>(Arrays.asList(prod[3].split(";")));
                products.add(
                        new Product(id, name, price, ingredients)
                );
                line = bufferedReader.readLine();
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            return products;
        }
    }

}
