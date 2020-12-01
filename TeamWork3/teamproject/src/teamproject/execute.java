package teamproject;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import com.mysql.jdbc.*;
import com.mysql.cj.jdbc.*;


public class execute extends Frame implements ActionListener{
	
	// mysql�������� �ʱ����� ���
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
			Class.forName(strMySQLDriver); // �α��� ��ư Ŭ���� jdbc ����̹� ���
			con = (Connection) DriverManager.getConnection(url, strUser, strPassword); // mysql ���� ����
			stmt = (Statement) con.createStatement(); // sql���� ���� ���� statement��ü
		} catch(Exception b) {
			System.out.println("db���� ����");
		}
		
		sumit.btn2.addActionListener(this);			// ȸ������ ��Ϲ�ư
		sumit.btn3.addActionListener(this);			// ȸ������ ��ҹ�ư
		log.button3.addActionListener(this);		// ȸ������ ��ư
		log.button1.addActionListener(this);		// �α��� ��ư
		logSub.button1.addActionListener(this);		// ������ư
		logSub.button2.addActionListener(this);		// Ż���ư
		logSub.button3.addActionListener(this);		// �α׾ƿ���ư
		logSub.button4.addActionListener(this);     // �� ���� �� Ȯ�� ����!!
	}
	
	@Override
	public void actionPerformed(ActionEvent e)   {
		
		// ��ư���� ����
		
		Object obj = e.getSource();
		if(obj.equals(log.button3)) {
			sumit.setVisible(true);
		} else if(obj.equals(log.button1)) {
			loginCheck();
			logSub.label1.setText(name + "���� �α����߽��ϴ�.");
			logSub.setTitle(name + "�� ����â");
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
				System.out.println("������ ���̽� ����");
			}
			
		} else if(obj.equals(sumit.btn2)) {
			if(sumit.btn2.getLabel().equals("���")) {
				selectInsert();
				sumit.setVisible(false);
			} else if(sumit.btn2.getLabel().equals("����")) {
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
	
	// ����
	private void selectUpdate() {
		Data d = new Data();
		d.id = sumit.tf_id.getText().trim();
		d.pw = sumit.tf_pass.getText().trim();
		d.name = sumit.tf_name.getText().trim();
		
		String sql = "update users set id='" + d.id + "',pw='" + d.pw + "' where name='" + d.name + "'";
		
		try {
			int rss = stmt.executeUpdate(sql);
			System.out.println(rss + "������Ʈ");
			
			logSub.tex1.setText("������Ʈ �Ϸ�");
			
			sumit.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	// ����
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
			
			System.out.println(rss + "����");
			logSub.tex1.setText("���� �Ϸ�");
		} catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	// �˻�
	void showUpdate() {
		sumit.btn3.setLabel("�������");
		sumit.btn2.setLabel("����");
		
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
				System.out.println(rs + "����");
				
				logSub.tex1.setText("���� �Ϸ�");
			}
		} catch (Exception e) {
			logSub.tex1.setText("���� �� ���� �߻�");
			System.out.println("���� �� ���� �߻� : " + e);
		}
		sumit.tf_name.setEnabled(false);
		sumit.setVisible(true);
	}
	
	// ����
	void selectDelete() {
		String name = logSub.tex1.getText();
		String sql = "delete from users where name = '" + name + "'";
		System.out.println(sql);
		try {
			int rss = stmt.executeUpdate(sql);
			
			logSub.tex1.setText("���� �Ϸ�");
		} catch(Exception e) {
			logSub.tex1.setText("���� �� ���� �߻�");
			System.out.println("���� �� ���� �߻� : " + e);
		}
	}
	
	// �α��� üũ
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
					System.out.println("�½��ϴ�.");
					logSub.setVisible(true);
				}
			}
		} catch (Exception b) {
			b.printStackTrace();
		}
	}
	
	// ����
	public static void main(String[] args) {
		new execute();
	}
}