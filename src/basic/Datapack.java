package basic;


/**
 * @author David
 * ��java���������ת��Ϊ����datapack��Ӧ��ͨ��tcp ������Ѿ���������ݴ��������ˣ�
 */
public class Datapack {
	
	private point px;
	private String username;//�о���Ч������
	private int roomid;
	
	public Datapack(){
		
	}
	public Datapack(String username,int roomid,point px){
		this.username = username;
		this.roomid = roomid;
		this.px = px;
		
	}
}
