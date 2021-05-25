package repository;
import model.account.User;
import model.product.*;
import config.*;

import java.sql.*;
import java.util.*;

public class ProductRepository {

    private static ProductRepository instance = null;
    private ProductRepository(){}

    public static ProductRepository getInstance() {
        if(instance == null){
            instance = new ProductRepository();
        }
        return instance;
    }


    public void addProduct(Product product) {
        String sql = "insert into products values (?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());

            String ingredients = "";
            if(product.getIngredients() != null){
                for(String i : product.getIngredients()){
                    ingredients += i + ",";
                }
                ingredients.substring(0, ingredients.length() - 1);
            }

            statement.setString(4, ingredients);
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public List<Product> getProducts(){
        List<Product> products = new ArrayList<>();
        String sql = "select * from Products";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String pId = result.getString(1);
                String name = result.getString(2);
                Double price = result.getDouble(3);
                List<String> ingredients = new ArrayList<String>(Arrays.asList(result.getString(4).split(",")));
                products.add(new Product(pId, name, price, ingredients));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return products;
    }


    public void updateProduct(Product product){
        String sql = "update products " +
                "set name = ?," +
                "price = ?," +
                "ingredients = ?," +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            String ingredients = "";
            if(product.getIngredients() != null){
                for(String i : product.getIngredients()){
                    ingredients += i + ",";
                }
                ingredients.substring(0, ingredients.length() - 1);
            }
            statement.setString(1, product.getId());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, ingredients);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteProduct(String id){
        String sql = "delete from products " +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, id);
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }



}
