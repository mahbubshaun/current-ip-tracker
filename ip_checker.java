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
public class ip_checker {

	JFrame frame;
	static Timer t;
	static String ss;
	static String dburl;
	static String user;
    static String pass;
    static Connection myConn;
    static Connection myConn2;
    static Statement myStmt;
    static Statement myStmt2;
    static ResultSet myRs;
    static ResultSet myRs2;
    static SwingWorker<Void,Void> email;
    private static JTextField textField;
    private static JTextField textField_1;
    private static JTextField textField_2;
    private static String glo;
    private static int prevent;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 
					
				        
					ip_checker window = new ip_checker(null);
					window.frame.setVisible(true);
					
					 ip();
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param userr1 
	 */
	//getting username from ip_tracker_login
	public ip_checker(String userr1) {
		initialize();
		//initializing a global variable called glo to the username..notice that we declared a global variable called glo with static referense  " private static String glo"
		 glo=userr1; 
         prevent=0;
	}



	/**
	 * Initialize the contents of the frame.
	 */
	public static void ip(){
		 email = new SwingWorker<Void,Void>()
				{
			
                    
					@Override
					protected Void doInBackground() throws Exception {
						
						while ( !isCancelled() ) {
					int j=0;
						try{
							//loop for contiue checking ip in every 5 seconds
						 for(int i=1;i<10;i++)
						 {
							 //checking db connection
								try{
									Connection myConn =null;
								//	Connection myConn2 =null;
							        Statement myStmt=null;
							        ResultSet myRs=null;
							    //    Statement myStmt2=null;
							     //   ResultSet myRs2=null;
							        String dburl="jdbc:mysql://127.0.0.1:3306/shopogqd_china_storebd";
							        String user="shopogqd";
							        String pass="VPrqteBv08NR";
								 myConn = (Connection) DriverManager.getConnection(dburl, user, pass);
						           myStmt=(Statement) myConn.createStatement();
						         //  myConn2 = (Connection) DriverManager.getConnection(dburl, user, pass);
						          // myStmt2=(Statement) myConn2.createStatement();
						      
						           String sql2 ="Select name from ip_tracking Where name='"+glo+"'";
						           myRs= myStmt.executeQuery(sql2);
						           if ((myRs.next())) {
						         String name = myRs.getString("name");
						         textField_2.setText(name);
						         textField_2.getGraphics(); 
						           }
						          
									}
									catch(Exception na)
									{   
										 textField_1.setText("FAILING");
										    textField_1.getGraphics(); 
										    textField_1.setForeground(Color.red);
										    //checking if already putty is running or not.If not then open putty
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
									}
							//checking current ip by ipify.orf api
						try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
						
							//initialize a variable with the api response 
						String ssa = s.next();
						
						System.out.println(ssa  +j++);
						
						try
						{
							Connection myConn =null;
							
						        Statement myStmt=null;
						        ResultSet myRs=null;
						  
						        String dburl="jdbc:mysql://127.0.0.1:3306/shopogqd_china_storebd";
						        String user="shopogqd";
						        String pass="VPrqteBv08NR";
							 myConn = (Connection) DriverManager.getConnection(dburl, user, pass);
					           myStmt=(Statement) myConn.createStatement();
				           
							
							//checking if user exist in ip tracking database
				           String sql3 ="Select name from ip_tracking Where name='"+glo+"'";
				           myRs= myStmt.executeQuery(sql3);
				           if((myRs.next()))
				        	   
				           {
				        	  // String ip = myRs.getString("ip");
				        	   
				        	   try{
				        		   
				        		   Connection myConn2 =null;
									
							        Statement myStmt2=null;
							        ResultSet myRs2=null;
							  
							        String dburl2="jdbc:mysql://127.0.0.1:3306/shopogqd_china_storebd";
							        String user2="shopogqd";
							        String pass2="VPrqteBv08NR";
								 myConn2 = (Connection) DriverManager.getConnection(dburl2, user2, pass2);
						           myStmt2=(Statement) myConn2.createStatement();
					           
						          
								/*checking if current ip is being used by any other user but the current user.if any other user found with current ip 
								 then terminate all chrome instanse and let user know to contact admin 
								  */
								 
					           String sql4 ="Select name from ip_tracking Where ip='"+ssa+"'";
					           
					           myRs2= myStmt2.executeQuery(sql4);
					           
					           
                           while((myRs2.next()))
					        	   
					           {
                           	 String check = myRs2.getString("name");
					        	   if((!check.equals(""+glo+"")))
					        	   {
					        		   System.out.println("duplicate ip found");
					        		   Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"taskkill /F /IM chrome.exe /T");
					        		   JOptionPane.showMessageDialog(null,"contact admin...your current ip is already in use by another user! close ur browser");
					        	   }
					        	 
					           }
                           
                           /*checking if current ip already exist in database or not.
                           if not then insert the current ip under the logged user
                           */
                           String sql55 ="Select name from ip_tracking Where ip='"+ssa+"'";
					           
					           myRs2= myStmt2.executeQuery(sql55);
					           if((myRs2.next()))
					        	   
					           {
					        	  
					        	   
					           }
					           else
					           {
					        	   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
					        	   LocalDateTime now = LocalDateTime.now(); 
					        	   String da=dtf.format(now);
					        	   System.out.println(da);  
					        	   
					        	   String sql7 = "INSERT INTO ip_tracking (name,ip,date) VALUES('"+glo+"','"+ssa+"','"+da+"')";
					        	   int upaa = myStmt2.executeUpdate(sql7);
					        	   if (upaa>0) {
					                   System.out.println("successfully inserted ip");
					                   
					        	   }
					           }
				        		   
				        	   }catch(Exception fh)
				        	   {
				        		   fh.printStackTrace();
				        	   }
				        	   textField_1.setText("CONNECTED");
							    textField_1.getGraphics();
							    textField_1.setForeground(Color.GREEN);
				        	  // System.out.println("ip found");
				           }
						}catch(Exception an)
						{
							an.printStackTrace();
						}
							//   System.out.println("My current IP address is " + s.next());
						   
						   try{
							
							   textField.setText(ssa);
							   textField.getGraphics(); 
							   textField.setForeground(Color.GREEN);
						   }catch(Exception bas)
						   {
							   bas.printStackTrace();
						   }
						    System.out.println("working");
						  Thread.sleep(5000);
						  
						  //making the loop infinite
							i=1;
							
						} catch (java.io.IOException m) {
						    m.printStackTrace();
						    //if any problem occurs in the code then go back and contiue from loop
						    i=1;
						 //   ip();
						    
						    
						}
							
							
						
					
						 }
						}catch (Exception ab)
						{
						
						}
						
					}
							return null;
					}
			
				};
				email.execute();
				
	}
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCurrentIp = new JLabel("current ip");
		lblCurrentIp.setFont(new Font("Stencil Std", Font.PLAIN, 13));
		lblCurrentIp.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrentIp.setBounds(119, 124, 95, 14);
		frame.getContentPane().add(lblCurrentIp);
		
		JLabel lblStatus = new JLabel("DB Status   :");
		lblStatus.setForeground(new Color(0, 0, 0));
		lblStatus.setFont(new Font("Stencil Std", Font.PLAIN, 17));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(56, 222, 125, 14);
		frame.getContentPane().add(lblStatus);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Stencil Std", Font.BOLD, 15));
		textField.setBounds(224, 122, 148, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Stencil Std", Font.PLAIN, 15));
		textField_1.setEditable(false);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(191, 221, 181, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Stencil Std", Font.PLAIN, 12));
		lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsername.setBounds(28, 27, 75, 14);
		frame.getContentPane().add(lblUsername);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setEditable(false);
		textField_2.setFont(new Font("Straczynski", Font.PLAIN, 11));
		textField_2.setBounds(109, 25, 105, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnPause = new JButton("PAUSE");
		btnPause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				prevent=2;
				email.cancel(true);
				 JOptionPane.showMessageDialog(null,"IP TRACKING IS PAUSED NOW. RESUME IT WHEN YOU START WORKING AGAIN");
				 
				 textField.setText("PAUSED");
				 textField.getGraphics(); 
				   textField.setForeground(Color.GREEN);
			}
		});
		btnPause.setForeground(Color.RED);
		btnPause.setBackground(Color.WHITE);
		btnPause.setBounds(283, 167, 89, 23);
		frame.getContentPane().add(btnPause);
		
		JButton btnResume = new JButton("RESUME");
		btnResume.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//prevent multiple instance of swingworker being called
				if ((prevent == 0))
				{
				
				JOptionPane.showMessageDialog(null,"YOU HAVE TO PAUSE IT BEFORE YOU CAN RESUME");
				
				}
				if ((prevent == 2))
				{
				ip();
				JOptionPane.showMessageDialog(null,"IP TRACKING IS RESUMED NOW.");
				prevent=0;
				}
				
			}
		});
		btnResume.setBackground(Color.WHITE);
		btnResume.setForeground(Color.GREEN);
		btnResume.setBounds(119, 167, 89, 23);
		frame.getContentPane().add(btnResume);
	}
	
}
