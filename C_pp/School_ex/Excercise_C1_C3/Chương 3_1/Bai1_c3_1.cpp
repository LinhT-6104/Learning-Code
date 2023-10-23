#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;

// Ham input
void input(int &n, int a[]) {
    do {
        cout << "Nhap n: ";
        cin >> n;
    } while (n >= 100);
    cout << "Nhap day so: ";
    for (int i = 0; i < n; i++) {
        cin >> a[i];
    }
    cout << endl;
}

// Ham dua ra day so da nhap
void show(int n, int a[]) {
    cout << "Day so da nhap: ";
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

// Ham liet ke cac gia tri le trong mang
bool check_duplicated(int n, int a[]) { // Ham loai bo cac gia tri le trung lap
    for (int i = 0; i < n; i++) {
        if (a[i] == a[n]) 
            return false;
    }
    return true;
}
void odd_number(int n, int a[]) {
    cout << "Cac gia tri le trong mang: ";
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 != 0 and check_duplicated(i, a)) {
            cout << a[i] << " ";
        }
    }
    cout << endl;
}

// Ham in ra vi tri dau tien cua phan tu lon nhat
int max_number(int n, int a[]) {    // Tim so lon nhat
    int max = a[0];
    for (int i = 0; i < n; i++) {
        if (a[i] >= a[0]) {
            max = a[i];
        }
    }
    return max;
}
int index_max_number(int n, int a[]) {  // Tim vi tri dau tien cua max
    for (int i = 0; i < n; i++) {
        if (a[i] == max_number(n,a)) {
            return i;
        }
    }
}

// Ham dem so phan tu lon nhat
int count_max_number(int n, int a[]) { 
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] == max_number(n,a)) {
            count++;
        }
    }
    return count;
}

// Ham tinh tong cac phan tu la so chinh phuong
bool check_sochinhphuong(int cp) {      // Ham kiem tra so chinh phuong
    int a = sqrt(cp);
    if (pow(a, 2) == cp) 
        return true;
    return false;
}
int sum_sochinhphuong(int n, int a[]) { // Ham tinh tong cac so chinh phuong trong day
    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (check_sochinhphuong(a[i])) {
            sum += a[i];
        }
    }
    return sum;
}

// Ham sap xep mang theo chieu khong giam
void sapxep(int n, int a[]) {
    sort(a, a+n);
    cout << "Mang sau khi sap xep: ";
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
}

int main() {
    int n, a[100]; 
    input(n,a);
    show(n,a);
    odd_number(n,a);
    cout << "Vi tri dau tien cua phan tu lon nhat la: " << index_max_number(n,a) << endl;
    cout << "So phan tu lon nhat la: " << count_max_number(n,a) << endl;
    cout << "Tong so cac so chinh phuong trong day la: " << sum_sochinhphuong(n,a) << endl;
    sapxep(n,a);
    return 0;
}