#include <iostream>
#include <algorithm>
#include <iomanip>
#include <string>

using namespace std;

class NHANVIEN {
private:
    string hoTen;
    string ngaySinh;
    bool gioiTinh;
    string queQuan;
    double luong;
    string trinhDo;
    string chucVu;

public: 
    NHANVIEN() {
        hoTen = "";
        ngaySinh = "";
        gioiTinh = 0;
        queQuan = "";
        luong = 0;
        trinhDo = "";
        chucVu = "";
    }
    
    bool checkHN() {
        return (queQuan == "Ha Noi");
    }

    double getLuong() {return luong;}

    int getNamSinh()  {
        int pos = ngaySinh.rfind("/");
        return stoi(ngaySinh.substr(pos + 1, 4));
    }

    NHANVIEN operator+=(NHANVIEN x) {
        luong += x.luong;
        return *this;
    }

    friend istream & operator>>(istream &inp, NHANVIEN &x) {
        cout << "- Ho ten: "; getline(inp, x.hoTen);
        cout << "- Ngay sinh: "; getline(inp, x.ngaySinh);
        cout << "- Gioi tinh (1: Nam / 0: Nu): "; inp >> x.gioiTinh;
        inp.ignore();
        cout << "- Que quan: "; getline(inp, x.queQuan);
        cout << "- Luong: "; inp >> x.luong;
        inp.ignore();
        cout << "- Trinh do: "; getline(inp, x.trinhDo);
        cout << "- Chuc vu: "; getline(inp, x.chucVu);
        return inp;
    }

    friend ostream & operator<<(ostream &outp, NHANVIEN &x) {
        outp << "Thong tin nhan vien\n";
        outp << "- Ho ten: " << x.hoTen << endl;
        outp << "- Ngay sinh: " << x.ngaySinh << endl;
        if (x.gioiTinh) outp << "- Gioi tinh: Nam " << endl;
        else outp << "- Gioi tinh: Nu " << endl;
        outp << "- Que quan: " << x.queQuan << endl;
        outp << "- Luong: " << fixed << setprecision(1) << x.luong << endl;
        outp << "- Trinh do: " << x.trinhDo << endl;
        outp << "- Chuc vu: " << x.chucVu << endl << endl;
        return outp;
    }

    ~NHANVIEN() {}  
};

void nhapThongTin(NHANVIEN A[], int n) {
    cout << "\nNhap thong tin nhan vien:\n";
    for (int i = 0; i < n; i++) {
        cout << "\nNhan vien " << i + 1 << endl;
        cin >> A[i];
    }
}

void nvHN(NHANVIEN A[], int n) {
    cout << "\nCac nhan vien co que o Ha Noi la:\n";
    for (int i = 0; i < n; i++) {
        if (A[i].checkHN()) cout << A[i];
    }
}

void tbLuong(NHANVIEN A[], int n) {
    NHANVIEN C;
    for (int i = 0; i < n; i++) {
        C += A[i];
    }
    cout << "Trung binh luong cua cac nhan vien: " << fixed << setprecision(1) << C.getLuong()/n << endl << endl;
}

bool sapXep(NHANVIEN &A1, NHANVIEN &A2) {
    return A1.getLuong() <= A2.getLuong();
}

void hienThi(NHANVIEN A[], int n) {
    for (int i = 0; i < n; i++) cout << A[i];
    cout << endl;
}

int NVT30(NHANVIEN A[], int n) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        if ((2020 - A[i].getNamSinh()) > 30) {
            count++;
        }
    }
    return count;
}

int main() {
    int n; cout << "Nhap so nhan vien: "; cin >> n; cin.ignore();

    NHANVIEN A[n]; 

    // a. Nhap danh sach nhan vien
    nhapThongTin(A, n);
    
    // b.Hien thi nhan vien co que o Ha Noi
    nvHN(A, n);

    // c. Tinh va dua ra trung binh luong cua cac nhan vien
    tbLuong(A, n);

    // d. Sap xep lai danh sach nhan vien theo luong khong giam
    sort(A, A + n, sapXep);
    cout << "Danh sach sinh vien theo luong khong giam:\n";
    hienThi(A, n);

    // e. Tinh so nhan vien tren 30 tuoi (Tinh den nam 2020)
    cout << "So nhan vien tren 30 tuoi la: " << NVT30(A, n);
    return 0;
}