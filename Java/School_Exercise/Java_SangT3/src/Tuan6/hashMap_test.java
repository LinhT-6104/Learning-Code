package Tuan6;

import java.util.HashMap;
import java.util.Set;

public class hashMap_test {
	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(1, "Java");
		hashMap.put(2, "PHP");
		hashMap.put(3, "C++");
		hashMap.put(4, "Python");
		
		Set<Integer> keySet = hashMap.keySet();
		
		for (Integer key: keySet) {
			System.out.println(key + " - " + hashMap.get(key));
		}
	}
}
