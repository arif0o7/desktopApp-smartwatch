import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;


public class Remainder extends JFrame {
	
		public Sound Sound1;
		
	public Remainder() {
	
		setSize(450, 340);
		setLayout(null);
		setTitle("set Remainder");
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		Sound1 = new Sound();
		
		final JList<String> jReminderHour;
		final JList<String> JReminderMin;
		final JList<String> jReminderAmPm;
		
		final String ReminderHour[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		final String ReminderMin[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
		final String ReminderAmOrPm [] = {"AM", "PM"};
		
		
		jReminderHour = new JList<String>(ReminderHour);
		jReminderHour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JReminderMin = new JList<String>(ReminderMin);
		JReminderMin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jReminderAmPm = new JList<String>(ReminderAmOrPm);
		jReminderAmPm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		final JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 280, 70, 25);
        btnBack.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(btnBack);
        
        final JLabel lblRewmainder = new JLabel("Set Reminder: ");
        lblRewmainder.setBounds(20, 10, 100, 30);
        lblRewmainder.setFont(new Font("serif", Font.BOLD, 15));
        this.add(lblRewmainder);
        
        final JTextField txtRemainder = new JTextField();
        txtRemainder.setBounds(20, 40, 405, 40);
        this.add(txtRemainder);
        
        final JTextArea txtRemind = new JTextArea(5, 10);
        txtRemind.setEditable(false);
        this.add(txtRemind);
        
        final JLabel lblReminder = new JLabel();
        lblReminder.setBounds(50, 20, 300, 50);
        lblReminder.setFont(new Font("serif", Font.BOLD, 20));
        this.add(lblReminder);
        
        final JButton btnSaveRemainder = new JButton("Save Remainder");
        btnSaveRemainder.setFont(new Font("serif", Font.BOLD, 15));
        btnSaveRemainder.setBounds(120, 220, 150, 30);
        this.add(btnSaveRemainder);
        
        final JLabel lblHour = new JLabel("Hour");
		lblHour.setBounds(70, 85, 75, 30);
		this.add(lblHour);
		
			
		final JScrollPane ScrollHour = new JScrollPane(jReminderHour);
		ScrollHour.setPreferredSize(new Dimension(100, 120));
		ScrollHour.setBounds(70, 120, 50, 80);
		this.add(ScrollHour);
		
	
		final JLabel lblMin = new JLabel("Minute");
		lblMin.setBounds(180, 85, 75, 30);
		this.add(lblMin);
		
		final JScrollPane ScrollMin = new JScrollPane(JReminderMin);
		ScrollMin.setPreferredSize(new Dimension(100, 120));
		ScrollMin.setBounds(180, 120, 50, 80);
		this.add(ScrollMin);
		
		final JLabel lblAmOrPm = new JLabel("AM/PM");
		lblAmOrPm.setBounds(280, 85, 75, 30);
		this.add(lblAmOrPm);
		
		final JScrollPane ScrollAmPm = new JScrollPane(jReminderAmPm);
		ScrollAmPm.setPreferredSize(new Dimension(100, 120));
		ScrollAmPm.setBounds(280, 120, 50, 80);
		this.add(ScrollAmPm);
		
		 final JButton btnRemindeOff = new JButton("Reminder Off");
		 btnRemindeOff.setBounds(140,200,120,25);
		 btnRemindeOff.setVisible(false);
	     this.add(btnRemindeOff);
		
		final SimpleDateFormat sdfRemindermHour = new SimpleDateFormat("hh");
        final SimpleDateFormat sdfReminderMin = new SimpleDateFormat("mm");
        final SimpleDateFormat sdfReminderAmPm = new SimpleDateFormat("a");
        
        final Timer AlarmReminder = new Timer(1000, new ActionListener() {
           
			@Override
            public void actionPerformed(ActionEvent e) {
               Date date = new Date();
               
			   int SysHour = Integer.parseInt(sdfRemindermHour.format(date));
			   
               int SysMin = Integer.parseInt(sdfReminderMin.format(date));

               String Sysampm = sdfReminderAmPm.format(date);



               int AlarmH = Integer.parseInt(ReminderHour[jReminderHour.getSelectedIndex()]);

               int AlarmM = Integer.parseInt(ReminderMin[JReminderMin.getSelectedIndex()]);

               String Alarmampm = ReminderAmOrPm[jReminderAmPm.getSelectedIndex()];

               if ((SysHour == AlarmH) && (SysMin == AlarmM) && (Sysampm.equals(Alarmampm) ) ){
                	
                	
            	   lblReminder.setText("Reminder : " + txtRemainder.getText() );	   
            	    Sound1.play();
            	   	
                }
            }
        });
		
    
        
        
        btnSaveRemainder.addActionListener(new ActionListener() {
			
			
 			public void actionPerformed(ActionEvent arg0) {
 			
 				btnBack.setVisible(true);
 				lblRewmainder.setVisible(false);
 				btnSaveRemainder.setVisible(false);
 				txtRemainder.setVisible(false);
 				
 				ScrollHour.setVisible(false);
 				ScrollMin.setVisible(false);
 				ScrollAmPm.setVisible(false);
 				
 				lblHour.setVisible(false);
 				lblMin.setVisible(false);
 				lblAmOrPm.setVisible(false);
 				btnRemindeOff.setVisible(true);
 				
 				lblReminder.setVisible(true);
 				
 				lblReminder.setText(" Reminder Set To : " + ReminderHour[jReminderHour.getSelectedIndex()]+" : " + ReminderMin[JReminderMin.getSelectedIndex()]+ " " + ReminderAmOrPm[jReminderAmPm.getSelectedIndex()] );
 				AlarmReminder.start();
 			}
 		});
        
        btnRemindeOff.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				
				btnBack.setVisible(true);
 				lblRewmainder.setVisible(true);
 				btnSaveRemainder.setVisible(true);
 				txtRemainder.setVisible(true);
 				
 				ScrollHour.setVisible(true);
 				ScrollMin.setVisible(true);
 				ScrollAmPm.setVisible(true);
 				
 				lblHour.setVisible(true);
 				lblMin.setVisible(true);
 				lblAmOrPm.setVisible(true);
 				btnRemindeOff.setVisible(false);
				
 				AlarmReminder.stop();
			}
		});
        
        btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				WatchFrame Watch = new WatchFrame();
				Watch.setVisible(true);
				Remainder R = new Remainder();
				R.setVisible(false);
				
				
			}
		});
	}
	

}
