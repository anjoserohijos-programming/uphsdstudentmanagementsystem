import java.awt.Image;
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

public class RemoveForm extends JFrame{
	private JTable ICTtable;

	RemoveForm(){
		setTitle("ICT Students");
		setSize(1047,670);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		JComboBox strandBox = new JComboBox();
		strandBox.setModel(new DefaultComboBoxModel(new String[] {"TVL - ICT", "TVL - HE", "STEM", "ABM", "HUMMS", "GAS", "AD"}));
		strandBox.setBounds(95, 121, 148, 20);
		getContentPane().add(strandBox);
		
		JComboBox sectionBox = new JComboBox();
		sectionBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02"}));
		sectionBox.setBounds(692, 121, 59, 20);
		getContentPane().add(sectionBox);
		
		JComboBox gradeBox = new JComboBox();
		gradeBox.setModel(new DefaultComboBoxModel(new String[] {"11", "12"}));
		gradeBox.setBounds(453, 121, 53, 20);
		getContentPane().add(gradeBox);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Connection conn = SQLConnect.ConnectDB();
					String select = "SELECT * FROM `students_info`";
					
					if(strandBox.getSelectedItem().equals("TVL - ICT") && gradeBox.getSelectedItem().equals("11") && sectionBox.getSelectedItem().equals("01")) {
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
					} // end of if
					else {
						JOptionPane.showMessageDialog(ICTtable,"Section hasn't been established yet");
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int index = ICTtable.getSelectedRow();
				TableModel model = ICTtable.getModel();
			
				try {
					Connection conn = SQLConnect.ConnectDB();
					String delete = "DELETE FROM `students_info` where Student_ID= ?";
					
					if(!strandBox.getSelectedItem().toString().isBlank()  && //the mother IF
							!gradeBox.getSelectedItem().toString().isBlank() && 	
							!sectionBox.getSelectedItem().toString().isBlank() && ICTtable.isRowSelected(index)) {

						String value = ICTtable.getModel().getValueAt(index, 9).toString();
						System.out.println(ICTtable.getModel().getValueAt(index, 9).toString());
						PreparedStatement	pst = conn.prepareStatement(delete);
						pst.setString(ICTtable.getRowCount(), value);
						pst.executeUpdate();
						DefaultTableModel modelReset = (DefaultTableModel) ICTtable.getModel();
						modelReset.setRowCount(0);
						JOptionPane.showMessageDialog(getContentPane(), "Removed successfully!");
					}
					else { //else of the mother if
						JOptionPane.showMessageDialog(getContentPane(), "Select a table first");
					}
					
					
					
				} catch (SQLException e) { // eto pa yung sa pinakauanang try
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		});
		btnRemove.setBounds(363, 511, 118, 56);
		
		getContentPane().add(btnRemove);
		
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
		bglbl.setIcon(new ImageIcon(RemoveForm.class.getResource("/source/night_city_top_view_buildings_railway_118814_1920x1080.jpg")));
		bglbl.setBounds(0,0,getWidth(),getHeight());
		//bglbl.setIcon(new Image(""));
		getContentPane().add(bglbl);
		//getContentPane().add(ICTtable);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
new RemoveForm();
	}
}
