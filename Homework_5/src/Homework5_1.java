import java.util.Scanner;

public class Homework5_1 {

	  public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      
	      int x1, y1;
	      int x2, y2;
	      double r1, r2, distance;
	      
	      System.out.print("ù��° ���� �߽ɰ� ������ �Է�>>");
	      x1 = sc.nextInt();
	      y1 = sc.nextInt();
	      r1 = sc.nextDouble();
	      System.out.print("�ι�° ���� �߽ɰ� ������ �Է�>>");
	      x2 = sc.nextInt();
	      y2 = sc.nextInt();
	      r2 = sc.nextDouble();
	      
	      distance = Math.sqrt(((x1-x2)*(x1-x2))+((y1-y2)*(y1-y2)));
	      
	      if(distance <= r1+r2) {
	         System.out.print("�� ���� ���� ��ģ��.");
	      }
	      else {
	         System.out.print("�� ���� ���� ��ġ�� �ʴ´�.");
	      }
	      
	      sc.close();
	   }

}
