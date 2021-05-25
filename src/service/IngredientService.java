package service;

import model.product.*;
import repository.IngredientRepository;

import java.util.*;

public class IngredientService {

    private static IngredientService instance = null;
    private IngredientRepository ingredientRepository;

    Scanner scanner = new Scanner(System.in);
    private IngredientService(){
        this.ingredientRepository = IngredientRepository.getInstance();
    }
    public static IngredientService getInstance(){
        if(instance == null){
            instance = new IngredientService();
        }
        return instance;
    }

    public void addIngredient() {
        System.out.println("Enter Ingredient Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Ingredient Caloric Value");
        Double cValue = scanner.nextDouble();

        Ingredient ingredient = new Ingredient(name, cValue);
        ingredientRepository.addIngredient(ingredient);
    }

}
