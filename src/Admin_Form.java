import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;



public class Admin_Form  extends JFrame{

	public Admin_Form() {
		setTitle("Admin_Form");
		setResizable(false);
		setSize(1250,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null); 
		
		JButton updateBtn = new JButton("REMOVE STUDENTS");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RemoveForm formRemove = new RemoveForm();
				setVisible(false);
				formRemove.setVisible(true);
			}
		});
		updateBtn.setOpaque(false);
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateBtn.setForeground(new Color(128,0,0));
				updateBtn.setBackground(new Color(255, 255, 255));
				updateBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
			}
			public void mouseExited(MouseEvent e) {
				
				updateBtn.setForeground(new Color(255,255,255));
				updateBtn.setBackground(new Color(128, 0, 0));
				updateBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255,255,255)));
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 18));
		updateBtn.setForeground(new Color(255, 255, 255));
		updateBtn.setBackground(new Color(255, 255, 255));
		updateBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
		updateBtn.setBounds(833, 309, 230, 185);
		getContentPane().add(updateBtn);
		
		JButton btnAddremove = new JButton("ADD STUDENTS");
		btnAddremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			AddForm adf = new AddForm();
			setVisible(false);
			adf.setVisible(true);
			
				
			}
		});
		btnAddremove.setOpaque(false);
		
		btnAddremove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnAddremove.setBackground(new Color(255, 255, 255));
				btnAddremove.setForeground(new Color(128,0,0));
				btnAddremove.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
				btnAddremove.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
			}
			public void mouseExited(MouseEvent arg0) {
				
				btnAddremove.setBackground(new Color(128,0,0));
				btnAddremove.setForeground(new Color(255,255,255));
				btnAddremove.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255,255,255)));
			}
			
		});
		btnAddremove.setForeground(new Color(255, 255, 255));
		btnAddremove.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnAddremove.setBackground(new Color(255, 255, 255));
		btnAddremove.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
		btnAddremove.setBounds(500, 306, 230, 185);
		getContentPane().add(btnAddremove);
		
		JButton viewStudentBtn = new JButton("View Students");
		viewStudentBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ICTframe goToICTframe = new ICTframe();
				setVisible(false);
				goToICTframe.setVisible(true);
			}
		});
		viewStudentBtn.setOpaque(false);
		viewStudentBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				viewStudentBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
				viewStudentBtn.setBackground(new Color(255, 255, 255));
				viewStudentBtn.setForeground(new Color(128, 0, 0));
			}
			public void mouseExited(MouseEvent e) {
				
				viewStudentBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
				viewStudentBtn.setBackground(new Color(128, 0, 0));
				viewStudentBtn.setForeground(new Color(255, 255, 255));
			}
		});
		viewStudentBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(255, 255, 255)));
		viewStudentBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		viewStudentBtn.setBackground(new Color(255, 255, 255));
		viewStudentBtn.setFont(new Font("Tahoma", Font.BOLD, 24));
		viewStudentBtn.setForeground(new Color(255, 255, 255));
		viewStudentBtn.setBounds(164, 306, 230, 185);
		
		getContentPane().add(viewStudentBtn);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(255, 255, 255));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(617, 549, 3, 71);
		getContentPane().add(separator);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Form login = new Login_Form();
				setVisible(false);
				login.setVisible(true);
				
			}
		});
		btnSignOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnSignOut.setBackground(new Color(255, 255, 255));
				btnSignOut.setForeground(new Color(128,0,0));
				btnSignOut.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
				
			}
			public void mouseExited(MouseEvent arg0) {
				btnSignOut.setBackground(new Color(255, 255, 255));
				btnSignOut.setForeground(new Color(255, 255, 255));
				btnSignOut.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
			}
		});
		btnSignOut.setForeground(new Color(255, 255, 255));
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignOut.setOpaque(false);
		btnSignOut.setBackground(new Color(255, 255, 255));
		btnSignOut.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		btnSignOut.setBounds(500, 573, 89, 23);
		getContentPane().add(btnSignOut);
		
		JButton aboutbtn = new JButton("About");
		aboutbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				aboutbtn.setBackground(new Color(255, 255, 255));
				aboutbtn.setForeground(new Color(128,0,0));
				aboutbtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
				
			}
			public void mouseExited(MouseEvent arg0) {
				aboutbtn.setBackground(new Color(255, 255, 255));
				aboutbtn.setForeground(new Color(255, 255, 255));
				aboutbtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
			}
		});
		aboutbtn.setForeground(new Color(255, 255, 255));
		aboutbtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		aboutbtn.setOpaque(false);
		aboutbtn.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255)));
		aboutbtn.setBackground(new Color(255, 255, 255));
		aboutbtn.setBounds(647, 573, 89, 23);
		getContentPane().add(aboutbtn);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(757, 582, 400, 3);
		getContentPane().add(separator_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(76, 582, 400, 3);
		getContentPane().add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(76, 182, 3, 400);
		getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setForeground(Color.WHITE);
		separator_4.setBounds(1155, 182, 3, 400);
		getContentPane().add(separator_4);
		
		JLabel titleLBL = new JLabel("Student Management System");
		titleLBL.setHorizontalAlignment(SwingConstants.CENTER);
		titleLBL.setForeground(new Color(255, 255, 255));
		titleLBL.setFont(new Font("Tahoma", Font.PLAIN, 76));
		titleLBL.setBounds(98, 53, 1039, 110);
		getContentPane().add(titleLBL);
		
		JLabel lblDate = new JLabel("March 07, 2019 Thursday");
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(458, 163, 296, 23);
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyy EEEE");
		lblDate.setText(sdf.format(d));
		getContentPane().add(lblDate);
		
		JLabel askWhatToDolbl = new JLabel("Hi there! What would you like to do?");
		askWhatToDolbl.setHorizontalAlignment(SwingConstants.CENTER);
		askWhatToDolbl.setForeground(Color.WHITE);
		askWhatToDolbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		askWhatToDolbl.setBounds(164, 245, 899, 33);
		getContentPane().add(askWhatToDolbl);
		
		JLabel bglbl = new JLabel("");
		bglbl.setIcon(new ImageIcon(Admin_Form.class.getResource("/source/dawn.jpg")));
		bglbl.setBounds(0, 0, 1244, 671);
		getContentPane().add(bglbl);
	}
	
	
	public static void main(String[] args) {
		new Admin_Form();
	}
	
}
