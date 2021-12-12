package javaTest;
import java.util.Scanner;

public class Changer {
   
   static Scanner scan;
   static int money = 0;
   static int t_money = 0;
   static Zapangi za;
   static DAO db;
   
   public Changer() {
      scan = new Scanner(System.in);
      za = new Zapangi();
      db = new DAO();
      db.opCoins();
   }
   
   public void doBusiness() {
      while (true) {
         if (money == 0) {
            InputCoin();
         }
         
         za.selectDrink(money);
         System.out.println("�߰� ���� �Ͻðڽ��ϱ�?(y/n)");
         char exit = scan.next().charAt(0);
         
         if (exit == 'n' || exit == 'N') {
            System.out.println("�߰� ���Ÿ� ���� �ʽ��ϴ�.");
            break;
         } else if (exit == 'y' || exit == 'Y') {
            za.selectDrink(money);
         }
         money = t_money;
         System.out.println("���� �ܾ� (DoBusiness) : " + money + ", t_money : " + t_money);
      }
   }
   
   static void InputCoin() {
      System.out.println("�ݾ��� �Է��ϼ��� : ");
      int s = scan.nextInt();
      money += s;
      t_money = money;
      System.out.println("���� �ܾ� (InputCoin) : " + money + ", t_money : " + t_money);
   }
   
   static void placeOrder(Selector order) {
      System.out.println(order);
      System.out.println(order.getName() + "�� �ֹ��ϼ̽��ϴ�. �ֹ� �ݾ��� " + order.getPrice() + "�� �Դϴ�.");
      db.addOrder(order);
   }
   
   static void checkM(int money, Selector order) {
      char sel;
      
      if (money < order.getPrice()) {
         System.out.println("������� �� ��ο�");
         System.out.println("�ݾ��� �� �����ðڽ��ϱ�?(y/n)");
         
         sel = scan.next().charAt(0);
         if (sel == 'y' || sel == 'Y') {
            InputCoin();
            money = t_money;
            za.selectDrink(money);
         } else if (sel == 'n' || sel == 'N') {
            System.out.println("���Ǳ� ����");
            System.exit(0);
         }
      } else {
         changePay(money, order);
      }
   }
   
   static void changePay(int money, Selector order) {
      int change = money - order.getPrice();
      
      db.account(money, change);
      
      db.calCoin(change);
      System.out.println();
      System.out.println("-------------------------------------------------------------------");
      System.out.println("�����Ͻ� ����� " + order.getName() + "�̸� �Ž������� " + change + "�� �Դϴ�.");
      System.out.println("10000�� : " + db.coins[0] + ", ");
      System.out.println("5000�� : " + db.coins[1] + ", ");
      System.out.println("1000�� : " + db.coins[2] + ", ");
      System.out.println("500�� : " + db.coins[3] + ", ");
      System.out.println("100�� : " + db.coins[4] + ", ");
      System.out.println("50�� : " + db.coins[5] + ", ");
      System.out.println("10�� : " + db.coins[6]);
      System.out.println("-------------------------------------------------------------------");
      System.out.println();
      t_money = change;
      System.out.println("���� �ܾ�(changePay) : " + money + ", t_money : " + t_money);
   }
}
