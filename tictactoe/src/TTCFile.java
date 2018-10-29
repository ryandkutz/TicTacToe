import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TTCFile {
	public static String getFilePrompt()
	{
		JFileChooser jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			return selectedFile.getAbsolutePath();
		}
		else
		{
			return null;
		}
	}
	public static String getDirPrompt()
	{
		JFileChooser jfc = new JFileChooser();
		jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int returnValue = jfc.showOpenDialog(null);
		
		if (returnValue == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
			return selectedFile.getAbsolutePath();
		}
		else
		{
			return null;
		}
	}
	public static String dateAsString()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	public static void newFile(String dir)
	{
		File file = new File(dir);
		  
		try {
		if (file.createNewFile())
		{
		    System.out.println("File is created!");
		} 
		else {
		    System.out.println("File already exists.");
		}
		
		}
		 
		catch (IOException e)
		{
			System.out.println(e);
		}
		
	}
	
	public static String getFileDir()
	{
		String fileDir = getDirPrompt() + "\\" + dateAsString() + ".dat";
		System.out.println(fileDir);
		return fileDir;
	}
}
