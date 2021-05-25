package model.account;

public class Admin extends User {
    public Admin() {
    }

    public Admin(String username, String password, String name, String phoneNumber, String email, String address, String currentOrder)  {
        super(username, password, name, phoneNumber, email, address, currentOrder);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", currentOrder=" + currentOrder +
                '}';
    }
}
