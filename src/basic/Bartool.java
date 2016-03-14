package basic;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.CompoundBorder;


public class Bartool extends JPanel{

	private JToolBar toolBar;
	private Label Time,least;
	private JButton Pen,Eraser,Clean;
	private JPanel	panel_4,panel_5,panel_6,panel_7,panel_8,panel_9,panel_10;
	private JLabel 	Color,Size;
	private Choice choice,choice_1;
	
	public Bartool(){

		toolBar = new JToolBar();
		this.add(toolBar);
		
		Pen = new JButton("Pen");
		toolBar.add(Pen);
		//Pen.addActionListener(this);
		
		
		panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder());
		toolBar.add(panel_4);
		panel_4.setToolTipText("");
		
		panel_6 = new JPanel();
		panel_6.setToolTipText("        ");
		panel_4.add(panel_6);
		
		Color = new JLabel("Color");
		panel_4.add(Color);
		
		choice = new Choice();
		choice.add("Red");
		choice.add("Orange");
		choice.add("Yellow");
		choice.add("Green");
		choice.add("Blue");
		choice.add("Pink");
		choice.add("Purple");
		choice.add("Black");
		panel_4.add(choice);
	
		
		
		Size = new JLabel("Size");
		
			 
		panel_4.add(Size);
		
		
		
		choice_1 = new Choice();
		choice_1.add("1");
		choice_1.add("2");
		choice_1.add("3");
		choice_1.add("4");
		panel_4.add(choice_1);
		
			 
		
		
		
		
		panel_8 = new JPanel();
		panel_8.setToolTipText("        ");
		toolBar.add(panel_8);
		
		Eraser = new JButton("Eraser");
		toolBar.add(Eraser);
		
		panel_9 = new JPanel();
		panel_9.setToolTipText("        ");
		toolBar.add(panel_9);
		
		Clean = new JButton("Clean");
		Clean.addActionListener(new ActionListener(){

			

			public void actionPerformed(ActionEvent e) {
				frame.canvas.canvasClear();
				
			}
			
			
		});
		toolBar.add(Clean);
		
		panel_10 = new JPanel();
		panel_10.setToolTipText("        ");
		toolBar.add(panel_10);
		
		panel_5 = new JPanel();
		
		this.add(panel_5);
		
		Time = new Label("Time:");
		panel_5.add(Time);
		
		least = new Label("");
		panel_5.add(least);
		
		
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
