package dinkZapangi;
import java.util.Scanner;

public class Screan {
	
	static Scanner scan = new Scanner(System.in);
	static int money;
	static int t_money = 0;
	
	public static void screan() {
		
		char exit;
	
	
		
		while (true) {
			
			System.out.println("����� ���Ǳ�~~~");
			System.out.println("--------------------");
			System.out.println("1. �ݶ�(600)  2. ȯŸ(550) 3. Ŀ��(370) 4. ��(420) 5. ���α׷� ������");
			System.out.println();
			
			
			
			
			if(money == 0) {
				  money = Changer.inputCoin();
				}
			
			
			
			Selector.select(money);
			System.out.println("�߰� ���� �Ͻðڽ��ϱ�(y/n) ? ");
			exit = scan.next().charAt(0);
			
			money = t_money;
			
			if (exit == 'n' || exit == 'N') {
				System.out.println("����� ���� ����");
				money = 0;
			}
		}
	}

}
