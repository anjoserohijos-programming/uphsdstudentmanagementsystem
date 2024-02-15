import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.Timer;

import com.placeholder.PlaceHolder;
import javax.swing.JSeparator;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField contactTF;
	private JTextField usernameTF;
	private JTextField emailTF;
	private JTextField idTF;
	private JPasswordField passwordTF;
	private JPasswordField confirmpassTF;
	private JButton ResetBtn;
	private JButton loginBtn;
	private JTextField fnTF;
	private JTextField lnTF;
	private PlaceHolder pl,pl2,pl3,pl4,pl5,pl6,pl7,pl8;
	private Connection conn;
	private PreparedStatement pst;
	private JLabel lblNewLabel;
	private JLabel label;
	private JLabel lblTime;
	private JLabel lblDate;
	private Timer time;
	private JLabel lblseconds;
	private JLabel lblAmPm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		
		setTitle("Register Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton RegisterBtn = new JButton("SUBMIT");
		RegisterBtn.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		RegisterBtn.setBackground(new Color(255, 255, 255));
		RegisterBtn.setForeground(new Color(128, 0, 0));
		RegisterBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		RegisterBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(fnTF.getText() != null && lnTF.getText() != null && contactTF.getText() != null) {
					
					try {
						
						conn = SQLConnect.ConnectDB();
						
						String insertsql = "INSERT INTO admin_info (First_name, Last_name, employee_ID, email_address, contact_number, username, password) VALUES (?, ?, ?, ?, ?, ?, ?);";
						pst = conn.prepareStatement(insertsql);
						pst.setString(1, fnTF.getText());
						pst.setString(2, lnTF.getText());
						pst.setString(3, idTF.getText());
						pst.setString(4, emailTF.getText());
						pst.setString(5, contactTF.getText());
						pst.setString(6, usernameTF.getText());
						pst.setString(7, passwordTF.getText());
						pst.execute();
						
						JOptionPane.showMessageDialog(RegisterBtn,"Account successfully registered.");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						JOptionPane.showMessageDialog(RegisterBtn, "Can't connect to Database");
					}
				}
				else {
					JOptionPane.showMessageDialog(RegisterBtn, "You have missing inputs.");
				}
			}
		});
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/source/UPHLOGO.png")));
		lblNewLabel.setBounds(84, 163, 218, 268);
		contentPane.add(lblNewLabel);
		RegisterBtn.setBounds(834, 498, 105, 47);
		contentPane.add(RegisterBtn);
		
		contactTF = new JTextField();
		contactTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		contactTF.setColumns(10);
		contactTF.setBounds(657, 273, 466, 44);
		pl6 = new PlaceHolder(contactTF, new Color(128,0,0), getForeground(), "Enter your contact number", true, "15", 16);
		contentPane.add(contactTF);
		
		usernameTF = new JTextField();
		usernameTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		usernameTF.setColumns(10);
		usernameTF.setBounds(657, 328, 466, 44);
		pl5 = new PlaceHolder(usernameTF, new Color(128,0,0), getForeground(), "Enter your username", true, "15", 16);
		contentPane.add(usernameTF);
		
		emailTF = new JTextField();
		emailTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		emailTF.setColumns(10);
		emailTF.setBounds(657, 218, 466, 44);
		pl4 = new PlaceHolder(emailTF, new Color(128,0,0), getForeground(), "Enter your email address", true, "15", 16);
		contentPane.add(emailTF);
		
		idTF = new JTextField();
		idTF.setDisabledTextColor(new Color(128, 0, 0));
		idTF.setEnabled(false);
		idTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		idTF.setColumns(10);
		idTF.setBounds(657, 163, 294, 44);
		pl3 = new PlaceHolder(idTF, new Color(128,0,0), getForeground(), "Enter your ID number", true, "15", 16);
		contentPane.add(idTF);
		
		passwordTF = new JPasswordField();
		passwordTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		passwordTF.setBounds(657, 383, 466, 44);
		pl7= new PlaceHolder(passwordTF, new Color(128,0,0), getForeground(), "password", true, "15", 16);
		contentPane.add(passwordTF);
		
		confirmpassTF = new JPasswordField();
		confirmpassTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		confirmpassTF.setBounds(657, 438, 466, 44);
		pl8 = new PlaceHolder(confirmpassTF, new Color(128,0,0), getForeground(), "password", true, "15", 16);
		contentPane.add(confirmpassTF);
		
		
		
		loginBtn = new JButton("LOGIN");
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginBtn.setForeground(new Color(128, 0, 0));
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setDefaultCapable(false);
		loginBtn.setMargin(new Insets(6, 14, 2, 14));
		loginBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		loginBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		loginBtn.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		loginBtn.setBounds(677, 498, 103, 47);
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Login_Form loginPort = new Login_Form();
				
				setVisible(false);
				loginPort.setVisible(true);
			}
			
		});
		contentPane.add(loginBtn);
		
		JLabel lblGenerateID = new JLabel("Generate ID:");
		lblGenerateID.setForeground(new Color(128, 0, 0));
		lblGenerateID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGenerateID.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerateID.setBounds(961, 165, 155, 14);
		contentPane.add(lblGenerateID);
		
		JButton btnGo = new JButton("GO");
		btnGo.setForeground(new Color(128, 0, 0));
		btnGo.setBorder(new LineBorder(new Color(128, 0, 0), 2, true));
		btnGo.setBackground(new Color(255, 255, 255));
		btnGo.setBounds(992, 184, 89, 23);
		btnGo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				Random rand = new Random();
				int minimum = 1000000;
				int maximum = 9000000;
				
				int i = minimum + rand.nextInt(maximum);
				idTF.setText(Integer.toString(i));
				btnGo.setEnabled(false);
			}
			
		});
		
		JLabel lblNoteThisIs = new JLabel("Note: This is only for administrators' use. Unauthorized signing is prohibited.");
		lblNoteThisIs.setHorizontalAlignment(SwingConstants.LEFT);
		lblNoteThisIs.setForeground(new Color(128, 0, 0));
		lblNoteThisIs.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNoteThisIs.setBounds(655, 562, 483, 36);
		contentPane.add(lblNoteThisIs);
		contentPane.add(btnGo);
		
		fnTF = new JTextField();
		fnTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		fnTF.setColumns(10);
		fnTF.setBounds(657, 102, 208, 44);
		pl = new PlaceHolder(fnTF, new Color(128,0,0), getForeground(), "First Name", true, "15", 16);
		contentPane.add(fnTF);
		
		lnTF = new JTextField();
		lnTF.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		lnTF.setColumns(10);
		lnTF.setBounds(886, 102, 237, 44);
		 pl2 = new PlaceHolder(lnTF, new Color(128,0,0), getForeground(), "Last Name", true, "15", 16);
		contentPane.add(lnTF);
		
		ResetBtn = new JButton("RESET");
		ResetBtn.setBackground(new Color(255, 255, 255));
		ResetBtn.setForeground(new Color(128, 0, 0));
		ResetBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ResetBtn.setBorder(new LineBorder(new Color(128, 0, 0), 3, true));
		ResetBtn.setBounds(992, 498, 114, 47);
		ResetBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				fnTF.setText(null);
				lnTF.setText(null);
				idTF.setText(null);
				emailTF.setText(null);
				contactTF.setText(null);
				usernameTF.setText(null);
				passwordTF.setText(null);
				confirmpassTF.setText(null);
				
				btnGo.setEnabled(true);
				
			}
			
		});
		
		JLabel ICT125 = new JLabel("ICT 12 - 05");
		ICT125.setForeground(new Color(124, 252, 0));
		ICT125.setFont(new Font("Calibri", Font.BOLD, 18));
		ICT125.setBounds(364, 336, 89, 25);
		contentPane.add(ICT125);
		contentPane.add(ResetBtn);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Register.class.getResource("/source/codezillaLogo.png")));
		label.setBounds(298, 175, 227, 256);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Register.class.getResource("/source/Untitled-3.gif")));
		label_1.setBounds(285, 148, 256, 256);
		contentPane.add(label_1);
		
		JLabel lblsecondsIndicator = new JLabel("s");
		lblsecondsIndicator.setForeground(Color.WHITE);
		lblsecondsIndicator.setFont(new Font("Calibri", Font.BOLD, 18));
		lblsecondsIndicator.setBounds(285, 45, 31, 25);
		contentPane.add(lblsecondsIndicator);
		
		lblseconds = new JLabel("54");
		lblseconds.setFont(new Font("Calibri", Font.BOLD, 18));
		lblseconds.setForeground(new Color(255, 255, 255));
		lblseconds.setBounds(266, 45, 31, 25);
		contentPane.add(lblseconds);
		
		lblTime = new JLabel("TIME");
		lblTime.setFont(new Font("Calibri", Font.BOLD, 84));
		lblTime.setForeground(new Color(255, 255, 255));
		lblTime.setHorizontalAlignment(SwingConstants.LEFT);
		lblTime.setBounds(57, 45, 195, 100);
		contentPane.add(lblTime);
		
		lblDate = new JLabel("DATE");
		lblDate.setForeground(new Color(255, 255, 255));
		lblDate.setFont(new Font("Calibri", Font.BOLD, 22));
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setBounds(64, 103, 282, 36);
		contentPane.add(lblDate);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(256, 70, 45, 2);
		contentPane.add(separator);
		
		lblAmPm = new JLabel("AM/PM");
		lblAmPm.setForeground(Color.WHITE);
		lblAmPm.setFont(new Font("Calibri", Font.BOLD, 32));
		lblAmPm.setBounds(256, 70, 56, 44);
		contentPane.add(lblAmPm);
		
		JLabel foregroundlbl = new JLabel();
		foregroundlbl.setLocation(603, 11);
		foregroundlbl.setIcon(new ImageIcon(Register.class.getResource("/source/pic.png")));
		foregroundlbl.setBackground(new Color(0,0,0,.4f));
		foregroundlbl.setSize(589,649);
		contentPane.add(foregroundlbl);
		JLabel backgroundlbl = new JLabel();
		backgroundlbl.setLocation(0, -29);
		backgroundlbl.setIcon(new ImageIcon(Register.class.getResource("/source/night_city_top_view_buildings_railway_118814_1920x1080.jpg")));
		backgroundlbl.setSize(1250,700);
		contentPane.add(backgroundlbl);
		setLocationRelativeTo(null);
		setResizable(false);
		
		fnTF.setOpaque(false);
		lnTF.setOpaque(false);
		idTF.setOpaque(false);
		emailTF.setOpaque(false);
		contactTF.setOpaque(false);
		usernameTF.setOpaque(false);
		passwordTF.setOpaque(false);
		confirmpassTF.setOpaque(false);
		loginBtn.setOpaque(false);
		ResetBtn.setOpaque(false);
		RegisterBtn.setOpaque(false);
		btnGo.setOpaque(false);
		oniichanShowDate();
		loliTime();
		
		
		
	}
	void oniichanShowDate() {
		Date d = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("MMMM dd, yyyy EEEE");
		lblDate.setText(dateformat.format(d));
	}
	void loliTime() {
		ActionListener timerinAction = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date t = new Date();
				SimpleDateFormat formatofTime = new SimpleDateFormat("hh:mm");
				lblTime.setText(formatofTime.format(t));
				
				Date s = new Date();
				SimpleDateFormat formatSec = new SimpleDateFormat("ss");
				lblseconds.setText(formatSec.format(s));
				
				Date ampm = new Date();
				SimpleDateFormat formatAMPM = new SimpleDateFormat("aa");
				lblAmPm.setText(formatAMPM.format(ampm));
			}

		};// end of ActionListener
		
		Timer time = new Timer(1000, timerinAction);
		time.setInitialDelay(0);
		time.start();
		
		
}
}