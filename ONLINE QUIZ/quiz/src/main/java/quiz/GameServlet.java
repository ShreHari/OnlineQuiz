package quiz;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/SaveScoreServlet")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the score and username from the request parameters
        int score = Integer.parseInt(request.getParameter("score"));
        String username = request.getParameter("username"); // Assuming username is sent from frontend

        // JDBC database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/scores";
        String dbUsername = "root";
        String dbPassword = "";

        // SQL query to update the score in the database
        String sql = "UPDATE scores_details SET score = ? WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the score and username parameters and execute the SQL query
            pstmt.setInt(1, score);
            pstmt.setString(2, username);
            int rowsUpdated = pstmt.executeUpdate();

            // Send a response to the client
            if (rowsUpdated > 0) {
                PrintWriter out = response.getWriter();
                out.println("Score updated successfully!");
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "User not found");
            }

        } catch (SQLException e) {
            // Handle any errors
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error updating score");
        }
    }
}
