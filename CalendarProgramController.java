package designchallenge1;

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
	
	public void submitEventForm(String name, String color, int day, int month, int year)
	{
		CalendarEvent event = new CalendarEvent(name, color, day, month, year);
		CPModel.addEvent(event);
	}
	
}
