package basic;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;










public class frame extends JFrame  {
	
	
	private static int Width=800;
	private static int Height=600;
	int tool;
	//String playname="my";
	
	static JP canvas;
	Chat chat;
	Bartool la;
	TBar Tb;
	
	public frame(){

		la = new Bartool();
		try{
			chat= new Chat();
		
		}
		catch(Exception e){			
			System.out.println("Chat server not found");
		}
		
		Tb=new TBar();
		BorderLayout border =new BorderLayout();
		
		
		
		
		setJMenuBar(Tb);
		FlowLayout flowLayout = (FlowLayout) la.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(5);
		
		
		
		getContentPane().add(la,border.NORTH);
		
		
		
		
		
		getContentPane().add(chat,border.EAST);
		
		
		
		canvas =new JP();
		getContentPane().add(canvas, BorderLayout.CENTER);
		canvas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		
		
		
		
		final JLabel hide = new JLabel("New label");
		getContentPane().add(hide, BorderLayout.SOUTH);
		
	
		
		
		//show the location of mouse
		canvas.addMouseMotionListener(new MouseAdapter(){
			public void mouseMoved(MouseEvent e) {
				
				
				hide.setText("SET:"+"("+e.getX()+","+e.getY()+")");
				
			}
			
		});
		
		la.setBounds(0,0,800,100);
		canvas.setBounds(0,100,600,450);
		
		chat.setBounds(600, 100, 200, 450);
		hide.setBounds(0,500,800,50);
		
		
		
		setSize(Width,Height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	

	public static void main(String[] agrs){
		
		frame fr =new frame();
		
	}


	class TBar extends JMenuBar{
		JMenu file,open,help,edit;
		
		JMenuItem op,ex,sa,saas,co,cu,call;
		
		public TBar(){
			
			file =new JMenu("File");
			
			op =new JMenuItem("open");
			ex =new JMenuItem("exit");
			sa =new JMenuItem("save");
			saas =new JMenuItem("save as");
			
			file.add(op);
			file.add(ex);
			file.add(sa);
			file.add(saas);
			
			sa.setEnabled(false);
			saas.setEnabled(false);
			
			
			edit =new JMenu("Edit");
			
			co =new JMenuItem("copy");
			cu =new JMenuItem("cut");

			edit.add(co);
			edit.add(cu);
			
			
			help =new JMenu("Help");
			
			call =new JMenuItem("Call me");
			
			help.add(call);
			
			
			
			
				
			this.add(file);
			this.add(edit);
			this.add(help);
			
			
			
		}
		
	}
	



	
	








}





 
	 





	
	
	
	


			
	
	
	
	
	
	
	
	
	








