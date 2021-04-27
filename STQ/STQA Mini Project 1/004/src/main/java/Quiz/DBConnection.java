package Quiz;
import java.sql.*;

public class DBConnection {

		public Connection conn()
		{
			try{  
				Class.forName("com.mysql.jdbc.Driver");  
				//Connection con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12308982","sql12308982","y4YDgZIgQF");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quiz","root","#imchaitanya123");
				System.out.println("Database Connected");
				return con;
			}
				catch(Exception e){ System.out.println(e);}
			return null;  
		}  
}


