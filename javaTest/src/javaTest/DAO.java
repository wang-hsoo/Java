package javaTest;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


public class DAO {
	/*
	 * 1.DB���� �ڵ� �ۼ�
	 * 2. �޼ҵ� �ϼ�
	 * 3. db����: vending
	 * 4.table ����: drink, account, drinksale, op_coin, t_sales
	 */
	
	int[] coins;
	
	 //DB ����
	   public static void main(String[] args) {
	      Connection conn = null;
	      
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vending","root","dhkdgustn1!");
	         System.out.println("DB����");
	         conn.close();
	      } catch (ClassNotFoundException cnfe) {
	         System.out.println("�ش�Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
	      } catch (SQLException se) {
	         System.out.println(se.getMessage());
	      }

	   }
	   
	   //DB�� �ֹ����� ����
	   public void addOrder(Selector order) {
		   
	   }
	   
	   //�⺻ � �ڱ� ���̺�� � �ڱ��� ����
	   public void opCoins() {
		   
	   }
	   
	   //��ü ���� ��Ȳ ���̺�, ���ڱ� + ���� ���� �ݾ� - �ܵ�
	   public void account(int money, int change) {
		   
	   }
	   
	   // �ݾ��� ��� �������� ������
	   public void calCoin(int amt) {
		   
	   }
}
