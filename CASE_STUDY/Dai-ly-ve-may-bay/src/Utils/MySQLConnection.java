package Utils;

import Entity.Others.FlightTicket;
import Entity.Others.Revenue;
import Entity.Others.UsersInfo;
import Entity.Users.Customer;
import Entity.Users.Staff;

import java.sql.*;

public class MySQLConnection {
    String SelectFromTable = null;

    Customer customer = null;
    Staff staff = null;
    FlightTicket flightTicket = null;
    UsersInfo usersInfo = null;
    Revenue revenue = null;
    public Connection getConnection() {
        Connection connection = null;
        String jdbcURL = "jdbc:mysql://localhost:3306/dai_ly_ve_may_bay";
        String jdbcUsername = "root";
        String jdbcPassword = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public Customer selectCustomer(int id) {
        Customer result = null;
        String account = "";
        String passWord = "";
        SelectFromTable = "SELECT * FROM Customer WHERE id = ?";
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SelectFromTable);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {

                account = rs.getString("account");
                passWord = rs.getString("password");
                result = new Customer(account, passWord);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Staff selectStaff(int id) {
        Staff result = null;
        String account = "";
        String passWord = "";
        SelectFromTable = "SELECT * FROM Staff WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SelectFromTable);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                account = rs.getString("account");
                passWord = rs.getString("password");
                result = new Staff(account, passWord);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public FlightTicket selectFlightTicket(int id) {
        FlightTicket result = null;
        SelectFromTable = "SELECT * FROM flight_ticket WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SelectFromTable);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String position = rs.getString("position");
                String plane = rs.getString("plane");
                String time = rs.getString("time");
                String seat = rs.getString("seat");
                String depart = rs.getString("depart");
                String dest = rs.getString("dest");
                String flightHour = rs.getString("flightHour");
                int price = rs.getInt("price");
                String date = rs.getString("date");
                result = new FlightTicket(depart, dest, position, plane, time, seat, flightHour, price, date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public UsersInfo selectUsersInfo(int id) {
        UsersInfo result = null;
        SelectFromTable = "SELECT * FROM UsersInfo WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SelectFromTable);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String gender = rs.getString("gender");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String dayOfBirth = rs.getString("dayOfBirth");
                String phoneNumber = rs.getString("phoneNumber");
                int UserID = rs.getInt("UserID");
                result = new UsersInfo(name, dayOfBirth, gender, phoneNumber, email, address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Revenue selectRevenue(int id) {
        Revenue result = null;
        SelectFromTable = "SELECT * FROM Revenue WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SelectFromTable);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String buyDate = rs.getString("buyDate");
                String income = rs.getString("income");
                result = new Revenue(buyDate, income);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}