package repository;
import model.account.*;
import config.*;

import java.sql.*;
import java.util.*;

public class UserRepository {

    private static UserRepository instance = null;
    private UserRepository(){}

    public static UserRepository getInstance() {
        if(instance == null){
            instance = new UserRepository();
        }
        return instance;
    }


    public void addUser(User user) {
        String sql = "insert into users values (?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCurrentOrder());
            statement.executeUpdate();


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<User> getUserById(String id) {
        String sql = "select * from users u where u.id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String userId = result.getString(1);
                String username = result.getString("username");
                String password = result.getString("password");
                String name = result.getString("name");
                String phoneNumber = result.getString("phonenumber");
                String email = result.getString("email");
                String address = result.getString("address");
                String currentOrder = result.getString("currentorder");
                return Optional.of(new User(userId, username, password, name, phoneNumber, email, address, currentOrder));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {
            ResultSet result = statement.executeQuery();
            while(result.next()){
                String userId = result.getString(1);
                String username = result.getString(2);
                String password = result.getString(3);
                String name = result.getString(4);
                String phoneNumber = result.getString(5);
                String email = result.getString(6);
                String address = result.getString(7);
                String currentOrder = result.getString(8);
                users.add(new User(userId, username, password, name, phoneNumber, email, address, currentOrder));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return  users;
    }


    public void updateUser(User user){
        String sql = "update users " +
                "set username = ?," +
                "password = ?," +
                "name = ?," +
                "phonenumber = ?," +
                "email = ?," +
                "address = ?," +
                "currentorder = ?" +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, user.getId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setString(5, user.getPhoneNumber());
            statement.setString(6, user.getEmail());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getCurrentOrder());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteUser(String id){
        String sql = "delete from users " +
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
