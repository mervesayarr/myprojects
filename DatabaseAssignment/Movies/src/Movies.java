import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;



import javax.swing.JScrollBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class Movies extends JFrame {

	
	private JFrame frmMovesPage;
	
	private JTextField textmoviename;
	private JTextField textwritername;
	private JTextField textdirectorname;
	private JTextField textimdb;
	private JTextField textreleasedate;
	private JTextField textgenre;
	private JTextField textcast;
	private JTextField textid;
	private static QueryTableModel TableModel = new QueryTableModel();
	private JTable table = new JTable(TableModel);
	private static QueryTableModel TblModel = new QueryTableModel();
	private JTable table2 = new JTable(TblModel);
	
	
	String cmd = null;

	// DB Connectivity Attributes
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	private Container content;
	private JTextField textFieldNumberOfGenre;
	private JTextField textFieldAvg;
	private JTextField textFieldListMoviesAfter;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movies window = new Movies();
					window.frmMovesPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Movies() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		initiate_db_conn();
		frmMovesPage = new JFrame();
		frmMovesPage.setResizable(false);
		frmMovesPage.getContentPane().setBackground(new Color(228, 210, 218));
		frmMovesPage.setTitle("MOVIES PAGE");
		frmMovesPage.setBounds(100, 100, 1297, 587);
		frmMovesPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMovesPage.getContentPane().setLayout(null);
		frmMovesPage.setLocationRelativeTo(null);
		
		JLabel lblid = new JLabel("ID:");
		lblid.setBounds(10, 45, 46, 14);
		frmMovesPage.getContentPane().add(lblid);
		
		JLabel lblid1 = new JLabel("ID:");
		lblid.setBounds(10, 45, 46, 14);
		
		
		JLabel lblMovieName = new JLabel("Movie Name:");
		lblMovieName.setBounds(10, 70, 92, 14);
		frmMovesPage.getContentPane().add(lblMovieName);
		
		JLabel lblWriterName = new JLabel("Writer Name:");
		lblWriterName.setBounds(10, 95, 92, 14);
		frmMovesPage.getContentPane().add(lblWriterName);
		
		JLabel lblDirectorName = new JLabel("Director Name:");
		lblDirectorName.setBounds(10, 120, 92, 14);
		frmMovesPage.getContentPane().add(lblDirectorName);
		
		JLabel lblImdb = new JLabel("IMDb:");
		lblImdb.setBounds(241, 45, 46, 14);
		frmMovesPage.getContentPane().add(lblImdb);
		
		JLabel lblReleaseDate = new JLabel("Release Date:");
		lblReleaseDate.setBounds(241, 70, 109, 14);
		frmMovesPage.getContentPane().add(lblReleaseDate);
		
		JLabel lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(241, 95, 46, 14);
		frmMovesPage.getContentPane().add(lblGenre);
		
		textmoviename = new JTextField();
		textmoviename.setColumns(10);
		textmoviename.setBounds(112, 67, 86, 20);
		frmMovesPage.getContentPane().add(textmoviename);
		
		textwritername = new JTextField();
		textwritername.setColumns(10);
		textwritername.setBounds(112, 92, 86, 20);
		frmMovesPage.getContentPane().add(textwritername);
		
		textdirectorname = new JTextField();
		textdirectorname.setColumns(10);
		textdirectorname.setBounds(112, 117, 86, 20);
		frmMovesPage.getContentPane().add(textdirectorname);
		
		textimdb = new JTextField();
		textimdb.setColumns(10);
		textimdb.setBounds(317, 42, 86, 20);
		frmMovesPage.getContentPane().add(textimdb);
		
		textreleasedate = new JTextField();
		textreleasedate.setColumns(10);
		textreleasedate.setBounds(317, 67, 86, 20);
		frmMovesPage.getContentPane().add(textreleasedate);
		
		textgenre = new JTextField();
		textgenre.setBounds(317, 92, 86, 20);
		frmMovesPage.getContentPane().add(textgenre);
		textgenre.setColumns(10);
		
		JLabel lblCast = new JLabel("Cast:");
		lblCast.setBounds(241, 120, 46, 14);
		frmMovesPage.getContentPane().add(lblCast);
		
		textcast = new JTextField();
		textcast.setText("");
		textcast.setBounds(317, 117, 86, 20);
		frmMovesPage.getContentPane().add(textcast);
		textcast.setColumns(10);
		
		textid = new JTextField();
		textid.setBounds(112, 39, 86, 20);
		frmMovesPage.getContentPane().add(textid);
		textid.setColumns(10);
		table.setForeground(new Color(0, 0, 51));
		table.setFont(new Font("Cambria", Font.BOLD, 11));
		table.setBorder(new LineBorder(new Color(0, 0, 51)));
		table.setBackground(Color.LIGHT_GRAY);
		
		JScrollPane scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(413, 12, 861, 300);
		frmMovesPage.getContentPane().add(scrollPane);
		
		
		
		
		
		
		
		table.setPreferredScrollableViewportSize(new Dimension(900, 300));
		TableModel.refreshFromDB(stmt);
		
		table2.setForeground(Color.RED);
		table2.setFont(new Font("Cambria", Font.ITALIC, 11));
		
		JScrollPane scrollPane_1 = new JScrollPane(table2,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(413, 371, 700, 166);
		frmMovesPage.getContentPane().add(scrollPane_1);
		
		
		JButton btnNewButton = new JButton("Add Movie");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					String insert ="INSERT INTO moviedetails VALUES("+
					null +",'"+textmoviename.getText()+"','"+textwritername.getText()+"','"+textdirectorname.getText()+"',"+textimdb.getText()+",'"
					+textreleasedate.getText()+"','"+textgenre.getText()+"','"+textcast.getText()+"');";

					stmt.executeUpdate(insert);

				}
				catch (SQLException sqle)
				{
					System.err.println("Error with  insert:\n"+sqle.toString());
				}
				finally
				{
					TableModel.refreshFromDB(stmt);
				}
			}
		});
		btnNewButton.setBounds(35, 163, 92, 23);
		frmMovesPage.getContentPane().add(btnNewButton);
		
		JButton btnDeleteMovie = new JButton("Delete Movie");
		btnDeleteMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					String delete ="DELETE FROM moviedetails WHERE id = "+textid.getText()+";"; 
					stmt.executeUpdate(delete);

				}
				catch (SQLException sqle)
				{
					System.err.println("Error with delete:\n"+sqle.toString());
				}
				finally
				{
					TableModel.refreshFromDB(stmt);
				}
			}
		});
		btnDeleteMovie.setBounds(137, 163, 122, 23);
		frmMovesPage.getContentPane().add(btnDeleteMovie);
		
		JButton btnUpdate = new JButton("Update ");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{ 			
					String update ="UPDATE moviedetails SET " +
					"movieName = '"+textmoviename.getText()+
					"', writerName  = '"+textwritername.getText()+
					"', directorName  = '"+textdirectorname.getText()+
					"', imdbRating  ="+textimdb.getText()+
					", releaseDate  = '"+textreleasedate.getText()+
					"', genre  = '"+textgenre.getText()+
					"', cast  = '"+textcast.getText()+
					"' where id = "+textid.getText();


					stmt.executeUpdate(update);
					//these lines do nothing but the table updates when we access the db.
					rs = stmt.executeQuery("SELECT * from moviedetails ");
					rs.next();
					rs.close();	
				}
				catch (SQLException sqle){
					System.err.println("Error with  update:\n"+sqle.toString());
				}
				finally{
					TableModel.refreshFromDB(stmt);
				}
			}
		});
		btnUpdate.setBounds(280, 163, 89, 23);
		frmMovesPage.getContentPane().add(btnUpdate);
		
		JButton btnExport = new JButton("Export");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cmd = "select * from moviedetails;";

				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		btnExport.setBounds(39, 210, 89, 23);
		frmMovesPage.getContentPane().add(btnExport);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textid.setText("");
				textmoviename.setText("");
				textwritername.setText("");
				textdirectorname.setText("");
				textimdb.setText("");
				textreleasedate.setText("");
				textgenre.setText("");
				textcast.setText("");
				
			}
		});
		btnClear.setBounds(151, 210, 89, 23);
		frmMovesPage.getContentPane().add(btnClear);
		
		JButton btnShowTheCast = new JButton("Show The Cast");
		btnShowTheCast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 CastMovie cm = new CastMovie();
			 cm.frmCastPage.setVisible(true);
			 cmd = "select movieName  ,cast from moviedetails;";

			 try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}

				
			
			}
		});
		btnShowTheCast.setBounds(266, 210, 122, 23);
		frmMovesPage.getContentPane().add(btnShowTheCast);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(137, 87, 109));
		menuBar.setBounds(40, 0, 363, 35);
		frmMovesPage.getContentPane().add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Cambria", Font.BOLD, 15));
		
		menuBar.add(mnFile);
		
		JMenuItem mnýtmExit = new JMenuItem("Exit");
		mnýtmExit.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		mnFile.add(mnýtmExit);
		mnýtmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenu mnSort = new JMenu("Sort");
		mnSort.setFont(new Font("Cambria", Font.BOLD, 15));
		menuBar.add(mnSort);
		
		JMenuItem mnýtmSortedByImdb = new JMenuItem("Sorted by IMDb");
		mnýtmSortedByImdb.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		mnSort.add(mnýtmSortedByImdb);
		mnýtmSortedByImdb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd = "select movieName,imdbRating "+  "from moviedetails " + "order by imdbRating desc ";

				
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		
		
		JMenuItem mnýtmSortedByRelease = new JMenuItem("Sorted by Release Date");
		mnýtmSortedByRelease.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		mnSort.add(mnýtmSortedByRelease);
		mnýtmSortedByRelease.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd = "select movieName,releaseDate "+  "from moviedetails " + "order by releaseDate desc ";

				
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		
		
		JMenuItem mnýtmSortedByMovie = new JMenuItem("Sorted by Movie Name ");
		mnýtmSortedByMovie.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 13));
		mnSort.add(mnýtmSortedByMovie);
		mnýtmSortedByMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd = "select movieName "+  "from moviedetails " + "order by movieName  ";

				
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
				
			}
		});
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(137, 87, 109));
		panel.setBounds(10, 245, 393, 139);
		frmMovesPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JButton btnNumberOfGenre = new JButton("Number Of Genre ");
		btnNumberOfGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String genreName = textFieldNumberOfGenre.getText();

				cmd = "select genre, count(*) "+  "from moviedetails " + "where genre = '"  +genreName+"';";

				System.out.println(cmd);
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnNumberOfGenre.setBounds(10, 11, 217, 23);
		panel.add(btnNumberOfGenre);
		
		textFieldNumberOfGenre = new JTextField();
		textFieldNumberOfGenre.setBounds(227, 12, 104, 20);
		panel.add(textFieldNumberOfGenre);
		textFieldNumberOfGenre.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Avg IMDb For Genre");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String avgIMDb = textFieldAvg.getText();

				cmd = "select genre, avg(imdbRating) "+  "from moviedetails " + "where genre = '"  +avgIMDb+"';";

				System.out.println(cmd);
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnNewButton_1.setBounds(10, 31, 217, 23);
		panel.add(btnNewButton_1);
		
		textFieldAvg = new JTextField();
		textFieldAvg.setBounds(227, 32, 104, 22);
		panel.add(textFieldAvg);
		textFieldAvg.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("List All Movies");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd = "select movieName from moviedetails;";

				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnNewButton_2.setBounds(10, 76, 162, 23);
		panel.add(btnNewButton_2);
		
		JButton btnListMoviesAfter = new JButton("List Movies After");
		btnListMoviesAfter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String listAfter = textFieldListMoviesAfter.getText();

				cmd = "select movieName,releaseDate "+  "from moviedetails " + "where releaseDate > '"  +listAfter+"';";

				System.out.println(cmd);
				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnListMoviesAfter.setBounds(10, 54, 217, 23);
		panel.add(btnListMoviesAfter);
		
		textFieldListMoviesAfter = new JTextField();
		textFieldListMoviesAfter.setBounds(227, 54, 104, 23);
		panel.add(textFieldListMoviesAfter);
		textFieldListMoviesAfter.setColumns(10);
		
		JButton btnListDirector = new JButton("List All Director");
		btnListDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmd = "select distinct directorName from moviedetails;";

				try{					
					rs= stmt.executeQuery(cmd); 	
					writeToFile(rs);
				}
				catch(Exception e1){e1.printStackTrace();}
			}
		});
		btnListDirector.setBounds(171, 76, 160, 23);
		panel.add(btnListDirector);
		
		JButton btnShowMovieDetails = new JButton("SHOW MOVIE DETAILS");
		btnShowMovieDetails.setBackground(new Color(51, 0, 0));
	
		btnShowMovieDetails.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnShowMovieDetails.setForeground(new Color(204, 204, 204));
		btnShowMovieDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TblModel.refreshFromDB2(stmt);
				
			}
		});
		btnShowMovieDetails.setBounds(413, 337, 354, 23);
		frmMovesPage.getContentPane().add(btnShowMovieDetails);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("image\\image.png"));
		label.setBounds(47, 395, 322, 142);
		frmMovesPage.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("image\\film.png"));
		label_1.setBounds(1123, 337, 148, 200);
		frmMovesPage.getContentPane().add(label_1);
		

		
		
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
			con = DriverManager.getConnection(url, "root", "5658337");
			//Create a generic statement which is passed to the TestInternalFrame1
			stmt = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
		}
	}
	private void writeToFile(ResultSet rs){
		try{
			System.out.println("writeToFile");
			FileWriter outputFile = new FileWriter("Movie.csv");
			PrintWriter printWriter = new PrintWriter(outputFile);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for(int i=0;i<numColumns;i++){
				printWriter.print(rsmd.getColumnLabel(i+1)+",");
			}
			printWriter.print("\n");
			while(rs.next()){
				for(int i=0;i<numColumns;i++){
					printWriter.print(rs.getString(i+1)+",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
