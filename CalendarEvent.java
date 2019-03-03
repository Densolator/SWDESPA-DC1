package designchallenge1;

import java.awt.Color;



public class CalendarEvent {
	//Attributes
	private String colorString, name, tag;
	Color color;
	private int day, month, year;
	
	String[] tags = {"Event", "Holiday"};
	
	//Constructor
	public CalendarEvent(String name, String color, int day, int month, int year)
	{
		try
		{
			this.colorString = color;
			this.name = name;
			this.color = (Color)Color.class.getField(color.toLowerCase()).get(null);
			this.day = day;
			this.month = month;
			this.year = year;
			this.tag = tags[0];
		}
		catch(Exception e)
		{
		}
	}
	
	public CalendarEvent(String name, String color, int day, int month, int year, int type)
	{
		try
		{
			this.colorString = color;
			this.name = name;
			this.color = (Color)Color.class.getField(color.toLowerCase()).get(null);
			this.day = day;
			this.month = month;
			this.year = year;
			this.tag = tags[type];
		}
		catch(Exception e)
		{
		}
	}
	
	//Methods
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setMonth(int month)
	{
		this.month = month;
	}
	
	public int getMonth()
	{
		return this.month;
	}
	
	public void setDay(int day)
	{
		this.day = day;
	}
	
	public int getDay()
	{
		return this.day;
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}
	
	public int getYear()
	{
		return this.year;
	}
	
	public void setColor(String color)
	{
		this.colorString = color;
	}
	
	public String getColorString()
	{
		try
		{
		return color.toString();
		}
		catch(NullPointerException e)
		{
			System.out.println("The color " + colorString + " is currently not supported. Please choose a different color");
			return colorString;
		}
	}
	
	public void setTag(int type)
	{
		try
		{
		tag = tags[type];
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("Please enter a number ranging from 0-1 only.");
			return;
		}
	}
	
	public String getTag()
	{
		return tag;
	}
}
