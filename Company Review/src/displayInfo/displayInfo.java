package displayInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class displayInfo
 */
@WebServlet("/displayInfo")
public class displayInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public displayInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
//		String name = request.getParameter("name");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyreview?useTimezone=true&serverTimezone=UTC", "root", "tillu123");
			PreparedStatement ps = con.prepareStatement("select Name, Product, Rating, Title, Pros, Cons, Review, Recommend from review_table");
			
			ResultSet rs = ps.executeQuery();
			out.println("<title>DISPLAY INFO</title>");
			out.println("<table>");
			out.println("<tr><td><b>Name</b></td><td><b>Product</b></td><td><b>Rating</b></td><td><b>Title</b></td><td><b>Pros</b></td><td><b>Cons</b></td><td><b>Review</b></td><td><b>Recommend</b></td>");
			while(rs.next())
			{
				out.println("<tr><td>'" + rs.getString(1)+"'</td><td>'" + rs.getString(2)+ "'</td><td>'" + rs.getString(3) + "'</td><td>'" + rs.getString(4) + "'</td><td>'" + rs.getString(5) + "'</td><td>'"+ rs.getString(6) + "'</td><td>'" + rs.getString(7) + "'</td><td>'" + rs.getString(8) +"'</td></tr>'");				
			}
			out.println("</table>");
		}catch(Exception e) {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
