package companyreview;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CompanyReview
 */
@WebServlet("/CompanyReview")
public class CompanyReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyReview() {
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
		
		String name = request.getParameter("name");
//		String[] product = request.getParameterValues("product");
		String product = request.getParameter("product");
		String rating = request.getParameter("rating");
		String title = request.getParameter("title");
		String pros= request.getParameter("pros");
		String cons= request.getParameter("cons");
		String review = request.getParameter("review");
		String recommend = request.getParameter("recommend");
		
		
		//jdbc code for connectivity to database(MySql)
		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/companyreview?useTimezone=true&serverTimezone=UTC", "root", "tillu123");
				PreparedStatement stmt = con.prepareStatement("insert into review_table(Name,Product,Rating,Title,Pros,Cons,Review,Recommend) values(?,?,?,?,?,?,?,?)");
				stmt.setString(1, name);
				stmt.setString(2, product);
				stmt.setString(3, rating);
				stmt.setString(4, title);
				stmt.setString(5, pros);
				stmt.setString(6, cons);
				stmt.setString(7, review);
				stmt.setString(8, recommend);
//				stmt.setString(1, name);
				
				int result = stmt.executeUpdate();

				
				
//				stmt.executeUpdate("insert into review_table values("+name+",'"+product+"', '"+rating+"','"+title+"','"+pros+"','"+cons+"','"+review+"','"+recommend+"'");
//				out.println("window.alert('Record entered successfully')");
				
//				out.println("Entered into db successfully");
				if(result == 1)
				{
					response.setContentType("text/html");
					out.write("<head><title>Confirm Page</title></head>");
					out.write("<h2> <center>Following data received sucessfully.. </center><h2> <br>");
					out.write("<h3> Customer Name: " + name + "</h3>");
					out.write("<h3> Product Name: " + product + "</h3>");
					out.write("<h3> Rating given: " + rating + "</h3>");
					out.write("<h3> Title: " + title + "</h3>");
					out.write("<h3> Pros: " + pros + "</h3>");
					out.write("<h3> Cons: " + cons + "</h3>");
					out.write("<h3> Review: " + review + "</h3>");
					out.write("<h3> Recommend: " + recommend + "</h3>");
					out.write("<br>");
//					out.write("<a href = 'displayInfo'>Display</a>");
					out.write("<form name = 'display' action = 'displayInfo' method = 'post'><button value = 'Display' onclick = 'document.display.ACTION';>Display</button></form> ");
					out.write("<button name = 'goBacktoHome' onclick = 'window.history.back();'>Go Back to Home Page</button>");
				}
				
			}catch(Exception p)
			{
				
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
