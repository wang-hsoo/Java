import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/*1�ܰ� : JDBC ����̹� �ε�
 * 2�ܰ�: DB ����
 * 3�ܰ�: DB�� �����͸� �аų� ����(�ݺ�����) sql ���� �ۼ�
 * 4�ܰ�: DB���� ����
 * 
 * ������ ��ȸ
 * 1. Statement ��ü�� ��´�
 * 		Statement stmt = conn.createStataement(); 
 * 
 * 2. ExecuteQuery �޼ҵ带 ȣ��
 *  	ResultSet rs = stmt.executeQuery("select * from goodsinfo(���̺� ��)");
 *  
 * 3. next �޼ҵ� ȣ��
 * 		boolean exists = rs.next();
 * 
 * 4. getInt, getString, getFLoat �޼ҵ带 ȣ���Ͽ� Ư�� �÷��� ���� �����´�
 * 		String code = re.getString("code");
 * 		int price = rs.getInt("price");
 * 
 * 	3,4
 * 	while(rs.net) {
 * 
 * 		String code = re.getString("code");
 * 		int price = rs.getInt("price");
 * 		......
 * }
 * 
 * 5. ResultSet ��ü�� ���� close() �޼ҵ� ȣ��
 * 		rs.close();
 * 
 * 6. statement ��ü�� ���� close() �޼ҵ� ȣ��
 * 		stmt.close();
 *
 *
 */

public class MysqlDB {
	
	/*
	 //��ü ������ ��ȸ
	public void sqlSelect() {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		//PreparedStatement
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "root", "dhkdgustn1!");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from goodsinfo;");
			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t ���� ������");
			System.out.println("------------------------------------------");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, toUnicode(name), price, toUnicode(maker));
				
			}
			
			}catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�" + cnfe.getMessage());
			}catch (SQLException se) {
			// TODO: handle exception
			System.out.println(se.getMessage());
			}
		
			finally {
				try {
					stmt.close();
				} catch (Exception ignored) {
					// TODO: handle exception
				}
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		
			
	}*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("��ǰ���Է�");
			return;
		}
		
		Connection conn = null;
		Statement stmt = null;
		//PreparedStatement
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "root", "dhkdgustn1!");
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from goodsinfo where name = '" + toLatin(args[0]) + "';" );
			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t ���� ������");
			System.out.println("------------------------------------------");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, toUnicode(name), price, toUnicode(maker));
				
			}
			
			}catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�" + cnfe.getMessage());
			}catch (SQLException se) {
			// TODO: handle exception
			System.out.println(se.getMessage());
			}
		
			finally {
				try {
					stmt.close();
				} catch (Exception ignored) {
					// TODO: handle exception
				}
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		
			
	}
	
	private static String toUnicode(String str) {
		try {
			byte[] b = str.getBytes("EUC-KR");
			return new String(b);
		} catch (java.io.UnsupportedEncodingException uee) {
			// TODO: handle exception
			System.out.println(uee.getMessage());
			return null;
		}
		
	}
	
	private static String toLatin(String str) {
		try {
			byte[] b = str.getBytes();
			return new String(b, "EUC-KR");
		} catch (java.io.UnsupportedEncodingException uee) {
			// TODO: handle exception
			System.out.println(uee.getMessage());
			return null;
		}
		
	}

}
