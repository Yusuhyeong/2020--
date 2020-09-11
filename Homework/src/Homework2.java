import java.util.Scanner;
public class Homework2 {

	public static void main(String[] args) {
		System.out.print("연산>>");
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
				System.out.print("0으로 나눌 수 없습니다.");
				s.close();
				return;
			}
			else
				res=op1/op2;
		}
		else {
			System.out.print("사칙연산이 아닙니다.");
			s.close();
			return;
		}
		System.out.println(op1+op+op2+"의 계산 결과는"+res);
		s.close();

	}

}
