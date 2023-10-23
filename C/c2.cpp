#include<stdio.h>

int main() {
	int n;
	scanf("%d", &n);
	if (n > 0) {
		printf("n is a positive number");
	} 
	if (n < 0) {
		printf("n is a negative number");
	}
	if (n == 0) {
		printf("n is equal to 0");
	}
	return 0;
}
