import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML2 {
	if(args.length !=3) {
		System.out.println("");
		System.exit(-1);
	}
	
	int deptno =0;
	
	try {
		deptno= Integer.parseInt(args[0]);
	} catch(NumberFormatException e) {
		e.printStackTrace();
	
	}
	PreparedStatement pstmt =null;
	String dname = args[1];
	String loc = args[2];
	
	
	try{// try catch is better than throws
		Class.forName("");
		Connection conn = DriverManager.getConnection(url, "root", "password");
		Statement stmt = conn.createStatement();
		
		conn.setAutoCommit(false);
		
		Statement sss = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		sss.addBatch("");
		sss.addBatch(sql);
		sss.addBatch(sql);
		sss.executeBatch();
		
		conn.setAutoCommit(true);
		sss.close(); 
		
		try {
	
			} catch(SQLException e) {
				if(conn!=null) {
					conn.rollback();
					conn.setAutoCommit(true);
			}
		}
		pstmt = conn.prepareStatement("");
		pstmt.setInt(1, deptnp);
		pstmt.setString(2, dame);
		pstmt.setString(3, loc);
		
		pstmt.executeUpdate();
		String sql = "select * from dept";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			rs.previous();
			rs.last();
			rs.isClosed();
			rs.absolute(21);
			rs.getRow();
			System.out.println(rs.getString("dept"));
			
		}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) { 
					rs.close();
					rs=null;}
				if(stmt!=null) {
					stmt.close();
					stmt=null;
				}
				if(conn!=null) {
					
					conn.close();
					conn=null;}
				
			 }
		}
}

}