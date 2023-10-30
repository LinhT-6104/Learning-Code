#include<iostream>
#include<cmath>
#include<iomanip>

using namespace std;

int giaithua(int a) {
    int result = 1;
    for (int i = 1; i <= a; i++) {
        result *= i;
    }
    return result;
}

int main() {
    int n;
    float x;
    cout << "Nhap n: ";  cin >> n;
    cout << "Nhap x: ";  cin >> x;

    float s = 1;
    for (int i = 1; i <= n; i++) {
        s += pow(x, 2*i+1) / giaithua(2*i+1);
    }

    cout << "S = " << fixed << setprecision(2) << s;
    return 0;
}