package basic;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.event.MouseInputListener;


public class Chat extends JPanel{
	
	static int PORT2 =8888;
	
	JLayeredPane pan;
	JButton send,submit,cancel;
	JPanel	chatting,name,panel,panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7,panel_8,panel_9,panel_10;
	JLabel 	lblNewLabel,lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,Color,Size;
	JTextField sendword,textField;
	JTextArea textArea;
	Socket s=null;
	DataOutputStream dos;
	DataInputStream dis;
	boolean bConnected =false;
	String playername;
	public Chat(){
		
		
		this.setLayout(new GridLayout(2,1));
		pan =new JLayeredPane();
		pan.setLayout(new GridLayout(1, 1, 0, 0));
		
		chatting = new JPanel();
		pan.setLayer(chatting, 1);
		pan.add(chatting);
		this.add(pan);
		chatting.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textArea = new JTextArea();
		chatting.add(textArea);
		textArea.setColumns(20);
		textArea.setRows(11);
		
		
		
		name = new JPanel();
		
		this.add(name);
		name.setToolTipText("");
		name.setLayout(new GridLayout(5, 1, 1, 0));
		
		panel_7 = new JPanel();
		name.add(panel_7);
		
		sendword = new JTextField();
		panel_7.add(sendword);
		sendword.setColumns(12);
		sendword.addActionListener(new JTListener());
		
		send = new JButton("send");
		
		
		panel_7.add(send);
		
		panel = new JPanel();
		name.add(panel);
		
		lblNewLabel = new JLabel(" Name :");
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1);
		
		panel_3 = new JPanel();
		name.add(panel_3);
		
		lblNewLabel_3 = new JLabel("Point :");
		lblNewLabel_3.setToolTipText("");
		panel_3.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("New label");
		panel_3.add(lblNewLabel_4);
		
		panel_1 = new JPanel();
		name.add(panel_1);
		
		lblNewLabel_2 = new JLabel(" Key Word :");
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		panel_2 = new JPanel();
		name.add(panel_2);
		
		submit = new JButton("submit");
		panel_2.add(submit);
		
		cancel = new JButton("cancel");
		panel_2.add(cancel);
		
		this.connect();
		RecvThread RT=new RecvThread();
		new Thread(RT).start();
	}	
	
	

	public void connect(){
		try {
			s = new Socket("127.0.0.1", PORT2);//8887 port
			System.out.print("Connect!");
			bConnected=true;
			dos=new DataOutputStream(s.getOutputStream());
			dis =new DataInputStream(s.getInputStream());
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}	
	public void disconnect(){
		try {
			s.close();
			dos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	
	
	
	
	
	private class JTListener implements ActionListener	{
	
	public void actionPerformed(ActionEvent e) {
		String str = sendword.getText().trim();
		//textArea.setText(str);
		//sendword.setText("");
		try {
			//¼ì²é×Ö·û³¤¶È
			dos.writeUTF(str);
			dos.flush();
			
			//dos.close();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		
	}

	}	
	class RecvThread implements Runnable{
		String rstr ;
		public void run() {
			while(bConnected){
				try {
					rstr=dis.readUTF();
					textArea.setText(textArea.getText()+""+rstr+'\n');
				} catch (IOException e) {
					break;
					//e.printStackTrace();
				}
				
				
			}
			
		}
		
	}
	
	
}
