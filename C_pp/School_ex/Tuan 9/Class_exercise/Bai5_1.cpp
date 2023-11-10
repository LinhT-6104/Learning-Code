#include<iostream>
#include<cmath>

using namespace std;

class DIEM {
private:
    float x, y;

public:
    void nhapToaDo();
    void hienThiKhoangCach();
    void diChuyen();
    void hienThi();
};

void DIEM::nhapToaDo() {
    cout << "Nhap x: ";
    cin >> x;
    cout << "Nhap y: ";
    cin >> y;
}

void DIEM::hienThiKhoangCach() {
    cout << "Khoang cach tu goc toa do toi diem: " << sqrt(x*x + y*y) << endl;
}

void DIEM::diChuyen() {
    float dx, dy;
    cout << "Nhap dx: ";
    cin >> dx;
    cout << "Nhap dy: ";
    cin >> dy;
    x += dx;
    y += dy;
}

void DIEM::hienThi() {
    cout << "[" << x << ", " << y << "]";
}

int main() {
    DIEM toado;
    toado.nhapToaDo();
    toado.hienThiKhoangCach();
    toado.diChuyen();
    toado.hienThi();
    
    return 0;
}
