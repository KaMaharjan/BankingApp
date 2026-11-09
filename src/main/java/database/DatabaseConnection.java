package database;

import java.sql.*;

public class DatabaseConnection {

    public Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/BankingApp";
        String username = "postgres";
        String password = "1234";
        return DriverManager.getConnection(url, username, password);}

    public void display(){
        String sql = "SELECT * FROM public.customers";
        try(Connection con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                System.out.println(id + " " + firstName + " " + lastName + " " + email + " " + phone);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DatabaseConnection db = new DatabaseConnection();
        try(Connection con = db.getConnection();){
            System.out.println("Connected to the database: " + con.getCatalog());
        }catch(SQLException e){
            e.printStackTrace();
        }
        db.display();
    }
}
