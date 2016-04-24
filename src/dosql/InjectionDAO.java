package dosql;

public interface InjectionDAO {
	
	public void connect();
	
	public void dosql(String sql);
	
	public void closesql();
	
	public int loginsql(String uid,String passw);
	
	public int registersql(String username,String passw);
	
	
}
