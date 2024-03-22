package Tuan5;

public class bai5_1_giao_trinh {
	public int max(int x1, int x2) {
		return x1 > x2 ? x1 : x2;
	}
	
	public int max(int x1, int x2, int x3) {
		return max(max(x1, x2), x3);
	}
	
	public int max(int x1, int x2, int x3, int x4) {
		return max(max(x1, x2), max(x3, x4));
	}
	
	public static void main(String[] args) {
		bai5_1_giao_trinh bai5_1 = new bai5_1_giao_trinh();
		System.out.println(bai5_1.max(5,7));
		System.out.println(bai5_1.max(-4, 4, 6));
		System.out.println(bai5_1.max(5, 5, 5));
		System.out.println(bai5_1.max(7, 4, 15, 7));
	}
}
