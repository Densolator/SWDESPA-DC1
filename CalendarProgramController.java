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
	
}
