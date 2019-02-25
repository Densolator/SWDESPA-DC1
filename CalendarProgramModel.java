package designchallenge1;

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
	}
}
