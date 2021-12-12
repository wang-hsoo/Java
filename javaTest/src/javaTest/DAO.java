package javaTest;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DAO {
	/*
	 * 1.DB연동 코드 작성
	 * 2. 메소드 완성
	 * 3. db생성: vending
	 * 4.table 생성: drink, account, drinksale, op_coin, t_sales
	 */
	
	int[] coins;
	
	 //DB 연동
	   public static void main(String[] args) {
	      Connection conn = null;
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vending","root","dhkdgustn1!");
	         System.out.println("DB접속");
	         conn.close();
	      } catch (ClassNotFoundException cnfe) {
	         System.out.println("해당클래스를 찾을 수 없습니다." + cnfe.getMessage());
	      } catch (SQLException se) {
	         System.out.println(se.getMessage());
	      }

	   }
	   
	   //DB에 주문별로 저장
	   public void addOrder(Selector order) {
		   
	   }
	   
	   //기본 운영 자금 테이블로 운영 자금을 세팅
	   public void opCoins() {
		   
	   }
	   
	   //전체 동전 현황 테이블, 운운영자금 + 현재 투입 금액 - 잔돈
	   public void account(int money, int change) {
		   
	   }
	   
	   // 금액을 모든 동전별로 나누기
	   public void calCoin(int amt) {
		   
	   }
}
