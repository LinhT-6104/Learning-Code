#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

class SINHVIEN {
private:
    string hoTen;
    int namSinh;
    double DiemTB;
    bool gioiTinh;

public:
    SINHVIEN() {
        hoTen = "";
        namSinh = 0;
        DiemTB = 0;
        bool gioiTinh = true;
    }
    SINHVIEN(string hoTen, int namSinh, double DiemTB, bool gioiTinh) {
        this->hoTen = hoTen;
        this->namSinh = namSinh;
        this->DiemTB = DiemTB;
        this->gioiTinh = gioiTinh;
    }
    void nhapDuLieu() {
        cout << "Nhap ho ten: ";    getline(cin, hoTen);
        cout << "Nhap nam sinh: ";  cin >> namSinh;
        cout << "Nhap diem trung binh: ";   cin >> DiemTB;
        cout << "Nhap gioi tinh (0: Nam, 1: Nu): "; cin >> gioiTinh;
    }
    void hienThi() {
        cout << "- Ho ten: " << hoTen << endl;
        cout << "- Nam sinh: " << namSinh << endl;
        cout << "- Diem trung binh: " << DiemTB << endl;
        cout << "- Gioi tinh: " << (gioiTinh == 0 ? "Nam" : "Nu") << endl;
    }
    bool operator>(SINHVIEN B) {
        return namSinh < B.namSinh; 
    }
    friend void SVBinh1982(SINHVIEN sv[], int n);
    friend bool sapXep(SINHVIEN A, SINHVIEN B);
};   

void nhapDL(SINHVIEN sv[], int &n) {
    cout << "Nhap so sinh vien: ";
    cin >> n;
    for (int i = 0; i < n; i++) {
        cout << "\nSinh vien " << i + 1 << endl;
        cin.ignore();
        sv[i].nhapDuLieu();
    }
}

void hienThiDL(SINHVIEN sv[], int n) {
    cout << "\nThong tin cac sinh vien\n";
    for (int i = 0; i < n; i++) {
        cout << "\nSinh vien " << i + 1 << endl;
        sv[i].hienThi();
    }
}

void SVBinh1982(SINHVIEN sv[], int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        string name = sv[i].hoTen;
        int index = name.rfind(" ");
        if (sv[i].namSinh == 1982 && name.substr(index + 1, name.size()) == "Binh") {
            count++;
        }
    }
    cout << "\nSo sinh vien Binh sinh nam 1982: " << count << endl;
}

bool sapXep(SINHVIEN A, SINHVIEN B) {
    return A>B;
}

void hienThiSapXep(SINHVIEN sv[], int n) {
    sort(sv, sv + n, sapXep);
    cout << "\nDanh sach sau khi sap xep\n";
    for (int i = 0; i < n; i++) {
        cout << "\nSinh vien " << i + 1 << endl;
        sv[i].hienThi();
    }
}

int main() {
    int n;
    SINHVIEN sv[100];
    nhapDL(sv, n);      // Nhap du lieu cho danh sach gom n sinh vien
    hienThiDL(sv, n);   // Hien thi du lieu da nhap len man hinh
    SVBinh1982(sv, n);  // Hien thi so sinh vien ten Binh sinh nam 1982
    hienThiSapXep(sv, n);   // Hien thi danh sach sau khi sap xep len man hinh
    return 0;
}