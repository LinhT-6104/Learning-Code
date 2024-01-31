#include <iostream>
#include <algorithm>

using namespace std;

void nhapDuLieu(int &n, int &x, int so[]) {
    cout << "Nhap n: ";
    do {
        cin >> n;
    }   while (n >= 1000);
    
    cout << "Nhap day so: ";
    for (int i = 0; i < n; i++) {
        cin >> so[i];
    }

    cout << "Nhap x: ";
    cin >> x;
}

int main() {
    int n;
    int so[100];
    int x;
    nhapDuLieu(n, x, so);
    cout << "So lan xuat hien x trong day la: " << count(so, so+n, x) << endl;

    return 0;
}