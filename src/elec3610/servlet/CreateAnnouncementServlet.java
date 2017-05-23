package elec3610.servlet;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateAnnouncementServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException {
		
		String title = request.getParameter("title");
		System.out.println("title=" + title);
		
		String description = request.getParameter("description");
		System.out.println("description=" + description);
		
		// add the data to the server
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String mysqlUrl = "jdbc:mysql://localhost:3306/elec3610";
			Properties userInfo = new Properties();
			userInfo.put("user", "root");
			userInfo.put("password", "root");
			//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			Connection connection = DriverManager.getConnection(mysqlUrl,userInfo);
			Statement stmt = connection.createStatement();
			String sql = "INSERT INTO announcement VALUES (null, '"+title+"', '"+description+"', null)";
	        stmt.executeUpdate(sql);
		       
	        
	        // response to the client
	        PrintWriter out = response.getWriter();
	        response.setContentType("text;html;charset=utf-8");
	   
			// New location to be redirected
			response.sendRedirect("index.html");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
protected void doPost(HttpServletRequest request,
HttpServletResponse response) throws ServletException {
doGet(request, response);
}
}