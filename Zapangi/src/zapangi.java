import java.util.Scanner;

public class zapangi {
	
	static Scanner scan = new Scanner(System.in);
	
	final static int COKE = 600; // int 앞에 static이 붙으면 클래스 변수
	final static int FANTA = 550; // final 이 붙으면 상수로
	final static int COFFEE = 370;
	final static int WATER = 420;
	
	final static String D1 = "콜라";
	final static String D2 = "환타";
	final static String D3 = "커피";
	final static String D4 = "물";
	
	static int money;
	static int t_money = 0; // 거스름돈 저장
	
	public static void main(String[] args) {
		char exit;
		
		System.out.println("음료수 자판기~~~");
		System.out.println("--------------------");
		System.out.println("1. 콜라(600)  2. 환타(550) 3. 커피(370) 4. 물(420)");
		System.out.println();
		
		money = 0;
		
		while (true) {
			if(money == 0) {
				money = inputCoin();
			}
			
			selectDrink(money);
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
	
	static int inputCoin() {
		System.out.println("금액을 입력하세요 :");
		money = scan.nextInt();
		money += t_money;
		t_money = money;
		return money;
	}
	
	static void selectDrink(int money) {
		int sel; // 지역변수
		System.out.println("음료수를 선택하세요 : ");
		sel = scan.nextInt();
		if (sel < 1 || sel > 4) {
			System.out.println("선택 오류 : 1~4중 다시 선택");
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
				System.out.println("선택 오류");
				break;
			}
		}
	}
	
	static void changePay(int money, int s, String drink) {
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
			System.out.println("뽑으신 음료수는 " + drink + "이며 거스름돈은 " + money + "원 입니다.");
			System.out.print("5000원 : " + m_5000 + ", ");
			System.out.print("1000원 : " + m_1000 + ", ");
			System.out.print("500원 : " + m_500 + ", ");
			System.out.print("100원 : " + m_100 + ", ");
			System.out.print("50원 : " + m_50 + ", ");
			System.out.print("10원 : " + m_10 );
			System.out.println("---------------------------------------------");
			System.out.println();
			
			t_money = money;
		}
	}
}


