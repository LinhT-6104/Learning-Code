#include<iostream>
#include<cmath>

using namespace std;

class DIEM {
    private:
        float x, y;
    public:
        void nhapToaDo();
        void tinhKhoangCach();
        void diChuyen();
        void hienThiDiem();
};

void DIEM::nhapToaDo() {
    cout << "Nhap toa do x: ";  cin >> x;
    cout << "Nhap toa do y: ";  cin >> y;
}

void DIEM::tinhKhoangCach() {
    cout << "Khoang cach tu goc toa do toi diem: " << sqrt(x*x + y*y) << endl;
}

void DIEM::diChuyen() {
    float dx,dy;
    cout << "Nhap khoang di chuyen dx: ";   cin >> dx;
    cout << "Nhap khoang di chuyen dy: ";   cin >> dy;
    x += dx;
    y += dy;
}

void DIEM::hienThiDiem() {
    cout << "Toa do diem: " << "[" << x << ", " << y << "]";
}

int main() {
    DIEM toado;
    toado.nhapToaDo();
    toado.tinhKhoangCach();
    toado.diChuyen();
    toado.hienThiDiem();
    return 0;
}