import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import quiz.Validate;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// ... (previous code)

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Fetching parameters from the request
	    String name1 = request.getParameter("name");
	    String password1 = request.getParameter("password");
	    String email1 = request.getParameter("email");
	    String number1 = request.getParameter("number");

	    // Displaying the fetched parameters in the console
	    System.out.println(name1);
	    System.out.println(password1);
	    System.out.println(email1);
	    System.out.println(number1);

	    // Creating an instance of the Validate class
	    Validate valid = new Validate(name1, password1, email1, number1);

	    // Checking if the store operation was successful
	    boolean registrationSuccessful = valid.store();

	    // Sending a response to the client based on the result
	    if (registrationSuccessful) {
	        response.sendRedirect("login.html");
	    } else {
	        response.getWriter().append("Registration failed! Please check your entered values.");
	    }

	    // doGet(request, response); // Note: No need to call doGet here
	}

}