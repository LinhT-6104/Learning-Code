#include<iostream>
#include<string>
#include<vector>

using namespace std;

struct banmaytinh {
    string ten;
    int soluong;
};
banmaytinh nv[100];

void input(int &n) {
    // Nhap so nhan vien
    cout << "Nhap so nhan vien: "; 
    cin >> n;
    
    // Nhap thong tin nhan vien
    cout << "Nhap thong tinh nhan vien\n";
    for (int i = 0; i < n; i++) {
        cin.ignore();
        cout << "Nhan vien " << i + 1 << endl;
        cout << "Ten: ";
        getline(cin, nv[i].ten);
        cout << "So luong may tinh ban duoc: ";
        cin >> nv[i].soluong;
        cout << endl;
    }
}

// Hàm tính số lượng bán máy tính trung bình 
int soluongbantb(int n){
    int soluongtb = 0;
    for (int i = 0; i < n; i++) {
        soluongtb += nv[i].soluong / n;
    }
    return soluongtb;
}

// Hàm hiện thông tin nhân viên bán máy tính lớn hơn lượng bán trung bình
void show(int n) {
    cout << "Thong tin nhan vien ban may tinh lon hon trung binh:\n";
    // Hàm in ra kết quả 
    for (int i = 0; i < n; i++) {
        if (nv[i].soluong > soluongbantb(n)) {
            cout << "Ten: " << nv[i].ten << endl;
            cout << "So luong may tinh ban duoc: " << nv[i].soluong << endl << endl;
        }
    }
}

void trao_thuong(int n) {
    cout << "Nhan vien duoc trao thuong la:\n";
    for (int i = 0; i < n; i++) {
        string ten = nv[i].ten;
        if (ten.length() > 0) {
            ten = ten.substr(ten.rfind(' '));
            if ((ten == "Trung" or ten == "Huyen") and nv[i].soluong > soluongbantb(n)) {
                cout << "- Ten: " << nv[i].ten << endl;
                cout << "- So luong ban: " << nv[i].soluong << endl << endl;
            }
        }
    }
}

int main() {
    int n;
    input(n);
    cout << soluongbantb(n) << endl;
    show(n);
    trao_thuong(n);
    return 0;
}