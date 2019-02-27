package designchallenge1;

public class AddEventController {
	
	AddEventView EventView;
	CalendarProgramModel CPModel;
	
	public void setView(AddEventView view)
	{
		EventView = view;
	}
	
	public void setModel(CalendarProgramModel model)
	{
		CPModel = model;
	}
	
	public void submitEventForm(String name, String color, int day, int month, int year)
	{
		CalendarEvent event = new CalendarEvent(name, color, day, month, year);
		CPModel.addEvent(event);
	}
}
