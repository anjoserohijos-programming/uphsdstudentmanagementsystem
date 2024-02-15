import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login_Form extends JFrame implements KeyListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    String val=" ";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Form frame = new Login_Form();
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
	public Login_Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 571);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(128, 0, 0));
		btnLogin.setBackground(new Color(255, 255, 255));
		btnLogin.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBounds(219, 351, 126, 40);
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					Connection conn = SQLConnect.ConnectDB();
					String sql = "SELECT * FROM admin_info WHERE username=? AND password =?";
					pst = conn.prepareStatement(sql);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					rs = pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(btnLogin,"Successfully logged in");
						setVisible(false);
						Admin_Form adminForm = new Admin_Form();
						adminForm.setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(btnLogin,"You have missing inputs or wrong keywords");
					}
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
	
		getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(128, 0, 0));
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnReset.setBounds(219, 402, 126, 40);
		
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				textField.setText(null);
				textField_1.setText(null);
			}
			
		});
		getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(139, 0, 0));
		btnExit.setBackground(new Color(255, 255, 255));
		btnExit.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(128, 0, 0)));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnExit.setBounds(219, 453, 126, 40);
		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
			
		});
		
		getContentPane().add(btnExit);
		btnLogin.setOpaque(false);
		btnReset.setOpaque(false);
		btnExit.setOpaque(false);
		
		textField = new JTextField();
		textField.setFocusTraversalKeysEnabled(false);
		textField.setEnabled(true);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		textField.setForeground(new Color(128, 0, 0));
		textField.setBounds(74, 147, 412, 40);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFocusTraversalKeysEnabled(false);
		textField_1.setEnabled(true);
		textField_1.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 0, 0)));
		textField_1.setForeground(new Color(128, 0, 0));
		textField_1.setColumns(10);
		textField_1.setBounds(74, 233, 412, 40);
		getContentPane().add(textField_1);
		textField.setOpaque(false);
		textField_1.setOpaque(false);
		
		JLabel lblNewUserClick = new JLabel("New user? click here to register!");
		lblNewUserClick.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewUserClick.setForeground(new Color(255,255,255));
			}
			public void mouseExited(MouseEvent arg0) {
				lblNewUserClick.setForeground(new Color(128,0,0));
			}
			public void mouseClicked(MouseEvent arg0) {
				Register reg =new Register();
				setVisible(false);
				reg.setVisible(true);
			}
		});
		lblNewUserClick.setForeground(new Color(128, 0, 0));
		lblNewUserClick.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewUserClick.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUserClick.setBounds(116, 515, 332, 14);
		getContentPane().add(lblNewUserClick);
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setForeground(new Color(128, 0, 0));
		lblPassword.setBounds(74, 198, 85, 29);
		getContentPane().add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setForeground(new Color(128, 0, 0));
		lblUsername.setBounds(74, 107, 85, 29);
		getContentPane().add(lblUsername);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(Login_Form.class.getResource("/source/pic4.png")));
		lblNewLabel.setBounds(10, 0, 548, 566);
		getContentPane().add(lblNewLabel);
		setResizable(false);
		setLocationRelativeTo(null);
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		val += e.getKeyChar();
		textField.setText(val);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub

	}
}
