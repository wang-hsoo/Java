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
         System.out.println("추가 선택 하시겠습니까?(y/n)");
         char exit = scan.next().charAt(0);
         
         if (exit == 'n' || exit == 'N') {
            System.out.println("추가 구매를 하지 않습니다.");
            break;
         } else if (exit == 'y' || exit == 'Y') {
            za.selectDrink(money);
         }
         money = t_money;
         System.out.println("현재 잔액 (DoBusiness) : " + money + ", t_money : " + t_money);
      }
   }
   
   static void InputCoin() {
      System.out.println("금액을 입력하세요 : ");
      int s = scan.nextInt();
      money += s;
      t_money = money;
      System.out.println("현재 잔액 (InputCoin) : " + money + ", t_money : " + t_money);
   }
   
   static void placeOrder(Selector order) {
      System.out.println(order);
      System.out.println(order.getName() + "을 주문하셨습니다. 주문 금액은 " + order.getPrice() + "원 입니다.");
      db.addOrder(order);
   }
   
   static void checkM(int money, Selector order) {
      char sel;
      
      if (money < order.getPrice()) {
         System.out.println("음료수가 더 비싸요");
         System.out.println("금액을 더 넣으시겠습니까?(y/n)");
         
         sel = scan.next().charAt(0);
         if (sel == 'y' || sel == 'Y') {
            InputCoin();
            money = t_money;
            za.selectDrink(money);
         } else if (sel == 'n' || sel == 'N') {
            System.out.println("자판기 종료");
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
      System.out.println("선택하신 음료는 " + order.getName() + "이며 거스름돈은 " + change + "원 입니다.");
      System.out.println("10000원 : " + db.coins[0] + ", ");
      System.out.println("5000원 : " + db.coins[1] + ", ");
      System.out.println("1000원 : " + db.coins[2] + ", ");
      System.out.println("500원 : " + db.coins[3] + ", ");
      System.out.println("100원 : " + db.coins[4] + ", ");
      System.out.println("50원 : " + db.coins[5] + ", ");
      System.out.println("10원 : " + db.coins[6]);
      System.out.println("-------------------------------------------------------------------");
      System.out.println();
      t_money = change;
      System.out.println("현재 잔액(changePay) : " + money + ", t_money : " + t_money);
   }
}
