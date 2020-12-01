package teamproject;



import java.awt.*;
import java.awt.event.*;


public class member extends Frame {
	// 클래스 내에서 사용될 멤버변수들을 선언하는 부분입니다..
	Panel p1, p2, p3,  p9, p10, pt,tp1,tp2;
	Label la_name, la_id, la_pass,  la_addr,la_title;
	TextField tf_name, tf_id, tf_pass;
	Button btn1, btn2, btn3;
	Choice job;
	Checkbox cb1, cb2;
	CheckboxGroup cbg;
	TextArea ta;

	// 생성자 정의 부분이 되겠습니다.
	member() {

	// 화면배치를 시작하게 되는 부분
	// p1~ p3까지 객체생성을 하면서 FlowLayout을 사용해서 화면배치
	p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
	p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
	p3 = new Panel(new FlowLayout(FlowLayout.LEFT));

	//버튼 패널
	p9 = new Panel();
	p10 = new Panel();

	//북쪽 패널 회원가입
	pt = new Panel();
	//table 패널
	tp1 = new Panel();
	tp2 = new Panel();

	// label들은 각각의 이름을 가진 Label객체들이 생성
	la_name = new Label("이 름");
	la_id = new Label("I D");
	la_pass = new Label("비밀 번호");
	la_title = new Label("회원 가입");

	// 각각 20이라는 길이를 가진채로 TextField 객체가 생성
	tf_name = new TextField(20);
	tf_id = new TextField(20);
	tf_pass = new TextField(20);
	job = new Choice();
	job.add("직업을선택하세요");
	job.add("프로그래머");
	job.add("강사");
	job.add("회사원");
	job.add("연구원");
	job.add("자영업");

	// 버튼 
	btn1 = new Button("아이디중복체크");
	btn2 = new Button();
	btn2.setLabel("등록");
	btn3 = new Button("가입취소");



	// pt부분에 label2를 붙임
	pt.add(la_title);

	//각 라벨들을 왼쪽 패널에 넣어준다. 
	//p1.add(la_name);
	p1.add(tf_name);
	//p2.add(la_id);
	p2.add(tf_id);
	//p3.add(la_pass);
	p3.add(tf_pass);
	//p4.add(la_pass2);


	tp1.setLayout(new GridLayout(8,1));
	tp1.add(la_name);
	tp1.add(la_id);
	tp1.add(la_pass);

	tp2.setLayout(new GridLayout(8,1));
	tp2.add(p1);
	tp2.add(p2);
	tp2.add(p3);

	p9.add(btn2);
	p9.add(btn3);

	add("North",pt);
	add("West",tp1);
	add("Center",tp2);
	add("South",p9);
	// 프레임의 사이즈 setting 부분이 되구요..
	setSize(400, 400);
	// 프레임을 보여줄지 안보이게 숨길지를 setting하는 부분
	setVisible(false);
	// 프레임창 종료 메소드
	
	addWindowListener(new WindowHandler());
	}

	class WindowHandler extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
} 

		 
