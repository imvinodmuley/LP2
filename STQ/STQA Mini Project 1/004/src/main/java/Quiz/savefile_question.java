package Quiz;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
public class savefile_question 
{
  private static String filePath;
	public savefile_question()
	{
		try
		{
			int flag=0;
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			PreparedStatement stmt1=con.prepareStatement("select max(id) from savequestionfile");
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				 flag=rs.getInt("max(id)");
			}
			flag+=1;
			//
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			FileNameExtensionFilter jf = new FileNameExtensionFilter( "*txt or *pdf", "txt", "text", "pdf");
			jfc.setFileFilter(jf);
			int r = jfc.showOpenDialog(null);		  
            if (r == JFileChooser.APPROVE_OPTION) 
            {  
                filePath= jfc.getSelectedFile().getAbsolutePath(); 
                System.out.println(filePath);
            } 			
			File f1=new File(filePath);
			FileInputStream ip=new FileInputStream(f1);
			PreparedStatement stmt=con.prepareStatement("insert into savequestionfile(id,filename) values(?,?)");
			stmt.setInt(1, flag);
			stmt.setBinaryStream(2, ip);
			stmt.executeUpdate();
			retrieve r1=new retrieve();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}