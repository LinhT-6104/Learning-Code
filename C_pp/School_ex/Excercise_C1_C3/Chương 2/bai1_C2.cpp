#include<iostream>

using namespace std;

// Ham ve tam giac ben trai
void left_triangle(int n) {
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n-i; j++) {
            cout << " ";
        }
        for (int j = 1; j <= i; j++) {
            cout << "* ";
        }
        cout << endl;
    }
}

// Ham ve tam giac ben phai
void right_triangle(int n) {
    left_triangle(n);
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            cout << " ";
        }
        for (int j = n - i; j >= 1; j-- ) {
            cout << "* ";
        }
        cout << endl;
    }
}

int main() {
    int n;
    do {
        cout << "Nhap n: ";
        cin >> n;
    } while (n < 3 or n > 9);
    left_triangle(n);
    cout << endl;
    right_triangle(n);
    return 0;
}