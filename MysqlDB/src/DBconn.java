import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {

	public static Connection getMyConnection() {
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/malldb";
			conn = DriverManager.getConnection(url,  "root", "dhkdgustn1!");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return conn;
	}
}
