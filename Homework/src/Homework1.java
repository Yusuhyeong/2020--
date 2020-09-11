import java.util.Scanner;

public class Homework1 {

	public static void main(String[] args) {
			System.out.println("첫 번째 원의 중심과 반지름 입력>>");
	Scanner s = new Scanner(System.in);
	int x=s.nextInt();
	int x1=s.nextInt();
	double r=s.nextDouble();
	
	System.out.println("두 번째 원의 중심과 반지름 입력>>");
	int y=s.nextInt();
	int y1=s.nextInt();
	double r1=s.nextDouble();
	double distance=0;
	distance = Math.sqrt((x-x1)*(x-x1)+(y-y1)*(y-y1));
	if(distance<=r+r1)
		System.out.println("두 원은 서로 겹친다.");
	else
		System.out.println("두 원은 서로 안겹친다.");
	s.close();


	}

}
