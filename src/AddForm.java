import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import com.placeholder.PlaceHolder;

public class AddForm extends JFrame {

	private JPanel contentPane;
	private JTextField lastnameTF;
	private JTextField firstnameTF;
	private JTextField midnameTF;
	private JTextField emailTF;
	private JTextField mfirstnameTF;
	private JTextField mlastnameTF;
	private JTextField flastnameTF;
	private JTextField ffirstnameTF;
	private JTextField guardianContactTF;
	private JTextField guardianName;
	private JTextField adviserTF;
	private JComboBox<String> strandBox,gradeBox,sectionBox,genderBox;
	
	private PlaceHolder pl1,pl2,pl3,pl4,pl5,pl6,pl7,pl8,pl9,pl10,pl11,pl12,pl13,pl14;
	private JLabel lblStrand,lblGrade,lblSection,lblAge;
	private JTextField addressTF;
	private JTextField contactTF;
	private JButton resetBtn;
	private JButton submitBtn;
	private JButton backBtn;
	private Connection conn;
	private PreparedStatement pst;
	public String Mother_Name;
	public JComboBox<String> ageBox;
	
	private JSpinner ageSpinner;
	private JComboBox<String> monthBox, dayBox,yearBox;
	 String s;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddForm frame = new AddForm();
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
	private JLabel lblPicture;
	private JTextField studentID;
	
	public AddForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(982,734);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 112, 147));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	lblPicture = new JLabel("");
		lblPicture.setBounds(720, 143, 219, 237);
		contentPane.add(lblPicture);
		
		lastnameTF = new JTextField();
		lastnameTF.setOpaque(false);
		lastnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		lastnameTF.setBounds(34, 195, 197, 37);
		contentPane.add(lastnameTF);
		lastnameTF.setColumns(10);
		
		firstnameTF = new JTextField();
		firstnameTF.setOpaque(false);
		firstnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		firstnameTF.setColumns(10);
		firstnameTF.setBounds(249, 195, 192, 37);
		contentPane.add(firstnameTF);
		
		midnameTF = new JTextField();
		midnameTF.setOpaque(false);
		midnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		midnameTF.setColumns(10);
		midnameTF.setBounds(468, 195, 192, 37);
		contentPane.add(midnameTF);
		
	 ageSpinner = new JSpinner();
		ageSpinner.setBorder(new EmptyBorder(0, 0, 0, 0));
		ageSpinner.setBounds(620, 254, 40, 37);
		contentPane.add(ageSpinner);
		
		 lblAge = new JLabel("Age: ");
		lblAge.setBounds(577, 265, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lblBirthDate = new JLabel("Birth Date:");
		lblBirthDate.setBounds(34, 255, 121, 36);
		contentPane.add(lblBirthDate);
		
		 dayBox = new JComboBox<String>();
		dayBox.setBorder(new EmptyBorder(0, 0, 0, 0));
	
		dayBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayBox.setBounds(303, 254, 40, 37);
		
		contentPane.add(dayBox);
		
		 yearBox = new JComboBox<String>();
		yearBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		yearBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003"}));
		yearBox.setBounds(375, 254, 86, 37);
		contentPane.add(yearBox);
		
		 monthBox = new JComboBox<String>();
		monthBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		monthBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
							
				if(monthBox.getSelectedItem().equals("January") ||
				   monthBox.getSelectedItem().equals("March")	||	
				   monthBox.getSelectedItem().equals("May")	||	
				   monthBox.getSelectedItem().equals("July")	||
				   monthBox.getSelectedItem().equals("October")	||
				   monthBox.getSelectedItem().equals("December")	
						
						) {
					dayBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));			
				}
				else if( monthBox.getSelectedItem().equals("February")) {
					dayBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29"}));
				}
				
				else {
					dayBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}));
				}
				
			}
		});
		monthBox.setModel(new DefaultComboBoxModel<String>(new String[] {"January", "February", "March", "April", "May ", "June", "July", "August", "September", "October", "November", "December"}));
		monthBox.setBounds(104, 254, 155, 37);
		contentPane.add(monthBox);
		
		genderBox = new JComboBox<String>();
		genderBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		genderBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Male", "Female"}));
		genderBox.setBounds(104, 302, 155, 37);
		contentPane.add(genderBox);
		
		emailTF = new JTextField();
		emailTF.setOpaque(false);
		emailTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		emailTF.setColumns(10);
		emailTF.setBounds(468, 302, 197, 37);
		contentPane.add(emailTF);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(34, 302, 121, 36);
		contentPane.add(lblGender);
		
		mfirstnameTF = new JTextField();
		mfirstnameTF.setOpaque(false);
		mfirstnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		mfirstnameTF.setColumns(10);
		mfirstnameTF.setBounds(362, 417, 298, 37);
		contentPane.add(mfirstnameTF);
		
		mlastnameTF = new JTextField();
		mlastnameTF.setOpaque(false);
		mlastnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		mlastnameTF.setColumns(10);
		mlastnameTF.setBounds(34, 417, 315, 37);
		contentPane.add(mlastnameTF);
		
		flastnameTF = new JTextField();
		flastnameTF.setOpaque(false);
		flastnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		flastnameTF.setColumns(10);
		flastnameTF.setBounds(362, 468, 298, 37);
		contentPane.add(flastnameTF);
		
		ffirstnameTF = new JTextField();
		ffirstnameTF.setOpaque(false);
		ffirstnameTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		ffirstnameTF.setColumns(10);
		ffirstnameTF.setBounds(34, 468, 315, 37);
		contentPane.add(ffirstnameTF);
		
		guardianContactTF = new JTextField();
		guardianContactTF.setOpaque(false);
		guardianContactTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		guardianContactTF.setColumns(10);
		guardianContactTF.setBounds(362, 516, 298, 37);
		contentPane.add(guardianContactTF);
		
		guardianName = new JTextField();
		guardianName.setOpaque(false);
		guardianName.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		guardianName.setColumns(10);
		guardianName.setBounds(34, 516, 315, 37);
		contentPane.add(guardianName);
		
		adviserTF = new JTextField();
		adviserTF.setOpaque(false);
		adviserTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		adviserTF.setColumns(10);
		adviserTF.setBounds(34, 564, 315, 37);
		contentPane.add(adviserTF);
		
		strandBox = new JComboBox<String>();
		strandBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		strandBox.setModel(new DefaultComboBoxModel<String>(new String[] {"TVL - ICT", "TVL - HE", "STEM", "HUMMS", "ABM", "GAS", "AD"}));
		strandBox.setBounds(361, 564, 114, 40);
		contentPane.add(strandBox);
		
		gradeBox = new JComboBox<String>();
		gradeBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		gradeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"11", "12"}));
		gradeBox.setBounds(496, 564, 77, 40);
		contentPane.add(gradeBox);
		
		sectionBox = new JComboBox<String>();
		sectionBox.setBorder(new EmptyBorder(0, 0, 0, 0));
		sectionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07"}));
		sectionBox.setBounds(583, 564, 77, 40);
		contentPane.add(sectionBox);
		
		lblStrand = new JLabel("Strand");
		lblStrand.setHorizontalAlignment(SwingConstants.CENTER);
		lblStrand.setBounds(345, 607, 121, 23);
		contentPane.add(lblStrand);
		
		lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setBounds(496, 607, 77, 23);
		contentPane.add(lblGrade);
		
		lblSection = new JLabel("Section");
		lblSection.setHorizontalAlignment(SwingConstants.CENTER);
		lblSection.setBounds(583, 607, 77, 23);
		contentPane.add(lblSection);
		contactTF = new JTextField();
		contactTF.setOpaque(false);
		contactTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		contactTF.setColumns(10);
		contactTF.setBounds(34, 369, 192, 37);
		contentPane.add(contactTF);
		
		
		addressTF = new JTextField();
		addressTF.setOpaque(false);
		addressTF.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(128, 0, 0)));
		addressTF.setColumns(10);
		addressTF.setBounds(249, 369, 411, 37);
		contentPane.add(addressTF);
		new PlaceHolder(lastnameTF, new Color(128,0,0), getForeground(), "Last Name", true, "15", 16);
		pl1 = new PlaceHolder(firstnameTF, new Color(128,0,0), getForeground(), "First Name", true, "15", 16);
		pl2 = new PlaceHolder(midnameTF, new Color(128,0,0), getForeground(), "Middle Name", true, "15", 16);
		pl4 = new PlaceHolder(addressTF, new Color(128,0,0), getForeground(), "Address", true, "15", 16);
		pl5 = new PlaceHolder(contactTF, new Color(128,0,0), getForeground(), "Contact Number", true, "15", 16);
		pl6 = new PlaceHolder(mfirstnameTF, new Color(128,0,0), getForeground(), "Mother's First Name", true, "15", 16);
		pl7 = new PlaceHolder(mlastnameTF, new Color(128,0,0), getForeground(), "Mother's Last Name", true, "15", 16);
		pl8 = new PlaceHolder(ffirstnameTF, new Color(128,0,0), getForeground(), "Father's First Name", true, "15", 16);
		pl9 = new PlaceHolder(flastnameTF, new Color(128,0,0), getForeground(), "Father's Last Name", true, "15", 16);
		pl10 = new PlaceHolder(guardianName, new Color(128,0,0), getForeground(), "Guardian Name", true, "15", 16);
		pl11 = new PlaceHolder(guardianContactTF, new Color(128,0,0), getForeground(), "Guardian Contact Number", true, "15", 16);
		pl12 = new PlaceHolder(adviserTF, new Color(128,0,0), getForeground(), "Adviser's Full Name", true, "15", 16);
		pl13 = new PlaceHolder(emailTF, new Color(128,0,0), getForeground(), "Email Address", true, "15", 16);
		
		resetBtn = new JButton("Reset");
		resetBtn.setBounds(720, 500, 104, 46);
		contentPane.add(resetBtn);
		
		submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					conn = SQLConnect.ConnectDB();
					if(lastnameTF.getText() != ""&& firstnameTF.getText() != "" && studentID.getText().length() == 7 
							&& !ageSpinner.getValue().equals(0) && strandBox.getSelectedItem() != "" && gradeBox.getSelectedItem() != "" && !sectionBox.equals("")) {
						insertData(
								firstnameTF.getText(),
								lastnameTF.getText(),
								" ",
								(int) ageSpinner.getValue(),
								monthBox.getSelectedItem() + " " +dayBox.getSelectedItem() + ", " + yearBox.getSelectedItem(), 
								(String) genderBox.getSelectedItem(),
								emailTF.getText(), 
								contactTF.getText(), 
								addressTF.getText(), 
								studentID.getText(),
								mfirstnameTF.getText() + " " + mlastnameTF.getText(), 
								ffirstnameTF.getText() + " " + flastnameTF.getText(), 
								guardianName.getText(), 
								guardianContactTF.getText(),
								adviserTF.getText(), 
								strandBox.getSelectedItem() + " " + gradeBox.getSelectedItem() + "-"+ sectionBox.getSelectedItem());
					}
					else {
						JOptionPane.showMessageDialog(lblGender, "Oh no!, One of the required textfields are filled blank! Or maybe the student ID is above 7 characters");
						
					}

				} catch (SQLException  e1) {
					
					e1.printStackTrace();
				}
			}
		});
		submitBtn.setBounds(720, 436, 219, 51);
		contentPane.add(submitBtn);
		
		backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_Form backToForm = new Admin_Form();
				setVisible(false);
				backToForm.setVisible(true);
			}
		});
		backBtn.setBounds(834, 500, 105, 46);
		contentPane.add(backBtn);
		
		studentID = new JTextField();
		studentID.setBounds(269, 302, 172, 37);
		contentPane.add(studentID);
		studentID.setColumns(10);
		
		JLabel formBorderlbl = new JLabel("");
		formBorderlbl.setIcon(new ImageIcon(AddForm.class.getResource("/source/Picture4.png")));
		formBorderlbl.setBounds(10, 143, 700, 527);
		contentPane.add(formBorderlbl);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AddForm.class.getResource("/source/night_city_top_view_buildings_railway_118814_1920x1080.jpg")));
		lblNewLabel.setBounds(0, 0, 966, 695);
		contentPane.add(lblNewLabel);

	}
	
	
	private void insertData(String firstName, String lastName, String midName, 
			int age, String birthdate, String gender, String email_address, String contactNo, String address, String studentId,String motherName,
			String fatherName, String guardianName, String guardianContact, String adviserName, String sectionName
			) throws SQLException {
		
		pst = conn.prepareStatement("INSERT INTO `students_info` (First_Name, Last_Name, Middle_Name, Age, Birth_Date, Gender, Contact_Number, Email_Address, Address, Student_ID, Mother_Name, Father_Name, Guardian_Name , Guardian_ContactNo, Adviser , Section) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?);");
		
		pst.setString(1, firstName);
		pst.setString(2, lastName);
		pst.setString(3, midName);
		pst.setInt(4, age);
		pst.setString(5, birthdate);
		pst.setString(6, gender);
		pst.setString(7, contactNo);
		pst.setString(8, email_address);
		pst.setString(9, address);
		pst.setString(10, studentId);
		pst.setString(11, motherName);
		pst.setString(12, fatherName);
		pst.setString(13, guardianName);
		pst.setString(14, guardianContact);
		pst.setString(15, adviserName);
		pst.setString(16, sectionName);
		pst.execute();
		
		JOptionPane.showMessageDialog(backBtn, "Thank you, student added succesfully");
		
	}
}
