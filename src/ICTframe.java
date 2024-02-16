import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.Font;

public class ICTframe extends JFrame{
	private JTable ICTtable;

	ICTframe(){
		setTitle("ICT Students");
		setSize(1047,670);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JComboBox<String> strandBox = new JComboBox<String>();
		strandBox.setModel(new DefaultComboBoxModel<String>(new String[] {"TVL - ICT", "TVL - HE", "STEM", "ABM", "HUMMS", "GAS", "AD"}));
		strandBox.setBounds(95, 121, 148, 20);
		getContentPane().add(strandBox);
		
		JComboBox<String> sectionBox = new JComboBox<String>();
		sectionBox.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02"}));
		sectionBox.setBounds(692, 121, 59, 20);
		getContentPane().add(sectionBox);
		
		JComboBox<String> gradeBox = new JComboBox<String>();
		gradeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"11", "12"}));
		gradeBox.setBounds(453, 121, 53, 20);
		getContentPane().add(gradeBox);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection conn = SQLConnect.ConnectDB();
					String select = "SELECT * FROM `students_info`";
					
					if(!strandBox.getSelectedItem().toString().isEmpty() && !gradeBox.getSelectedItem().toString().isEmpty() && !sectionBox.getSelectedItem().toString().isEmpty()) {
						PreparedStatement pst = conn.prepareStatement(select);
						ResultSet rs = pst.executeQuery();
						DefaultTableModel tableModel = (DefaultTableModel) ICTtable.getModel();
						tableModel.setRowCount(0);
						
						while (rs.next()) {
							Object contents[] = {
									rs.getString("Last_Name"),
									rs.getString("First_Name"),
									rs.getString("Middle_Name"),
									rs.getString("Age"),
									rs.getString("Birth_Date"),
									rs.getString("Gender"),
									rs.getString("Email_Address"),
									rs.getString("Contact_Number"),
									rs.getString("Address"),
									rs.getString("Student_ID"),
									rs.getString("Mother_Name"),
									rs.getString("Father_Name"),
									rs.getString("Guardian_Name"),
									rs.getString("Guardian_ContactNo"),
									rs.getString("Adviser"),
									rs.getString("Section"),
							};
							tableModel.addRow(contents);
						}
					}
					else {
						JOptionPane.showMessageDialog(ICTtable,"Section hasn't been established yet");
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		JButton btnFullView = new JButton("FULL VIEW");
		btnFullView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FullView fv = new FullView();
				fv.setSize(988,637);
				int index = ICTtable.getSelectedRow();
				TableModel model = ICTtable.getModel();
				
				if(ICTtable.isRowSelected(index)) {
					String Last_Name = model.getValueAt(index,0).toString(); // 
					String First_Name = model.getValueAt(index,1).toString(); // 
					String Middle_Name = model.getValueAt(index,2).toString(); // 
					String Age = model.getValueAt(index,3).toString(); //
					String Birth_Date = model.getValueAt(index,4).toString(); //
					String Gender = model.getValueAt(index,5).toString(); //
					// String Email_Address = model.getValueAt(index,6).toString();
					// String Contact = model.getValueAt(index,7).toString(); //
					// String Student_ID = model.getValueAt(index,8).toString(); //
					// String Mother_Name = model.getValueAt(index,9).toString(); //
					// String Father_Name = model.getValueAt(index,10).toString(); //
					// String Guardian_Name = model.getValueAt(index,11).toString(); //
					// String Guardian_Number = model.getValueAt(index,12).toString(); //
					// String Adviser = model.getValueAt(index,13).toString(); //
					// String Section = model.getValueAt(index,14).toString(); //
		
				fv.setVisible(true);
				
				
				
				fv.txtFirstname.setText(First_Name);
				fv.txtLastName.setText(Last_Name);
				fv.fullnameTF.setText(Last_Name+", "+First_Name + " " + Middle_Name);
				fv.ageTF.setText(Age);
				fv.birthTF.setText(Birth_Date);
				fv.genderTF.setText(Gender);
				}
				else {
					JOptionPane.showMessageDialog(ICTtable, "Select a table first");
				}
				
			
			
			
			
			}
		});
		btnFullView.setBounds(363, 511, 118, 56);
		
		getContentPane().add(btnFullView);
		
		JButton backBtn = new JButton("BACK");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Admin_Form backToForm = new Admin_Form();
				setVisible(false);
				backToForm.setVisible(true);
			}
		});
		backBtn.setBounds(536, 511, 127, 56);
		getContentPane().add(backBtn);
		
		searchBtn.setBounds(832, 120, 89, 23);
		
		getContentPane().add(searchBtn);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 0, 0)));
		scrollPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 0, 0)));
		scrollPane.setBounds(10, 154, 1011, 260);
		getContentPane().add(scrollPane);
		
		ICTtable = new JTable();
		ICTtable.setBackground(new Color(255, 255, 102));
		ICTtable.setOpaque(false);
		ICTtable.setSelectionBackground(new Color(250, 128, 114));
		ICTtable.setGridColor(new Color(139, 0, 0));
		ICTtable.setRowHeight(20);
		ICTtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ICTtable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Surname", "First Name", "Middle Name", "Age", "Birth Date", "Gender","Email Address","Contact Number", "Address", "Student ID", "Mother's Name", "Father's Name","Guardian Name","Guardian Contact", "Adviser", "Section"
			}
		));
		ICTtable.setBounds(10, 154, 1011, 349);
		scrollPane.setViewportView(ICTtable);
		
		JLabel lblStrand = new JLabel("Strand: ");
		lblStrand.setForeground(new Color(255, 255, 255));
		lblStrand.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStrand.setBounds(20, 124, 65, 14);
		getContentPane().add(lblStrand);
		
		JLabel lblSection = new JLabel("Section:");
		lblSection.setForeground(Color.WHITE);
		lblSection.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSection.setBounds(598, 123, 65, 14);
		getContentPane().add(lblSection);
		
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setForeground(Color.WHITE);
		lblGrade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblGrade.setBounds(340, 123, 65, 14);
		getContentPane().add(lblGrade);
		JLabel bglbl = new JLabel();
		bglbl.setIcon(new ImageIcon(ICTframe.class.getResource("/source/night_city_top_view_buildings_railway_118814_1920x1080.jpg")));
		bglbl.setBounds(0,0,getWidth(),getHeight());
		//bglbl.setIcon(new Image(""));
		getContentPane().add(bglbl);
		//getContentPane().add(ICTtable);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new ICTframe();
	}
}
