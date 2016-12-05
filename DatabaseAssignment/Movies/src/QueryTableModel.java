import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
class QueryTableModel extends AbstractTableModel
{
	Vector modelData; 
	int colCount;
	String[] headers=new String[0] ;
	Connection con;
	Statement stmt = null;
	Statement stmt2 = null;
	Statement stmt3 = null;
	String[] record;
	ResultSet rs = null;

	public QueryTableModel(){
		modelData = new Vector();
	}

	public String getColumnName(int i){
		return headers[i];
	}	
	public int getColumnCount(){
		return colCount;
	}
	
	public int getRowCount(){
		return modelData.size();
	}
	
	public Object getValueAt(int row, int col){
		return ((String[])modelData.elementAt(row))[col];
	}

	public void refreshFromDB( Statement stmt1)
	{
		

		modelData = new Vector();
		stmt = stmt1;
		try{
			
			rs = stmt.executeQuery("SELECT * FROM moviedetails");
			ResultSetMetaData meta = rs.getMetaData();
			colCount = meta.getColumnCount(); 
			headers = new String[colCount];
	
			for(int h = 0; h<colCount; h++)
			{
				headers[h] = meta.getColumnName(h+1);
			}
		
			
		
			while(rs.next())
			{
				record = new String[colCount];
				for(int i = 0; i < colCount; i++)
				{
					record[i] = rs.getString(i+1);
				}
				modelData.addElement(record);
			}
			fireTableChanged(null);
		}
		catch(Exception e) {
					System.out.println("Error with refreshFromDB Method\n"+e.toString());
		} 
	}
	public void refreshFromDB1( Statement stmt1)
	{
		

		modelData = new Vector();
		stmt2 = stmt1;
		try{
			
			rs = stmt2.executeQuery("select movieName,cast from cast_movies; ");
			ResultSetMetaData meta = rs.getMetaData();
			colCount = meta.getColumnCount(); 
			headers = new String[colCount];
	
			for(int h = 0; h<colCount; h++)
			{
				headers[h] = meta.getColumnName(h+1);
			}
		
			
		
			while(rs.next())
			{
				record = new String[colCount];
				for(int i = 0; i < colCount; i++)
				{
					record[i] = rs.getString(i+1);
				}
				modelData.addElement(record);
			}
			fireTableChanged(null);
		}
		catch(Exception e) {
					System.out.println("Error with refreshFromDB1 Method\n"+e.toString());
		} 
	}
	public void refreshFromDB2( Statement stmt1)
	{
		

		modelData = new Vector();
		stmt3 = stmt1;
		try{
			
			rs = stmt3.executeQuery("select moviedetails1.moviename,moviedetails1.country,moviedetails1.language,moviedetails1.runtime,moviedetails.writerName ,moviedetails.directorName,moviedetails.imdbRating,moviedetails.releaseDate,moviedetails.genre from moviedetails1 inner join moviedetails on moviedetails1.m_id= moviedetails.id; ");
			ResultSetMetaData meta = rs.getMetaData();
			colCount = meta.getColumnCount(); 
			headers = new String[colCount];
	
			for(int h = 0; h<colCount; h++)
			{
				headers[h] = meta.getColumnName(h+1);
			}
		
			
		
			while(rs.next())
			{
				record = new String[colCount];
				for(int i = 0; i < colCount; i++)
				{
					record[i] = rs.getString(i+1);
				}
				modelData.addElement(record);
			}
			fireTableChanged(null);
		}
		catch(Exception e) {
					System.out.println("Error with refreshFromDB2 Method\n"+e.toString());
		} 
	}
	
}
