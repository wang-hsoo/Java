import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

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
 * 3. next 메소드 호출
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 1) {
			System.out.println("상품명입력");
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
