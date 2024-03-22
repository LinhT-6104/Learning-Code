package Tuan6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(3);
		set.add(5);
		set.add(4);
		
		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
		
}
 	