import java.util.Scanner;

public class Homework5_2 {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      
	      double a, c, result;
	      String b; //������
	      System.out.print("����>>");
	      a = sc.nextDouble();
	      b = sc.next();
	      c = sc.nextDouble();
	      
	      if(b.equals("+")) {
	         result = a + c;
	         System.out.print(a+b+c+"�� ��� ����� "+result);
	      }
	      else if(b.equals("-")) {
	         result = a - c;
	         System.out.print(a+b+c+"�� ��� ����� "+result);
	      }
	      else if(b.equals("*")) {
	         result = a * c;
	         System.out.print(a+b+c+"�� ��� ����� "+result);
	      }
	      else if(b.equals("/")) {
	         if(c==0) {
	            System.out.print("0���� ���� �� �����ϴ�.");
	         }
	         else {
	            result = a / c;
	            System.out.print(a+b+c+"�� ��� ����� "+result);
	         }
	      }
	      
	      switch(b) {
	      case "+" :
	         result = a+c;
	         System.out.print(a+b+c+"�� ��� ����� "+result);
	         break;
	      case "-":
	         result = a-c;
	         System.out.print(a+b+c+"�� ��� ����� "+result);
	         break;
	      case "*":
	         result = a*c;
	         System.out.print(a+b+c+"�� ��� ����� "+result);
	         break;
	      case "/":
	         if(c==0) {
	            System.out.print("0���� ���� �� �����ϴ�.");
	            break;
	         }
	         else {
	            result = a / c;
	            System.out.print(a+b+c+"�� ��� ����� "+result);
	            break;
	         }
	      default:
	         System.out.print("�߸� �Է��Ͽ����ϴ�.");
	      }
	      
	      sc.close();
	   }
}
