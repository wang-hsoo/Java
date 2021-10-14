package dinkZapangi;
import java.util.Scanner;

public class Screan {
	
	static Scanner scan = new Scanner(System.in);
	static int money;
	static int t_money = 0;
	
	public static void screan() {
		
		char exit;
	
	
		
		while (true) {
			
			System.out.println("음료수 자판기~~~");
			System.out.println("--------------------");
			System.out.println("1. 콜라(600)  2. 환타(550) 3. 커피(370) 4. 물(420) 5. 프로그램 끝내기");
			System.out.println();
			
			
			
			
			if(money == 0) {
				  money = Changer.inputCoin();
				}
			
			
			
			Selector.select(money);
			System.out.println("추가 선택 하시겠습니까(y/n) ? ");
			exit = scan.next().charAt(0);
			
			money = t_money;
			
			if (exit == 'n' || exit == 'N') {
				System.out.println("음료수 선택 종료");
				money = 0;
			}
		}
	}

}
