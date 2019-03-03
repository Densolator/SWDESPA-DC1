package designchallenge1;

import java.awt.Color;
import java.util.ArrayList;

public class CalendarProgramModel {
	
	//Set Controller
	CalendarProgramController CPController;
	ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
	
	public void setController(CalendarProgramController controller)
	{
		CPController = controller;
	
	}
	
	public void addEvent(CalendarEvent event)
	{
		events.add(event);
		System.out.println(event.getName());
		System.out.println(event.getDay() + " " +event.getMonth() + " " + event.getYear());
	}
	
	public void temp()
	{
		events.add(new CalendarEvent("Valentine's Day", "Red", 14, 2, 2019));
	}
	
	public void printAllEvents()
	{
		for(CalendarEvent event: events)
		{
			System.out.println(event.getName() + "," + event.getColorString() + ": " + event.getDay() + "," + event.getMonth() + "," + event.getYear());
		}
	}
	
	public ArrayList<CalendarEvent> getHolidays()
	{
		ArrayList<CalendarEvent> holidays = new ArrayList<CalendarEvent>();
		for(CalendarEvent e: events)
		{
			System.out.println(e.getTag() + " " + e.getName() + " " + e.getYear());
			if(e.getTag().equals("Holiday"))
			{
				holidays.add(e);
			}
		}
		return holidays;
	}
}
