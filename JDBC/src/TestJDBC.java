import java.sql.*;

public class TestJDBC {
	
	public static void main(String[] args) throws Exception{
		//ResultSet rs = null;
		
		try{// try catch is better than throws
		Class.forName("");
		Connection conn = DriverManager.getConnection(url, "root", "password");
		Statement stmt = conn.createStatement();
		String sql = "select * from dept";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
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


