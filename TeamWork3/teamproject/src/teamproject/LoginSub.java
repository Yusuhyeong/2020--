package teamproject;



import java.awt.*;
import java.awt.event.*;

public class LoginSub extends Frame {
	Label label1;
	TextField tex1;
	Button button1, button2, button3, button4;
	Panel p1,p2,p3;
	public String id1, pw1;

	LoginSub() {

		//�г� �ϳ��� ����� .ȯ���Ѵٴ� �ؽ�Ʈ�� �� ���̿��̴�. �������� flowlayout�� ����.
		p1 = new Panel();
		p1.setLayout(new FlowLayout());
		//�г� �ϳ��� �����. ���̾ƿ��� �׸��� ���̾ƿ������ش�. ��ư���� �� ���̾ƿ���
		p2 = new Panel();
		p2.setLayout(new GridLayout(0,3,1,1));

		p3 = new Panel();
		p3.setLayout(new BorderLayout());

		//�� p1�гο� �ְ�
		label1  = new Label();
		label1.setText("aa");
		p1.add(label1);
		//��ư
		button1 = new Button("����");
		button2 = new Button("Ż��");
		button3 = new Button("�α׾ƿ�");
		button4 = new Button("���� �� ����??");
		//��ư�� p2�� �ִ´�.
		p2.add(button1);
		p2.add(button2);
		p2.add(button3);
		//Ÿ��Ʋ 
		tex1= new TextField();
		tex1.setText("");
		p3.add(tex1);
        p3.add(button4, "Center");
		setTitle("ȯ���մϴ�. ");
		setSize(250, 250);
		setVisible(false);
		setLayout(new BorderLayout());
		//p1,p2�� ���� �߰��� �Ʒ��ʿ� �д�. 
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		add(p3, BorderLayout.NORTH);
		addWindowListener(new WindowHandler());
		setLocationRelativeTo(null); 
	
		}


		class WindowHandler extends WindowAdapter {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		}
}