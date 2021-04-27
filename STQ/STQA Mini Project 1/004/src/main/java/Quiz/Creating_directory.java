package Quiz;
//package miniproject;
import java.io.*;

import javax.swing.JOptionPane;
public class Creating_directory 
{
	static int count=1;
	static boolean status=true;
	public  Creating_directory(String file,String filename)
	{
		String path = System.getProperty("user.home") + File.separator + "Documents";
		path += File.separator +""+count+"_"+filename;
		File f1=new File(path);
		JOptionPane jop = new JOptionPane();
		try {
			if(f1.createNewFile() && status)
			{
				 
				 jop.showMessageDialog(jop, "File Downloaded sucessfully :(Location) "+f1);
				 
				System.out.println("New File is created"+f1);
				FileWriter fw=new FileWriter(f1);
				BufferedWriter bw=new BufferedWriter(fw);
				FileReader re=new FileReader(file);
				BufferedReader b=new BufferedReader(re);
				String line="";
				while((line=b.readLine())!=null)
				{
					bw.write(line);
					bw.newLine();
				}
				bw.close();
				b.close();
			}
			else
			{
				 jop.showMessageDialog(jop, "File is already downloaded");
				 status=false;
				 count=1;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		count++;
	}
	public static void main(String[] args) 
	{
		
	}

}
