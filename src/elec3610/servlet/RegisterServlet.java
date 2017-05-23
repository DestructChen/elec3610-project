package elec3610.servlet;
import java.sql.*;
import java.util.Properties;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		
		String username = request.getParameter("username");
		System.out.println("username=" + username);
		
		String password = request.getParameter("password");
		System.out.println("password=" + password);
		
		String passwordcfm = request.getParameter("passwordcfm");
		System.out.println("passwordcfm=" + passwordcfm);
		
		String gender = request.getParameter("gender");
		System.out.println("gender=" + gender);
		
		String year = request.getParameter("year");
		System.out.println("year=" + year);
		
		String user_type = request.getParameter("user_type");
		System.out.println("usertype=" + user_type);
		
		// add the data to the server
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String mysqlUrl = "jdbc:mysql://localhost:3306/elec3610";
			Properties userInfo = new Properties();
			userInfo.put("user", "root");
			userInfo.put("password", "root");
			Connection connection = DriverManager.getConnection(mysqlUrl,userInfo);
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO user VALUES (null, '"+username+"', '"+password+"', "+gender+", "+year+","+gender+")";
	        stmt.executeUpdate(sql);
		       
	        // response to the client
	        PrintWriter out = response.getWriter();
	        response.setContentType("text;html;charset=utf-8");
	        out = response.getWriter();
			out.print("You have inserted a new user");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException {
doGet(request, response);
}
}