package Quiz;
//package miniproject;
import java.io.*;
import java.sql.*;
public class DownLoadsNotes 
{
	public DownLoadsNotes(String filename )
	{
		downloadNotes(filename);
	
	}
	public DownLoadsNotes() {}
	
	public boolean downloadNotes(String filename) {
		try
		{
			//int p=1;
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
//			PreparedStatement stmt1=con.prepareStatement("select max(id) from savefile");
//			ResultSet rs=stmt1.executeQuery();
//			while(rs.next())
//			{
//				 p=rs.getInt("max(id)");
//			}
			PreparedStatement stmt=con.prepareStatement("select filecolumn from savefile where filename=?");
			stmt.setString(1,filename);
			ResultSet rs=stmt.executeQuery();
			File file=new File("abc.txt");
			FileOutputStream op=new FileOutputStream(file);
			while(rs.next())
			{
				InputStream input = rs.getBinaryStream("filecolumn");
			    byte[] buffer = new byte[1024];
			    while (input.read(buffer) > 0) 
			    {
			        op.write(buffer);
			    }
			}	
			 Creating_directory c1=new Creating_directory("abc.txt",filename);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}
}
