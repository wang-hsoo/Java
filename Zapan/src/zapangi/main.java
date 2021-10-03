package zapangi;
import java.util.Scanner;


public class main {
	
	static Scanner scan = new Scanner(System.in);
	static changePay  changePay = new changePay();
	static inputcoin inputcoin = new inputcoin();
	static selectDrink selectDrink = new selectDrink();
	
	static int money;
	static int t_money = 0;

	public static void zapan(String[] args)  {
		
		char exit;
		
		System.out.println("음료수 자판기~~~");
		System.out.println("--------------------");
		System.out.println("1. 콜라(600)  2. 환타(550) 3. 커피(370) 4. 물(420)");
		System.out.println();
		
		while (true) {
			if(money == 0) {
				t_money = inputcoin.tMoney();
				money = inputcoin.inputCoin();
				
			}
			
			selectDrink.select(money, t_money);
			System.out.println("추가 선택 하시겠습니까(y/n) ? ");
			exit = scan.next().charAt(0);
			
			money = t_money;
			
			if (exit == 'n' || exit == 'N') {
				System.out.println("음료수 선택 종료");
				break;
			}
			System.out.println();
		}
	}
	
}
