package Tuan5;

public class NapChongMax {
	public int max(int num1, int num2) {
		if (num1 >= num2) { return num1; }
		return num2;
	}
	public int max(int num1, int num2, int num3) {
		return max(max(num1, num2), num3);
	}
	public int max(int ...nums) {
		int maxs = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (maxs < nums[i]) { maxs = nums[i];}
		}
		return maxs;	
	}
	public static void main(String[] args) {
		NapChongMax ncMax = new NapChongMax();
		System.out.println(ncMax.max(5,7));
		System.out.println(ncMax.max(5,7,9));
		System.out.println(ncMax.max(5,6,7,78,8,9));
	}
}