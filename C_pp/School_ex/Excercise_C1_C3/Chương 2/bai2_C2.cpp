#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

// Ham tinh s1
float s1(int n) {
    float sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += 1.0 / (i * (i+1));
    }
    return sum;
}

// Ham tinh s2
float s2(int n) {
    float sum = 0, mau = 0;
    for (int i = 1; i <= n; i++) {
        mau += i;
        sum += 1.0 / mau;
    }
    return sum;
}

// Ham tinh s3
int s3(int n, int x) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        sum += pow(x, 2*i);
    }
    return sum;
}

// Ham tinh s4
int s4(int n, int x) {
    int sum = 0;
    for (int i = 0; i <= n; i++) {
        sum += pow(x, 2*i + 1);
    }
    return sum;
}

// Ham tinh s5
float s5(int n, int x) {
    return s1(n) + 2*s2(n) + 3*s3(n, x) + 4*s4(n, x);
}

int main()
{
    int n, x;
    cout << "Nhap n: "; cin >> n;
    cout << "Nhap x: "; cin >> x;
    cout << "s1 = " << fixed << setprecision(3) << s1(n) << endl;
    cout << "s2 = " << fixed << setprecision(3) << s2(n) << endl;
    cout << "s3 = " << s3(n, x) << endl;
    cout << "s4 = " << s4(n, x) << endl;
    cout << "s5 = " << s5(n, x) << endl;
    return 0;
}