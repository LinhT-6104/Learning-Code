#include <iostream>
#include <iomanip>
#include <algorithm>

using namespace std;

class Circle {
    private:
        int x,y,r;
    public:
        void nhap() {
            cout << "Nhap toa do x: ";
            cin >> x;
            cout << "Nhap toa do y: ";
            cin >> y;
            cout << "Nhap ban kinh: ";
            cin >> r;
        }

        float chuVi() {
            return 2 * 3.14 * r;
        }

        float dienTich() {
            return 3.14 * r * r;
        }

        void xuat() {
            cout << "Toa do tam: [" << x << ", " << y << "]\n";
            cout << "Ban kinh: " << r << endl;
            cout << "Chu vi: " << fixed << setprecision(2) << chuVi() << endl;
            cout << "Dien tich: " << fixed << setprecision(2) << dienTich() << endl << endl;
        }
};

bool sapxep(Circle &toaDo1, Circle &toaDo2) {   // Ham sap xem thu tu hinh tron theo chieu tang cua dien tich
    return toaDo1.dienTich() < toaDo2.dienTich();
}

int main() {
    Circle hinhTron[3];
    for (int i = 0; i < 3; i++) {
        cout << "Nhap toa do hinh " << i + 1 << ":\n";
        hinhTron[i].nhap();
        cout << endl;
    }

    sort(hinhTron, hinhTron + 3, sapxep);   // Sap xep hinh tron theo chieu tang dan cua dien tich
    cout << "Thong tin hinh tron:\n\n";   // Hien thi thong tin hinh tron

    for (int i = 0; i < 3; i++) {
        hinhTron[i].xuat();
    }
    return 0;
}