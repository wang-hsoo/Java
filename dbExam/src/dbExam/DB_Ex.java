package dbExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Ex {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//1�ܰ�: JDBC ����̹��� �ε�
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2�ܰ�: DB�� ����
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb","root","dhkdgustn1!");
			
			//3�ܰ�: SQL���� �Ǵ� ���๮(��ü ���)
			System.out.println("DB�� �⼮ ����");
			
			//4�ܰ�: DB���� ����(��ü ��� ����)
			conn.close();
 			
		} catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
			
		} catch (SQLException se) {
			// TODO: handle exception
			System.out.println(se.getMessage());
		}
	}
}
