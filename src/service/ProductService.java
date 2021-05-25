package service;

import model.product.*;
import repository.ProductRepository;

import java.util.*;

public class ProductService {

    private static ProductService instance = null;
    Scanner scanner = new Scanner(System.in);
    private ProductRepository productRepository;

    private ProductService(){
        this.productRepository = ProductRepository.getInstance();
    }
    public static ProductService getInstance(){
        if(instance == null){
            instance = new ProductService();
        }
        return instance;
    }

    public void addProduct() {
        System.out.println("Enter product Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter product Price");
        Double price = scanner.nextDouble();

        System.out.println("Enter product Ingredients");
        String ingredient = scanner.nextLine();
        List<String> list = new ArrayList<>();
        while(true) {
            System.out.println("Add more? (yes or no)");
            String choice = scanner.nextLine();
            if (choice.equals("yes")) {
                System.out.println("Enter Ingredient name");
                String iName = scanner.nextLine();
                list.add(iName);
            } else {
                if(list.size() == 0){
                System.out.println("No ingredients added");
                }
                else {
                    break;
                }
            }
        }

        Product product = new Product(name, price, list);
        productRepository.addProduct(product);


    }


}
