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
		
		System.out.println("����� ���Ǳ�~~~");
		System.out.println("--------------------");
		System.out.println("1. �ݶ�(600)  2. ȯŸ(550) 3. Ŀ��(370) 4. ��(420)");
		System.out.println();
		
		while (true) {
			if(money == 0) {
				t_money = inputcoin.tMoney();
				money = inputcoin.inputCoin();
				
			}
			
			selectDrink.select(money, t_money);
			System.out.println("�߰� ���� �Ͻðڽ��ϱ�(y/n) ? ");
			exit = scan.next().charAt(0);
			
			money = t_money;
			
			if (exit == 'n' || exit == 'N') {
				System.out.println("����� ���� ����");
				break;
			}
			System.out.println();
		}
	}
	
}
