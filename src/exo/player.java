package exo;

public class player {
	private String name,password;
	private int point=0;
	public boolean host,now;
	
	
	
	
	
	public player(String name,String password){
		this.name=name;
		this.password=password;		
		
		
		
		
		
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void earnPoint(){
		point++;

	}

	
	
	
	
}
