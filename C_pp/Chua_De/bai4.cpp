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

    friend istream & operator<<(istream &inp, MAYTINH &x) {
        x.nhapThongTin();
        cout << "Nhap ten hang san xuat: "; 
        inp.ignore();
        getline(inp, x.hangSX);
        cout << "Nhap toc do: "; inp >> x.tocDo;
        cout << "Nhap dung luong o cung: "; inp >> x.SizeOCung;
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

void nhapThongTinCacThietBi(int &n, int &m, MAYTINH pc[], DIENTHOAI phone[]) {
    cout << "Nhap so luong may tinh: ";
    cin >> n;   // Nhap so luong may tinh 

    // Nhap thong tin cac may tinh
    cout << "\nNhap thong tin may tinh\n";
    for (int i = 0; i < n; i++) {
        cout << "--- May tinh " << i+1 << " ---\n";
        pc[i].nhapThongTin();
    }
}

int main() {
    int n;
    int m;
    MAYTINH pc[100];
    
    return 0;
}