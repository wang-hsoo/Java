package dinkZapangi;
import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;



public class Changer {
	
	
	static Scanner scan = new Scanner(System.in);

	static int inputCoin() {	
		 
		
		System.out.println("�ݾ��� �Է��ϼ��� :");
		Screan.money = scan.nextInt();
		Screan.t_money += Screan.money;
		Screan.money = Screan.t_money;
		
		return Screan.money;
		
	}
	
	
	
	 static void change(int money, int s, String drink) {
		 
		 int tmp;
			int m_5000, m_1000, m_500, m_100, m_50, m_10;
			char sel; // ��������
			
			if (money < s) {
				System.out.println("�ݾ��� �����մϴ�.");
				System.out.println("�ݾ��� �� �����ðڽ��ϱ�?");
				sel = scan.next().charAt(0);
				
				if(sel == 'y' || sel == 'Y') {
					inputCoin();
				} else if (sel == 'n' || sel == 'N') {
					System.out.println("�Ž����� ��ȯ");
					System.out.print("\n");
					
				} else {
					Selector.select(money);
				}
			} else {
				money -= s;
				m_5000 = money / 5000;
				tmp = money % 5000;
				m_1000 = tmp / 1000;
				tmp = tmp % 1000;
				m_500 = tmp / 500;
				tmp = tmp % 500;
				m_100 = tmp / 100;
				tmp = tmp % 100;
				m_50 = tmp / 50;
				tmp = tmp % 50;
				m_10 = tmp / 10;
				
				System.out.println();
				System.out.println("---------------------------------------------");
				System.out.println("������ ������� " + drink + "�̸� �Ž������� " + money + "�� �Դϴ�.");
				System.out.print("5000�� : " + m_5000 + ", ");
				System.out.print("1000�� : " + m_1000 + ", ");
				System.out.print("500�� : " + m_500 + ", ");
				System.out.print("100�� : " + m_100 + ", ");
				System.out.print("50�� : " + m_50 + ", ");
				System.out.print("10�� : " + m_10 );
				System.out.println("---------------------------------------------");
				System.out.println();
				
				Screan.t_money = money;
				
			}
					
		
	}
	

}
