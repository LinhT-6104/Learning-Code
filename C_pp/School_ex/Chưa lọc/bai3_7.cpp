#include<iostream>
#include<string>

using namespace std;

struct thongtin {
    int ma, namsx, soluong;
    string ten;
    float giaban;
};
thongtin sp[100];

//Input
void input(int n) {
    for (int i = 0; i < n; i++) {
        cout << "\nSan pham " << i + 1 << endl;
        
        cout << "Ma: "; 
        cin >> sp[i].ma;    
        
        cout << "Ten: "; 
        cin.ignore(); 
        getline(cin, sp[i].ten);
        
        cout << "Nam san xuat: "; 
        cin >> sp[i].namsx;
        
        cout << "So luong: "; 
        cin >> sp[i].soluong;
            
        cout << "Gia ban: "; 
        cin >> sp[i].giaban;
    }
}

void sp2020(int n) {
    cout << "\nNhung sp san xuat nam 2020:\n";
    for (int i = 0; i < n; i++) {
        if (sp[i].namsx == 2020) {
            cout << "- San pham " << sp[i].ten << endl;
        }
    }
    cout << endl;
}

void gia_ban(int n) {
    cin.ignore();
    string tensp;
    cout << "Nhap ten sp can tim: ";
    getline(cin, tensp);
    for (int i = 0; i < n; i++) {
        if (sp[i].ten == tensp) {
            cout << "- Gia ban san pham " << tensp << ": " << sp[i].giaban << endl;
        }
    }
    cout << endl;
}

float tongtien(int n){
    float bill = 0;
    for (int i = 0; i < n; i ++) {
        bill += sp[i].giaban * sp[i].soluong;
    }
    return bill;
}

int main() {
    int n;
    cout << "Nhap so san pham: ";
    cin >> n;
    cin.ignore();
    input(n);
    sp2020(n);
    gia_ban(n);
    cout << "Tong gia tri cua san pham da nhap: " << tongtien(n);
    return 0;
}