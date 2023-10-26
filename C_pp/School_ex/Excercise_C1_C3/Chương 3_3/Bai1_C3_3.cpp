#include<iostream>

using namespace std;

// Ham nhap mang 2 chieu
void input(int &dong, int &cot, int a[][100]) {
	cout << "Nhap dong: "; cin >> dong;
	cout << "Nhap cot: "; cin >> cot;
	cout << "Nhap vao ma tran:\n";
	for (int i = 0; i < dong; i++) {
		for (int j =0 ; j < cot; j++) {
			cin >> a[i][j];
		}
	}
	cout << endl;
}

// Hien thi mang vua nhap
void show(int dong, int cot, int a[][100]) {
	cout << "1. Mang vua nhap:\n";
	for (int i = 0; i < dong; i++) {
		for (int j =0 ; j < cot; j++) {
			cout << a[i][j] << "\t";
		}
		cout << endl;
	}
	cout << endl;
}

// Ham dem so lan xuat hien cua 1 so
void count(int dong, int cot, int a[][100]) {
	int so, count = 0;
	cout << "Nhap so can dem: ";	cin >> so;
	for (int i = 0; i < dong; i++) {
		for (int j =0 ; j < cot; j++) {
			if (so == a[i][j])	count++;
		}
	}
	cout << "2. So lan xuat hien cua so " << so << " trong mang la " << count << endl << endl;
}

// Ham tim phan tu lon nhat trong mang
int max_array(int dong, int cot, int a[][100]) {
	int max = a[0][0];
	for (int i = 0; i < dong; i++) {
		for (int j = 0 ; j < cot; j++) {
			if (max < a[i][j]) {
				max = a[i][j];	
			}
		}
	}
	return max;
}
 
// Ham tim phan tu nho nhat trong mang
int min_array(int dong, int cot, int a[][100]) {
	int min = a[0][0];
	for (int i = 0; i < dong; i++) {
		for (int j = 0 ; j < cot; j++) {
			if (min > a[i][j]) {
				min = a[i][j];	
			}
		}
	}
	return min;
}

// Ham hien thi cac so nguyen khac nhau trong mang
bool check_so_khac_nhau(int b, int cot, int a[][100], int d) {	// Ham kiem tra so nguyen khac nhau
	int count = 0;
	for (int i = 0; i <= b; i++) {
		for (int j = 0 ; j <= cot; j++) {
			if (d == a[i][j])	count++;
		}
	}
	if (count != 1) return false;
	return true;
}	

void so_khac_nhau(int dong, int cot, int a[][100]) {	// Ham in ra cac so nguyen khac nhau
	cout << "5. Cac so nguyen khac nhau trong day la: ";
	for (int i = 0; i < dong; i++) {
		for (int j = 0 ; j < cot; j++) {
			if (check_so_khac_nhau(i, cot, a, a[i][j])) {
				cout << a[i][j] << " ";
			}
		}
	}
}

int main() {
	int dong, cot, a[100][100];
	input(dong, cot, a);
	show(dong, cot, a);
	count(dong, cot, a);
	cout << "3. Gia tri lon nhat trong mang la: " << max_array(dong, cot, a) << endl << endl;
	cout << "4. Gia tri nho nhat trong mang la: " << min_array(dong, cot, a) << endl << endl;
	so_khac_nhau(dong, cot, a);
	return 0;
}
