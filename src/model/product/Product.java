package model.product;

import java.util.*;

public class Product {
    private String id = UUID.randomUUID().toString();
    private String name;
    private double price;
    private List<String> ingredients;

    public Product(String name, double price, List<String> ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public Product(String id, String name, double price, List<String> ingredients) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

//    public double getTotalCalories() {
//        double sum = 0;
//        for(int i = 0; i < ingredients.size(); i++) {
//            sum = sum + this.ingredients.get(i).getCaloricValue();
//        }
//        return sum;
//    }
//
    public void showProductRecipee() {
        System.out.println("Ingredients for " + this.getName()+ ":");
        for(String i : ingredients) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ingredients=" + ingredients +
                '}';
    }
}
