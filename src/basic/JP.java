package basic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JPanel;

import basic.MyPath;



public class JP extends JComponent implements MouseListener,MouseMotionListener {
	//ºÃ≥–∂‘œÛ
	
	
	
	static BufferedImage bimg=new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
	static Graphics2D bg = bimg.createGraphics();
	static int PORT1=8887;
	private Graphics2D g2d;
	
	private boolean dragged;
	boolean a = true;
	boolean start=false;
	float f= 1.0f,nf;
	int x,nx;
	int y,ny;
	int px,npx;
	int py,npy;
	
	
	int whosturn=1;
	Socket s;
	DataOutputStream dosd;
	DataInputStream disd,diswhosturn;
	boolean bConnect = true;
	Color c;
	int intcolor;
	private boolean bConnected;
	
	
	
	public JP() {
		
		
		
		setBackground(Color.white);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.connect();
		RecvDThread RDT =new RecvDThread();
		new Thread(RDT).start();
		start =true;
		
	}
	
		
	
	public void paint(Graphics g){
		if(whosturn==0){
			bg.setStroke(new BasicStroke(3.0f));
			bg.setColor(Color.black);
		
			bg.drawLine(px, py, x, y);
		}if(whosturn==1){
			
			
		}
		
		g2d = (Graphics2D) g;
		g2d.drawImage(bimg, 0, 0, this);
	}
		
	public void canvasClear() {
		BufferedImage bimg=new BufferedImage(600, 450, BufferedImage.TYPE_INT_ARGB);
		Graphics2D bg = bimg.createGraphics();
	}
	public void send(){
		if(whosturn==0){
		try {
			//dos.writeFloat(f);
			//dos.writeInt(intcolor);
			dosd.writeInt(px);
			System.out.println("PX="+px);
			dosd.writeInt(py);
			System.out.println("PY="+py);
			dosd.writeInt(x);
			System.out.println(x);
			dosd.writeInt(y);
			System.out.println(y);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}	
	public void connect(){
		try {
			s=new Socket("127.0.0.1",PORT1);
			dosd = new DataOutputStream(s.getOutputStream());
			disd = new DataInputStream(s.getInputStream());
			diswhosturn =new DataInputStream(s.getInputStream());
			bConnected =true;
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	class RecvDThread implements Runnable{
		
		
		public void run() {
			try {
				whosturn=diswhosturn.readInt();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			while(true){
				
				try {
					npx=disd.readInt();
					npy=disd.readInt();
					nx=disd.readInt();
					ny=disd.readInt();
				
					System.out.println(npx+"  "+npy+"  "+nx+"  "+ny);
					repaint();
					
					
				} catch (IOException e) {
					break;
					
				
				}
			
				
			}
			
			
		}
		}
	
	public void mouseDragged(MouseEvent e) {
		a = true;
		if (a) {
			px = x;
			py = y;
		}
		x = e.getX();
		y = e.getY();
		
		whosturn=0;
		send();
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		
		px = e.getX();
		py = e.getY();
		a = false;
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		px=e.getX();
		py=e.getY();
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	
	
		
}
