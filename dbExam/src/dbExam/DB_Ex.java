package dbExam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Ex {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//1단계: JDBC 드라이버를 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2단계: DB에 연결
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/malldb","root","dhkdgustn1!");
			
			//3단계: SQL쿼리 또는 실행문(객체 사용)
			System.out.println("DB에 잡석 성공");
			
			//4단계: DB연결 종료(객체 사용 종료)
			conn.close();
 			
		} catch (ClassNotFoundException cnfe) {
			// TODO: handle exception
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			
		} catch (SQLException se) {
			// TODO: handle exception
			System.out.println(se.getMessage());
		}
	}
}
