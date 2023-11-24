#include <iostream>
#include <algorithm>
#include <iomanip>

using namespace std;

class Student {
    private:
        string maSV, HoTen;
    public:
        double diemTB;

        void nhapDuLieu() {
            cout << "Nhap ma sinh vien: ";
            cin >> maSV;
            cout << "Nhap ho va ten: ";
            cin.ignore();
            getline(cin, HoTen);
            cout << "Nhap diem trung binh: ";
            cin >> diemTB;
            cout << endl;
        }
        
        void hienThi() {
            cout << "Msv: " << maSV << endl;
            cout << "Ho ten: " << HoTen << endl;
            cout << "Diem trung binh: " << fixed << setprecision(1) << diemTB << endl << endl;
        }
};

bool sapXep(Student &nguoi1, Student &nguoi2) {
    return nguoi1.diemTB >= nguoi2.diemTB;
}

int main() {
    int n;
    cout << "Nhap so sinh vien: ";
    cin >> n;
    
    Student sv[n];

    cout << "\nNhap thong tin " << n << " sinh vien:\n";
    for (int i = 0; i < n; i++) {
        sv[i].nhapDuLieu();
    }

    sort(sv, sv + n, sapXep);

    cout << "Thong tin cac sinh vien vua nhap theo chieu giam dan cua diem trung binh:\n";
    for (int i = 0; i < n; i++) {
        sv[i].hienThi();
    }
    return 0;
} 