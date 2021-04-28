package service;

import model.account.*;
import model.product.Ingredient;
import model.product.Product;
import model.company.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class CSVWriter {
    private static CSVWriter instance = null;
    Map<String, Path> paths;

    private CSVWriter() {
        paths = new HashMap<>();
        paths.put("User", Path.of("files/users.csv"));
        paths.put("Driver", Path.of("files/drivers.csv"));
        paths.put("Ingredient", Path.of("files/ingredients.csv"));
        paths.put("Product", Path.of("files/products.csv"));
        paths.put("Local", Path.of("files/locals.csv"));
        paths.put("Company", Path.of("files/companies.csv"));

        for (Path p : paths.values()) {
            if (!Files.exists(p)) {
                try {
                    Files.createFile(p);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
    public static CSVWriter getInstance() {
        if(instance == null) {
            instance = new CSVWriter();
        }
        return instance;
    }

    public void write(User user) {
        try {
            BufferedWriter bw = Files.newBufferedWriter(paths.get("User"), StandardOpenOption.APPEND);
            String output =
                    user.getId() + ", " +
                    user.getUsername() + ", " +
                    user.getName() + ", " +
                    user.getEmail() + ", " +
                    user.getPassword() + ", " +
                    user.getPhoneNumber() + ", " +
                    user.getAddress();
            bw.write(output + "\n");
            bw.flush();
            bw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(Driver driver){
        try {
            BufferedWriter bw = Files.newBufferedWriter(paths.get("Driver"), StandardOpenOption.APPEND);
            String output =
                    driver.getId() + ", " +
                    driver.getUsername() + ", " +
                    driver.getName() + ", " +
                    driver.getEmail() + ", " +
                    driver.getPassword() + ", " +
                    driver.getPhoneNumber() + ", " +
                    driver.getAddress();
            bw.write(output + "\n");
            bw.flush();
            bw.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void write(Product product){
        try {
            BufferedWriter bw = Files.newBufferedWriter(paths.get("Product"), StandardOpenOption.APPEND);
            String ingredients = "";
            if(product.getIngredients().size()>0){
                for (String ingredient : product.getIngredients()) {
                    ingredients += ingredient + ";";
                }
                ingredients = ingredients.substring(0, ingredients.length() - 1);
            }
            String output = product.getId() + ", " +
                    product.getName() + ", " +
                    product.getPrice() + ", " +
                    product.getIngredients().toString();

            bw.write(output + "\n");
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public void write(Ingredient ingredient){
        try {
            BufferedWriter bw = Files.newBufferedWriter(paths.get("Ingredient"), StandardOpenOption.APPEND);
            String output = ingredient.getId() + ", " +
                    ingredient.getName() + ", " +
                    ingredient.getCaloricValue();
            bw.write(output + "\n");
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void write(Company company){
        try {
            BufferedWriter bw = Files.newBufferedWriter(paths.get("Company"), StandardOpenOption.APPEND);
            String output = company.getId() + ", " +
                    company.getName() + ", " +
                    company.getLocals().toString();
            bw.write(output + "\n");
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public void write(Local local){
        try {
            BufferedWriter bw = Files.newBufferedWriter(paths.get("Local"), StandardOpenOption.APPEND);
            String output = local.getId() + ", " +
                    local.getName() + ", " +
                    local.getAddress() + ", " +
                    local.getMenu().toString();
            bw.write(output + "\n");
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            System.out.println(e);
        }

    }



}


