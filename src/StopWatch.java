import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class StopWatch extends JFrame{
	
	public StopWatch() {
		
		final StopWatchHelper SWH = new StopWatchHelper();
		
		setTitle("StopWatch");
		//setDefaultCloseOperation(StopWatch.EXIT_ON_CLOSE);
		setSize(450, 340);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
				
		
		final JButton btnStart = new JButton("Start");
		btnStart.setBounds(60, 200, 100, 30);
		add(btnStart);
		
		final JButton btnStop = new JButton("Stop");
		btnStop.setBounds(170, 200, 100, 30);
		btnStop.setEnabled(false);
		this.add(btnStop);
		
		final JButton btnReset = new JButton("Reset");
		btnReset.setBounds(280, 200, 100, 30);
		btnReset.setEnabled(false);
		this.add(btnReset);
	
		final JLabel lblStopWatch = new JLabel();
		lblStopWatch.setBounds(100, 45, 400, 150);
		lblStopWatch.setText("00:00:00:00");
		lblStopWatch.setFont(new Font("serif", Font.BOLD, 50));
		this.add(lblStopWatch);
		
		 final JButton btnBack = new JButton("Back");
	     btnBack.setBounds(10, 280, 70, 25);
	     btnBack.setFont(new Font("Serif", Font.BOLD, 15));
	     this.add(btnBack);
		
		final javax.swing.Timer timer = new javax.swing.Timer(10, new ActionListener() {
						
			public void actionPerformed(ActionEvent e) {
				SWH.increaseMilSeconds();
				lblStopWatch.setText(SWH.DisplayStopWatch());
				
				
			}
		});
		
		
		btnStart.addActionListener(new ActionListener() {
						
			public void actionPerformed(ActionEvent e) {
				timer.start();
				btnStart.setEnabled(false);
				btnReset.setEnabled(true);
				btnStop.setEnabled(true);
				
			}
		});
		
		btnStop.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				btnStop.setEnabled(false);
				btnStart.setEnabled(true);
				
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
			SWH.resetClock();
			lblStopWatch.setText(SWH.DisplayStopWatch());
			btnReset.setEnabled(false);	
			}
		});
	
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				WatchFrame Watch = new WatchFrame();
				Watch.setVisible(true);
				StopWatch S = new StopWatch();
				S.setVisible(false);
				
				
			}
		});
		
	
	}
	
	
}
