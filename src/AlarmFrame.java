
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.lang.model.util.SimpleElementVisitor7;
import javax.sound.midi.Soundbank;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;

public class AlarmFrame extends JFrame{
		
		protected static final String[] AlarmHour = null;
		JLabel lblSetAlarm, lblSetHour, lblSetMin, lblSetAmOrPm;
		JButton btnAlarmSave, btnAlarmoff;
		
		
		private String sound;
		 
	public AlarmFrame() {
		
		setTitle("Set Your Alarm");
		setSize(450, 340);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		WatchFrame TFrame = new WatchFrame();
		AlarmWindow();
		Remainder remind = new Remainder();
		
		sound1 = new Sound();
		
	}
	private Sound sound1;
	
	public void AlarmWindow(){
			
		final JList<String> jAlarmHour;
		final JList<String> jAlarmMin;
		final JList<String> jAlarmAmOrPm;
		
		final String AlarmHour[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		final String AlarmMin[] = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"};
		final String AlarmAmOrPm [] = {"AM", "PM"};
		
		jAlarmHour = new JList<String>(AlarmHour);
		jAlarmHour.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jAlarmMin = new JList<String>(AlarmMin);
		jAlarmMin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jAlarmAmOrPm = new JList<String>(AlarmAmOrPm);
		jAlarmAmOrPm.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lblSetAlarm = new JLabel("Set New Alarm");
		lblSetAlarm.setBounds(105, 15, 200, 50);
		lblSetAlarm.setFont(new Font("Serif", Font.BOLD, 30));
		this.add(lblSetAlarm);
		
		lblSetHour = new JLabel("Hour");
		lblSetHour.setBounds(70, 85, 75, 30);
		this.add(lblSetHour);
		
		final JScrollPane ScrollHour = new JScrollPane(jAlarmHour); //Cannot refer to a non-final variable ScrollMin inside an inner class defined in a different method
		ScrollHour.setPreferredSize(new Dimension(100, 120));
		ScrollHour.setBounds(70, 120, 50, 80);
		this.add(ScrollHour);
		
	
		lblSetMin = new JLabel("Minute");
		lblSetMin.setBounds(180, 85, 75, 30);
		this.add(lblSetMin);
		
		final JScrollPane ScrollMin = new JScrollPane(jAlarmMin);
		ScrollMin.setPreferredSize(new Dimension(100, 120));
		ScrollMin.setBounds(180, 120, 50, 80);
		this.add(ScrollMin);
		
		lblSetAmOrPm = new JLabel("AM/PM");
		lblSetAmOrPm.setBounds(280, 85, 75, 30);
		this.add(lblSetAmOrPm);
		
		final JScrollPane ScrollAmPm = new JScrollPane(jAlarmAmOrPm);
		ScrollAmPm.setPreferredSize(new Dimension(100, 120));
		ScrollAmPm.setBounds(280, 120, 50, 80);
		this.add(ScrollAmPm);
		
		final JLabel alarmLabel = new JLabel();
		alarmLabel.setFont(new Font("serif", Font.BOLD , 25) );
		alarmLabel.setBounds(75, 50, 300, 50);
		this.add(alarmLabel);
		
		final JButton btnAlarmSave = new JButton("Save");
        btnAlarmSave.setBounds(180,220,80,25);
        this.add(btnAlarmSave);
		
        final JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 280, 70, 25);
        btnBack.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(btnBack);
        
        final JButton btnAlarmoff = new JButton("Turn Off");
        btnAlarmoff.setBounds(170,200,80,25);
        btnAlarmoff.setVisible(false);
        this.add(btnAlarmoff);
        
   
        
        
        final SimpleDateFormat sdfalarmHour = new SimpleDateFormat("hh");
        final SimpleDateFormat sdfalarmMin = new SimpleDateFormat("mm");
        final SimpleDateFormat sdfalarmAmPm = new SimpleDateFormat("a");
        
        final Timer Alarm = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Date date = new Date();
               
			   int SysHour = Integer.parseInt(sdfalarmHour.format(date));
			   
               int SysMin = Integer.parseInt(sdfalarmMin.format(date));

               String Sysampm = sdfalarmAmPm.format(date);



               int AlarmH = Integer.parseInt(AlarmHour[jAlarmHour.getSelectedIndex()]);

               int AlarmM = Integer.parseInt(AlarmMin[jAlarmMin.getSelectedIndex()]);

               String Alarmampm = AlarmAmOrPm[jAlarmAmOrPm.getSelectedIndex()];

               if ((SysHour == AlarmH) && (SysMin == AlarmM) && (Sysampm.equals(Alarmampm) ) ){
                	
                	
                	alarmLabel.setText("Alarm Ringing");
                	
            	   sound1.play();

                }
            }
        });
		 
		
		btnAlarmSave.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				ScrollAmPm.setVisible(false);
				ScrollHour.setVisible(false);
				ScrollMin.setVisible(false);
				
				lblSetAlarm.setVisible(false);
				lblSetHour.setVisible(false);
				lblSetMin.setVisible(false);
				lblSetAmOrPm.setVisible(false);
				btnAlarmSave.setVisible(false);
				btnAlarmoff.setVisible(true);
				btnBack.setVisible(true);
				
				alarmLabel.setVisible(true);
				
				
				
				
				alarmLabel.setText("Alarm Set To " + AlarmHour[jAlarmHour.getSelectedIndex()]+ " : "+AlarmMin[jAlarmMin.getSelectedIndex()]+ " " + AlarmAmOrPm[jAlarmAmOrPm.getSelectedIndex()]);
				
				Alarm.start();
				
				
				
				
				
			}
		});
		
		btnAlarmoff.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				btnAlarmoff.setVisible(false);
				btnAlarmSave.setVisible(true);
				btnBack.setVisible(true);
				alarmLabel.setVisible(false);
				
				ScrollAmPm.setVisible(true);
				ScrollHour.setVisible(true);
				ScrollMin.setVisible(true);
				
				lblSetAlarm.setVisible(true);
				lblSetAmOrPm.setVisible(true);
				lblSetMin.setVisible(true);
				lblSetHour.setVisible(true);
				
				Alarm.stop();
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				setVisible(false);
				
				
			}
		});
		
		
	
	}
	
}

