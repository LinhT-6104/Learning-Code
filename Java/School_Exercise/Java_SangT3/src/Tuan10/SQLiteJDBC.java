package Tuan10;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SQLiteJDBC {	// Tạo class SQLiteJDBC giúp kết nối với CSDL
	private Connection connect;	// Connect: Kết nối đến CSDL SQLite
	private Statement stmt;		// Statement: thực hiện câu lệnh truy vấn SQL
	private ArrayList<Employee> listEmployees;
	
	public SQLiteJDBC() {
		this.connect = null;
		this.stmt = null;
		this.listEmployees = null;
	}
	
	public void writeDB(String query, String pathDB) {	// Hàm writeDB() thực hiện câu lệnh truy vấn làm thay đổi CSDL (Ghi CSDL)
		try {
			// Khởi tạo JDBC class
			Class.forName("org.sqlite.JDBC");	
			// Mở kết nối đến CSDL SQLite
			Connection connect = DriverManager.getConnection("jdbc:sqlite: " + pathDB);
			
			Statement stmt = connect.createStatement();
			// Thực hiện câu lệnh truy vấn
			stmt.executeUpdate(query);
			stmt.close();
			
			connect.close();
			System.out.println("Executed query successfully: " + pathDB);
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
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
	
	public ArrayList<Employee> readEmployeeTable(String query, SQLiteJDBC sqLiteJDBC, String DATABASE_PATH) {
		// Đọc dữ liệu trong CSDL
		ResultSet resultSet = sqLiteJDBC.readDB(query, DATABASE_PATH);
		
		ArrayList<Employee> listEmployees = new ArrayList<>();
		Employee emp = null;
		try {	// Đọc dữ liệu trong ResultSet và lưu vào ArrayList
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				String address = resultSet.getString("address");
				float salary = resultSet.getFloat("salary");
				
				emp = new Employee(id, name, age, address, salary);
				listEmployees.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// In ArrayList ra màn hình và trả về kết quả
		// Xuất dữ liệu nhân viên trong CSDL ra màn hình Console
		System.out.println("\n----------Danh sách nhân viên trong CSDL----------\n");
		for (int i = 0; i < listEmployees.size(); i++) {
			System.out.println(listEmployees.get(i));
		}
		return listEmployees;
	}
}
