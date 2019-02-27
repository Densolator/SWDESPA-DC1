package designchallenge1;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddEventView {
	AddEventController EventController;
	
	//GUI Elements
	public JLabel eventNameLabel, eventDayLabel, eventMonthLabel, eventYearLabel, eventColorLabel;
	public JButton btnCancel, btnConfirm;
	public JTextField eventNameField;
	public JComboBox cmbDaySelection, cmbYearSelection, cmbMonthSelection, cmbColorSelection;
	public DefaultComboBoxModel model = new DefaultComboBoxModel();
	public JFrame frmEvent;
	public JPanel eventPanel;
	public Container eventPane;
	
	String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    String[] colors = {"Red", "Blue", "Green", "Yellow", "Orange"};
    
    public AddEventView(int month, int year)
    {
    	
    	
    	frmEvent = new JFrame("Create a new event");
        frmEvent.setSize(500, 500);
        frmEvent.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        eventPane = frmEvent.getContentPane();
    	eventPane.setLayout(null);
    	
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
    	
    	btnCancel.addActionListener(new btnCancel_Action());
    	btnConfirm.addActionListener(new btnConfirm_Action());
    	
    }
    
    public void showView()
    {
    	frmEvent.setVisible(true);
    }
    
    public void hideView()
    {
    	frmEvent.setVisible(false);
    }
    
    class btnCancel_Action implements ActionListener
	{
		public void actionPerformed (ActionEvent e)
		{
			hideView();
		}
	}

	class btnConfirm_Action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			hideView();
//			CPController.submitEventForm(eventNameField.getText(), (String)cmbColorSelection.getSelectedItem(), cmbDaySelection.getSelectedIndex() + 1, cmbMonthSelection.getSelectedIndex() + 1,(int) cmbYearSelection.getSelectedItem());		
		}
	}
	
	public void setController(AddEventController controller)
	{
		EventController = controller;
	}
}
