package designchallenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class FilesReader{
	public String name, color, line;
	public int day, month, year;
	public BufferedReader br; //= new BufferedReader(new FileReader("Philippine Holidays.csv"));
	public ArrayList<String> characters = new ArrayList<String>();
	public File file;
	
	
	
	public FilesReader(File file) throws FileNotFoundException, IOException
	{
		this.file = file;
		br = new BufferedReader(new FileReader(file));
	}
	
	public void read() throws IOException
	{
		String line;
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(",");
	        for(String value: values)
	        	characters.add(value);
	    }
	}
	
	public String getname()
	{
		return "";
	}
	
	public String getColor()
	{
		return "";
	}
	
	public int getDay()
	{
		return 0;
	}
	
	public int getMonth()
	{
		return 0;
	}
	
	public int getYear()
	{
		return 0;
	}

}
