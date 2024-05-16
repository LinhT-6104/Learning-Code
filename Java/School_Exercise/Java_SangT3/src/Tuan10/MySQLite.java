package Tuan10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class MySQLite {
	private Connection connection;
	private Statement statement;
	private ArrayList<Employee> listEmps;
	
	public MySQLite() {
		this.connection = null;
		this.statement = null;
		this.listEmps = null;
	}
	
	public void writeDB(String query, String pathDB) {
		try {
			Class.forName("org.sqlite.jdbc");
			this.connection = DriverManager.getConnection(pathDB);
			this.statement = connection.createStatement();
			this.statement.executeUpdate(pathDB);
			this.statement.close();
			this.connection.close();
			System.out.println("Cập nhật thành công: " + pathDB);
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	public ResultSet readDB(String query, String pathDB) {	// hàm readDB() thực hiện câu lệnh truy vấn không làm thay đổi CSDL (Đọc CSDL)
		ResultSet resultSet = null;
		try {
			// Khởi tạo JDBC class
			Class.forName("org.sqlite.JDBC");
			// Mở kết nối đến CSDL SQLite
			Connection connect = DriverManager.getConnection("jdbc:sqlite:" + pathDB);
			
			Statement stmt = connect.createStatement();
			// Kết quả trả về của câu truy vấn là 1 ResultSet
			resultSet = stmt.executeQuery(query);
			
			System.out.println("Read DB successfully: " + pathDB);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return resultSet;
	}
}
