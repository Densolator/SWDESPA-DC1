/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Arturo III
 */
public class DesignChallenge1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
    	String PSVPath = "\\Users\\Rafael\\Documents\\Subjects\\SWDESPA\\SWDESPA - DC1 - Source files\\Source Code\\DesignChallenge1\\src\\designchallenge1\\DLSU Unicalendar.psv";
    	String CSVPath = "\\Users\\Rafael\\Documents\\Subjects\\SWDESPA\\SWDESPA - DC1 - Source files\\Source Code\\DesignChallenge1\\src\\designchallenge1\\Philippine Holidays.csv";
    	File PSVFile = new File(PSVPath);
    	File CSVFile = new File(CSVPath);
    	FilesReader PSVReader = new FilesReader(PSVFile);
    	FilesReader CSVReader = new FilesReader(CSVFile);
    	PSVReader.read();
    	CSVReader.read();
        CalendarProgramView CPView = new CalendarProgramView();
        CalendarProgramController CPController = new CalendarProgramController();
        CalendarProgramModel CPModel = new CalendarProgramModel();
        CPView.setController(CPController);
        CPController.setView(CPView);
        CPController.setModel(CPModel);
        FileWriter PSVWriter = new FileWriter(PSVReader.getEvent(), " \\| ");
        PSVWriter.writeTo(CPModel.events);
        FileWriter CSVWriter = new FileWriter(CSVReader.getEvent(), ", ");
        CSVWriter.writeTo(CPModel.events);
        
        AddEventController EventController = new AddEventController();
        CPView.EventView.setController(EventController);
    }
}
