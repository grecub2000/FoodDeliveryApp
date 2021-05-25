package repository;

import config.DatabaseConnection;
import model.account.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DriverRepository {

    private static DriverRepository instance = null;
    private DriverRepository(){}

    public static DriverRepository getInstance() {
        if(instance == null){
            instance = new DriverRepository();
        }
        return instance;
    }


    public void addDriver(Driver driver) {
        String sql = "insert into drivers values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, driver.getId());
            statement.setString(2, driver.getUsername());
            statement.setString(3, driver.getPassword());
            statement.setString(4, driver.getName());
            statement.setString(5, driver.getPhoneNumber());
            statement.setString(6, driver.getEmail());
            statement.setString(7, driver.getAddress());
            statement.setString(8, driver.getCurrentOrder());
            statement.setString(9, driver.getRatings());
            statement.setString(10, driver.getCurrentDelivery());
            statement.executeUpdate();


        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public Optional<Driver> getdriverById(String id) {
        String sql = "select * from drivers u where u.id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql)) {
            statement.setString(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String driverId = result.getString(1);
                String username = result.getString("username");
                String password = result.getString("password");
                String name = result.getString("name");
                String phoneNumber = result.getString("phonenumber");
                String email = result.getString("email");
                String address = result.getString("address");
                String currentOrder = result.getString("currentorder");
                String ratings = result.getString("ratings");
                String currentdelivery = result.getString("currentdelivery");
                return Optional.of(new Driver(driverId, username , password, name, phoneNumber, email, address, currentOrder, ratings, currentdelivery));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<Driver> getDrivers(){
        List<Driver> drivers = new ArrayList<>();
        String sql = "select * from drivers";
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
                String ratings = result.getString(9);
                String currentDelivery = result.getString(10);
                drivers.add(new Driver(userId, username, password, name, phoneNumber, email, address, currentOrder, ratings, currentDelivery));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return drivers;
    }


    public void updateDriver(Driver driver){
        String sql = "update drivers " +
                "set username = ?," +
                "password = ?," +
                "name = ?," +
                "phonenumber = ?," +
                "email = ?," +
                "address = ?," +
                "currentorder = ?" +
                "ratings = ?" +
                "currentdelivery = ?" +
                "where id = ?";
        try(PreparedStatement statement = DatabaseConnection.getInstance().prepareStatement(sql))
        {

            statement.setString(1, driver.getId());
            statement.setString(2, driver.getUsername());
            statement.setString(3, driver.getPassword());
            statement.setString(4, driver.getName());
            statement.setString(5, driver.getPhoneNumber());
            statement.setString(6, driver.getEmail());
            statement.setString(7, driver.getAddress());
            statement.setString(8, driver.getCurrentOrder());
            statement.setString(8, driver.getRatings());
            statement.setString(8, driver.getCurrentDelivery());
            statement.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void deleteDriver(String id){
        String sql = "delete from drivers " +
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
