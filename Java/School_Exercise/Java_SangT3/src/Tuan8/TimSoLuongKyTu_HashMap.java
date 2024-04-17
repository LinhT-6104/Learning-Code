package Tuan8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TimSoLuongKyTu_HashMap {
	public static void main(String[] args) {
		HashMap<String, Integer> hmDemKyTu = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String data = "";
		System.out.println("Nhap 1 chuoi ky tu: ");
		data = sc.nextLine();
		for (int i = 0; i < data.length(); i++) {
			String key = data.charAt(i) + "";
			Integer value = hmDemKyTu.getOrDefault(key, 0);
			hmDemKyTu.put(key, value+1);
		}
		System.out.println("Cac ky tu khac nhau trong chuoi: ");
		for (Map.Entry<String, Integer> item : hmDemKyTu.entrySet()) {
			System.out.println(item.getKey() + "; ");
		}
		for (Map.Entry<String, Integer> item : hmDemKyTu.entrySet()) {
			System.out.println("Co " + item.getValue() + " ky tu '" + item.getKey() + "'");
		}
	}
}
