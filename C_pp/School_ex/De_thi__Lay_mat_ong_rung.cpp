#include<iostream>
#include<algorithm>

using namespace std;

int main() {
    // Nhap so thanh vien trong doan
    int n;
    cout << "Nhap so thanh vien trong doan: ";
    cin >> n;

    // Nhap loi nhuan tung thanh vien va dem so thanh vien co loi nhuan duong
    int tv[n], count = 0;
    for (int i = 0; i < n; i++) {
        cout << "Loi nhuan thanh vien thu " << i + 1 << ": ";
        cin >> tv[i];
        if (tv[i] > 0)  count++;
    }

    cout << "Tong so thanh vien co loi nhuan duong: " << count << endl;

    sort(tv, tv + n, greater<int>());   // Tim loi nhuan cao nhat

    // Dem so luong thanh vien co loi nhuan cao nhat
    count = 0;
    for (int i = 0; i < n; i++) {
        if (tv[i] == tv[0]) count++;
    }

    cout << "So luong thanh vien co loi nhuan cao nhat: " << count;
    return 0;
}