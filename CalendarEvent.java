package designchallenge1;

import java.awt.Color;

import javax.swing.table.DefaultTableCellRenderer;

public class CalendarEvent {
	//Attributes
	private String  colorString, name;
	Color color = Color.getColor(colorString);
	private int day, month, year;
	DefaultTableCellRenderer cell = new DefaultTableCellRenderer();
	
	//Constructor
	public CalendarEvent(String name, String color, int day, int month, int year)
	{
		this.name = name;
		this.color = Color.getColor(color);
		this.day = day;
		this.month = month;
		this.year = year;
		
		cell.setBackground(this.color);
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
	
	public String getColor()
	{
		return this.color.toString();
	}
}
