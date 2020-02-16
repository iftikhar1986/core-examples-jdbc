package com.soft.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.soft.dto.Employee;
import com.soft.service.EmployeeService;

public class EmployeeSearchFrame extends Frame implements ActionListener {
	
	Label l;
	TextField tf;
	Button b;
	
	Employee emp;
	
	public EmployeeSearchFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Employee Search Frame");
		this.setBackground(Color.green);
		this.setLayout(new FlowLayout());
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		l = new Label("Employe Number ");
		tf = new TextField(20);
		b = new Button("SEARCH");
		
	    b.addActionListener(this);
	    
	    Font f = new Font("consolas", Font.BOLD, 15);
	    
	    l.setFont(f);
	    tf.setFont(f);
	    b.setFont(f);
	    
	    this.add(l);this.add(tf);this.add(b);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			int eno = Integer.parseInt(tf.getText());
			EmployeeService empServ = new EmployeeService();
			emp = empServ.search(eno);
			repaint();
			
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
	
	@Override
	public void paint(Graphics g) {
		Font f = new Font("consolas",Font.BOLD,25);
		g.setFont(f);
		
		if (emp == null) {
			g.drawString("Employe Not Existed", 50, 250);
		}else {
			g.drawString("Employe Number : "+emp.getEno(),50,200);
			g.drawString("Employe Name : "+emp.getEname(),50,240);
			g.drawString("Employe Salary : "+emp.getEsal(),50,280);
			g.drawString("Employe Address : "+emp.getEaddr(),50,320 );
		}
		
	}

}
