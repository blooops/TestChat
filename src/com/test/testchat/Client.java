package com.test.testchat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String username;
	private String ip;
	private int port;
	private JTextField txtMessage;
	private JTextArea txtrHistory;
	private JButton btnSend;

	/**
	 * Create the frame.
	 */
	public Client(String username, String ip, int port) {
		setResizable(false);
		this.username = username;
		this.ip = ip;
		this.port = port;
		createClientWindow();
		logToChatHistory(this.username + " just logged in! Say Hi!");

	}

	private void createClientWindow() {
		setTitle("TestChat Client" + ":" + this.username + " @ " + this.ip + ":" + this.port);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 700);
		setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Attach GridBagLayout to Client Window
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 31, 735, 33, 1 };
		gbl_contentPane.rowHeights = new int[] { 55, 600, 40, 5 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		// txtrHistory JTextArea inside a JScrollPane called scrollTxtrHistory
		txtrHistory = new JTextArea();
		txtrHistory.setEditable(false);
		JScrollPane scrollTxtrHistory = new JScrollPane(txtrHistory);
		txtrHistory.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints scrollTxtrHistory_constraints = new GridBagConstraints();
		scrollTxtrHistory_constraints.insets = new Insets(0, 0, 5, 5);
		scrollTxtrHistory_constraints.fill = GridBagConstraints.BOTH;
		scrollTxtrHistory_constraints.gridx = 1;
		scrollTxtrHistory_constraints.gridy = 1;
		scrollTxtrHistory_constraints.gridwidth = 2; // to make it span multiple lines
		contentPane.add(scrollTxtrHistory, scrollTxtrHistory_constraints);

		// txtMessage JTextField
		txtMessage = new JTextField();
		txtMessage.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // keyboard enter even handler
					send(txtMessage.getText());
				}
			}
		});
		txtMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.insets = new Insets(0, 0, 5, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 1;
		gbc_txtMessage.gridy = 2;
		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);

		// Send JButton
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // mouse button event handler
				send(txtMessage.getText());
				txtMessage.requestFocus();
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.insets = new Insets(0, 0, 5, 5);
		gbc_btnSend.gridx = 2;
		gbc_btnSend.gridy = 2;
		contentPane.add(btnSend, gbc_btnSend);

		setVisible(true);
		txtMessage.requestFocus();

	}

	/**
	 * Log to the Chat History, a particularly message in message area
	 */
	public void logToChatHistory(String message) {
		txtrHistory.append(message + "\n\r");
		txtMessage.setText("");
	}

	/**
	 * Send the message in message area to server and also log it on own chatHistory
	 */
	public void send(String message) {
		if (!message.equals("")) {
			logToChatHistory(this.username + " : " + message);
		}
		txtrHistory.setCaretPosition(txtrHistory.getDocument().getLength());
		txtMessage.requestFocus();
	}

}
