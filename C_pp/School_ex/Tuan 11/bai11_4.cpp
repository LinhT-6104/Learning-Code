#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Sach {
private:
    string tenSach;
    string tenNXB;
    int namXB;
    int soLuong;
    bool trangThaiMuon;

public:
    void nhapThongTin() {
        cout << "- Nhap ten sach: ";  
        cin.ignore();
        getline(cin, tenSach);
        cout << "- Nhap ten nha xuat ban: ";  getline(cin, tenNXB) ;
        cout << "- Nhap nam san xuat: ";  cin >> namXB;
        cout << "- Nhap so luong: ";  cin >> soLuong;
        cout << "- Nhap trang thai muon (1: Da muon, 0: Chua muon): ";    cin >> trangThaiMuon;
    }

    void hienThi() {
        cout << "- Ten sach: " << tenSach << endl;
        cout << "- Ten nha xuat ban: " << tenNXB << endl;
        cout << "- Nam xuat ban: " << namXB << endl;
        cout << "- So luong sach: " << soLuong << endl;
        cout << "- Trang thai muon: " << (trangThaiMuon ? "Dang muon" : "Chua muon") << endl;
        cout << "------------------------------------------------------------------------\n";
    }

    bool daMuon() {
        return trangThaiMuon;
    }

    string getTenSach() {
        return tenSach;
    }

    bool truocNam1990() {
        return namXB < 1990;
    }
};

bool sapXep(Sach &sach1, Sach &sach2) {
    return sach1.getTenSach() < sach2.getTenSach();
}

int main() {
    int n;
    do {
        cout << "Nhap so luong sach: ";
        cin >> n;
    } while (n < 0 || n > 100);

    vector<Sach> danhSachSach(n);

    // Nhap thong tin cho tung quyen sach
    for (int i = 0; i < n; i++) {
        cout << "Nhap thong tin quyen sach thu " << i + 1 << ":\n";
        danhSachSach[i].nhapThongTin();
    }

    // Hien thi nhung quyen sach da muon
    cout << "\nSach da muon\n\n";
    for (Sach sach : danhSachSach) {
        if (sach.daMuon())  sach.hienThi();
    }

    // Sap xep sach theo ten sach
    sort(danhSachSach.begin(), danhSachSach.end(), sapXep);

    // Hien thi nhung quyen sach xuat ban truoc nam 1990
    cout << "\nNhung quyen sach xuat ban truoc nam 1990\n\n";
    for (Sach sach : danhSachSach) {
        if (sach.truocNam1990())    sach.hienThi();
    }
    return 0;
}