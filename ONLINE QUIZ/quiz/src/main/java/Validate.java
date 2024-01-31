

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Validate {
    String dbUrl = "jdbc:mysql://localhost:3306/scores";
    String dbUname = "root";
    String dbPassword = "";
    String dbDriver = "com.mysql.cj.jdbc.Driver";
    String name1, password1, email1, number1;

    public Validate(String name1, String password1, String email1, String number1) {
        this.name1 = name1;
        this.password1 = password1;
        this.email1 = email1;
        this.number1 = number1;
    }

    public boolean store() {
        try (Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword)) {
            Class.forName(dbDriver);

            String sql = "INSERT INTO scores_details (name1, password1, email1, number1) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, name1);
                preparedStatement.setString(2, password1);
                preparedStatement.setString(3, email1);
                preparedStatement.setString(4, number1);

                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0; // Return true if rows were affected (registration successful)
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Return false if an exception occurred (registration failed)
        }
    }
}
