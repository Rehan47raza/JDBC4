
package com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TestProcedure {
	
	
	public static ArrayList<Book> getbooksListbyprice(DbTransaction db) 
	{
		ArrayList<Book> ar = new ArrayList<Book>();
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try
		{
			cn=db.getConnection();
			st=cn.createStatement();
			String sql="SELECT * FROM TBL_BOOK_1190848 ORDER BY PRICE DESC";
			rs = st.executeQuery(sql);
			//System.out.println(rs.getFetchSize());
			while(rs.next())
			{
				Book a = new Book();
				a.setBookId(rs.getInt(1));
				a.setTitle(rs.getString(2));
				a.setPrice(rs.getDouble(3));
				a.setPages(rs.getInt(4));
				
				
				ar.add(a);
				
			}
			
			
		}catch (Exception e) {
			return null;
		}
		
		return ar;
	}
	

}
