package model.product;

import java.util.*;

public class Ingredient {
    private String id = UUID.randomUUID().toString();
    private String name;
    private double caloricValue;


    public Ingredient(String name, double caloricValue) {
        this.name = name;
        this.caloricValue = caloricValue;
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

    public double getCaloricValue() {
        return caloricValue;
    }

    public void setCaloricValue(double caloricValue) {
        this.caloricValue = caloricValue;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", caloricValue=" + caloricValue +
                '}';
    }
}
