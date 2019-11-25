import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.SwingWorker;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
public class ip_tracker_login {

	 private JFrame frame;
 static	private JTextField textField;
static	private JTextField textField_1;
	static String dburl;
	static String user;
    static String pass;
    static Connection myConn;
    static Connection myConn2;
    static Statement myStmt;
    static Statement myStmt2;
    static ResultSet myRs;
    static ResultSet myRs2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ip_tracker_login window = new ip_tracker_login();
					window.frame.setVisible(true);
					  //checking if database has connection or putty is running or not if not then open putty .kitty is a fork for putty.kitty can access ssh with automatic password
					try{
						Connection myConn =null;
						
				        Statement myStmt=null;
				        ResultSet myRs=null;
				  
				        String dburl="jdbc:mysql://127.0.0.1:3306/shopogqd_china_storebd";
				        String user="shopogqd";
				        String pass="VPrqteBv08NR";
					 myConn = (Connection) DriverManager.getConnection(dburl, user, pass);
			           myStmt=(Statement) myConn.createStatement();
			           String sql ="Select * from reg";
			           myRs= myStmt.executeQuery(sql);
			           
			           if((myRs.next()))
			           {
			        	   
			           }
					}catch(Exception b)
					{
					 Runtime.getRuntime().exec("cmd /c cd c:// & start kitty.lnk");
					}
					/* putty connecting checking ends here  if no connection is detected it will auto connect*/
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ip_tracker_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Stencil Std", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(111, 80, 114, 30);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(235, 87, 148, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Stencil Std", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(111, 127, 114, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 129, 147, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 //checking if user exist in database
				try{
				Connection myConn =null;
				
		        Statement myStmt=null;
		        ResultSet myRs=null;
		  
		        String dburl="jdbc:mysql://127.0.0.1:3306/shopogqd_china_storebd";
		        String user="shopogqd";
		        String pass="VPrqteBv08NR";
			 myConn = (Connection) DriverManager.getConnection(dburl, user, pass);
	           myStmt=(Statement) myConn.createStatement();
           
			
			
         /*  String sql3 ="Select name from ip_tracking Where name='admin'";
           myRs= myStmt.executeQuery(sql3);
          */ 
           
           String userr1=textField.getText();
           String pass1=textField_1.getText();
           
           
           String sql ="Select * from reg Where username='"+ userr1 + "' and pass='"+pass1+ "'";
           myRs= myStmt.executeQuery(sql);
           
           if((myRs.next()))
           {
        	   System.out.println("successfully logged in");  
        	     
        	      frame.dispose();
        	                          //creating an instanse of class ip_checker and passing username to the constructor
        	                            ip_checker fra = new ip_checker(userr1);
        	                            fra.frame.setVisible(true);
        	                            //calling method ip() of class ip_checker
        	                            fra.ip();
           }
           else{
        	   
           }
				}
				catch(Exception ba)
				{
					StringWriter errors2a = new StringWriter();
					ba.printStackTrace(new PrintWriter(errors2a));
                  String  dyna = errors2a.toString();
                  JOptionPane.showMessageDialog(null,""+dyna+"");
				}
				
			}
		});
		btnLogin.setBounds(201, 189, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		JLabel lblEnterYourShopinglounge = new JLabel("ENTER YOUR SHOPING-LOUNGE LOGIN INFO");
		lblEnterYourShopinglounge.setFont(new Font("Stencil Std", Font.PLAIN, 15));
		lblEnterYourShopinglounge.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterYourShopinglounge.setBounds(38, 36, 368, 33);
		frame.getContentPane().add(lblEnterYourShopinglounge);
	}
}
