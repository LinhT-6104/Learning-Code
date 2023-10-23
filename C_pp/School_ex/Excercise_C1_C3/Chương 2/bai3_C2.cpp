#include<iostream>
#include<cmath>

using namespace std;

// Ham nhap gia tri
void input(float &r, float &canh_a, float &canh_b, float &canh_c, float &chieu_dai, float &chieu_rong) {
    cout << "Nhap ban kinh hinh tron: ";
    cin >> r;
    cout << "Nhap canh a tam giac: ";
    cin >> canh_a;
    cout << "Nhap canh b tam giac: ";
    cin >> canh_b;
    cout << "Nhap canh c tam giac: ";
    cin >> canh_c;
    cout << "Nhap chieu dai hinh chu nhat: ";
    cin >> chieu_dai;
    cout << "Nhap chieu rong hinh chu nhat: ";
    cin >> chieu_rong;
}

// Tinh dien tich hinh tron
float dientich(float r){
    return r * r * 3.14;
}

// Tinh dien tich tam giac
float dientich(float a, float b, float c) {
    float p = (a+b+c)/2; // Tinh nua chu vi tam giac
    return sqrt(p*(p-a)*(p-b)*(p-c)); // Ap dung cong thuc Heron
}

// Tinh dien tich hinh chu nhat
float dientich(float chieu_dai, float chieu_rong) {
    return chieu_dai * chieu_rong;
}

int main(){
    float r, canh_a, canh_b, canh_c, chieu_dai, chieu_rong;
    input(r, canh_a, canh_b, canh_c, chieu_dai, chieu_rong);
    cout << "Dien tich hinh tron: " << dientich(r) << endl;
    cout << "Dien tich tam giac: " << dientich(canh_a, canh_b, canh_c) << endl;
    cout << "Dien tich hinh chu nhat: " << dientich(chieu_dai, chieu_rong);
    return 0;
}