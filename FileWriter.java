package designchallenge1;

import java.util.ArrayList;

public class FileWriter {
	int day, month, year;
	String name, color;
	ArrayList<CalendarEvent> events =  new ArrayList<CalendarEvent>();
	ArrayList<String> lines = new ArrayList<String>();
	String delimiter;
	boolean isThisStringColor;
	String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange"};
	
	public FileWriter(ArrayList<String> lines, String delimiter)
	{
		this.lines = lines;
		this.delimiter = delimiter;
	}
	
	public void writeTo(ArrayList<CalendarEvent> events)
	{
		for(String s: lines)
		{
			String[] splitString = s.split(delimiter);
			for(String t: splitString)
			{
				isThisStringColor = false;
				if(t.contains("/"))
				{
					String[] stringSplitFurther = t.split("/");
					month = Integer.valueOf(stringSplitFurther[0]);
					day = Integer.valueOf(stringSplitFurther[1]);						
					year = Integer.valueOf(stringSplitFurther[2]);
				}
				
				else
				{
					for(String color: colors)
					{
						if(t.equalsIgnoreCase(color))
						{
							isThisStringColor = true;
						}
					}
					if(isThisStringColor)
						color = t;
					else
						name = t;
				}
			}
			events.add(new CalendarEvent(name, color, day, month, year));
		}
	}
}
