package dosql;

import java.sql.*;

public class Conn {

	public static String url = "jdbc:mysql://localhost:3306/nhwc?";
	public static String name = "root";
	public String code = "";
	public Connection conn = null;
	public Statement stmt = null;
	public PreparedStatement pst = null;

	public Conn(String sql) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(url, name, code);
			stmt = conn.createStatement();//执行一次
			pst = conn.prepareStatement(sql);//批量执行效率高
			
			// stmt.close();
			// conn.close();

			System.out.println("finConn");
		} catch (Exception e) {
			System.out.println("wrong!");
		}
	}

	public void close() {

		try {
			this.conn.close();
			this.stmt.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		//Conn c =new Conn("");
	}

}
