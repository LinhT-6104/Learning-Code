#include<iostream>
#include<cmath>

using namespace std;

double s1(int n, float x) {
    float s = 0;
    for (int i = 1; i <= n; i++){
        s += pow(x, i) / (i*(i+1));
    }
    return s;
}
double s2(int n) {
    float s = 1, mau = 1;
    for (int i = 1; i <= n; i++) {
        mau *= i;
        s += 1.0 / mau;
    }
    return s;
}
double s3(int n, float x) {
    double s = 0;
    for (int i = 0; i <= n; i++) {
        s += pow(x, 2*i+1);
    }
    return s;
}
double s4(int n, float x) {
    return s1(n, x) + 2*s2(n) + 3*s3(n, x);
}


int main() {
    int n; cin >> n;
    float x; cin >> x;
    cout << s1(n,x) << endl;
    cout << s2(n) << endl;
    cout << s3(n,x) << endl;
    cout << s4(n, x);
    return 0;
}