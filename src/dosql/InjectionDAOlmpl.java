package dosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InjectionDAOlmpl implements InjectionDAO{
	
	public static String url = "jdbc:mysql://localhost:3306/nhwc?";
	public static String name = "root";
	public String code = "";
	public Connection conn = null;
	public Statement stmt = null;
	public PreparedStatement pst = null;
	
	public InjectionDAOlmpl(){
		
		System.out.println("Database connect");
		
	} 
	
	
	@Override
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			conn = DriverManager.getConnection(url, name, code);
			//stmt = conn.createStatement();//执行一次
			//pst = conn.prepareStatement(sql);//批量执行效率高
			
			// stmt.close();
			// conn.close();

			System.out.println("finConn");
		} catch (Exception e) {
			System.out.println("wrong!");
		}
		
	}

	@Override
	public int loginsql(String uid, String passw) {
		//1: login succeed  2: false
				String sql1 ="Select * from User where User_id ='"+uid+"' and passw ='"+passw+"' and status = b'0' ";
				//status prepared for login's status check 
				
				ResultSet rs = null ;
				try {
					this.dosql(sql1);
					rs = this.stmt.executeQuery(sql1);
					
					//System.out.println(rs.getRow());
					//rs row not correctable
					int count =0;
					while(rs.next())
						count++;
					
					if(count==0){
						return 2;
					}
					if(count==1){
						return 1;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				return 0;
				
	}

	@Override
	public int registersql(String username, String passw) {
		//首先，要查询是否冲突
				String sql1 ="Select * from `User` where User_name ='"+username+"'";

				ResultSet rs =null ;
				try {
					this.dosql(sql1);
					rs = this.stmt.executeQuery(sql1);
					
					//System.out.println(rs.getRow());
					//rs row not correctable
					int count =0;
					while(rs.next())
						count++;
					rs = null;
					if(count==0){
						String sql2= "Select User_id from user where User_id>=all(select User_id from user)";
						this.dosql(sql2);
						int cid =0;
						rs = this.stmt.executeQuery(sql2);
						while(rs.next())
							cid = rs.getInt("User_id");
						
						System.out.println("cid is :"+cid);
						
						String sql3= "Insert into `user` (`User_id`,`User_name`,`passw`,`status`) VALUES('"+(cid+1)+"','"+username+"','"+passw+"',b'0')";
						
						this.dosql(sql3);
						this.pst.executeUpdate(sql3);
						
						
						return 2;//没人注册过
						
						
					}
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				return 0;
	}

	@Override
	public void dosql(String sql) {
		try {
			stmt = conn.createStatement();//执行一次
			pst = conn.prepareStatement(sql);//批量执行效率高
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void closesql() {
		try {
			this.conn.close();
			this.stmt.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
