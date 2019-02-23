/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package designchallenge1;

/**
 *
 * @author Arturo III
 */

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CalendarProgram
{
	String PSVFilename = "C:\\Users\\Rafael\\Documents\\Subjects\\SWDESPA\\SWDESPA - DC1 - Source files\\Source Code\\DesignChallenge1\\src\\designchallenge1\\DLSU Unicalendar.psv";
	String CSVFilename = "C:\\Users\\Rafael\\Documents\\Subjects\\SWDESPA\\SWDESPA - DC1 - Source files\\Source Code\\DesignChallenge1\\src\\designchallenge1\\Philippine Holidays.csv";
	File PSVFile = new File(PSVFilename);
	File CSVFile = new File(CSVFilename);
	
	
	
        /**** Day Components ****/
	public int yearBound, monthBound, dayBound, yearToday, monthToday;
	public ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();
	public CalendarEvent event = new CalendarEvent("Birthday", "Blue", 15, 02, 2019);

        /**** Swing Components ****/
	//Main calendar components
    public JLabel monthLabel, yearLabel;
	public JButton btnPrev, btnNext, btnAdd;
    public JComboBox cmbYear;
	public JFrame frmMain;
	public Container pane;
	public JScrollPane scrollCalendarTable;
	public JPanel calendarPanel;
    
	//Add event components
	
	public JLabel eventNameLabel, eventDayLabel, eventMonthLabel, eventYearLabel, eventColorLabel;
	public JButton btnCancel, btnConfirm;
	public JTextField eventNameField;
	public JComboBox cmbDaySelection, cmbYearSelection, cmbMonthSelection, cmbColorSelection;
	public DefaultComboBoxModel model = new DefaultComboBoxModel();
	public JFrame frmEvent;
	public JPanel eventPanel;
	public Container eventPane;
	
        /**** Calendar Table Components ***/
	public JTable calendarTable;
    public DefaultTableModel modelCalendarTable;
    
    //Assigned as global variable
    String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange"};
        
        public void refreshCalendar(int month, int year)
        {
		int numOfDays, startOfMonth, i, j;	
		
		btnPrev.setEnabled(true);
		btnNext.setEnabled(true);
		if (month == 0 && year <= yearBound-10)
                    btnPrev.setEnabled(false);
		if (month == 11 && year >= yearBound+100)
                    btnNext.setEnabled(false);
                
		monthLabel.setText(months[month]);
		monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 360, 50);
                
		cmbYear.setSelectedItem(""+year);
		
		cmbMonthSelection.setSelectedItem(months[month]);
		cmbYearSelection.setSelectedItem(year);
		cmbDaySelection.removeAll();
		
		for (i = 0; i < 6; i++)
			for (j = 0; j < 7; j++)
				modelCalendarTable.setValueAt(null, i, j);
		
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		numOfDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startOfMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);
		
		
		for (i = 1; i <= numOfDays; i++)
        {
			if(model.getIndexOf(i) == -1)
				cmbDaySelection.addItem(i);
			int row = new Integer((i+startOfMonth-2)/7);
			int column  =  (i+startOfMonth-2)%7;
			for(CalendarEvent event: events)
			{
				if(event.getDay() == i && event.getMonth()-1 == month && event.getYear() == year)
				{
//					System.out.println("Event fired");
					modelCalendarTable.setValueAt(i + "Event:" + event.getName(), row, column);
				}
				else
					modelCalendarTable.setValueAt(i, row, column);
			}
        }

		calendarTable.setDefaultRenderer(calendarTable.getColumnClass(0), new TableRenderer());


        }
        
        
                
	public CalendarProgram() throws IOException
        {
		try 
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
		catch (Exception e) {}
		CSVFileReader CSVReader = new CSVFileReader(CSVFile);
		PSVReader PSVReader = new PSVReader(PSVFile);
		CSVReader.read();
		PSVReader.read();
		ArrayList<CalendarEvent> PSVEvents = PSVReader.getEvents();
		ArrayList<CalendarEvent> CSVEvents = CSVReader.getEvents();
		
		for(CalendarEvent e: PSVEvents)
		{
			e.getName();
			events.add(e);
			System.out.println("PSV");
		}
		
		for(CalendarEvent e: CSVEvents)
		{
			e.toString();
			events.add(e);
			System.out.println("CSV");
		}
		
		
		
		events.add(event);
		
		for(CalendarEvent e: events)
		{
			System.out.println(e.getName());
		}
		
		frmMain = new JFrame ("Calendar Application");
        frmMain.setSize(660, 750);
        frmEvent = new JFrame("Create a new event");
        frmEvent.setSize(500, 500);
        frmEvent.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		pane = frmMain.getContentPane();
		pane.setLayout(null);
		eventPane = frmEvent.getContentPane();
		eventPane.setLayout(null);
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Calendar window elements
		monthLabel = new JLabel ("January");
		yearLabel = new JLabel ("Change year:");
		cmbYear = new JComboBox();
		btnPrev = new JButton ("<<");
		btnNext = new JButton (">>");
		btnAdd = new JButton("+");
		
		//Event window elements
		eventNameLabel = new JLabel("Name of event:");
		eventDayLabel = new JLabel("Day:");
		eventMonthLabel = new JLabel("Month:");
		eventYearLabel = new JLabel("Year:");
		eventColorLabel = new JLabel("Color:");
		eventNameField = new JTextField();
		btnCancel = new JButton("Cancel");
		btnConfirm = new JButton("Confirm");
		cmbDaySelection = new JComboBox(model);
		cmbMonthSelection = new JComboBox(months);
		cmbYearSelection = new JComboBox();
		cmbColorSelection = new JComboBox(colors);
		
		
		
		
		modelCalendarTable = new DefaultTableModel()
                {
                    public boolean isCellEditable(int rowIndex, int mColIndex)
                    {
                        return true;
                    }
                };
                
		calendarTable = new JTable(modelCalendarTable);
                calendarTable.addMouseListener(new MouseAdapter()   
                {  
                    public void mouseClicked(MouseEvent evt)  
                    {  
                        int col = calendarTable.getSelectedColumn();  
                        int row = calendarTable.getSelectedRow();  
                    }
                });
                
		scrollCalendarTable = new JScrollPane(calendarTable);
		calendarPanel = new JPanel(null);

		calendarPanel.setBorder(BorderFactory.createTitledBorder("Calendar"));
		
		//Main Frame Listeners
		btnPrev.addActionListener(new btnPrev_Action());
		btnNext.addActionListener(new btnNext_Action());
		cmbYear.addActionListener(new cmbYear_Action());
		btnAdd.addActionListener(new btnAdd_Action());
		
		//Event Frame Listeners
		btnCancel.addActionListener(new btnCancel_Action());
		btnConfirm.addActionListener(new btnConfirm_Action());
		
		pane.add(calendarPanel);
		calendarPanel.add(monthLabel);
		calendarPanel.add(yearLabel);
		calendarPanel.add(cmbYear);
		calendarPanel.add(btnPrev);
		calendarPanel.add(btnNext);
		calendarPanel.add(btnAdd);
		calendarPanel.add(scrollCalendarTable);
		
		eventPanel = new JPanel(null);
		eventPane.add(eventPanel);
		eventPanel.add(btnCancel);
		eventPanel.add(btnConfirm);
		eventPanel.add(eventNameLabel);
		eventPanel.add(eventDayLabel);
		eventPanel.add(eventMonthLabel);
		eventPanel.add(eventYearLabel);
		eventPanel.add(eventColorLabel);
		eventPanel.add(eventNameField);
		eventPanel.add(cmbDaySelection);
		eventPanel.add(cmbMonthSelection);
		eventPanel.add(cmbYearSelection);
		eventPanel.add(cmbColorSelection);
		
		eventPanel.setBounds(0, 0, 700, 700);
		btnCancel.setBounds(125, 375, 100, 50);
		btnConfirm.setBounds(275, 375, 100, 50);
		eventNameLabel.setBounds(125, 50, 100, 25);
		eventDayLabel.setBounds(125, 100, 50, 25);
		eventMonthLabel.setBounds(125, 150, 50, 25);
		eventYearLabel.setBounds(125, 200, 50, 25);
		eventColorLabel.setBounds(125, 250, 50, 25);
		eventNameField.setBounds(225, 55, 150, 25);
		cmbDaySelection.setBounds(175, 105, 50, 25);
		cmbMonthSelection.setBounds(175, 155, 150, 25);
		cmbYearSelection.setBounds(175, 205, 100, 25);
		cmbColorSelection.setBounds(175, 255, 100, 25);
		
		frmEvent.setVisible(false);
		
        calendarPanel.setBounds(0, 0, 640, 670);
        monthLabel.setBounds(320-monthLabel.getPreferredSize().width/2, 50, 200, 50);
		yearLabel.setBounds(20, 610, 160, 40);
		cmbYear.setBounds(100, 610, 160, 40);
		btnPrev.setBounds(20, 50, 100, 50);
		btnNext.setBounds(520, 50, 100, 50);
		btnAdd.setBounds(520, 610, 100, 42);
		scrollCalendarTable.setBounds(20, 100, 600, 500);
                
		frmMain.setResizable(false);
		frmMain.setVisible(true);
		
		GregorianCalendar cal = new GregorianCalendar();
		dayBound = cal.get(GregorianCalendar.DAY_OF_MONTH);
		monthBound = cal.get(GregorianCalendar.MONTH);
		yearBound = cal.get(GregorianCalendar.YEAR);
		monthToday = monthBound; 
		yearToday = yearBound;
		
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
			modelCalendarTable.addColumn(headers[i]);
		}
		
		calendarTable.getParent().setBackground(calendarTable.getBackground()); //Set background

		calendarTable.getTableHeader().setResizingAllowed(false);
		calendarTable.getTableHeader().setReorderingAllowed(false);

		calendarTable.setColumnSelectionAllowed(true);
		calendarTable.setRowSelectionAllowed(true);
		calendarTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		calendarTable.setRowHeight(76);
		modelCalendarTable.setColumnCount(7);
		modelCalendarTable.setRowCount(6);
		
		
		
		for (int i = yearBound-100; i <= yearBound+100; i++)
        {
			cmbYear.addItem(String.valueOf(i));
			cmbYearSelection.addItem(i);
		}
		
		
//		DefaultTableCellRenderer cell2 = cell.getTableCellRendererComponent(calendarTable, 2, 3);
		refreshCalendar (monthBound, yearBound); //Refresh calendar
	}
	
	//Main Frame Listeners
	class btnPrev_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 0)
                        {
				monthToday = 11;
				yearToday -= 1;
			}
			else
                        {
				monthToday -= 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	class btnNext_Action implements ActionListener
        {
		public void actionPerformed (ActionEvent e)
                {
			if (monthToday == 11)
                        {
				monthToday = 0;
				yearToday += 1;
			}
			else
                        {
				monthToday += 1;
			}
			refreshCalendar(monthToday, yearToday);
		}
	}
	
	class btnAdd_Action implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			frmEvent.setVisible(true);
		}
	}
	
	class cmbYear_Action implements ActionListener
    {
		public void actionPerformed (ActionEvent e)
        {
			if (cmbYear.getSelectedItem() != null)
            {
				String b = cmbYear.getSelectedItem().toString();
				yearToday = Integer.parseInt(b);
				refreshCalendar(monthToday, yearToday);
			}
		}
	}
	
	
	//Event Frame Listeners
	class btnCancel_Action implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			frmEvent.setVisible(false);
		}
	}
	
	class btnConfirm_Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			events.add(new CalendarEvent(eventNameField.getText(), String.valueOf(cmbColorSelection.getSelectedItem()), (Integer)cmbDaySelection.getSelectedItem(), cmbMonthSelection.getSelectedIndex() + 1, (Integer)cmbYearSelection.getSelectedItem()));
			frmEvent.setVisible(false);
		}
	}
}
