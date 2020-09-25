import java.util.Scanner;


public class Homework4
{
    public static void main(String[] args)
    {
        Concent c = new Concent();
        int choice;
        while(true)
        {
            System.out.println("예약(1), 조회(2), 취소(3), 끝내기(4) >>");
            Scanner s = new Scanner(System.in);
            try
            {
                choice = Integer.parseInt( s.nextLine() );
                if( choice < 1 || choice > 4 )
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("잘못선택 하였습니다 다시 선택 하여 주세요");
                continue;
            }
            switch(choice)
            {
                case 1 : c.reserve();break;
                case 2 : c.SeatsAll();break;
                case 3 : System.out.print("이름>>");
                         String name = s.nextLine();
                         if(c.cancle(name)) System.out.println("예약을 취소되었습니다.");
                         else System.out.println("예약된 이름이 없습니다.");
                         break;
                case 4 : return;
            }
        }
    }
}

class Concent
{
    String[][] seats = new String[3][10];
    public Concent()
    {
        for(int i = 0; i <3; i++)
        {   
            for(int j = 0; j < 10; j ++)
            {
                seats[i][j] = "___";
            }
        }
    }
    public void reserve ()
    {
        int seat;
        while(true)
        {
            System.out.println("좌석구분 S석(1), A석(2), B석(3) >>");
            Scanner s = new Scanner(System.in);
            try
            {
                seat = Integer.parseInt( s.nextLine() );
                if( seat < 1 || seat > 3 )
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("잘못선택 하였습니다 다시 선택 하여 주세요.");
                continue;
            }
            printSeats(seat-1);
            System.out.print("이름>> ");
            String name = s.nextLine();
            if(Name(name));
            else { System.out.println("이미 예약된 이름입니다."); continue;}
            System.out.println("좌석 번호>>");
            int num = s.nextInt();
            try
            {
                if(num < 1 || num>10)
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("좌석은 1번부터 10번까지 있습니다.");
                continue;
            }
            if( Num(seat-1, num-1, name) )
            {
                System.out.println("<<예약을 완료하였습니다.>>");
            }
            else
            {
                System.out.println("<<이미 예약된 좌석입니다.>>");
                continue;
            }
            break;
           
        }
    }
    public boolean Name(String name)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(seats[i][j].equals(name))return false;
            }
        }
        return true;
    }
    public void printSeats(int seat)
    {
        String L = null;
        switch (seat)
        {
            case 0 : L = "S석"; break;
            case 1 : L = "A석"; break;
            case 2 : L = "B석"; break;
        }
        System.out.print(L + ">> ");
        for(int i=0 ; i<10 ; i++)
        {
            System.out.print( seats[seat][i] + " ");
        }
        System.out.println();
    }
    public boolean Num(int seat, int num, String name)
    {
        if( seats[seat][num].equals("___") )
        {
            seats[seat][num] = name;
            return true;
        }
        else
        {
            return false;
        }
    }
    public void SeatsAll()
    {
        for(int i = 0; i < 3; i++) printSeats(i);
    }
    public boolean cancle(String name)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(seats[i][j].equals(name))
                {
                    seats[i][j] = "___";
                    return true;
                }
            }
        }
        return false;
    }
}