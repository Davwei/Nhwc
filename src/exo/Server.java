package exo;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {//需要把这个server 分成两个servers

	public static void main(String[] args) {
		Server server=new Server();
		server.Start();
	}
		
	boolean started = false;
	ServerSocket ss = null;
	ServerSocket ssd =null;
	Socket s=null;
	Socket sd=null;
	
	int clientnumber= 0;
	int whosturn = 0;
	
	 
	List<Sclient> Sclients=new ArrayList<Sclient>();
	List<Dclient> Dclients=new ArrayList<Dclient>();
	public void Start(){
		
		
		
		System.out.println("Server has been open");
		try {
			ss = new ServerSocket(8888);
			ssd =new ServerSocket(8887);
			
			started =true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		while (started) {

				try {
					s = ss.accept();
					sd = ssd.accept();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clientnumber++;
				if(clientnumber==1)
					System.out.println("1 Client has connected");
				else
					System.out.println(clientnumber+" Clients have connected");	
				Sclient Sc =new Sclient(s);
				new Thread(Sc).start();
				Sclients.add(Sc);
				
				Dclient Dc =new Dclient(sd);
				new Thread(Dc).start();
				Dclients.add(Dc);
			}

		

	}
	class Dclient implements Runnable{//对客户端交互游戏数据
		private Socket soc;
		private DataInputStream disd = null;
		private DataOutputStream dosd = null,doswhosturn =null;
		
		private boolean bConnected = false;
		float f;
		int px,py,x,y,indc;
		
	
		
		public  Dclient(Socket s){
			this.soc=s;
			bConnected=true;
			try {
				disd =new DataInputStream(s.getInputStream());
				dosd =new DataOutputStream(s.getOutputStream());
				doswhosturn =new DataOutputStream(s.getOutputStream()); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}public void send(float f, int indc, int px, int py, int x, int y){
			try {
				/*this.f=f;
				this.indc=indc;
				this.x=x;
				this.y=y;
				this.px=px;
				this.py=py;
				*/
				//dos.writeFloat(Server.f);
				//dos.writeInt(Server.indc);
				dosd.writeInt(px);
				//System.out.println("Server px"+px);
				dosd.writeInt(py);
				//System.out.println("Server py"+py);
				dosd.writeInt(x);
				//System.out.println("Server x"+x);
				dosd.writeInt(y);
				//System.out.println("Server y"+y);
				
				
				dosd.flush();
				
				
			} catch (IOException e) {
				Dclients.remove(this);
				e.printStackTrace();
			}
			
	
			
			
		}
		
		public void run() {
			
			while(bConnected){
				try {
					//f=dis.readFloat();
					//indc=dis.readInt();
					px=disd.readInt();
					py=disd.readInt();
					x=disd.readInt();
					y=disd.readInt();
					System.out.println(px+"  "+py+"  "+x+"  "+y);
					//doswhosturn.writeInt(whosturn);
					for(int i=0;i<Dclients.size();i++){
						Dclients.get(i).send(f,indc,px,py,x,y);
						}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			
		}
		}
	class Sclient implements Runnable {//对所有客户端交互聊天
		private Socket soc;
		private DataInputStream dis = null;
		private DataOutputStream dos = null;
		private boolean bConnected = false;
		

		public Sclient(Socket s) {
			this.soc = s;
			bConnected = true;
			try {
				dis = new DataInputStream(soc.getInputStream());
				dos =new DataOutputStream(soc.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		public void send(String str){
			
			
				try {
					
					dos.writeUTF(str);
					
				} catch (Exception e) {
					Sclients.remove(this);
					//e.printStackTrace();
				}
			
		}
		public void run() {
			
			try{
			while (bConnected) {
				
				BufferedReader br =new BufferedReader(new InputStreamReader(dis));
				
				String str = br.readLine();
				
				for(int i=0;i<Sclients.size();i++){
					Sclient Sc =Sclients.get(i);
					Sc.send(str);					
				}
				
			
				System.out.println(str);
			
			}
			

			}catch(SocketException e) {
				
				System.out.println("a client closed");
			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				try {
					if (soc != null)
						soc.close();
					if (dis != null)
						dis.close();
					if(dos != null)
						dos.close();
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();

				}
				
				
				
			}
		
		}
	}
}