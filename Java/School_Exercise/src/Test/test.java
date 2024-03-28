package Test;


public class test {
	
	public static int exp(int x, int n) {
		if (n == 0) {
			return 1;
		}
		
		int result = exp(x * x, (int)(n/2));
		if (n % 2 == 0) {
			return result;
		}
		else {
			return x * result;
		}
	}
	
	public static void main(String[] args) {
		System.out.print("3 mũ 4 = " + exp(3,4));
	}
}
