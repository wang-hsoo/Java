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
	      System.out.println("���Ǳ� �Դϴ�.");
	      System.out.println("------------------------------------------");
	      System.out.println("1.�ݶ�(600) 2.ȯŸ(550) 3.Ŀ��(370) 4.��(420)");
	      System.out.println("------------------------------------------");
	      System.out.println();
	   }
	   
	   public void selectDrink(int money) {
	      int sel;
	      System.out.println("������� �����ϼ��� : ");
	      //���ڿ��� ���� �ϳ��� �޴´�. �ƽ�Ű�ڵ带 ���༭ ������ ���� �޴´�
	      sel = (int)(scan.next().charAt(0))-48;
	      
	      if (sel < 1 || sel > 4) {
	         System.out.println("������� ����� ������(1~4).");
	         selectDrink(money);
	      } else {
	         order = new Selector(sel);
	         biz.placeOrder(order);
	         biz.checkM(money, order);
	      }
	   }

}
