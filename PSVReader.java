package designchallenge1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PSVReader extends FilesReader{
	
	public String name, color, line;
	public int day, month, year;
	public BufferedReader br; // = new BufferedReader(new FileReader("Philippine Holidays.csv"));
	public ArrayList<String> characters = new ArrayList<String>();
	public ArrayList<Integer> integers = new ArrayList<Integer>();
	public File file;
	public ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
	
	public PSVReader(File file) throws FileNotFoundException, IOException {
		super(file);
		br = new BufferedReader(new FileReader(file));
		// TODO Auto-generated constructor stub
	}
	


	public void read() throws IOException
	{
		characters.clear();
		integers.clear();
		String line;
	    while ((line = br.readLine()) != null) {
	        String[] values = line.split(" \\| ");
	        for(String value: values)
	        	characters.add(value);
	    
	    String secondLine = characters.get(1);
	    String[] temp = secondLine.split("/");
	    for(String i: temp)
	    {
	    	integers.add(Integer.parseInt(i));
	    	System.out.println(i);
	    }
	    
	    events.add(new CalendarEvent(characters.get(0), characters.get(2), integers.get(1), integers.get(0), integers.get(2)));
	    }
	    return;
	}
	

	public ArrayList<CalendarEvent> getEvents()
	{
		return events;
	}

}
