#include<iostream>
#include<cmath>

using namespace std;

// Ham kiem tra so doi xung
bool sodoixung(int n) {
    if (n < 10) return false;
    else {
        int dx = 0, a = n;
        while (a != 0) {
            dx = dx*10 + a % 10;
            a /= 10;
        }
        if (dx == n) return true;
        return false;
    }
}

// Ham kiem tra so nguyen to
bool songuyento(int n) {
    if (n < 2) return false;
    else {
        for (int i = 2; i <= sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Ham tinh tong so nguyen to nho hon n
int sum_snt(int n) {
    if (n < 2) return 0;
    else {
        int sum = 0;    
        for (int i = 2; i < n; i++) {
            if (songuyento(i)) {
                sum += i;
            }
        }
        return sum;
    }
}

int main() {
    int n;
    do {
        cout << "Nhap n: ";
        cin >> n;
    } while (n < 0 or n > pow(10,5));
    
    // Kiểm tra N có phải là đối xứng không
    if (sodoixung(n)) cout << "N la so doi xung" << endl;
    else cout << "N khong la so doi xung" << endl;
    
    // Kiểm tra N có phải là số nguyên tố không?
    if (songuyento(n)) cout << "N la so nguyen to" << endl;
    else cout << "N khong la so nguyen to" << endl;
    
    // Tính tổng các số nguyên tố nhỏ hơn N
    cout << "Tong cac so nguyen to nho hon n: " << sum_snt(n);
    return 0;
}