package zapangi;
import java.util.Scanner;

public class selectDrink {
	final static int COKE = 600; // int �տ� static�� ������ Ŭ���� ����
	final static int FANTA = 550; // final �� ������ �����
	final static int COFFEE = 370;
	final static int WATER = 420;
	
	final static String D1 = "�ݶ�";
	final static String D2 = "ȯŸ";
	final static String D3 = "Ŀ��";
	final static String D4 = "��";
	
	static Scanner scan = new Scanner(System.in);
	
	static void select(int money, int t_money) {
		int sel;// ��������
		System.out.println("������� �����ϼ��� : ");
		sel = scan.nextInt();
		if (sel < 1 || sel > 5) {
			System.out.println("���� ���� : 1~5�� �ٽ� ����");
			select(money, t_money);
		} else {
			switch (sel) {
			case 1: {
				changePay.change(money, t_money , COKE, D1);
				break;
			}
			case 2: {
				changePay.change(money, t_money, FANTA, D2);
				break;
			}
			case 3: {
				changePay.change(money, t_money, COFFEE, D3);
				break;
			}
			case 4: {
				changePay.change(money, t_money, WATER, D4);
				break;
			}
			case 5:{
				System.out.println("���α׷��� �����մϴ�");
				System.exit(0);
			}
			default:
				System.out.println("���� ����");
				break;
			}
		}
	}
}
