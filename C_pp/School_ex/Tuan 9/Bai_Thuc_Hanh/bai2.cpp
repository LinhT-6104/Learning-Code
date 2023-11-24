#include <iostream>
#include <algorithm>

using namespace std;

class Fracsion {
    private:
        int a,b;
    public: 
        void nhapDuLieu() {
            cout << "Nhap gia tri a: "; 
            cin >> a;
            cout << "Nhap gia tri b: ";
            cin >> b;
            cout << endl;
        }

        int UCLN(int x, int y) {
           while (x != 0) {
            int z = x;
            x = y % x;
            y = z;
           }
           return y;
        }

        void rutGon() {
            int uc = UCLN(a,b);
            a /= uc;
            b /= uc;
        }

        float giaTri() {
            return a/b;
        }

        void hienThi() {
            rutGon();
            cout << a << "/" << b << endl;
        }
};

bool sapXep(Fracsion &so1, Fracsion &so2) {
    return so1.giaTri() < so2.giaTri();
}

int main() {
    int n;
    cout << "Nhap so doi tuong: ";
    cin >> n;

    Fracsion phanSo[n];

    for (int i = 0; i < n; i++) {
        cout << "Nhap thong tin doi tuong " << i + 1 << ":\n";
        phanSo[i].nhapDuLieu();
    }

    sort(phanSo, phanSo + n, sapXep);

    cout << "Cac doi tuong vua nhap:\n";
    for (int i = 0; i < n; i++) {
        cout << "Doi tuong " << i + 1 << endl;
        phanSo[i].hienThi();
        cout << endl;
    }
    return 0;
}