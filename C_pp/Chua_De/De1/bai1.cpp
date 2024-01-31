#include <iostream>
#include <cmath>

using namespace std;

void nhapMaTran(int &n, int &m, int a[][100]) {
    cout << "Nhap n: ";
    cin >> n;
    cout << "Nhap m: ";
    cin >> m;
    cout << "Nhap ma tran:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> a[i][j];
        }
    }
}

void hienThi(int n, int m, int a[][100]) {
    cout << "Ma tran vua nhap la:\n";
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

void demSoCP(int n, int m, int a[][100]) {
    int x;
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            x = sqrt(a[i][j]);
            if (x*x == a[i][j])     count++;
        }
    }
    cout << "So luong phan tu cua ma tran la so chinh phuong: " << count;
}

int main() {
    int n, m;
    int a[100][100];
    nhapMaTran(n,m,a);
    hienThi(n, m, a);
    demSoCP(n, m, a);
    return 0;
}