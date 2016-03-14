package dosql;
import java.sql.*;
public class loginsql {
   
	public loginsql(){
		
	}
	public int login(String uid,String passw){
		//1: login succeed  2: false
		String sql1 ="Select * from User where User_id ='"+uid+"' and passw ='"+passw+"' and status =b'0' ";
		//status prepared for login's status check 
		Conn con =new Conn(sql1);
		ResultSet rs =null ;
		try {
			rs = con.stmt.executeQuery(sql1);
			
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
	
}
