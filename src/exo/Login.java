package exo;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import basic.frame;
import dosql.*;



public class Login   {
	
	JPanel p1,p2,p3,p4;
	JLabel l1,l2;
	JButton b1,b2,b3;
	JTextField jtf;
	JPasswordField jpf;
	ActionListener A1,A2,A3;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	
	
	public Login(){
		
		final JFrame jf =new JFrame();
		
		Container con =jf.getContentPane();
		
		jf.setSize(500, 400);
		jf.getContentPane().setLayout(new GridLayout(4,1));
		jf.setDefaultCloseOperation(0);
		
		A1 =new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Uname = jtf.getText();
				char[] pa =jpf.getPassword();
				String passw ="";
				for(int i = pa.length;i>0;i--){//java的密码是倒序存在char【】里边的
					passw = pa[i-1]+passw;
				}
				//System.out.println(passw);
				
				if(Uname!=""&&passw!=""){
					loginsql l = new loginsql();
					System.out.println(l.login(Uname,passw));
					jf.setVisible(false);
					if(l.login(Uname,passw)==1){
					frame fr = new frame();
					}else{
						jf.setVisible(true);
						System.out.println("Wrong password");
					}
					
					
				}
				
			}
		};
		
		A2 =new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String Uname = jtf.getText();
				char[] pa =jpf.getPassword();
				String passw ="";
				for(int i = pa.length;i>0;i--){//java的密码是倒序存在char【】里边的
					passw = pa[i-1]+passw;
				}
				//System.out.println(passw);
				
				if(Uname!=""&&passw!=""){
					register r = new register();
					int rs = r.registersql(Uname, passw);
					System.out.println(rs);
					jf.setVisible(false);
					if(rs==2){ 
					frame fr = new frame();//可以加上用户的id了
					}else{
						jf.setVisible(true);
						System.out.println("Wrong password");
					}
					
					
				}
				
				
			}
			
			
		};
		
		
		p1 =new JPanel();
		p2 =new JPanel();
		p3 =new JPanel();
		p4= new JPanel();
		
		
		l1=new JLabel("Username:");
		l1.setFont(new Font("Cambria", Font.PLAIN, 13));
		l1.setBounds(83, 10, 81, 33);
		jtf=new JTextField(20);
		jtf.setBounds(170, 16, 126, 21);
		p1.setLayout(null);
		p1.add(l1);
		p1.add(jtf);
		
		
		
		
		l2=new JLabel("password:");
		l2.setBounds(85, 10, 80, 32);
		jpf=new JPasswordField(18);
		jpf.setBounds(172, 16, 114, 21);
		p2.setLayout(null);
		p2.add(l2);
		p2.add(jpf);
		
	
		//p4 is icon
		
		con.add(p4);
		p4.setLayout(null);
		
		
		lblNewLabel = new JLabel("\u4F60\u753B\u6211\u731C");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(161, 10, 133, 50);
		p4.add(lblNewLabel);
		con.add(p1);
		con.add(p2);
		con.add(p3);
		p3.setLayout(null);
		
		btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(A1);
		btnNewButton.setBounds(61, 21, 93, 23);
		p3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setBounds(177, 21, 93, 23);
		p3.add(btnNewButton_1);
		btnNewButton_1.addActionListener(A2);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		btnNewButton_2.setBounds(290, 21, 93, 23);
		p3.add(btnNewButton_2);
		
		JLabel lblVarsion = new JLabel("Varsion 3.0");
		lblVarsion.setBounds(347, 50, 77, 15);
		p3.add(lblVarsion);
		
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		
		jf.setVisible(true);
		
	}
	public static void main(String[] agrs){
		Login lg = new Login();
		
		
		
		
	}
	
	
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
}
