package Tuan5;

public class NapChong {
	public int tinhTong(int num1, int num2) {
		return num1 + num2;
	}
	
	public int tinhTong(int num1, int num2, int num3) {
		return tinhTong(tinhTong(num1, num2), num3);
	}
	
	public double tinhTong(double num1, double num2) {
		return num1 + num2;
	} 
	public int tinhTong(int ...numbers) {	// VarArg in Java
		int total = 0;
		for (int x:numbers) {
			total += x;
		}
		return total;
	}
	
	public static void main(String[] args) {
		NapChong napChong = new NapChong();
		System.out.println(napChong.tinhTong(5, 7));
		System.out.println(napChong.tinhTong(5, 7, 9));
		System.out.println(napChong.tinhTong(5.75, 7.25));
		System.out.println(napChong.tinhTong(5,6,7,8,8,99,90,4));
	}
}
