import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class SplashScreen extends JFrame {
	String ID = "";
	Scanner scan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private Timer t;
	private ActionListener Al;
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,750);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		getContentPane().setLayout(null);
		
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(195,365,402,14);
		JLabel label = new JLabel();
		label.setFont(new Font("Calibri", Font.BOLD, 85));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(258,235,276,119);
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setIcon(new ImageIcon(SplashScreen.class.getResource("/source/startup.gif")));
		
		label_1.setBounds(0, 0, 750, 644);
		getContentPane().add(label_1);
		getContentPane().add(progressBar);
		getContentPane().add(label);
		Al = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				if(progressBar.getValue()<100) {
					progressBar.setValue(progressBar.getValue()+1);
					
					
					int task = progressBar.getValue();
					label.setText(Integer.toString(task)+"%");
				}
				else {
					try {
						Thread.sleep(800);
						t.stop();
						setVisible(false);
						MainFrame frame = new MainFrame();
						frame.setVisible(true);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} 
		};
			try {
				t = new Timer(60,Al);
				t.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e);
			}
			// end of Al
			
		
		setLocationRelativeTo(null);
		
	}
}
