import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/*1단계 : JDBC 드라이버 로드
 * 2단계: DB 연결
 * 3단계: DB에 데이터를 읽거나 쓴다(반복가능) sql 쿼리 작성
 * 4단계: DB연결 종료
 * 
 * 데이터 조회
 * 1. Statement 객체를 얻는다
 * 		Statement stmt = conn.createStataement(); 
 * 
 * 2. ExecuteQuery 메소드를 호출
 *  	ResultSet rs = stmt.executeQuery("select * from goodsinfo(테이블 명)");
 *  
 * 3. next 메소드 호출 다음행으로 옮긴다
 * 		boolean exists = rs.next();
 * 
 * 4. getInt, getString, getFLoat 메소드를 호출하여 특정 컬럼의 값을 가져온다
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
 * 5. ResultSet 객체에 대해 close() 메소드 호출
 * 		rs.close();
 * 
 * 6. statement 객체에 대해 close() 메소드 호출
 * 		stmt.close();
 *
 *
 */

public class MysqlDB {
	
	/*
	 //전체 데이터 조회
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
			System.out.println("상품코드 상품명 \t\t 가격 제조사");
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
			System.out.println("해당 클래스를 찾을 수 없습니다" + cnfe.getMessage());
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
		System.out.println("조회할 상품명 입력: ");
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
			
			
			System.out.println("상품코드 상품명 \t\t 가격 제조사");
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
	 * 데이터의 입력/수정/삭제
	 * 1. Statement 객체를 얻는다 -> PreparedStatement객체로 전환
	 * 		Statement stmt = conn.createStatement();
	 * 
	 * 
	 * 2. ExecuteUpdate() 메소드 호출
	 * 		int rowNum = stmt.excuteUpdate("insert goodsinfo(code, name, price, maker) values ('10006', '미니오븐', 170000, '애플');")
	 * 
	 * 
	 */
	
	
	public void sqlInsert() {
		Connection conn = null;
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("저장할 코드입력: ");
		String codeIn = scan.next();
		System.out.println("저장할 상품입력: ");
		String nameIn = scan.next();
		System.out.println("저장할 가격입력: ");
		int priceIn = scan.nextInt();
		System.out.println("저장할 제조사 입력: ");
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
			
			System.out.println(rowNum + "행이 추가되었다.");
			
			sqlSelect();
			
//			System.out.println("----------------------------입력 후 조회---------------------------");
//			
//			
//			ResultSet rs = pstmt.executeQuery("select * from goodsinfo;");
//			
//			
//			System.out.println("상품코드 상품명 \t\t 가격 제조사");
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
			
			
			System.out.println("상품코드 상품명 \t\t 가격 제조사");
			System.out.println("------------------------------------------");
			
			while(rs.next()) {
				String code = rs.getString("code");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				String maker = rs.getString("maker");
				System.out.printf("%8s %s \t%12d %s%n", code, toUnicode(name), price, toUnicode(maker));
				
			}
			}catch (ClassNotFoundException cnfe) {
				System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
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
		
		System.out.println("저장할 코드입력: ");
		String codeIn = scan.next();
		System.out.println("저장할 상품입력: ");
		String nameIn = scan.next();
		System.out.println("저장할 가격입력: ");
		int priceIn = scan.nextInt();
		System.out.println("저장할 제조사 입력: ");
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
			System.out.println(rowNum + "행이 추가되었다.");
			
			sqlSelect();
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
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
//			System.out.println("상품코드 상품명 \t\t 가격 제조사");
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
//		System.out.println("저장할 코드입력: ");
//		String codeIn = scan.next();
//		System.out.println("저장할 상품입력: ");
//		String nameIn = scan.next();
//		System.out.println("저장할 가격입력: ");
//		int priceIn = scan.nextInt();
//		System.out.println("저장할 제조사 입력: ");
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
//			System.out.println(rowNum + "행이 추가되었다.");
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