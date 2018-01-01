package com.test.testchat;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private JPanel contentPane;
	private String username;
	private String ip;
	private int port;

	/**
	 * Create the frame.
	 */
	public Client(String username, String ip, int port) {
		this.username = username;
		this.ip = ip;
		this.port = port;
		createClientWindow();
		
	}

	private void createClientWindow() {
		setTitle("TestChat Client" + ":" + this.username + " @ " + this.ip + ":" + this.port);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
	}

}
