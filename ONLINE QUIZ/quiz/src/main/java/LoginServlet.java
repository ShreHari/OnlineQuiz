import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (isValidUser(username, password)) {
            // Redirect to game.html
            response.sendRedirect("game.html");
        } else {
            response.getWriter().println("Invalid username or password");
        }
    }

    private boolean isValidUser(String username, String password) {
    	 String dbUrl = "jdbc:mysql://localhost:3306/scores";
    	 String dbUname = "root";
    	 String dbPassword = "";
    	 String dbDriver = "com.mysql.cj.jdbc.Driver";

        try (Connection con = DriverManager.getConnection(dbUrl, dbUname, dbPassword)) {
            Class.forName(dbDriver);

            String sql = "SELECT * FROM scores_details WHERE name1 = ? AND password1 = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // If there is a match, the user is valid
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            ((Throwable) e).printStackTrace(); // Log the error instead of printing to console in a production environment
            return false;
        }
    }
}
