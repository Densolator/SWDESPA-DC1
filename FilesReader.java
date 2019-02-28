package designchallenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;

public class FilesReader{
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
	        characters.add(line);
	    }
	}
	
	public ArrayList<String> getEvent()
	{
		return characters;
	}

}
