package designchallenge1;

import java.util.ArrayList;

public class CalendarProgramController {
	
	//Set View
	CalendarProgramView CPView;
	
	//Set Model
	CalendarProgramModel CPModel;
	
	public void setModel(CalendarProgramModel model)
	{
		CPModel = model;
	}
	
	public void setView(CalendarProgramView view)
	{
		CPView = view;
	}
	
	public void getEventsFor(int day, int month, int year)
	{
		
	}
	
	public boolean isThereEvent(int day, int month, int year)
	{
		for(CalendarEvent event: CPModel.events)
		{
			if((day == event.getDay()) && (month + 1 == event.getMonth()) && (year == event.getYear()))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean isThereHoliday(int day, int month)
	{
		for(CalendarEvent event: CPModel.events)
		{
			if((day == event.getDay()) && (month + 1 == event.getMonth()) && event.getTag().equals("Holiday"))
			{
				return true;
			}
		}
		return false;
	}
	
//	public void setHolidaysYear(int year)
//	{
//		ArrayList<CalendarEvent> holidays = CPModel.getHolidays();
//		for(CalendarEvent e: holidays)
//		{
//			CalendarEvent someEvent = new CalendarEvent(e.getName(), e.getColorString(), e.getDay(), e.getMonth(), year, 1);
//			if(CPModel.events.contains(someEvent))
//				continue;
//			else
//				CPModel.events.add(someEvent);
//		}
//	}

}
