#include<iostream>

using namespace std;

int main() {
	// Nhap mang 2 chieu
	int dong, cot, a[100][100];
	cout << "Nhap dong: "; cin >> dong;
	cout << "Nhap cot: "; cin >> cot;
	cout << "Nhap vao ma tran:\n";
	for (int i = 0; i < dong; i++) {
		for (int j =0 ; j < cot; j++) {
			cin >> a[i][j];
		}
	}
	
	cout << endl;
	
	// Hien thi mang vua nhap
	for (int i = 0; i < dong; i++) {
		for (int j =0 ; j < cot; j++) {
			cout << a[i][j] << "\t";
		}
		cout << endl;
	}
	
	cout << endl;
	
	// Dem so lan xuat hien cua 1 so
	int so, count = 0;
	cout << "Nhap vao so can dem: "; cin >> so;
	for (int i = 0; i < dong; i++) {
		for (int j =0 ; j < cot; j++) {
			if (so == a[i][j]) {
				count++;	
			}
		}
	}
	cout << "So lan xuat hien cua so " << so << " trong mang la " << count;
	
	cout << endl;
	
	// Tim phan tu lon nhat tron gmang
	return 0;
}
