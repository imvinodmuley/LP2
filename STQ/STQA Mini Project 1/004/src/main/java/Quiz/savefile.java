package Quiz;

import java.io.File;
import java.io.FileInputStream;
import java.sql.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
public class savefile 
{
	private static String filePath;
	
	public savefile()
	{
		
	}
	
	@SuppressWarnings("static-access")
	public boolean saveFiles() {
		String fileName="";
		try
		{
			int flag=0;
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			PreparedStatement stmt1=con.prepareStatement("select max(id) from savefile");
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				 flag=rs.getInt("max(id)");
			}
			flag+=1;
			//
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			FileNameExtensionFilter jf = new FileNameExtensionFilter("*txt or *pdf", "txt", "text", "pdf");
			jfc.setFileFilter(jf);
			int r = jfc.showOpenDialog(null);		  
            if (r == JFileChooser.APPROVE_OPTION) 
            { 
                // set the label to the path of the selected directory 
                filePath= jfc.getSelectedFile().getAbsolutePath(); 
                System.out.println(filePath);
            } 
          //  
            	String fName = getFileName(filePath);
            	fileName = getFileName(fName);
			
			//
			File f1=new File(filePath);
			FileInputStream ip=new FileInputStream(f1);
			PreparedStatement stmt=con.prepareStatement("insert into savefile(id,filecolumn,filename) values(?,?,?)");
			stmt.setInt(1, flag);
			stmt.setBinaryStream(2, ip);
			stmt.setString(3, fileName);
			int i = stmt.executeUpdate();
			if(i==1) {
				JOptionPane jop = new JOptionPane();
				jop.showMessageDialog(jop, "File Successfully Uploaded.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}

	public String getFileName(String filePath) 
	{
		String fileName="";
        for(int i=filePath.length()-1;i>=0;i--)
        {
        	if(filePath.charAt(i)=='\\')
        	{
        		break;
        	}
        	fileName+=filePath.charAt(i);
        }
        System.out.println(fileName);
       	//filePath.substring(filePath.indexOf("\\", filePath.length()), endIndex)
		return fileName;
	}

}
