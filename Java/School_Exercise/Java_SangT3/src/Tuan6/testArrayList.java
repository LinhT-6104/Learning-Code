package Tuan6;

import java.util.ArrayList;

public class testArrayList {
	public static void main(String[] args) {
		ArrayList<String> a = new ArrayList<String>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList c = new ArrayList();
		a.add("Lan");
		b.add(45);
		c.add('7');
		c.add("String");
		
		System.out.println(a.get(0));
		System.out.println(b.get(0));
		System.out.println(c.get(0));
		System.out.println(c.get(1));
	}
}
