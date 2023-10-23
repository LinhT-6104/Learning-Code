#include<iostream>
#include<cmath>

using namespace std;

int main(){
    // Nhap phuong trinh bac 2
    float a,b,c;
    cout << "Cho pt bac 2 dang a*x^2 + b*x + c = 0\n";
    cout << "Nhap gia tri cua a: ";
    cin >> a;
    cout << "Nhap gia tri cua b: ";
    cin >> b;
    cout << "Nhap gia tri cua c: ";
    cin >> c;

    // Giai phuong trinh bac 2
    float denta = b*b - 4*a*c;
    if (a == 0 and b) {
        cout << "Phuong trinh co 1 nghiem x = " << -c / b;
    }
    else if (denta < 0 or (a == 0 and b == 0)) {
        cout << "Phuong trinh bac 2 vo nghiem";
    }
    else if (denta == 0) {
        cout << "Phuong trinh bac 2 co nghiem kep x1 = x2 = " << -b/(2*a);
    } 
    else if (denta > 0) {
        float x1, x2;
        x1 = (-b + sqrt(denta))/(2 * a);
        x2 = (-b - sqrt(denta))/(2 * a);
        cout << "Phuong trinh bac 2 co 2 nghiem phan biet\n";
        cout << "x1 = " << x1 << endl;
        cout << "x2 = " << x2;
    }
    return 0;
}