package dinkZapangi;

import java.util.Scanner;



public class Selector {
	final static int COKE = 600; // int 앞에 static이 붙으면 클래스 변수
	final static int FANTA = 550; // final 이 붙으면 상수로
	final static int COFFEE = 370;
	final static int WATER = 420;
	
	final static String D1 = "콜라";
	final static String D2 = "환타";
	final static String D3 = "커피";
	final static String D4 = "물";
	
	static Scanner scan = new Scanner(System.in);
	
	static void select(int money) {
		int sel;// 지역변수
		System.out.println("음료수를 선택하세요 : ");
		sel = scan.nextInt();
		if (sel < 1 || sel > 5) {
			System.out.println("선택 오류 : 1~5중 다시 선택");
			select(money);
		} else {
			switch (sel) {
			case 1: {
				Changer.change(money , COKE, D1);
				break;
			}
			case 2: {
				Changer.change(money, FANTA, D2);
				break;
			}
			case 3: {
				Changer.change(money, COFFEE, D3);
				break;
			}
			case 4: {
				Changer.change(money, WATER, D4);
				break;
			}
			case 5:{
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
			default:
				System.out.println("선택 오류");
				break;
			}
		}
	}
	

}
