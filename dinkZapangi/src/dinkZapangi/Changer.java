package dinkZapangi;
import java.awt.desktop.ScreenSleepEvent;
import java.util.Scanner;



public class Changer {
	
	
	static Scanner scan = new Scanner(System.in);

	static int inputCoin() {	
		 
		
		System.out.println("금액을 입력하세요 :");
		Screan.money = scan.nextInt();
		Screan.t_money += Screan.money;
		Screan.money = Screan.t_money;
		
		return Screan.money;
		
	}
	
	
	
	 static void change(int money, int s, String drink) {
		 
		 int tmp;
			int m_5000, m_1000, m_500, m_100, m_50, m_10;
			char sel; // 지역변수
			
			if (money < s) {
				System.out.println("금액이 부족합니다.");
				System.out.println("금액을 더 넣으시겠습니까?");
				sel = scan.next().charAt(0);
				
				if(sel == 'y' || sel == 'Y') {
					inputCoin();
				} else if (sel == 'n' || sel == 'N') {
					System.out.println("거스름돈 반환");
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
				System.out.println("뽑으신 음료수는 " + drink + "이며 거스름돈은 " + money + "원 입니다.");
				System.out.print("5000원 : " + m_5000 + ", ");
				System.out.print("1000원 : " + m_1000 + ", ");
				System.out.print("500원 : " + m_500 + ", ");
				System.out.print("100원 : " + m_100 + ", ");
				System.out.print("50원 : " + m_50 + ", ");
				System.out.print("10원 : " + m_10 );
				System.out.println("---------------------------------------------");
				System.out.println();
				
				Screan.t_money = money;
				
			}
					
		
	}
	

}
