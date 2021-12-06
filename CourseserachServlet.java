package springjspservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CourseserachServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String coursename=req.getParameter("CourseName");
try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost/relation", "root","root");
PreparedStatement ps= con.prepareStatement("select * from course where cname=?");
ps.setString(1,coursename);
ResultSet rs=ps.executeQuery();

if(rs.next()) {
	Course course=new Course();
	course.setId(rs.getInt(1));
	course.setCourseName(rs.getString(2));
	course.setDuration(rs.getInt(3));
	
}}

catch(Exception e) {

	e.printStackTrace();
}


req.setAttribute("data", course);
 req.getRequestDispatcher("output.jsp").forward(req,resp);
	}
}
 