package zapangi;
import java.util.Scanner;


public class inputcoin {
	
	static Scanner scan = new Scanner(System.in);
	static int money;
	static int t_money = 0;
	
	static int inputCoin() {
		System.out.println("금액을 입력하세요 :");
		money = scan.nextInt();
		return money;
	}
	
	static int tMoney() {
		money += t_money;
		t_money = money;
		
		return t_money;
	}
}
