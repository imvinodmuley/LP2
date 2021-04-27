package Quiz;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class FileRead1 
{
	public FileRead1(String file) throws IOException, SQLException
	{
		int flag=1;
		File f1=new File(file);
		int count=0;
		String [] str=new String[6];
		try {
			DBConnection conn=new DBConnection();
			Connection con=conn.conn();
			String line,s="",s1="",s2="";
			FileReader reader=new FileReader(f1);
			BufferedReader bread=new BufferedReader(reader);
			PreparedStatement stmt1=con.prepareStatement("select max(no) from cpp");
			ResultSet rs=stmt1.executeQuery();
			while(rs.next())
			{
				 flag=rs.getInt("max(no)");
			}
			flag+=1;
			while((line=bread.readLine())!=null)
			{
				s+=line;
				if(!s.isEmpty())
				{	
					if(s.charAt(0)=='$' && s.charAt(1)=='$')
					{
						s1=s+'\n';
						int len=s1.length();
						s=s1;
						while(s.charAt(len-2)!='$' && s.charAt(len-3)!='$')
						{
							line=bread.readLine();
							s+=line+'\n';
							s1+=line+'\n';
							len=s1.length();
						}
						str[count]=s1;
						count++;
					}
					else if(s.charAt(0)=='#')
					{
						s2=s;
						int len2=s2.length();
						while(s2.charAt(len2-1)!='#')
						{
							line=bread.readLine();
							s2+=line;
							len2=s2.length();
						}
						str[count]=s2;
						count++;
						 if(count==6)
							{
								System.out.println(count);
								PreparedStatement stmt=con.prepareStatement("insert into cpp(no,question,op1,op2,op3,op4,ans) values(?,?,?,?,?,?,?)");
								stmt.setInt(1,flag);
								stmt.setString(2, str[0].substring(2, str[0].length()-3));
								stmt.setString(3, str[1].substring(1,str[1].length()-1));
								stmt.setString(4, str[2].substring(1,str[2].length()-1));
								stmt.setString(5, str[3].substring(1,str[3].length()-1));
								stmt.setString(6, str[4].substring(1,str[4].length()-1));
								stmt.setString(7, str[5].substring(1,str[5].length()-1));
								stmt.executeUpdate();
								count=0;
								str[0]="";str[1]="";str[2]="";str[3]="";str[4]="";str[5]="";
								flag++;
							}
					}
					s="";
					s1="";
					s2="";
				}
			}
			bread.close();
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}		

	}
}
