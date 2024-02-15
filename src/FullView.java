import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Rectangle;

public class FullView extends JFrame {

	private JPanel contentPane;
	public JTextField txtFirstname;
	public JTextField txtLastName;
	public JTextField fullnameTF;
	public JTextField ageTF;
	public JTextField birthTF;
	public JTextField genderTF;
	private JTextField studentIDTF;
	private JTextField contactTF;
	private JTextField emailTF;
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullView frame = new FullView();
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
	public FullView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(988,637);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFirstname = new JTextField();
		txtFirstname.setBorder(null);
		txtFirstname.setOpaque(false);
		txtFirstname.setHorizontalAlignment(SwingConstants.CENTER);
		txtFirstname.setEditable(false);
		txtFirstname.setForeground(new Color(255, 255, 255));
		txtFirstname.setFont(new Font("Calibri", Font.BOLD, 40));
		txtFirstname.setText("FIRSTNAME");
		txtFirstname.setBounds(10, 295, 376, 68);
		contentPane.add(txtFirstname);
		txtFirstname.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setBorder(null);
		txtLastName.setText("Last Name");
		txtLastName.setOpaque(false);
		txtLastName.setHorizontalAlignment(SwingConstants.CENTER);
		txtLastName.setForeground(Color.WHITE);
		txtLastName.setFont(new Font("Calibri", Font.PLAIN, 31));
		txtLastName.setEditable(false);
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 344, 376, 43);
		contentPane.add(txtLastName);
		
		fullnameTF = new JTextField();
		fullnameTF.setForeground(new Color(255, 255, 255));
		fullnameTF.setFont(new Font("Tahoma", Font.BOLD, 12));
		fullnameTF.setOpaque(false);
		fullnameTF.setBorder(null);
		fullnameTF.setEditable(false);
		fullnameTF.setHorizontalAlignment(SwingConstants.LEFT);
		fullnameTF.setBounds(143, 437, 203, 20);
		contentPane.add(fullnameTF);
		fullnameTF.setColumns(10);
		
		studentIDTF = new JTextField();
		studentIDTF.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		studentIDTF.setForeground(new Color(255, 255, 255));
		studentIDTF.setBorder(null);
		studentIDTF.setOpaque(false);
		studentIDTF.setBounds(556, 96, 187, 20);
		contentPane.add(studentIDTF);
		studentIDTF.setColumns(10);
		
		contactTF = new JTextField();
		contactTF.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		contactTF.setForeground(new Color(255, 255, 255));
		contactTF.setBorder(null);
		contactTF.setOpaque(false);
		contactTF.setColumns(10);
		contactTF.setBounds(556, 136, 187, 20);
		contentPane.add(contactTF);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		emailTF.setForeground(new Color(255, 255, 255));
		emailTF.setBorder(null);
		emailTF.setOpaque(false);
		emailTF.setColumns(10);
		emailTF.setBounds(556, 180, 187, 20);
		contentPane.add(emailTF);
		
		JTextArea homeAddressTF = new JTextArea();
		homeAddressTF.setFont(new Font("Calibri Light", Font.PLAIN, 17));
		homeAddressTF.setForeground(new Color(255, 255, 255));
		homeAddressTF.setLineWrap(true);
		homeAddressTF.setWrapStyleWord(true);
		homeAddressTF.setOpaque(false);
		homeAddressTF.setText("Blk 10 Lot 6 Viva Homes Subdivision, Salawag, Dasmari\u00F1as, Cavite");
		homeAddressTF.setBounds(556, 218, 283, 90);
		contentPane.add(homeAddressTF);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("Calibri", Font.BOLD, 17));
		lblAddress.setBounds(435, 224, 107, 14);
		contentPane.add(lblAddress);
		
		JLabel lblStudentID = new JLabel("Student ID:");
		lblStudentID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentID.setFont(new Font("Calibri", Font.BOLD, 17));
		lblStudentID.setForeground(new Color(255, 255, 255));
		lblStudentID.setBounds(435, 99, 107, 14);
		contentPane.add(lblStudentID);
		
		JLabel lblContact = new JLabel("Contact No.:");
		lblContact.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContact.setFont(new Font("Calibri", Font.BOLD, 17));
		lblContact.setForeground(new Color(255, 255, 255));
		lblContact.setBounds(435, 139, 107, 14);
		contentPane.add(lblContact);
		
		JLabel lblEmailAdd = new JLabel("Email Address:");
		lblEmailAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmailAdd.setFont(new Font("Calibri", Font.BOLD, 17));
		lblEmailAdd.setForeground(new Color(255, 255, 255));
		lblEmailAdd.setBounds(435, 183, 107, 14);
		contentPane.add(lblEmailAdd);
		
		JLabel lblOther = new JLabel("Other");
		lblOther.setForeground(Color.WHITE);
		lblOther.setFont(new Font("Calibri", Font.BOLD, 28));
		lblOther.setBounds(435, 328, 283, 48);
		contentPane.add(lblOther);
		
		JLabel lblLocationAndContact = new JLabel("Contact and Location");
		lblLocationAndContact.setForeground(new Color(255, 255, 255));
		lblLocationAndContact.setFont(new Font("Calibri", Font.BOLD, 28));
		lblLocationAndContact.setBounds(435, 40, 283, 48);
		contentPane.add(lblLocationAndContact);
		
		JLabel lblPersonalInfo = new JLabel("PERSONAL INFO:");
		lblPersonalInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPersonalInfo.setForeground(new Color(255, 255, 255));
		lblPersonalInfo.setBounds(23, 411, 114, 14);
		contentPane.add(lblPersonalInfo);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFullName.setForeground(Color.WHITE);
		lblFullName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFullName.setBounds(23, 440, 114, 14);
		contentPane.add(lblFullName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAge.setForeground(Color.WHITE);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAge.setBounds(23, 465, 114, 14);
		contentPane.add(lblAge);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDateOfBirth.setBounds(23, 490, 114, 14);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblGender.setBounds(23, 515, 114, 14);
		contentPane.add(lblGender);
		
		ageTF = new JTextField();
		ageTF.setForeground(new Color(255, 255, 255));
		ageTF.setFont(new Font("Tahoma", Font.BOLD, 12));
		ageTF.setOpaque(false);
		ageTF.setBorder(null);
		ageTF.setEditable(false);
		ageTF.setHorizontalAlignment(SwingConstants.LEFT);
		ageTF.setColumns(10);
		ageTF.setBounds(143, 462, 203, 20);
		contentPane.add(ageTF);
		
		birthTF = new JTextField();
		birthTF.setForeground(new Color(255, 255, 255));
		birthTF.setFont(new Font("Tahoma", Font.BOLD, 12));
		birthTF.setOpaque(false);
		birthTF.setBorder(null);
		birthTF.setEditable(false);
		birthTF.setHorizontalAlignment(SwingConstants.LEFT);
		birthTF.setColumns(10);
		birthTF.setBounds(143, 487, 203, 20);
		contentPane.add(birthTF);
		
		genderTF = new JTextField();
		genderTF.setForeground(new Color(255, 255, 255));
		genderTF.setFont(new Font("Tahoma", Font.BOLD, 12));
		genderTF.setOpaque(false);
		genderTF.setBorder(null);
		genderTF.setEditable(false);
		genderTF.setHorizontalAlignment(SwingConstants.LEFT);
		genderTF.setColumns(10);
		genderTF.setBounds(143, 512, 203, 20);
		contentPane.add(genderTF);
		
		JLabel imageBorder = new JLabel("");
		imageBorder.setIcon(new ImageIcon(FullView.class.getResource("/source/imageBorder.png")));
		imageBorder.setBounds(78, 40, 245, 198);
		contentPane.add(imageBorder);
		
		JLabel imagePanel = new JLabel("");
		imagePanel.setIcon(new ImageIcon(FullView.class.getResource("/source/imagePanel.png")));
		imagePanel.setBounds(0, 0, 400, 611);
		contentPane.add(imagePanel);
		
		JLabel lblBglbl = new JLabel("");
		lblBglbl.setIcon(new ImageIcon(FullView.class.getResource("/source/dawn.jpg")));
		lblBglbl.setBounds(397, 0, 586, 611);
		contentPane.add(lblBglbl);
		
		JLabel label = new JLabel("Student ID:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Calibri", Font.BOLD, 17));
		label.setBounds(445, 387, 107, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Student ID:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Calibri", Font.BOLD, 17));
		label_1.setBounds(445, 423, 107, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Student ID:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Calibri", Font.BOLD, 17));
		label_2.setBounds(445, 465, 107, 14);
		contentPane.add(label_2);
	}
}
