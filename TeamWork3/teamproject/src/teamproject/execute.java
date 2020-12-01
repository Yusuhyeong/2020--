package teamproject;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import com.mysql.jdbc.*;
import com.mysql.cj.jdbc.*;


public class execute extends Frame implements ActionListener{
	
	// mysql연결위해 초기정보 등록
	private String url = "jdbc:mysql://localhost/data";
	private String strUser = "root";
	private String strPassword = "root";
	private String strMySQLDriver = "com.mysql.cj.jdbc.Driver";
	Connection con;
	Statement stmt;
	ResultSet rs;
	String sql;
	
	String id;
	String pass;
	String name;
	
	member sumit = new member();
	Login log = new Login();
	LoginSub logSub = new LoginSub();
	Data d = new Data();
	
	Button ok;
	Label msg;
	Dialog info;
	
	execute(){
		try {
			Class.forName(strMySQLDriver); // 로그인 버튼 클릭시 jdbc 드라이버 등록
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword); // mysql 서버 접속
			stmt = (Statement) con.createStatement(); // sql쿼리 실행 위한 statement객체
		} catch(Exception b) {
			System.out.println("db연결 실패");
		}
		
		sumit.btn2.addActionListener(this);			// 회원가입 등록버튼
		sumit.btn3.addActionListener(this);			// 회원가입 취소버튼
		log.button3.addActionListener(this);		// 회원가입 버튼
		log.button1.addActionListener(this);		// 로그인 버튼
		logSub.button1.addActionListener(this);		// 수정버튼
		logSub.button2.addActionListener(this);		// 탈퇴버튼
		logSub.button3.addActionListener(this);		// 로그아웃버튼
		logSub.button4.addActionListener(this);     // 뭐 먹을 지 확인 시작!!
	}
	
	@Override
	public void actionPerformed(ActionEvent e)   {
		
		// 버튼마다 설정
		
		Object obj = e.getSource();
		if(obj.equals(log.button3)) {
			sumit.setVisible(true);
		} else if(obj.equals(log.button1)) {
			loginCheck();
			logSub.label1.setText(name + "님이 로그인했습니다.");
			logSub.setTitle(name + "님 접속창");
			log.setVisible(false);
		} else if(obj.equals(logSub.button1)) {
			showUpdate();
		} else if(obj.equals(logSub.button2)) {
			selectDelete();
		} else if(obj.equals(logSub.button3)) {
			logSub.setVisible(false);
			log.setVisible(true);
			
			clearText();
		}else if(obj.equals(logSub.button4)) {
			try {
				new DBFrame();
			}
			catch(Exception err){
				System.out.println("데이터 베이스 오류");
			}
			
		} else if(obj.equals(sumit.btn2)) {
			if(sumit.btn2.getLabel().equals("등록")) {
				selectInsert();
				sumit.setVisible(false);
			} else if(sumit.btn2.getLabel().equals("수정")) {
				selectUpdate();
			}
		} else if(obj.equals(sumit.btn3)) {
				sumit.setVisible(false);
		}
	}
	
	private void clearText() {
		log.tex1.setText("");
		log.tex2.setText("");
		sumit.tf_id.setText("");
		sumit.tf_pass.setText("");
		sumit.tf_name.setText("");
		logSub.tex1.setText("");
	}
	
	// 수정
	private void selectUpdate() {
		Data d = new Data();
		d.id = sumit.tf_id.getText().trim();
		d.pw = sumit.tf_pass.getText().trim();
		d.name = sumit.tf_name.getText().trim();
		
		String sql = "update users set id='" + d.id + "',pw='" + d.pw + "' where name='" + d.name + "'";
		
		try {
			int rss = stmt.executeUpdate(sql);
			System.out.println(rss + "업데이트");
			
			logSub.tex1.setText("업데이트 완료");
			
			sumit.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	// 삽입
	private void selectInsert() {
		Data d = new Data();
		PreparedStatement ps = null;
		d.id = sumit.tf_id.getText().trim();
		d.pw = sumit.tf_pass.getText().trim();
		d.name = sumit.tf_name.getText().trim();
		//String sql = "insert into users('" + d.id + "','" + d.pw + "','" + d.name + "')'";
		String sql = "insert into users(" + "id,pw,name)" + "values(?,?,?)";
		
		try {
			
			
			ps = con.prepareStatement(sql);
			ps.setString(1, d.id);
			ps.setString(2, d.pw);
			ps.setString(3, d.name);
			int r = ps.executeUpdate();
			int rss = stmt.executeUpdate(sql);
			
			System.out.println(rss + "삽입");
			logSub.tex1.setText("삽입 완료");
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	// 검색
	void showUpdate() {
		sumit.btn3.setLabel("수정취소");
		sumit.btn2.setLabel("수정");
		
		String name = logSub.tex1.getText();
		String id = sumit.tf_id.getText();
		String pw = sumit.tf_pass.getText();
		String sql = "select * from users where name=" + name + ";";
		
		System.out.println(sql);
		
		try {
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				sumit.tf_id.setText(rs.getString("id"));
				sumit.tf_pass.setText(rs.getString("pw"));
				sumit.tf_name.setText(rs.getString("name"));
				System.out.println(rs + "삭제");
				
				logSub.tex1.setText("수정 완료");
			}
		} catch (Exception e) {
			logSub.tex1.setText("수정 중 예외 발생");
			System.out.println("수정 중 예외 발생 : " + e);
		}
		sumit.tf_name.setEnabled(false);
		sumit.setVisible(true);
	}
	
	// 삭제
	void selectDelete() {
		String name = logSub.tex1.getText();
		String sql = "delete from users where name = '" + name + "'";
		System.out.println(sql);
		try {
			int rss = stmt.executeUpdate(sql);
			
			logSub.tex1.setText("삭제 완료");
		} catch(Exception e) {
			logSub.tex1.setText("삭제 중 예외 발생");
			System.out.println("삭제 중 예외 발생 : " + e);
		}
	}
	
	// 로그인 체크
	void loginCheck() {
		id = log.tex1.getText().trim();
		pass = log.tex2.getText().trim();
		
		String query = "SELECT pw,name FROM users where id = '" + id + "'";
		
		System.out.println(query);
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				name = rs.getString("name");
				if(pass.equals(rs.getString("pw"))) {
					System.out.println("맞습니다.");
					logSub.setVisible(true);
				}
			}
		} catch (Exception b) {
			b.printStackTrace();
		}
	}
	
	// 실행
	public static void main(String[] args) {
		new execute();
	}
}