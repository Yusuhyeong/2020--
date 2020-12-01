package teamproject;

import java.awt.*;
import java.awt.event.*;

public class Login extends Frame {
	static Label label1, label2, label3;
	TextField tex1, tex2;
	Button button1, button2, button3;
	public String id1, pw1;
	
	Login(){
		Panel p1 = new Panel();
		p1.setLayout(new FlowLayout());
		Panel p2 = new Panel();
		p2.setLayout(new GridLayout(2,2,1,5));
		button1 = new Button("로그인");
		button2 = new Button("취소");
		button3 = new Button("회원가입");
		
		p1.add(button1);
		p1.add(button2);
		p1.add(button3);
		
		label1 = new Label("ID");
		label1.setSize(10,10);
		
		p2.add(label1);
		
		tex1 = new TextField();
		tex1.setSize(10,10);
		
		p2.add(tex1);
		
		label2 = new Label("PW");
		label2.setSize(10,10);
		
		p2.add(label2);
		
		tex2 = new TextField();
		tex2.setSize(10,10);
		
		p2.add(tex2);
		
		Panel p3 = new Panel();
		p3.setLayout(new FlowLayout());
		label3 = new Label("로그인");
		p3.add(label3);
		
		setTitle("java");
		setSize(250,250);
		setVisible(true);
		setLayout(new BorderLayout());
		
		add(p1, BorderLayout.SOUTH);
		add(p2);
		add(p3,BorderLayout.NORTH);
		addWindowListener(new WindowHandler());
		setLocationRelativeTo(null); 
	}
}

class WindowHandler extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}