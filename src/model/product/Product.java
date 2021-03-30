package model.product;

import java.util.List;
import java.util.UUID;
import java.util.Comparator;
import java.util.Collections;

public class Product {
    private final String id = UUID.randomUUID().toString();
    private String name;
    private double price;
    private List<Ingredient> ingredients;

    public Product(String name, double price, List<Ingredient> ingredients) {
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

    public double getTotalCalories() {
        double sum = 0;
        for(int i = 0; i < ingredients.size(); i++) {
            sum = sum + this.ingredients.get(i).getCaloricValue();
        }
        return sum;
    }

    public void showProductRecipee() {
        System.out.println("Ingredients for " + this.getName()+ ":");
        for(int i = 0; i < ingredients.size(); i++) {
            System.out.println(ingredients.get(i).getName());
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
