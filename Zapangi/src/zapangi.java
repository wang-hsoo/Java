import java.util.Scanner;

public class zapangi {
	
	static Scanner scan = new Scanner(System.in);
	
	final static int COKE = 600; // int �տ� static�� ������ Ŭ���� ����
	final static int FANTA = 550; // final �� ������ �����
	final static int COFFEE = 370;
	final static int WATER = 420;
	
	final static String D1 = "�ݶ�";
	final static String D2 = "ȯŸ";
	final static String D3 = "Ŀ��";
	final static String D4 = "��";
	
	static int money;
	static int t_money = 0; // �Ž����� ����
	
	public static void main(String[] args) {
		char exit;
		
		System.out.println("����� ���Ǳ�~~~");
		System.out.println("--------------------");
		System.out.println("1. �ݶ�(600)  2. ȯŸ(550) 3. Ŀ��(370) 4. ��(420)");
		System.out.println();
		
		money = 0;
		
		while (true) {
			if(money == 0) {
				money = inputCoin();
			}
			
			selectDrink(money);
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
	
	static int inputCoin() {
		System.out.println("�ݾ��� �Է��ϼ��� :");
		money = scan.nextInt();
		money += t_money;
		t_money = money;
		return money;
	}
	
	static void selectDrink(int money) {
		int sel; // ��������
		System.out.println("������� �����ϼ��� : ");
		sel = scan.nextInt();
		if (sel < 1 || sel > 4) {
			System.out.println("���� ���� : 1~4�� �ٽ� ����");
			selectDrink(money);
		} else {
			switch (sel) {
			case 1: {
				changePay(money, COKE, D1);
				break;
			}
			case 2: {
				changePay(money, FANTA, D2);
				break;
			}
			case 3: {
				changePay(money, COFFEE, D3);
				break;
			}
			case 4: {
				changePay(money, WATER, D4);
				break;
			}
			default:
				System.out.println("���� ����");
				break;
			}
		}
	}
	
	static void changePay(int money, int s, String drink) {
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
				System.exit(0);
			} else {
				selectDrink(money);
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
			
			t_money = money;
		}
	}
}


