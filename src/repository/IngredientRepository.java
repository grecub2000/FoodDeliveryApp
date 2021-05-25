package repository;
import model.account.User;
import model.product.*;
import config.*;

import java.sql.*;
import java.util.*;

public class IngredientRepository {

    private static IngredientRepository instance = null;
    private IngredientRepository(){}

    public static IngredientRepository getInstance() {
        if(instance == null){
            instance = new IngredientRepository();
        }
        return instance;
    }


    public void addIngredient(Ingredient ingredient) {
        String sql = "insert into ingredients values (?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, ingredient.getId());
            statement.setString(2, ingredient.getName());
            statement.setDouble(3, ingredient.getCaloricValue());
            statement.executeUpdate();

        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public List<Ingredient> getIngredients(){
        List<Ingredient> ingredients = new ArrayList<>();
        String sql = "select * from ingredients";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String iId = result.getString(1);
                String name = result.getString(2);
                Double calories = result.getDouble(3);
                ingredients.add(new Ingredient(iId, name, calories));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return ingredients;
    }


    public void updateIngredient(Ingredient ingredient){
        String sql = "update ingredients " +
                "set name = ?," +
                "calories = ?," +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, ingredient.getId());
            statement.setString(2, ingredient.getName());
            statement.setDouble(3, ingredient.getCaloricValue());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteIngredient(String id){
        String sql = "delete from ingredients " +
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
