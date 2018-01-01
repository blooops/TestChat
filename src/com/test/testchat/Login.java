package com.test.testchat;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAddress;
	private JLabel lblNewLabel;
	private JTextField txtPort;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		
		// Setting Look and Feel to Native OS
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		// Login JFrame
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// txtName JtextField
		txtName = new JTextField();
		txtName.setBounds(71, 50, 193, 30);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		// Username Label
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(141, 20, 54, 28);
		contentPane.add(lblUsername);
		
		// txtAddress JTextField
		txtAddress = new JTextField();
		txtAddress.setBounds(71, 138, 193, 30);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		// IP Address labek
		lblNewLabel = new JLabel("IP Address");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(138, 115, 60, 13);
		contentPane.add(lblNewLabel);
		
		// txtPort JTextField
		txtPort = new JTextField();
		txtPort.setBounds(71, 230, 193, 30);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		// Port Label
		lblNewLabel_1 = new JLabel("Port");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(154, 209, 27, 13);
		contentPane.add(lblNewLabel_1);
		
		// Login JButton
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtName.getText();
				String ip = txtAddress.getText();
				int port = Integer.parseInt(txtPort.getText());
				login(username, ip, port);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.setBounds(125, 297, 85, 21);
		contentPane.add(btnLogin);
	}
	
	/**
	 *  Log the user into the chat server and open client
	 */
	private void login(String username, String ip, int port) {
		dispose();
		Client client = new Client(username, ip, port);
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
