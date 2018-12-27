import java.sql.*;



public class ArticleTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class DeamonThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		} 
		
	}
	
	
	public void show() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			rs.getStatement().executeQuery("select * from article where pid = 0");
			while(rs.next()) {
				System.out.println((rs.getString("cont"));
				tree(conn.createStatement().getInt("id"),1);
			}
			
			
		} catch(ClassNotFoundException e) { 
			e.printStackTrace();
		}
		  catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
					rs =null;
				}
				if(stmt != null) {
					stmt.close();
					stmt=null;
				}
				if(conn !=null) {
					conn.close();
					conn=null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	private void tree(Connection conn, int id, int level) {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String sql = "select * from article where pid = " + id;
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("cont"));
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {
					rs.close();
					rs =null;
				}
				if(stm != null) {
					stmt.close();
					stmt=null;
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
