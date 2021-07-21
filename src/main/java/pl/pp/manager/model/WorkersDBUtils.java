package pl.pp.manager.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkersDBUtils {
    public static List<Worker> getWorkers() {
        System.out.println("Metoda get workers");
        List<Worker> workers = new ArrayList<>();

        String url = "jdbc:mysql://127.0.0.1:3306/worker_manager";
        String user = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM workers");

            while (resultSet.next()) {

                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                double salary = resultSet.getDouble("salary");

                Worker worker = new Worker(firstName, lastName, salary);
                System.out.println(worker);
                workers.add(worker);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return workers;
    }
}
