import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;


public class CastMovie extends JFrame{

	JFrame frmCastPage;
	
	private static QueryTableModel TableMdl = new QueryTableModel();
	private JTable table = new JTable(TableMdl);
	String cmd = null;

	// DB Connectivity Attributes
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	private Container content;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CastMovie window = new CastMovie();
					window.frmCastPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CastMovie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initiate_db_conn();
		frmCastPage = new JFrame();
		frmCastPage.setResizable(false);
		frmCastPage.getContentPane().setBackground(new Color(89, 132, 162));
		frmCastPage.setTitle("Cast Page");
		frmCastPage.setBounds(100, 100, 1350, 258);
		frmCastPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCastPage.getContentPane().setLayout(null);
		frmCastPage.setLocationRelativeTo(null);
		table.setBackground(new Color(204, 204, 204));
		table.setForeground(new Color(102, 0, 51));
		table.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 11, 1300, 200);
		frmCastPage.getContentPane().add(scrollPane);
		TableMdl.refreshFromDB1(stmt);
		
	}
	
	public void initiate_db_conn()
	{
		try
		{
			// Load the JConnector Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Specify the DB Name
			String url="jdbc:mysql://localhost:3306/movie";
			// Connect to DB using DB URL, Username and password
			con = DriverManager.getConnection(url, "username", "password");
			//Create a generic statement which is passed to the TestInternalFrame1
			stmt = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
		}
	}
	
	}

