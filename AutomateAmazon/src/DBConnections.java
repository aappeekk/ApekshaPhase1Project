import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnections {
	
	public static Connection con;
	public static Statement stmt;
	public static String category;
	public static String Subcategory;		
	public static String brand;
	public static int price;
	public static String CanGetitTomorrow;
	public static String Product;
	
	public static void FetchfromDB() throws SQLException
	{
		try
		{
			String DBurl="jdbc:mysql://localhost:3306/amazonproducts";
			String usrname="root";
			String pass="root";
			String Query="select * from products where brand='SAMSUNG' AND productname='SMARTPHONE'AND cangetTomorrow='yes';";
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(DBurl,usrname,pass);
			stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(Query);
			
			while(rs.next())
			{
			    System.out.println("fetching values from amazonproducts database ,procudts table");
				System.out.println("Category is   " +rs.getString("category"));
				category=rs.getString("category");
				System.out.println("subcategory is   " +rs.getString("subcategory"));
				Subcategory=rs.getString("subcategory");
				System.out.println("brand is   " +rs.getString("brand"));
				brand=rs.getString("brand");
				price=rs.getInt("price");
				System.out.println("price is"+price);
				CanGetitTomorrow=rs.getString("cangetTomorrow");
				System.out.println("Is it delivered today"+CanGetitTomorrow);
				System.out.println("productname   " +rs.getString("productname"));
				Product=rs.getString("productname");
			}
			}

	     catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		finally
		{
		stmt.close();
		con.close();
			System.out.println("Out of DBprogram");
		}	
	}

}
