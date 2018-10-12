import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;



public class WatchFrame extends JFrame{
 	
	
	JButton btnAlarm, btnStopWatch, btnCountdown, btnReminder ;
	JLabel lbl1, labelClockTime, labelClockDay;
	
	SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
	SimpleDateFormat sdfDay = new SimpleDateFormat("EEEE");
	SimpleDateFormat sdfDate = new SimpleDateFormat("MMMM dd, yyyy");
	
	
	
	
public WatchFrame() {
	
	
	setTitle("Watch");
	setSize(600, 400);
	setResizable(false);
	setLayout(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	getContentPane().setBackground(Color.LIGHT_GRAY);
	
			
	Window();
	CreateClock();
	addActionListener();
	
}

public void Window(){
	
	lbl1 = new JLabel(" Smart Watch ");
	lbl1.setBounds(170, 15, 350 , 35);
	lbl1.setFont(new Font("Serif", Font.BOLD, 40 ));
	this.add(lbl1);
	
	
	btnAlarm = new JButton("Alarm");
	btnAlarm.setBounds(140, 250, 150, 40);
	btnAlarm.setFont(new Font("Serif", Font.BOLD, 20));
	//btnAlarm.setBackground(Color.pink);
	this.add(btnAlarm);
	
	btnStopWatch = new JButton("StopWatch");
	btnStopWatch.setBounds(310, 250, 150, 40);
	btnStopWatch.setFont(new Font("Serif", Font.BOLD, 20));
	this.add(btnStopWatch);
	
	btnCountdown = new JButton("Countdown");
	btnCountdown.setBounds(310, 310, 150, 40);
	btnCountdown.setFont(new Font("Serif", Font.BOLD, 20));
	this.add(btnCountdown);

	btnReminder = new JButton("Reminder");
	btnReminder.setBounds(140, 310, 150, 40);
	btnReminder.setFont(new Font("Serif", Font.BOLD, 20));
	this.add(btnReminder);	
}
public void CreateClock(){
	
	
	final JLabel labelClockTime = new JLabel();
	labelClockTime.setBounds(195, 40, 400, 100);
	labelClockTime.setFont(new Font("Serif", Font.BOLD, 50));
    this.add(labelClockTime);
    
    final JLabel labelClockDay = new JLabel();
    labelClockDay.setBounds(210, 120, 150, 50);
    labelClockDay.setFont(new Font("serif", Font.BOLD, 35));
    this.add(labelClockDay);
    
    final JLabel labelClockDate = new JLabel();
    labelClockDate.setBounds(195, 160, 200, 50);
    labelClockDate.setFont(new Font("serif", Font.BOLD, 30));
    this.add(labelClockDate);
    
    ActionListener timerListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Date date = new Date();
			String time = sdfTime.format(date);
			labelClockTime.setText(sdfTime.format(date));
			labelClockDay.setText(sdfDay.format(date));
			labelClockDate.setText(sdfDate.format(date));
		}
	};
    
    
    javax.swing.Timer timer = new javax.swing.Timer(1000, timerListener);
    timer.setInitialDelay(0); 
    timer.start();
           
    
}


public void addActionListener(){
	
	btnAlarm.addActionListener( new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			
			AlarmFrame sAlarm = new AlarmFrame();
			sAlarm.setVisible(true);
			
		
			 
			
			
		}
	});
	
	btnStopWatch.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent e) {
			
			StopWatch StopW = new StopWatch();
			StopW.setVisible(true);
			
		
			
			
		}
	});
		
	btnCountdown.addActionListener(new ActionListener() {
		
		
		public void actionPerformed(ActionEvent arg0) {
			Countdown Cd = new Countdown();
			Cd.setVisible(true);
			
	
			
		}
	});
	
	btnReminder.addActionListener(new ActionListener() {
		
	
		public void actionPerformed(ActionEvent arg0) {
			Remainder R = new Remainder();
			R.setVisible(true);
			
		}
	});
	
	
	}
}


