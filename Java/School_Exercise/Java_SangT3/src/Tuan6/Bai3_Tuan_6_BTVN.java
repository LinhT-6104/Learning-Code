package Tuan6;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class User {
	private String username, password;
	
	Scanner sc = new Scanner(System.in);
	
	public User() {
		this.username = this.password = "";
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public void nhapDuLieu() {
		System.out.print("Nhập username: ");
		this.username = sc.nextLine();
		System.out.print("Nhập password: ");
		this.password = sc.nextLine();
	}

	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}

public class Bai3_Tuan_6_BTVN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhập số tài khoản: ");
		int n = Integer.parseInt(sc.next());
		
		HashMap<String, String> Users = new HashMap<>();
		
		// Nhập tài khoản
		for (int i = 0; i < n; i++) {
			User userInfo = new User();
			userInfo.nhapDuLieu();
			String name = userInfo.getUsername();
			String pass = userInfo.getPassword();
			if (Users.containsKey(name)) {
				System.out.print("Username '" + name + "' đã tồn tại, bạn có muốn ghi đè lên username cũ? (Y/N)...");
				char choice = sc.next().charAt(0);
				if (choice == 'y' || choice == 'Y') {
					System.out.print("Ghi đè username '" + name + "', pass cũ: " + Users.get(name) + " => pass mới: " + pass);
					Users.put(name, pass);
				}
			}
			else {
				Users.put(name, pass);				
			}
		}
		
		// In tài khoản
		Set<String> keySet = Users.keySet();
		System.out.print("\nDanh sách tài khoản: ");
		for (String key : keySet) {
			System.out.print(key + " = " + Users.get(key) + " ");
		}	
	}
}