package org.itstep.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;
import org.itstep.dao.AccountDAO;
import org.itstep.dao.GoodDAO;
import org.itstep.dao.GoodActionDAO;
import org.itstep.service.BotService;
import org.openqa.selenium.WebDriver;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;
import java.awt.SystemColor;

public class MainWindow extends JFrame{	
	
private WebDriver driver;
	
	private Account account;
	private Good good;
	private GoodAction goodAction;	
	
	private JLabel lblFirsName;
	private JTextField firstName;
	private JLabel lblLastName;
	private JTextField lastName;
	private JLabel lblEmail;
	private JTextField email;
	private JLabel lblPassword;
	private JTextField password;
	private JLabel lblAsin;
	private JTextField asin;
	private JButton btnAddToCart;
	private JTextField statusField;
	private JPanel panelAccount;
	private JPanel panelAsin;
	private JPanel panelStatus;

	public MainWindow(String title) {
		
		account = new Account("no_FirstName", "no_LastName", "no@mail.com", "no_password");
		AccountDAO.save(account);
		good = new Good("no_asin", "no_GoodName", "no_ShopURL");
		GoodDAO.save(good);
		goodAction = new GoodAction(System.currentTimeMillis(), "input initial info", false, account, good);		
		GoodActionDAO.save(goodAction);
		
		setTitle(title);
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);	

		// First Name:
		lblFirsName = new JLabel("First Name:");
		lblFirsName.setBounds(30, 35, 64, 20);
		getContentPane().add(lblFirsName);

		firstName = new JTextField();
		firstName.setToolTipText("Input first name");
		firstName.setBounds(105, 35, 250, 20);		
		getContentPane().add(firstName);
		firstName.setColumns(10);
		firstName.getDocument().addDocumentListener(new DocumentListener() {			
			public void removeUpdate(DocumentEvent e) {
				account.setFirstName(firstName.getText());				
			}			
			public void insertUpdate(DocumentEvent e) {
				account.setFirstName(firstName.getText());				
			}			
			public void changedUpdate(DocumentEvent e) {				
				account.setFirstName(firstName.getText());				
			}
		});
		
		// Last Name:
		lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(30, 73, 64, 20);
		getContentPane().add(lblLastName);
		
		lastName = new JTextField();
		lastName.setToolTipText("Input last name");
		lastName.setBounds(105, 73, 250, 20);
		getContentPane().add(lastName);
		lastName.setColumns(10);
		lastName.getDocument().addDocumentListener(new DocumentListener() {			
			public void removeUpdate(DocumentEvent e) {
				account.setLastName(lastName.getText());
			}			
			public void insertUpdate(DocumentEvent e) {
				account.setLastName(lastName.getText());				
			}			
			public void changedUpdate(DocumentEvent e) {				
				account.setLastName(lastName.getText());				
			}
		});
		
		// Email:
		lblEmail = new JLabel("Email:");
		lblEmail.setBounds(30, 110, 64, 20);
		getContentPane().add(lblEmail);
		
		email = new JTextField();
		email.setToolTipText("Input email");
		email.setBounds(105, 110, 250, 20);
		getContentPane().add(email);
		email.setColumns(10);
		email.getDocument().addDocumentListener(new DocumentListener() {			
			public void removeUpdate(DocumentEvent e) {
				account.setEmail(email.getText());				
			}			
			public void insertUpdate(DocumentEvent e) {
				account.setEmail(email.getText());				
			}			
			public void changedUpdate(DocumentEvent e) {				
				account.setEmail(email.getText());				
			}
		});
		
		// Password:
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(30, 145, 64, 20);
		getContentPane().add(lblPassword);
		
		password = new JTextField();
		password.setToolTipText("Input password");
		password.setBounds(105, 145, 250, 20);
		getContentPane().add(password);
		password.setColumns(10);
		password.getDocument().addDocumentListener(new DocumentListener() {			
			public void removeUpdate(DocumentEvent e) {
				account.setPassword(password.getText());				
			}			
			public void insertUpdate(DocumentEvent e) {
				account.setPassword(password.getText());				
			}			
			public void changedUpdate(DocumentEvent e) {				
				account.setPassword(password.getText());
			}
		});		
		
		// ASIN:
		lblAsin = new JLabel("ASIN:");
		lblAsin.setBounds(30, 210, 64, 20);
		getContentPane().add(lblAsin);
		
		asin = new JTextField();		
		asin.setToolTipText("Input ASIN");
		asin.setBounds(105, 210, 250, 20);
		getContentPane().add(asin);
		asin.setColumns(10);
		asin.getDocument().addDocumentListener(new DocumentListener() {			
			public void removeUpdate(DocumentEvent e) {
				good.setAsin(asin.getText());				
			}			
			public void insertUpdate(DocumentEvent e) {
				good.setAsin(asin.getText());				
			}			
			public void changedUpdate(DocumentEvent e) {				
				good.setAsin(asin.getText());
			}
		});
		asin.setText("0545703301");

		// Run button
		btnAddToCart = new JButton("RUN BOT");
		btnAddToCart.setBounds(14, 258, 355, 30);
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				runBot(account, good);
			}
		});
		getContentPane().add(btnAddToCart);
		
		// Status field:
		statusField = new JTextField("Enter all info and press Run");
		statusField.setForeground(Color.DARK_GRAY);
		statusField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		statusField.setEditable(false);
		statusField.setBackground(SystemColor.menu);
		statusField.setBounds(22, 320, 340, 20);
		statusField.setHorizontalAlignment(SwingConstants.CENTER);
		statusField.setBorder(null);
		getContentPane().add(statusField);
		statusField.setColumns(10);
		
		// Panels:		
		panelAccount = new JPanel();		
		panelAccount.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Account", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY));
		panelAccount.setBounds(12, 10, 360, 170);
		getContentPane().add(panelAccount);
		
		panelAsin = new JPanel();		
		panelAsin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "ASIN", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY));
		panelAsin.setBounds(12, 188, 360, 58);
		getContentPane().add(panelAsin);
		
		panelStatus = new JPanel();		
		panelStatus.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Status", TitledBorder.CENTER, TitledBorder.TOP, null, Color.GRAY));
		panelStatus.setBounds(12, 300, 360, 50);
		getContentPane().add(panelStatus);

		getContentPane().repaint();
	}
	
	private void runBot(Account account, Good good) {		
		
		statusField.setText("Bot is running...");
		//getContentPane().revalidate();
		getContentPane().repaint();
		
		//JOptionPane.showMessageDialog(this, "test to renew text");
		
		driver = BotService.getChromeDriver();
		
		driver = BotService.registerAccount(driver, account);
		if(driver != null) {
			statusField.setText("Bot has successfully registered an account");
			getContentPane().repaint();
			
			//driver = BotService.addGoodToCart(driver, good);
			if(driver != null)
				statusField.setText("Bot has successfully added a good to the cart");
			else
				statusField.setText("Something has come wrong with adding to the cart");			
			driver.quit();
		} else {
			statusField.setText("Something has come wrong with registration");
		}
		
		firstName.setText("");
		lastName.setText("");
		email.setText("");
		password.setText("");
		asin.setText("");
		getContentPane().repaint();
	}
}