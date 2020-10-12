import java.util.*;

public class Homework6 {
	Scanner scan=new Scanner(System.in);
	private String name;
	
	Homework6 (String name) { this.name=name; }
	
	boolean play() {
		System.out.print("["+name+"]:<Enter>");
		scan.nextLine();
		System.out.print("\t");
		int arr[]=new int[3];
		for (int i=0;i<3;i++) {
			arr[i]=(int)(Math.random()*3+1);
			System.out.print(arr[i]+"\t");
		}
		if ((arr[0]==arr[1])&&(arr[0]==arr[2]))
			return true;
		else
			return false;
	}
	
	String getName() { return name; }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("1번째 선수 이름>>");
		Homework6 p1=new Homework6(scan.next());
		System.out.print("2번째 선수 이름>>");
		Homework6 p2=new Homework6(scan.next());
		
		while(true) {
			if (p1.play()) {
				System.out.println(p1.getName()+"님이 이겼습니다!");
				break;
			}
			else
				System.out.println("아쉽군요!");
			if (p2.play()) {
				System.out.println(p2.getName()+"님이 이겼습니다!");
				break;
			}
			else
				System.out.println("아쉽군요!");
		}
		
	}

}