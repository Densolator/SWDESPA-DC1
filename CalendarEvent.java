package designchallenge1;

import java.awt.Color;
import java.lang.reflect.Field;

import javax.swing.table.DefaultTableCellRenderer;


public class CalendarEvent {
	//Attributes
	private String colorString, name;
	Color color;
	private int day, month, year;
	DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
	
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
}
