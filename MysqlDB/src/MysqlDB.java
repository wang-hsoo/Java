import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


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
 * 3. next �޼ҵ� ȣ�� ���������� �ű��
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
	
	public void sqlSelect() {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("��ȸ�� ��ǰ�� �Է�: ");
		String choice = scan.next();
		
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn = DBconn.getMyConnection();
			
			//stmt = conn.createStatement();
			String query = "select * from goodsinfo where name = ? ;";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, toLatin1(choice));
			ResultSet rs = pstmt.executeQuery();
			
			
			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t ���� ������");
			System.out.println("------------------------------------------");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, toUnicode(name), price, toUnicode(maker));
				
			}
			
			}catch (SQLException se) {
			// TODO: handle exception
			System.out.println(se.getMessage());
			}
		
			finally {
				try {
					pstmt.close();
				} catch (Exception ignored) {
					// TODO: handle exception
				}
				try {
					conn.close();
				} catch (Exception ignored) {
					// TODO: handle exception
				}
			}
		
			
	}
	
//	private static String toUnicode(String str) {
//		try {
//			byte[] b = str.getBytes("EUC-KR");
//			return new String(b);
//		} catch (java.io.UnsupportedEncodingException uee) {
//			// TODO: handle exception
//			System.out.println(uee.getMessage());
//			return null;
//		}
//		
//	}
//	
//	private static String toLatin(String str) {
//		try {
//			byte[] b = str.getBytes();
//			return new String(b, "EUC-KR");
//		} catch (java.io.UnsupportedEncodingException uee) {
//			// TODO: handle exception
//			System.out.println(uee.getMessage());
//			return null;
//		}
//		
//	}
	
	
	
	
	/*
	 * �������� �Է�/����/����
	 * 1. Statement ��ü�� ��´� -> PreparedStatement��ü�� ��ȯ
	 * 		Statement stmt = conn.createStatement();
	 * 
	 * 
	 * 2. ExecuteUpdate() �޼ҵ� ȣ��
	 * 		int rowNum = stmt.excuteUpdate("insert goodsinfo(code, name, price, maker) values ('10006', '�̴Ͽ���', 170000, '����');")
	 * 
	 * 
	 */
	
	
	public void sqlInsert() {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �ڵ��Է�: ");
		String codeIn = scan.next();
		System.out.println("������ ��ǰ�Է�: ");
		String nameIn = scan.next();
		System.out.println("������ �����Է�: ");
		int priceIn = scan.nextInt();
		System.out.println("������ ������ �Է�: ");
		String makerIn = scan.next();
		
		
		try {
			conn = DBconn.getMyConnection();
			//stmt = conn.createStatement();
			
			String query = "insert into goodsinfo(code, name, price, maker) values(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, toLatin1(codeIn));
			pstmt.setString(2, toLatin1(nameIn));
			pstmt.setInt(3, priceIn);
			pstmt.setString(4, toLatin1(makerIn));
			int rowNum = pstmt.executeUpdate();
			
			System.out.println(rowNum + "���� �߰��Ǿ���.");
			
			sqlSelect();
			
//			System.out.println("----------------------------�Է� �� ��ȸ---------------------------");
//			
//			
//			ResultSet rs = pstmt.executeQuery("select * from goodsinfo;");
//			
//			
//			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t ���� ������");
//			System.out.println("------------------------------------------");
//			
//			while(rs.next()) {
//				String code = rs.getString("code");
//				String name = rs.getString("name");
//				int price = rs.getInt("price");
//				String maker = rs.getString("maker");
//				System.out.printf("%8s %s \t%12d %s%n", code, toUnicode(name), price, toUnicode(maker));
//				
//			}
			
			
		}catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
		finally {
			try {
				pstmt.close();
			} catch (Exception ignored) {
				
			}
			
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	private static String toLatin1(String str) {
		try {
			byte[] b = str.getBytes();
			return new String(b, "UTF-8");
		} catch (java.io.UnsupportedEncodingException uee) {
			System.out.println(uee.getMessage());
			return null;
		}
	}
	
	private static String toUnicode(String str) {
		try {
			byte[] b = str.getBytes("UTF-8");
			return new String(b);
		} catch (java.io.UnsupportedEncodingException uee) {
			System.out.println(uee.getMessage());
			return null;
		}
	}

	/*
	public void sqlSelect() {
		Connection conn = null;
		Statement stmt = null;
		
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
				System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
			}catch (SQLException se) {
				System.out.println(se.getMessage());
			}
			
			finally {
				try {
					stmt.close();
				} catch (Exception ignored) {
					
				}
				
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
	}
	
	public void sqlInsert() {
		Connection conn = null;
		Statement stmt = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("������ �ڵ��Է�: ");
		String codeIn = scan.next();
		System.out.println("������ ��ǰ�Է�: ");
		String nameIn = scan.next();
		System.out.println("������ �����Է�: ");
		int priceIn = scan.nextInt();
		System.out.println("������ ������ �Է�: ");
		String makerIn = scan.next();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb", "root", "dhkdgustn1!");
			stmt = conn.createStatement();
			
			int rowNum = stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('" + 
												toLatin1(codeIn) + "', '" + 
												toLatin1(nameIn) + "', " + 
												priceIn + ", '" +
												toLatin1(makerIn) + "');");
			System.out.println(rowNum + "���� �߰��Ǿ���.");
			
			sqlSelect();
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("�ش� Ŭ������ ã�� �� �����ϴ�." + cnfe.getMessage());
		}catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		
		finally {
			try {
				stmt.close();
			} catch (Exception ignored) {
				
			}
			
			try {
				conn.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	private static String toLatin1(String str) {
		try {
			byte[] b = str.getBytes();
			return new String(b, "UTF-8");
		} catch (java.io.UnsupportedEncodingException uee) {
			System.out.println(uee.getMessage());
			return null;
		}
	}
	
	private static String toUnicode(String str) {
		try {
			byte[] b = str.getBytes("UTF-8");
			return new String(b);
		} catch (java.io.UnsupportedEncodingException uee) {
			System.out.println(uee.getMessage());
			return null;
		}
	}
	*/
	
//	public void sqlSelect() {
//		Connection conn = null;
//		Statement stmt = null;
//		
//		try {
//			conn = DBconn.getMyConnection();
//			stmt = conn.createStatement();
//			
//			ResultSet rs = stmt.executeQuery("select * from goodsinfo;");
//			
//			
//			System.out.println("��ǰ�ڵ� ��ǰ�� \t\t ���� ������");
//			System.out.println("------------------------------------------");
//			
//			while(rs.next()) {
//				String code = rs.getString("code");
//				String name = rs.getString("name");
//				int price = rs.getInt("price");
//				String maker = rs.getString("maker");
//				System.out.printf("%8s %s \t%12d %s%n", code, toUnicode(name), price, toUnicode(maker));
//				
//			}
//			}
//			catch (SQLException se) {
//				System.out.println(se.getMessage());
//			}
//			
//			finally {
//				try {
//					stmt.close();
//				} catch (Exception ignored) {
//					
//				}
//				
//				try {
//					conn.close();
//	 			} catch (Exception e) {
//					// TODO: handle exception
//				}
//			}
//	}
//	
//	public void sqlInsert() {
//		Connection conn = null;
//		Statement stmt = null;
//		Scanner scan = new Scanner(System.in);
//		
//		System.out.println("������ �ڵ��Է�: ");
//		String codeIn = scan.next();
//		System.out.println("������ ��ǰ�Է�: ");
//		String nameIn = scan.next();
//		System.out.println("������ �����Է�: ");
//		int priceIn = scan.nextInt();
//		System.out.println("������ ������ �Է�: ");
//		String makerIn = scan.next();
//		
//		
//		try {
//			conn = DBconn.getMyConnection();
//			stmt = conn.createStatement();
//			
//			int rowNum = stmt.executeUpdate("insert into goodsinfo(code, name, price, maker) values('" + 
//												toLatin1(codeIn) + "', '" + 
//												toLatin1(nameIn) + "', " + 
//												priceIn + ", '" +
//												toLatin1(makerIn) + "');");
//			System.out.println(rowNum + "���� �߰��Ǿ���.");
//			
//			sqlSelect();
//			
//		} catch (SQLException se) {
//			System.out.println(se.getMessage());
//		}
//		
//		finally {
//			try {
//				stmt.close();
//			} catch (Exception ignored) {
//				
//			}
//			
//			try {
//				conn.close();
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//	
//	private static String toLatin1(String str) {
//		try {
//			byte[] b = str.getBytes();
//			return new String(b, "UTF-8");
//		} catch (java.io.UnsupportedEncodingException uee) {
//			System.out.println(uee.getMessage());
//			return null;
//		}
//	}
//	
//	private static String toUnicode(String str) {
//		try {
//			byte[] b = str.getBytes("UTF-8");
//			return new String(b);
//		} catch (java.io.UnsupportedEncodingException uee) {
//			System.out.println(uee.getMessage());
//			return null;
//		}
//	}
	
	 
}