import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;


public class Countdown extends JFrame{
	
	
	final CountdownHelper CDH = new CountdownHelper();

	public Countdown() {
		
		setTitle("Countdown");
		setSize(450, 340);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		
		
		final JLabel lblCountDownHour = new JLabel("Hour");
		lblCountDownHour.setBounds(110, 70, 40, 50);
		lblCountDownHour.setFont(new Font("serif", Font.BOLD, 15));
		this.add(lblCountDownHour);
		
		final JTextField txtCountDownHour = new JTextField("00");
		txtCountDownHour.setBounds(100, 120, 75, 30);
		this.add(txtCountDownHour);
		
		final JLabel lblCountDownMin = new JLabel("Minute");
		lblCountDownMin.setBounds(250, 70, 60, 50);
		lblCountDownMin.setFont(new Font("serif", Font.BOLD, 15));
		this.add(lblCountDownMin);
		
		final JTextField txtCountDownMin = new JTextField("00");
		txtCountDownMin.setBounds(240, 120, 75, 30);
		this.add(txtCountDownMin);
		
		final JButton btnStartTimer = new JButton("Start timer");
		btnStartTimer.setBounds(70, 200, 130, 30);
		this.add(btnStartTimer);
		
		final JButton btnPause = new JButton("Pause");
		btnPause.setBounds(150, 160, 100, 30);
		btnPause.setVisible(false);
		this.add(btnPause);
		
		final JButton btnResume = new JButton("Resume");
		btnResume.setBounds(150, 160, 100, 30);
		btnResume.setVisible(false);
		this.add(btnResume);
		
		final JButton btnStopTimer = new JButton("Stop Timer");
		btnStopTimer.setBounds(220, 200, 100, 30);
		btnStopTimer.setEnabled(false);
		this.add(btnStopTimer);
		
		final JLabel lblCountdownStart = new JLabel();
		lblCountdownStart.setBounds(140,80,250,40);
		lblCountdownStart.setFont(new Font("Serif", Font.BOLD, 40));
        this.add(lblCountdownStart);
        
        final JButton btnBack = new JButton("Back");
        btnBack.setBounds(10, 280, 70, 25);
        btnBack.setFont(new Font("Serif", Font.BOLD, 15));
        this.add(btnBack);
		
        
		final Timer CountTimer = new Timer(1000 , new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				lblCountdownStart.setText(CDH.displayTime());
				CDH.decrease();
				
				
			}
		});
		
		
		btnPause.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				CountTimer.stop();
				
			}
		});
		
		btnStartTimer.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				
				String hour = txtCountDownHour.getText();
				CDH.setCountdownHour(hour);
				String min = txtCountDownMin.getText();
				CDH.setCountdownMin(min);
				
				btnStartTimer.setEnabled(false);
				btnStopTimer.setEnabled(true);
				btnPause.setVisible(true);
				
				CDH.values();
				
				lblCountDownHour.setVisible(false);
				lblCountDownMin.setVisible(false);
				txtCountDownHour.setVisible(false);
				txtCountDownMin.setVisible(false);
				lblCountdownStart.setVisible(true);
				
				CountTimer.start();
			}
		});
		
		btnStopTimer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				CountTimer.stop();
				btnStartTimer.setEnabled(true);
				btnStopTimer.setEnabled(false);
				btnPause.setVisible(false);
				
				txtCountDownHour.setVisible(true);
				txtCountDownMin.setVisible(true);
				
				lblCountDownHour.setVisible(true);
				lblCountDownMin.setVisible(true);
				//lblCountdownEnd.setVisible(false);
				lblCountdownStart.setVisible(false);
				
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				WatchFrame Watch = new WatchFrame();
				Watch.setVisible(true);
				Countdown C = new Countdown();
				C.setVisible(false);
				
				
			}
		});
		
		btnPause.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				CountTimer.stop();
				btnPause.setVisible(false);
				btnResume.setVisible(true);
				
			}
		});
		btnResume.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				CountTimer.start();
				btnPause.setVisible(true);
				btnResume.setVisible(false);
				
				
			}
		});
		
	}
	 


	
}
