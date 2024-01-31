#include <iostream>
#include <cmath>

using namespace std;

class THIETBI {
private:
    string tenTB;
    int namSX;
    double GiaBan;

public:
    THIETBI() {
        tenTB = "";
        namSX = 0;
        GiaBan = 0;
    }
    THIETBI(string tenTB, int namSX, double GiaBan) {
        this->tenTB = tenTB;
        this->namSX = namSX;
        this->GiaBan = GiaBan;
    }
    void nhapThongTin() {
        cout << "Nhap ten thiet bi: ";  
        cin.ignore();
        getline(cin, tenTB);
        cout << "Nhap nam san xuat: ";  cin >> namSX;
        cout << "Nhap gia ban: "; cin >> GiaBan;
    }
    void hienThiThongTin() {
        cout << "- Ten thiet bi: " << tenTB << endl;
        cout << "- Nam san xuat: " << namSX << endl;
        cout << "- Gia ban: " << GiaBan << endl;
    }
    double getGiaBan(){
        return GiaBan;
    }
};

class MAYTINH : public THIETBI {
private:
    string hangSX;
    double tocDo;
    long SizeOCung;

public:
    MAYTINH() : THIETBI() {
        hangSX = "";
        tocDo = 0;
        SizeOCung = 0;
    }
    MAYTINH(string tenTB, int namSX, double GiaBan, string hangSX, double tocDo, long SizeOCung) : THIETBI(tenTB, namSX, GiaBan) {
        this->hangSX = hangSX;
        this->tocDo = tocDo;
        this->SizeOCung = SizeOCung;
    }
    void nhapThongTin() {
        THIETBI::nhapThongTin();
        cout << "Nhap ten hang san xuat: "; 
        cin.ignore();
        getline(cin, hangSX);
        cout << "Nhap toc do: "; cin >> tocDo;
        cout << "Nhap dung luong o cung: "; cin >> SizeOCung;
    }
    void hienThiThongTin() {
        THIETBI::hienThiThongTin();
        cout << "- Hang san xuat: " << hangSX << endl;
        cout << "- Toc do: " << tocDo << endl;
        cout << "- Do lon o cung: " << SizeOCung << endl;
    }
    bool checkSieuMayTinh() {
        return tocDo >=  pow(10, 6);
    }
};

class DIENTHOAI : public THIETBI {
private:
    string hangSX;
    string heDH;
    double kichThuocMH;
    double canNang;

public:
    DIENTHOAI() : THIETBI() {
        hangSX = "";
        heDH = "";Sa
        kichThuocMH = 0;
        canNang = 0;
    }
    DIENTHOAI(string tenTB, int namSX, double GiaBan, string hangSX, string heDH, double kichThuocMH, double canNang) : THIETBI(tenTB, namSX, GiaBan) {
        this->hangSX = hangSX;
        this->heDH = heDH;
        this->kichThuocMH = kichThuocMH;
        this->canNang = canNang;
    }
    void nhapThongTin() {
        THIETBI::nhapThongTin();
        cin.ignore();
        cout << "Nhap hang san xuat dien thoai: ";
        getline(cin, hangSX);
        cout << "Nhap he dieu hanh: "; cin >> heDH;
        cout << "Nhap kich thuoc man hinh: "; cin >> kichThuocMH;
        cout << "Nhap can nang: "; cin >> canNang;
    }
    void hienThiThongTin() {
        THIETBI::hienThiThongTin();
        cout << "- Hang san xuat dien thoai: " << hangSX << endl;
        cout << "- He dieu hanh: " << heDH << endl;
        cout << "- Kich thuoc man hinh: " << kichThuocMH << endl;
        cout << "- Can nang: " << canNang << endl;
    }
    bool CheckDThSieuNhe() {
        return canNang <= 50;
    }
};

void nhapThongTinCacThietBi(int &n, int &m, MAYTINH pc[], DIENTHOAI phone[]) {
    cout << "Nhap so luong may tinh: ";
    cin >> n;   // Nhap so luong may tinh 

    cout << "Nhap so luong dien thoai: ";   
    cin >> m;   // Nhap so luong dien thoai

    // Nhap thong tin cac may tinh
    cout << "\nNhap thong tin may tinh\n";
    for (int i = 0; i < n; i++) {
        cout << "--- May tinh " << i+1 << " ---\n";
        pc[i].nhapThongTin();
    }

    // Nhap thong tin cac dien thoai
    cout << "\nNhap thong tin dien thoai\n";
    for (int i = 0; i < m; i++) {
        cout << "--- Dien thoai " << i+1 << " ---\n";
        phone[i].nhapThongTin();
    }
}

void mayTinhGiaTu10mu5(int n, MAYTINH pc[]) {
    cout << "\nMay tinh co gia >= 10^5:\n";
    for (int i = 0; i < n; i++) {
        if (pc[i].getGiaBan() >= pow(10, 5)) {
            pc[i].hienThiThongTin();
            cout << endl;
        }
    }
}

void dienThoaiGiaDuoi10mu4(int m, DIENTHOAI phone[]) {
    cout << "Dien thoai co gia <= 10^2:\n";
    for (int i = 0; i < m; i++) {
        if (phone[i].getGiaBan() <= pow(10, 4)) {
            phone[i].hienThiThongTin();
            cout << endl;
        }
    }
}

void soSieuMayTinhvaDienThoaiSieuNhe(int n, MAYTINH pc[], int m, DIENTHOAI phone[]) {
    int countPC = 0, countPHONE = 0;
    for (int i = 0; i < n; i++) {
        if (pc[i].checkSieuMayTinh())   countPC++;
    }
    for (int i = 0; i < m; i++) {
        if (phone[i].CheckDThSieuNhe()) countPHONE++;
    }
    cout << "So Sieu may tinh: " << countPC << endl;
    cout << "So Dien thoai sieu nhe: " << countPHONE << endl;
}

int main() {
    int n;
    int m;
    MAYTINH pc[100];
    DIENTHOAI phone[100];
    nhapThongTinCacThietBi(n, m, pc, phone);
    mayTinhGiaTu10mu5(n, pc);
    dienThoaiGiaDuoi10mu4(m, phone);
    soSieuMayTinhvaDienThoaiSieuNhe(n, pc, m, phone);
    return 0;
}
