import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.script.Bindings;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JTextArea;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SEWindow {

	private JFrame frame;
	private JPanel panel;
	private JPanel card1;
	private JPanel card2;
	private JPanel card3;
	private JTextField textFieldUsername;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldStudentID;
	private JPanel panelOnCard2;
	private JPanel panelOnCard5;
	private JScrollPane scroll;
	private JScrollPane scrollAddMore;
	private JScrollPane scrollHaveScrollArea;
	private JScrollPane scrollNeedScrollArea;
	private JScrollPane scrollPlanScrollArea;
	private JScrollPane scrollPane;
	private JTextField textFieldCreateUsername;
	private JTextField textFieldCreatePassword;
	private JPasswordField passwordField;
	private Student newStudent;
	private JTextField textFieldCurrentYearLogin;
	private JButton loginBtn;
	private JCheckBox chckbxBscs;
	private JCheckBox chckbxBscsit;
	private JCheckBox chckbxBSCSIA;
	private JTextField textFieldCACurrentYear;
	private JLabel lblCurrentYear_1;
	private ArrayList<JCheckBox> chkBoxList;
	private ArrayList<JCheckBox> chkBoxListCard5;
	private JPanel card4;
	private ArrayList<JPanel> mapPanels;
	private JButton btnCreateAccount;
	private JButton btnGenerateTrackPlan;
	private JLabel lblEnterTheCourse;
	private JPanel card5;
	private JButton btnAddMoreCourses;
	private Student loggedInStudent;
	private Track t;
	private JMenuBar menuBar;
	private JMenu mnMenu;
	private JMenuItem mntmBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					SEWindow window = new SEWindow();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SEWindow()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() 
	{
		Student sdent = new Student();
		Track cs = new Track();
		Track it = new Track();
		Track csIA = new Track();
		ActionListener actionListener = new ActionListener()
		 {
		      public void actionPerformed(ActionEvent actionEvent) {

		          System.out.println(actionEvent.getActionCommand());
		      }
		    };
		JTextArea paneOfPlan = new JTextArea();
		paneOfPlan.setEditable(false);
		scrollPane = new JScrollPane(paneOfPlan);
		scrollPane.setBounds(20, 51, 299, 470);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JTextArea textAreaTakenCourses = new JTextArea();
		textAreaTakenCourses.setEditable(false);
		textAreaTakenCourses.setFont(new Font("Arial Black", Font.PLAIN, 15));
		scrollHaveScrollArea = new JScrollPane(textAreaTakenCourses);
		scrollHaveScrollArea.setBounds(20, 51, 299, 470);
		scrollHaveScrollArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JTextArea textAreaNeededCourses = new JTextArea();
		textAreaNeededCourses.setEditable(false);
		textAreaNeededCourses.setFont(new Font("Arial Black", Font.PLAIN, 15));
		scrollNeedScrollArea = new JScrollPane(textAreaNeededCourses);
		scrollNeedScrollArea.setBounds(354, 51, 363, 470);
		scrollNeedScrollArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		JTextArea textAreaPlan = new JTextArea();
		textAreaPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				UIManager.put("OptionPane.maximumSize",new Dimension(500,500));
				paneOfPlan.setText(textAreaPlan.getText());
				JOptionPane.showMessageDialog(null,scrollPane);
				
			}
		});
		textAreaPlan.setEditable(false);
		textAreaPlan.setFont(new Font("Arial Black", Font.PLAIN, 15));
		scrollPlanScrollArea = new JScrollPane(textAreaPlan);
		scrollPlanScrollArea.setBounds(754, 51, 321, 466);
		scrollPlanScrollArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1101, 648);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 1085, 609);
		panel.setLayout(new CardLayout());
		
		card1 = new JPanel();
		card1.setBackground(SystemColor.activeCaptionBorder);
		card1.setLayout(null);
		panel.add(card1,"Login Card");
		
		textFieldUsername = new JTextField();
		textFieldUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e)
			{
				if((!textFieldUsername.getText().equals(""))&&(!textFieldCurrentYearLogin.getText().equals(""))&&(!passwordField.getText().equals("")))
				{
					loginBtn.setEnabled(true);
				}
				else
					loginBtn.setEnabled(false);
			}
		});
		textFieldUsername.setBounds(525, 31, 103, 20);
		card1.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPathToGrad = new JLabel("PATH");
		lblPathToGrad.setForeground(new Color(0, 0, 0));
		lblPathToGrad.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblPathToGrad.setBounds(79, 42, 173, 105);
		card1.add(lblPathToGrad);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsername.setBounds(444, 31, 80, 17);
		card1.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(649, 31, 86, 17);
		card1.add(lblPassword);
		
		JLabel lblCreateAccount = new JLabel("Create Account: ");
		lblCreateAccount.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblCreateAccount.setBounds(607, 189, 178, 39);
		card1.add(lblCreateAccount);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(542, 250, 86, 17);
		card1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(542, 278, 98, 16);
		card1.add(lblLastName);
		
		JLabel lblStudentID = new JLabel("Student ID# : ");
		lblStudentID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentID.setBounds(542, 305, 98, 14);
		card1.add(lblStudentID);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if((!textFieldStudentID.getText().equals(""))&&(!textFieldLastName.getText().equals(""))&&(!textFieldFirstName.getText().equals("")))
				{
					btnCreateAccount.setEnabled(true);
				}
				else
					btnCreateAccount.setEnabled(false);
			}
		});
		textFieldFirstName.setBounds(638, 250, 86, 20);
		card1.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if((!textFieldStudentID.getText().equals(""))&&(!textFieldLastName.getText().equals(""))&&(!textFieldFirstName.getText().equals("")))
				{
					btnCreateAccount.setEnabled(true);
				}
				else
					btnCreateAccount.setEnabled(false);
			}
		});
		textFieldLastName.setBounds(638, 277, 86, 20);
		card1.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldStudentID = new JTextField();
		textFieldStudentID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)||(c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE)))
				{
		   			e.consume();
				}
			}
			@Override
			public void keyPressed(KeyEvent e)
			{
				if((!textFieldStudentID.getText().equals(""))&&(!textFieldLastName.getText().equals(""))&&(!textFieldFirstName.getText().equals("")))
				{
					btnCreateAccount.setEnabled(true);
				}
				else
					btnCreateAccount.setEnabled(false);
			}
		});
		textFieldStudentID.setBounds(638, 302, 86, 20);
		card1.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);
		
		JLabel lblTrack = new JLabel("Select Track:");
		lblTrack.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblTrack.setBounds(588, 330, 103, 14);
		card1.add(lblTrack);
		
		chckbxBscs = new JCheckBox("BS.CS");
		chckbxBscs.setSelected(true);
		chckbxBscs.setBounds(588, 351, 65, 23);
		card1.add(chckbxBscs);
		
		chckbxBscsit = new JCheckBox("BS.ITE");
		chckbxBscsit.setBounds(655, 351, 80, 23);
		card1.add(chckbxBscsit);
		
		chckbxBSCSIA = new JCheckBox("BS.CS.IA");
		chckbxBSCSIA.setBounds(737, 351, 76, 23);
		card1.add(chckbxBSCSIA);
		
		card2 = new JPanel();
		card2.setBackground(Color.LIGHT_GRAY);
		
		panel.add(card2,"Create Account Card");
		card2.setLayout(null);
		
		panelOnCard5 = new JPanel();
		panelOnCard5.setBackground(Color.WHITE);
		panelOnCard5.setBounds(0, 138, 739, 317);
		panelOnCard5.setLayout(new BoxLayout(panelOnCard5, BoxLayout.Y_AXIS));
		scrollAddMore = new JScrollPane(panelOnCard5);
		scrollAddMore.setBounds(168, 95, 739, 457);
		scrollAddMore.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		
		panelOnCard2 = new JPanel();
		panelOnCard2.setBackground(Color.WHITE);
		panelOnCard2.setBounds(0, 138, 739, 317);
		panelOnCard2.setLayout(new BoxLayout(panelOnCard2, BoxLayout.Y_AXIS));
		
		scroll = new JScrollPane(panelOnCard2);
		scroll.setBounds(168, 95, 739, 457);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		card2.add(scroll);
		
		JLabel lblEnterNewLogin = new JLabel("Enter New LOGIN information");
		lblEnterNewLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblEnterNewLogin.setBounds(413, 2, 344, 14);
		card2.add(lblEnterNewLogin);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(271, 27, 71, 14);
		card2.add(lblUsername_1);
		
		textFieldCreateUsername = new JTextField();
		textFieldCreateUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if((!textFieldCreateUsername.getText().equals(""))&&(!textFieldCreatePassword.getText().equals(""))&&(!textFieldCACurrentYear.getText().equals("")))
				{
					btnGenerateTrackPlan.setEnabled(true);
				}
				else
					btnGenerateTrackPlan.setEnabled(false);
			}
		});
		textFieldCreateUsername.setBounds(352, 24, 86, 20);
		card2.add(textFieldCreateUsername);
		textFieldCreateUsername.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password: ");
		lblPassword_1.setBounds(472, 27, 86, 14);
		card2.add(lblPassword_1);
		
		textFieldCreatePassword = new JTextField();
		textFieldCreatePassword.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if((!textFieldCreateUsername.getText().equals(""))&&(!textFieldCreatePassword.getText().equals(""))&&(!textFieldCACurrentYear.getText().equals("")))
				{
					btnGenerateTrackPlan.setEnabled(true);
				}
				else
					btnGenerateTrackPlan.setEnabled(false);
			}
		});
		
		textFieldCreatePassword.setBounds(534, 24, 86, 20);
		card2.add(textFieldCreatePassword);
		textFieldCreatePassword.setColumns(10);
		
		card3 = new JPanel();
		card3.setBackground(Color.LIGHT_GRAY);
		card3.setLayout(null);
		panel.add(card3,"Path Card");
		
		frame.getContentPane().add(panel);
		CardLayout cardLayout = (CardLayout)panel.getLayout();
		ButtonGroup bg = new ButtonGroup();
		bg.add(chckbxBscs);
		bg.add(chckbxBscsit);
		bg.add(chckbxBSCSIA);
		
		loginBtn = new JButton("Login");
		loginBtn.setEnabled(false);
		loginBtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent a) 
			{	
				try {
					
					loggedInStudent = new Student();
					t = new Track();
					
					int year = Integer.parseInt(textFieldCurrentYearLogin.getText());
					ArrayList<Course> neededList = new ArrayList<Course>();
					boolean goodToGo = false;
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pathtograd","root","1234");
					Statement myStmt = conn.createStatement();
					ResultSet myAccount = myStmt.executeQuery("select * from createaccount");
					while (myAccount.next())
					{
						if((myAccount.getString("Username").equals(textFieldUsername.getText()))&&myAccount.getString("Password").equals(passwordField.getText()))
						{
							goodToGo = true;	
							if(myAccount.getString("MajorTrack").equals("BS.CS"))
							{
								t.setTrackName(myAccount.getString("MajorTrack"));
								loggedInStudent.setStudentID(Integer.parseInt(myAccount.getString("StudentNum")));
								loggedInStudent.setNameFirst(myAccount.getString("FirstName"));
								loggedInStudent.setNameLast(myAccount.getString("LastName"));
								loggedInStudent.setTrackName(myAccount.getString("MajorTrack"));
								loggedInStudent.setPassword(myAccount.getString("Password"));
								loggedInStudent.setUserName(myAccount.getString("Username"));
								
								Statement bsCsStatement = conn.createStatement();
								ResultSet mycs = bsCsStatement.executeQuery("select * from bscs");
								t.generateTrack(mycs);
								mycs.close();
								bsCsStatement.close();
								Statement cCStmt = conn.createStatement();
								ResultSet myStuCC = cCStmt.executeQuery("select * from completedcourses");
								while(myStuCC.next())
								{
									if(myStuCC.getString("studentnumber").equals(Integer.toString(loggedInStudent.getStudentID())))
									{
										
										Course c = new Course();
										c.setCourseName(myStuCC.getString("CourseNum&Name"));
										c.setCreditHours(Integer.parseInt(myStuCC.getString("CourseCreditHour")));
										loggedInStudent.getCompletedCourses().add(c);
									}
								}
							}
							else if (myAccount.getString("MajorTrack").equals("BS.CS.IA"))
							{
								t.setTrackName(myAccount.getString("MajorTrack"));
								loggedInStudent.setStudentID(Integer.parseInt(myAccount.getString("StudentNum")));
								loggedInStudent.setNameFirst(myAccount.getString("FirstName"));
								loggedInStudent.setNameLast(myAccount.getString("LastName"));
								loggedInStudent.setTrackName(myAccount.getString("MajorTrack"));
								loggedInStudent.setPassword(myAccount.getString("Password"));
								loggedInStudent.setUserName(myAccount.getString("Username"));
								
								Statement bsIAStatement = conn.createStatement();
								ResultSet myIA = bsIAStatement.executeQuery("select * from bscsiat");
								cs.generateTrack(myIA);
								myIA.close();
								bsIAStatement.close();
								
								Statement iAStmt = conn.createStatement();
								ResultSet myIACC = iAStmt.executeQuery("select * from completedcourses");
								while(myIACC.next())
								{
									if(myIACC.getString("studentnumber").equals(Integer.toString(loggedInStudent.getStudentID())))
									{
										Course c = new Course();
										c.setCourseName(myIACC.getString("CourseNum&Name"));
										c.setCreditHours(Integer.parseInt(myIACC.getString("CourseCreditHour")));
										loggedInStudent.getCompletedCourses().add(c);
									}
								}
							}
							else if(myAccount.getString("MajorTrack").equals("BS.ITE"))
							{
								t.setTrackName(myAccount.getString("MajorTrack"));
								loggedInStudent.setStudentID(Integer.parseInt(myAccount.getString("StudentNum")));
								loggedInStudent.setNameFirst(myAccount.getString("FirstName"));
								loggedInStudent.setNameLast(myAccount.getString("LastName"));
								loggedInStudent.setTrackName(myAccount.getString("MajorTrack"));
								loggedInStudent.setPassword(myAccount.getString("Password"));
								loggedInStudent.setUserName(myAccount.getString("Username"));
								
								Statement bsITEStatement = conn.createStatement();
								ResultSet myIT = bsITEStatement.executeQuery("select * from bscsite");
								cs.generateTrack(myIT);
								myIT.close();
								bsITEStatement.close();
								
								Statement cITEStmt = conn.createStatement();
								ResultSet myITECC = cITEStmt.executeQuery("select * from completedcourses");
								while(myITECC.next())
								{
									if(myITECC.getString("studentnumber").equals(Integer.toString(loggedInStudent.getStudentID())))
									{
										Course c = new Course();
										c.setCourseName(myITECC.getString("CourseNum&Name"));
										c.setCreditHours(Integer.parseInt(myITECC.getString("CourseCreditHour")));
										loggedInStudent.getCompletedCourses().add(c);
									}
								}
							}
							textAreaTakenCourses.setText(loggedInStudent.outputCompletedCourses());
							neededList = generateNeededCourses(loggedInStudent.getCompletedCourses(),t);
							textAreaNeededCourses.setText(needListToString(neededList));
							textAreaPlan.setText(needToPlan(neededList,loggedInStudent.getCompletedCourses(),year));
							
						}
						
					}
					if(goodToGo)
					{
						cardLayout.show(panel,"Path Card");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "ACCESS DENIED!");
					}
						
				}
				catch (Exception e)
				{
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		loginBtn.setBounds(860, 30, 89, 23);
		card1.add(loginBtn);
		
		btnGenerateTrackPlan = new JButton("Generate Track Plan");
		btnGenerateTrackPlan.setEnabled(false);
		btnGenerateTrackPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try 
				{
					Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pathtograd","root","1234");
					newStudent.setUserName(textFieldCreateUsername.getText());
					newStudent.setPassword(textFieldCreatePassword.getText());
					int year = Integer.parseInt(textFieldCACurrentYear.getText());
					
					ArrayList<Course> needList = new ArrayList<Course>();
					newStudent.getCompletedCourses().clear();
					Course mth105 = new Course();
					mth105.setCourseName("MTH 105");
					mth105.setCreditHours(0);
					newStudent.getCompletedCourses().add(mth105);
					 
					for(int i = 0;i<t.getTrackCourses().size();i++)
					{
						for(int j = 0;j<chkBoxList.size();j++)
						{
							if(chkBoxList.get(j).getText().equals(t.getTrackCourses().get(i).getName()))
							{
								if(chkBoxList.get(j).isSelected())
								{
									newStudent.getCompletedCourses().add(t.getTrackCourses().get(i));
								}
							}
						}
					}
					ArrayList<Course> completedCourses = newStudent.getCompletedCourses();
					textAreaTakenCourses.setText(newStudent.outputCompletedCourses());
					needList = generateNeededCourses(newStudent.getCompletedCourses(),t);
					textAreaNeededCourses.setText(needListToString(needList));
					textAreaPlan.setText(needToPlan(needList,completedCourses, year));
					 
					
					String query = "INSERT INTO createaccount(StudentNum, FirstName, LastName, MajorTrack, Username, Password)"
					        + "VALUES (?, ?, ?, ?, ?, ?)";
				    PreparedStatement preparedStmt = conn2.prepareStatement(query);
					preparedStmt.setInt(1, newStudent.getStudentID());
			        preparedStmt.setString(2, newStudent.getNameFirst());
		     	    preparedStmt.setString(3, newStudent.getNameLast());
					preparedStmt.setString(4, newStudent.getTrackName());
					preparedStmt.setString(5, newStudent.getUserName());
					preparedStmt.setString(6, newStudent.getPassword());
					preparedStmt.execute();
					preparedStmt.close();
					
					PreparedStatement pst = conn2.prepareStatement("INSERT INTO completedcourses (`studentnumber`, `CourseNum&Name`, `CourseCreditHour`)"
							+ "VALUES (?, ?, ?)");
					conn2.setAutoCommit(false);
					for(int i = 0; i < newStudent.getCompletedCourses().size();i++)
					{
						
						pst.setInt(1, newStudent.getStudentID());
						pst.setString(2, newStudent.getCompletedCourses().get(i).getName());
						pst.setInt(3, newStudent.getCompletedCourses().get(i).getCreditHours());
						pst.addBatch();
						
					}
						try
						{
							int count[] = pst.executeBatch();	
						}
						catch(SQLException e1)
						{
							JOptionPane.showMessageDialog(null, e1.getMessage());
						}
							
					
					conn2.commit();
					
					pst.close();
					conn2.close();
					
					JOptionPane.showMessageDialog(null, "Saved");
					loggedInStudent = newStudent;
					cardLayout.show(panel,"Path Card");
				}
				catch (SQLException e1) 
				{
					JOptionPane.showMessageDialog(null, "Database connection error.");
				}
			}
		});
		btnGenerateTrackPlan.setBounds(426, 563, 289, 23);
		card2.add(btnGenerateTrackPlan);
		
		textFieldCACurrentYear = new JTextField();
		textFieldCACurrentYear.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)||(c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE)))
					{
		   				e.consume();
					}
			}
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if((!textFieldCreateUsername.getText().equals(""))&&(!textFieldCreatePassword.getText().equals(""))&&(!textFieldCACurrentYear.getText().equals("")))
				{
					btnGenerateTrackPlan.setEnabled(true);
				}
				else
					btnGenerateTrackPlan.setEnabled(false);
			}
		});
		textFieldCACurrentYear.setBounds(754, 24, 86, 20);
		card2.add(textFieldCACurrentYear);
		textFieldCACurrentYear.setColumns(10);
		
		lblCurrentYear_1 = new JLabel("Current year: (YYYY)");
		lblCurrentYear_1.setBounds(636, 27, 121, 14);
		card2.add(lblCurrentYear_1);
		
		lblEnterTheCourse = new JLabel("Enter the course you have completed");
		lblEnterTheCourse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblEnterTheCourse.setBounds(362, 55, 363, 29);
		card2.add(lblEnterTheCourse);
		
		btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.setEnabled(false);
		btnCreateAccount.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try 
				{
					Track temp = new Track();
					String s = "";
					Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pathtograd","root","1234");
					newStudent = new Student();
					newStudent.setNameFirst(textFieldFirstName.getText());
					newStudent.setNameLast(textFieldLastName.getText());
					newStudent.setStudentID(Integer.parseInt(textFieldStudentID.getText()));
					if(chckbxBscs.isSelected())
					{
						
						s = "BS.CS";
						newStudent.setTrackName(s);
						Statement myBSCSStatement = conn1.createStatement();
						ResultSet mybscs = myBSCSStatement.executeQuery("select * from bscs");
						temp.generateTrack(mybscs);
						mybscs.close();
						myBSCSStatement.close();
					}
					else if(chckbxBscsit.isSelected())
					{
						System.out.println("Inside bscsit");
						s = "BS.ITE";
						newStudent.setTrackName(s);
						System.out.println("Inside bscsit");
						Statement myITEStatement = conn1.createStatement();
						System.out.println("Inside bscsit");
						ResultSet myite = myITEStatement.executeQuery("select * from bscsite");
						System.out.println("Inside bscsit");
						temp.generateTrack(myite);
						System.out.println("Inside bscsit");
						myite.close();
						myITEStatement.close();
					}
					else if(chckbxBSCSIA.isSelected())
					{
						s = "BS.CS.IA";
						newStudent.setTrackName(s);
						Statement myIAStatement = conn1.createStatement();
						ResultSet myia = myIAStatement.executeQuery("select * from bscsiat");
						temp.generateTrack(myia);
						myia.close();
						myIAStatement.close();
					}
					temp.setTrackName(s);
					chkBoxList = new ArrayList<JCheckBox>();
					chkBoxList = generateCheckBoxs(temp.getTrackCourses());
					t = temp;
					conn1.close();
					cardLayout.show(panel,"Create Account Card");
				} catch (SQLException e) 
				{
					
					JOptionPane.showMessageDialog(null, "Connection Error.");
				}
			}
		});
		btnCreateAccount.setBounds(618, 381, 154, 23);
		card1.add(btnCreateAccount);
		
		card3.add(scrollHaveScrollArea);
		card3.add(scrollNeedScrollArea);
		card3.add(scrollPlanScrollArea);
		
		JLabel lblCompletedCourses = new JLabel("Completed Courses:");
		lblCompletedCourses.setBounds(20, 26, 118, 14);
		card3.add(lblCompletedCourses);
		
		JLabel lblNeededCourses = new JLabel("Needed Courses:");
		lblNeededCourses.setBounds(354, 26, 111, 14);
		card3.add(lblNeededCourses);
		
		JLabel lblPlanToGraduate = new JLabel("Plan to Graduate:");
		lblPlanToGraduate.setBounds(749, 26, 118, 14);
		card3.add(lblPlanToGraduate);
		
		JButton btnMap = new JButton("MAP");
		btnMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				menuBar.setVisible(true);
				cardLayout.show(panel,"Map Card");
			}
		});
		btnMap.setBounds(764, 528, 311, 23);
		card3.add(btnMap);
		
		btnAddMoreCourses = new JButton("Add More Courses to Completed");
		btnAddMoreCourses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println(loggedInStudent.getCompletedCourses().size());
				ArrayList<Course> neededList = new ArrayList<Course>();
				neededList = generateNeededCourses(loggedInStudent.getCompletedCourses(),t);
				generateCheckBoxsCard5(neededList);
				
				cardLayout.show(panel,"Add More Courses");
			}
		});
		btnAddMoreCourses.setBounds(46, 532, 254, 23);
		card3.add(btnAddMoreCourses);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{
				if((!textFieldUsername.getText().equals(""))&&(!textFieldCurrentYearLogin.getText().equals(""))&&(!passwordField.getText().equals("")))
				{
					loginBtn.setEnabled(true);
				}
				else
					loginBtn.setEnabled(false);
			}
		});
		passwordField.setBounds(738, 31, 90, 20);
		card1.add(passwordField);
		
		textFieldCurrentYearLogin = new JTextField();
		textFieldCurrentYearLogin.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if(!(Character.isDigit(c)||(c == KeyEvent.VK_BACK_SPACE) ||(c == KeyEvent.VK_DELETE)))
					{
		   				e.consume();
					}
			}
			@Override
			public void keyPressed(KeyEvent e)
			{
				if((!textFieldUsername.getText().equals(""))&&(!textFieldCurrentYearLogin.getText().equals(""))&&(!passwordField.getText().equals("")))
				{
					loginBtn.setEnabled(true);
				}
				else
					loginBtn.setEnabled(false);
			}
		});
		textFieldCurrentYearLogin.setBounds(588, 68, 103, 20);
		card1.add(textFieldCurrentYearLogin);
		textFieldCurrentYearLogin.setColumns(10);
		
		JLabel lblCurrentYear = new JLabel("Current Year: (YYYY)");
		lblCurrentYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCurrentYear.setBounds(444, 62, 154, 29);
		card1.add(lblCurrentYear);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblTo.setBounds(89, 145, 92, 57);
		card1.add(lblTo);
		
		JLabel lblGrad = new JLabel("GRAD");
		lblGrad.setFont(new Font("Tahoma", Font.BOLD, 59));
		lblGrad.setBounds(79, 237, 218, 72);
		card1.add(lblGrad);
		
		card4 = new JPanel();
		card4.setBackground(Color.LIGHT_GRAY);
		panel.add(card4, "Map Card");
		card4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		card5 = new JPanel();
		card5.setBackground(SystemColor.activeCaptionBorder);
		panel.add(card5, "Add More Courses");
		card5.setLayout(null);
		
		card5.add(scrollAddMore);
		
		JButton btnGeneratePlan = new JButton("Generate Plan");
		btnGeneratePlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
				Connection conn3 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pathtograd","root","1234");
				int year = 0;
				ArrayList<Course> needList = new ArrayList<Course>();
				ArrayList<Course> completedAlreadyIn = new ArrayList<Course>();
				Statement iAStmt = conn3.createStatement();
				ResultSet myIACC = iAStmt.executeQuery("select * from completedcourses");
				while(myIACC.next())
				{
					if(myIACC.getString("studentnumber").equals(Integer.toString(loggedInStudent.getStudentID())))
					{
						Course c = new Course();
						c.setCourseName(myIACC.getString("CourseNum&Name"));
						c.setCreditHours(Integer.parseInt(myIACC.getString("CourseCreditHour")));
						completedAlreadyIn.add(c);
					}
				}
				myIACC.close();
				iAStmt.close();
				
				
				if(loginBtn.action(null, actionListener))
				{
					 year = Integer.parseInt(textFieldCurrentYearLogin.getText());
				}
				else if(btnCreateAccount.action(null, actionListener))
				{
					 year = Integer.parseInt(textFieldCurrentYearLogin.getText());
				}
				
				for(int i = 0;i<t.getTrackCourses().size();i++)
				{
					for(int j = 0;j<chkBoxListCard5.size();j++)
					{
						if(chkBoxListCard5.get(j).getText().equals(t.getTrackCourses().get(i).getName()))
						{
							if(chkBoxListCard5.get(j).isSelected())
							{
								loggedInStudent.getCompletedCourses().add(t.getTrackCourses().get(i));
							}
						}
					}
				}
				ArrayList<Course> completedCourses = loggedInStudent.getCompletedCourses();
				textAreaTakenCourses.setText(loggedInStudent.outputCompletedCourses());
				needList = generateNeededCourses(loggedInStudent.getCompletedCourses(),t);
				textAreaNeededCourses.setText(needListToString(needList));
				generateCheckBoxsCard5(needList);
				textAreaPlan.setText(needToPlan(needList,completedCourses, year));
				
				PreparedStatement pst = conn3.prepareStatement("INSERT INTO completedcourses (`studentnumber`, `CourseNum&Name`, `CourseCreditHour`)"
						+ "VALUES (?, ?, ?)");
				conn3.setAutoCommit(false);
				for(int i = 0; i < loggedInStudent.getCompletedCourses().size();i++)
				{
					pst.setInt(1, loggedInStudent.getStudentID());
					pst.setString(2, loggedInStudent.getCompletedCourses().get(i).getName());
					pst.setInt(3, loggedInStudent.getCompletedCourses().get(i).getCreditHours());
					pst.addBatch();
				}
					try
					{
						int count[] = pst.executeBatch();
					}
					catch(SQLException e1)
					{
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
						
				
				System.out.println("Connection 9");
				conn3.commit();
				
				pst.close();
				conn3.close();
				System.out.println("Connection 5");
				JOptionPane.showMessageDialog(null, "Saved");
				
				cardLayout.show(panel,"Path Card");
			}
			catch (SQLException e1) 
			{
				JOptionPane.showMessageDialog(null, "Database connection error.");
			}
			}
		});
		btnGeneratePlan.setBounds(470, 567, 123, 23);
		card5.add(btnGeneratePlan);
		
		JLabel lblSelectCompletedCourses = new JLabel("Select Completed Courses");
		lblSelectCompletedCourses.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSelectCompletedCourses.setBounds(416, 26, 247, 33);
		card5.add(lblSelectCompletedCourses);
		
		menuBar = new JMenuBar();
		menuBar.setVisible(false);
		frame.setJMenuBar(menuBar);
		
		mnMenu = new JMenu("MENU");
		menuBar.add(mnMenu);
		
		mntmBack = new JMenuItem("Back ");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				cardLayout.show(panel, "Path Card");
				menuBar.setVisible(false);
			}
		});
		mnMenu.add(mntmBack);
		
	}
	
	public ArrayList<JCheckBox> generateCheckBoxs(ArrayList<Course> t)
	{
		int numberCheckBox = t.size();
				chkBoxList = new ArrayList<JCheckBox>();

				for(int i = 0; i < numberCheckBox; i++) 
				{
				    chkBoxList.add(new JCheckBox(t.get(i).getName()));
				    chkBoxList.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
				    panelOnCard2.add(chkBoxList.get(i));
				}				
			return chkBoxList;

	}
	
	public void generateCheckBoxsCard5(ArrayList<Course> c)
	{
		chkBoxListCard5 = new ArrayList<JCheckBox>();
		for(int i = 0; i < c.size(); i++) 
		{
		    chkBoxListCard5.add(new JCheckBox(c.get(i).getName()));
		    chkBoxListCard5.get(i).setAlignmentX(Component.CENTER_ALIGNMENT);
		    panelOnCard5.add(chkBoxListCard5.get(i));
		}		
	}
	
	public void generateMap(ArrayList<Semester> plans)
	{
		String s = "";
		mapPanels = new ArrayList<JPanel>();
		for(int i = 0;i<plans.size();i++)
		{
			if(plans.get(i).getSemesterName())
			{
				s = "Fall";
			}
			else
				s = "Spring";
			
			TitledBorder titleOfPanel = new TitledBorder(s+" "+plans.get(i).getYear());
			titleOfPanel.setTitleJustification(TitledBorder.CENTER);
			titleOfPanel.setTitlePosition(TitledBorder.TOP);
			JPanel panel = new JPanel();
			panel.setBorder(titleOfPanel);
			panel.setPreferredSize(new Dimension(125,595));
			panel.setLayout(new GridLayout(plans.get(i).getSemesterCourses().size(),1));
			for(int j = 0;j<plans.get(i).getSemesterCourses().size();j++)
			{	
				JButton tempButton = new JButton(plans.get(i).getSemesterCourses().get(j).toButton());
				tempButton.setMaximumSize(new Dimension(125,100));
				panel.add(tempButton); 
			}
			mapPanels.add(panel);
			card4.add(mapPanels.get(i));
		}
		
	}
	
	public ArrayList<Course> generateNeededCourses(ArrayList<Course> completed, Track t)
	{
		ArrayList<Course> needList = new ArrayList<Course>();
		for(int i = 0;i<t.getTrackCourses().size();i++)
		{
			needList.add(t.getTrackCourses().get(i));
			for(int j = 0;j<completed.size();j++)
			{
				if(completed.get(j).getName().equals(t.getTrackCourses().get(i).getName()))
				{
					needList.remove(t.getTrackCourses().get(i));
				}
			}
		}
		
		return needList;
	}
	
	public String needListToString(ArrayList<Course> n)
	{
		String s = "";
		for(int i = 0;i<n.size();i++)
		{
			s = s + n.get(i).generateCourse()+"\n";
		}
		return s;
	}
	
	
	//need to add a boolen showing which seemster it is to parameters for needToPlan, then create field to show current semester and the year in string format ?????
	public String needToPlan(ArrayList<Course> needList,ArrayList<Course> completed,int year)
	{
		
		String s = "";
		ArrayList<Semester> plan = new ArrayList<Semester>();
		int creditHours = 0;
		ArrayList<Course> courseComplete = new ArrayList<Course>();
		courseComplete = completed;
		 
		while(totalCreditHours(courseComplete)<120)
		{
			Semester semester = new Semester();
			for(int i = 0;i<needList.size();i++)
			{
				creditHours = semester.addUpCreditHours(semester.getSemesterCourses());
				if((creditHours<15)||(creditHours+needList.get(i).getCreditHours()<=18))
				{	
							if(needList.get(i).getPrereqs().get(0).getName().equals(""))
							{
								if((499>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>399))&&(totalCreditHours(courseComplete)>=90))
								{
									semester.getSemesterCourses().add(needList.get(i));
									
								}
								else if((399>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>299))&&(totalCreditHours(courseComplete)>=60))
								{
									semester.getSemesterCourses().add(needList.get(i));
									
								}
								else if((299>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>199))&&(totalCreditHours(courseComplete)>=30))
								{
									semester.getSemesterCourses().add(needList.get(i));
									
								}
								else if(199>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>99)&&(totalCreditHours(courseComplete)>=0))
								{
									semester.getSemesterCourses().add(needList.get(i));
								}
									
							}
							else if(!needList.get(i).getPrereqs().isEmpty())
							{
								for(int j = 0; j<courseComplete.size();j++)
								{
									String prereqName = needList.get(i).getPrereqs().get(0).getName();
									String completedCourseName = courseComplete.get(j).getName().substring(0, 7);
									if(prereqName.equals(completedCourseName))
									{
										if((499>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>399))&&(totalCreditHours(courseComplete)>=90))
										{
											semester.getSemesterCourses().add(needList.get(i));
											
										}
										else if((399>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>299))&&(totalCreditHours(courseComplete)>=60))
										{
											semester.getSemesterCourses().add(needList.get(i));
											
										}
										else if((299>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>199))&&(totalCreditHours(courseComplete)>=30))
										{
											semester.getSemesterCourses().add(needList.get(i));
											
										}
										else if(199>=Integer.parseInt(needList.get(i).getName().substring(4, 7))&&(Integer.parseInt(needList.get(i).getName().substring(4, 7))>99)&&(totalCreditHours(courseComplete)>=0))
										{
											semester.getSemesterCourses().add(needList.get(i));
											
										}
									}
								}
							}		
				}
				
				if((plan.isEmpty())||(!plan.get(plan.size()-1).getSemesterName()))
				{
					semester.setSemesterName(true);
					
				}
				else if(plan.get(plan.size()-1).getSemesterName())
				{
					semester.setSemesterName(false);
				}
				
			}
			plan.add(semester);
			 
			for(int i = 0;i<semester.getSemesterCourses().size();i++)
			{
				 
				courseComplete.add(semester.getSemesterCourses().get(i));
				needList.remove(semester.getSemesterCourses().get(i));
				 
			}
		}
		
		
			for(int j = 0; j <plan.size();j++)
			{
				for(int k = 0; k<plan.get(j).getSemesterCourses().size();k++)
				{
					courseComplete.remove(plan.get(j).getSemesterCourses().get(k));
				}
			}
		
		for(int i = 0;i<plan.size();i++)// fix year problem here
		{
			if(i == 0)
			{
				plan.get(i).setYear(year);
			}
			else if (!plan.get(i).getSemesterName())
			{
				year = year +1;
				plan.get(i).setYear(year);
			}
			else if(plan.get(i).getSemesterName())
			{
				plan.get(i).setYear(year);
			}		
		}
		
		for(int i = 0;i<plan.size();i++)
		{
			s = s+plan.get(i).toString();
		}
		
		generateMap(plan);
		
		return s;
	}
	
	public int totalCreditHours(ArrayList<Course> complete)
	{
		int totalCredits = 0;
		for(int i = 0;i<complete.size();i++)
		{
			totalCredits = totalCredits + complete.get(i).getCreditHours();
		}
		return totalCredits;
	}
}
