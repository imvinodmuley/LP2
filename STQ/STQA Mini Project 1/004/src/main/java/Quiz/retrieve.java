package Quiz;
import java.io.*;
import java.sql.*;
public class retrieve 
{
	public retrieve()
	{
		try
		{
			int p=1;
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			PreparedStatement stmt1=con.prepareStatement("select max(id) from savequestionfile");
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				 p=rs.getInt("max(id)");
			}
			PreparedStatement stmt=con.prepareStatement("select filename from savequestionfile where id=?");
			stmt.setInt(1,p);
			rs=stmt.executeQuery();
			File file=new File("abc.txt");
			FileOutputStream op=new FileOutputStream(file);
			while(rs.next())
			{
				InputStream input = rs.getBinaryStream("filename");
			    byte[] buffer = new byte[1024];
			    while (input.read(buffer) > 0) 
			    {
			        op.write(buffer);
			    }
			}
			FileRead1 fn=new FileRead1("abc.txt");
			op.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}