package Tuan10;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//import org.sqlite.SQLiteJDBCLoader;

public class learn {
	// Ghi vào CSDL
	public void writeDB(String query, String pathDB) {
		try {
			Class.forName("org.sqlite.JDBC");	// Khởi tạo JDBC class
			Connection connect = DriverManager.getConnection("jdbc:sqlite: " + pathDB);	// Mở kết nối đến CSDL SQLite
			
			Statement stmt = connect.createStatement();
			stmt.executeUpdate(query);	// Thực hiện câu lệnh truy vấn
			stmt.close();
			
			connect.close();
			System.out.println("Executed query successfully: " + pathDB);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// Đọc từ CSDL
	public ResultSet readDB(String query, String pathDB) {
		ResultSet resultSet = null;
		try {
			Class.forName("org.sqlite.JDBC");	// Khởi tạo JDBC class
			Connection connect = DriverManager.getConnection("jdbc:sqlite" + pathDB);	// Mở kết nối đến CSDL SQLite
			
			Statement stmt = connect.createStatement();
			resultSet =stmt.executeQuery(query);	// Kết quả trả về của câu truy vấn là 1 ResultSet
			
			System.out.println("Read DB successfully: " + pathDB);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		return resultSet;
	}
	
	// Xử lý kết quả trả về của CSDL
	public ArrayList<Employee> readEmployeeTable(String query, SQLiteJDBC sqLiteJDBC, String DATABASE_PATH) {
		ResultSet resultSet = sqLiteJDBC.readDB(query, DATABASE_PATH);
		ArrayList<Employee> listEmployees = new ArrayList<>();
		Employee emp = null;
		try {
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				float salary = resultSet.getFloat("Salary");
				
				emp = new Employee(id, name, age, address, salary);
				listEmployees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Xuất dữ liệu nhân viên trong CSDL ra màn hình Console
		System.out.println("\n------------Danh sách nhân viên trong CSDL------------");
		for (int i = 0; i < listEmployees.size(); i++) {
			System.out.println(listEmployees.get(i));
		}
		return listEmployees;
	}
}
