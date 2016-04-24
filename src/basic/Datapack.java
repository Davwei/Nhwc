package basic;


/**
 * @author David
 * 将java的输入输出转化为传输datapack（应该通过tcp 传输的已经解决了数据传输问题了）
 */
public class Datapack {
	
	private point px;
	private String username;//感觉有效率问题
	private int roomid;
	
	public Datapack(){
		
	}
	public Datapack(String username,int roomid,point px){
		this.username = username;
		this.roomid = roomid;
		this.px = px;
		
	}
}
