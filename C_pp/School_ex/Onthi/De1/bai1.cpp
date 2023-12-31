#include <iostream>
#include <cmath>

using namespace std;

void nhapDuLieu(int &n, int &m, int a[][100]) {
    cout << "Nhap n: "; cin >> n;
    cout << "Nhap m: "; cin >> m;
    cout << "Nhap ma tran kich thuoc " << n << "x"<< m << ":\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
}

void hienThi(int n, int m, int a[][100]) {
    cout << "\n- Ma tran vua nhap la:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0 ; j < m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

bool checkCP(int a) {
    int x = sqrt(a);
    return x * x == a;
}

int soLuongSCP(int n, int m, int a[][100]) {
    int count = 0;
    cout << "\n- So luong so chinh phuong trong ma tran la: ";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (checkCP(a[i][j]))   count++;
        }
    }
    return count;
}

int main() {
    // Cau a
    int n, m;
    int a[100][100];
    nhapDuLieu(n, m, a);

    // Cau b
    hienThi(n, m, a);

    // Cau c
    cout << soLuongSCP(n, m, a) << endl;
    return 0;
}