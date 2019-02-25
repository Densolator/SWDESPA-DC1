/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

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
        CalendarProgramView CPView = new CalendarProgramView();
        CalendarProgramController CPController = new CalendarProgramController();
        CalendarProgramModel CPModel = new CalendarProgramModel();
        CPView.setController(CPController);
        CPController.setView(CPView);
        CPController.setModel(CPModel);
    }
}
