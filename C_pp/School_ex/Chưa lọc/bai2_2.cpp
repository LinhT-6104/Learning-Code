#include<iostream>
#include<cmath>

using namespace std;

int dem(int m){
    int count = 0;  
    while(m != 0) {
        count++;
        m /= 10;
    }
    return count;
}
string so_cp(int m) {
    int a = (int)sqrt(m);
    if (m == pow(a, 2)) return "true";
        return "false";
}
string so_ngto(int m) {
    for (int i = 2; i <= sqrt(m); i++) {
        if ( m % i == 0) return "false";
    }
    return "true";
}
string so_dxung(int m) {
    int reverse_m = 0, m1 = m;
    while (m1 != 0) {
        reverse_m = reverse_m * 10 + m1 % 10;
        m1 /= 10;
    }
    if (reverse_m == m) return "true";
        return "false";
}

int main(){
    int m;
    cin >> m;
    cout << dem(m) << endl;
    cout << so_cp(m) << endl;
    cout << so_ngto(m) << endl;
    cout << so_dxung(m) << endl;
    return 0;
}