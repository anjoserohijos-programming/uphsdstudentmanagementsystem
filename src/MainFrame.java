import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize( 900, 700);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton StartBtn = new JButton("START");
		StartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login_Form log = new Login_Form();
				
				setVisible(false);
				log.setVisible(true);
			}
		});
		StartBtn.setForeground(new Color(128, 0, 0));
		StartBtn.setBackground(new Color(255, 255, 255));
		StartBtn.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(128, 0, 0)));
		StartBtn.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 34));
		StartBtn.setBounds(329, 550, 236, 60);
		contentPane.add(StartBtn);
		
		JLabel lblNewLabel = new JLabel("STUDENT MANAGEMENT");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 56));
		lblNewLabel.setBounds(10, 37, 864, 104);
		contentPane.add(lblNewLabel);
		
		JLabel lblSystem = new JLabel("SYSTEM");
		lblSystem.setForeground(new Color(255, 255, 255));
		lblSystem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystem.setFont(new Font("Calibri", Font.BOLD, 56));
		lblSystem.setBounds(20, 100, 864, 104);
		contentPane.add(lblSystem);
		
		JLabel lblSerohijosAnjo = new JLabel("Serohijos, Anjo");
		lblSerohijosAnjo.setFont(new Font("Calibri", Font.BOLD, 17));
		lblSerohijosAnjo.setForeground(new Color(255, 255, 255));
		lblSerohijosAnjo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSerohijosAnjo.setBounds(new Rectangle(0, 0, 80, 34));
		lblSerohijosAnjo.setBounds(150, 289, 260, 14);
		contentPane.add(lblSerohijosAnjo);
		
		JLabel lblRomeroMatthew = new JLabel("Romero, Matthew");
		lblRomeroMatthew.setFont(new Font("Calibri", Font.BOLD, 17));
		lblRomeroMatthew.setForeground(new Color(255, 255, 255));
		lblRomeroMatthew.setHorizontalAlignment(SwingConstants.CENTER);
		lblRomeroMatthew.setBounds(new Rectangle(0, 0, 80, 34));
		lblRomeroMatthew.setBounds(150, 336, 260, 14);
		contentPane.add(lblRomeroMatthew);
		
		JLabel lblRiveraKevinChristian = new JLabel("Rivera, Kevin Christian");
		lblRiveraKevinChristian.setFont(new Font("Calibri", Font.BOLD, 17));
		lblRiveraKevinChristian.setForeground(new Color(255, 255, 255));
		lblRiveraKevinChristian.setHorizontalAlignment(SwingConstants.CENTER);
		lblRiveraKevinChristian.setBounds(new Rectangle(0, 0, 80, 34));
		lblRiveraKevinChristian.setBounds(150, 378, 260, 14);
		contentPane.add(lblRiveraKevinChristian);
		
		JLabel lblSalardaBrian = new JLabel("Salarda, John Brian");
		lblSalardaBrian.setFont(new Font("Calibri", Font.BOLD, 17));
		lblSalardaBrian.setForeground(new Color(255, 255, 255));
		lblSalardaBrian.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalardaBrian.setBounds(new Rectangle(0, 0, 80, 34));
		lblSalardaBrian.setBounds(150, 420, 260, 14);
		contentPane.add(lblSalardaBrian);
		
		JLabel lblVillafrancaAudrey = new JLabel("Villafranca, Audrey");
		lblVillafrancaAudrey.setFont(new Font("Calibri", Font.BOLD, 17));
		lblVillafrancaAudrey.setForeground(new Color(255, 255, 255));
		lblVillafrancaAudrey.setHorizontalAlignment(SwingConstants.CENTER);
		lblVillafrancaAudrey.setBounds(new Rectangle(0, 0, 80, 34));
		lblVillafrancaAudrey.setBounds(150, 464, 260, 14);
		contentPane.add(lblVillafrancaAudrey);
		
		JLabel lblSebastianAxelJohn = new JLabel("Sebastian, Axel John Jac");
		lblSebastianAxelJohn.setFont(new Font("Calibri", Font.BOLD, 17));
		lblSebastianAxelJohn.setForeground(new Color(255, 255, 255));
		lblSebastianAxelJohn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSebastianAxelJohn.setBounds(new Rectangle(0, 0, 80, 34));
		lblSebastianAxelJohn.setBounds(495, 289, 243, 14);
		contentPane.add(lblSebastianAxelJohn);
		
		JLabel lblMatipoKarl = new JLabel(" Matipo, Karl Justine");
		lblMatipoKarl.setFont(new Font("Calibri", Font.BOLD, 17));
		lblMatipoKarl.setForeground(new Color(255, 255, 255));
		lblMatipoKarl.setHorizontalAlignment(SwingConstants.CENTER);
		lblMatipoKarl.setBounds(new Rectangle(0, 0, 80, 34));
		lblMatipoKarl.setBounds(495, 336, 243, 14);
		contentPane.add(lblMatipoKarl);
		
		JLabel lblSalemMarkJoseph = new JLabel("Salem, Mark Joseph");
		lblSalemMarkJoseph.setFont(new Font("Calibri", Font.BOLD, 17));
		lblSalemMarkJoseph.setForeground(new Color(255, 255, 255));
		lblSalemMarkJoseph.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalemMarkJoseph.setBounds(new Rectangle(0, 0, 80, 34));
		lblSalemMarkJoseph.setBounds(495, 378, 243, 14);
		contentPane.add(lblSalemMarkJoseph);
		
		JLabel lblSalaoAmiel = new JLabel("Salao, Amiel");
		lblSalaoAmiel.setFont(new Font("Calibri", Font.BOLD, 17));
		lblSalaoAmiel.setForeground(new Color(255, 255, 255));
		lblSalaoAmiel.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalaoAmiel.setBounds(new Rectangle(0, 0, 80, 34));
		lblSalaoAmiel.setBounds(495, 420, 243, 14);
		contentPane.add(lblSalaoAmiel);
		
		JLabel lblMembers = new JLabel("MEMBERS:");
		lblMembers.setForeground(new Color(255, 255, 255));
		lblMembers.setFont(new Font("Calibri", Font.BOLD, 26));
		lblMembers.setHorizontalAlignment(SwingConstants.CENTER);
		lblMembers.setBounds(362, 215, 179, 39);
		contentPane.add(lblMembers);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainFrame.class.getResource("/source/Coruscant city at night wallpaper.jpg")));
		lblNewLabel_1.setBounds(0, 0, 884, 661);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("MEMBERS:");
		label.setBounds(428, 265, 46, 14);
		contentPane.add(label);
	
	}
	
}
