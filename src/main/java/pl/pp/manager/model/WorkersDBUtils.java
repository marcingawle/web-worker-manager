package pl.pp.manager.model;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkersDBUtils {
    public static List<Worker> getWorkers(DataSource dataSource) {
        System.out.println("Metoda get workers");
        List<Worker> workers = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
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

    public static void addWorker(Worker worker, DataSource dataSource) {
        String sql = "INSERT INTO workers (first_name, last_name, salary) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, worker.getFirstName());
            statement.setString(2, worker.getLastName());
            statement.setDouble(3, worker.getSalary());

            statement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
