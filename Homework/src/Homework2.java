import java.util.Scanner;
public class Homework2 {

	public static void main(String[] args) {
		System.out.print("����>>");
		Scanner s = new Scanner(System.in);
		int op1=s.nextInt();
		String op = s.next();
		int op2=s.nextInt();
		
		int res=0;
		if(op.equals("+"))
			res=op1+op2;
		else if(op.equals("-"))
			res=op1-op2;
		else if(op.equals("*"))
			res=op1*op2;
		else if(op.equals("/")) {
			if(op2==0) {
				System.out.print("0���� ���� �� �����ϴ�.");
				s.close();
				return;
			}
			else
				res=op1/op2;
		}
		else {
			System.out.print("��Ģ������ �ƴմϴ�.");
			s.close();
			return;
		}
		System.out.println(op1+op+op2+"�� ��� �����"+res);
		s.close();

	}

}
