import java.util.Scanner;


public class Homework4
{
    public static void main(String[] args)
    {
        Concent c = new Concent();
        int choice;
        while(true)
        {
            System.out.println("����(1), ��ȸ(2), ���(3), ������(4) >>");
            Scanner s = new Scanner(System.in);
            try
            {
                choice = Integer.parseInt( s.nextLine() );
                if( choice < 1 || choice > 4 )
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("�߸����� �Ͽ����ϴ� �ٽ� ���� �Ͽ� �ּ���");
                continue;
            }
            switch(choice)
            {
                case 1 : c.reserve();break;
                case 2 : c.SeatsAll();break;
                case 3 : System.out.print("�̸�>>");
                         String name = s.nextLine();
                         if(c.cancle(name)) System.out.println("������ ��ҵǾ����ϴ�.");
                         else System.out.println("����� �̸��� �����ϴ�.");
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
            System.out.println("�¼����� S��(1), A��(2), B��(3) >>");
            Scanner s = new Scanner(System.in);
            try
            {
                seat = Integer.parseInt( s.nextLine() );
                if( seat < 1 || seat > 3 )
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("�߸����� �Ͽ����ϴ� �ٽ� ���� �Ͽ� �ּ���.");
                continue;
            }
            printSeats(seat-1);
            System.out.print("�̸�>> ");
            String name = s.nextLine();
            if(Name(name));
            else { System.out.println("�̹� ����� �̸��Դϴ�."); continue;}
            System.out.println("�¼� ��ȣ>>");
            int num = s.nextInt();
            try
            {
                if(num < 1 || num>10)
                throw new Exception();
            }
            catch(Exception e)
            {
                System.out.println("�¼��� 1������ 10������ �ֽ��ϴ�.");
                continue;
            }
            if( Num(seat-1, num-1, name) )
            {
                System.out.println("<<������ �Ϸ��Ͽ����ϴ�.>>");
            }
            else
            {
                System.out.println("<<�̹� ����� �¼��Դϴ�.>>");
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
            case 0 : L = "S��"; break;
            case 1 : L = "A��"; break;
            case 2 : L = "B��"; break;
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