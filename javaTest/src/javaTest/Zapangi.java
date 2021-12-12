package javaTest;
import java.util.Scanner;

public class Zapangi {
	   Scanner scan;
	   Selector order;
	   static Changer biz;
	   
	   public Zapangi() {
	      scan = new Scanner(System.in);
	   }
	   
	   public void show() {  
	      System.out.println("자판기 입니다.");
	      System.out.println("------------------------------------------");
	      System.out.println("1.콜라(600) 2.환타(550) 3.커피(370) 4.물(420)");
	      System.out.println("------------------------------------------");
	      System.out.println();
	   }
	   
	   public void selectDrink(int money) {
	      int sel;
	      System.out.println("음료수를 선택하세요 : ");
	      //문자열에 문자 하나만 받는다. 아스키코드를 뺴줘서 정수로 값을 받는다
	      sel = (int)(scan.next().charAt(0))-48;
	      
	      if (sel < 1 || sel > 4) {
	         System.out.println("음료수를 제대로 고르세요(1~4).");
	         selectDrink(money);
	      } else {
	         order = new Selector(sel);
	         biz.placeOrder(order);
	         biz.checkM(money, order);
	      }
	   }

}
