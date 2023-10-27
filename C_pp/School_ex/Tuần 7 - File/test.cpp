#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>

using namespace std;

struct thongtin {
    string ma_mathang;
    string ten_mathang;
    int so_luong;
    float gia_ban;
};


bool sapxep(const thongtin &st1, const thongtin &st2) {
    if (st1.so_luong == st2.so_luong) 
        return st1.gia_ban > st2.gia_ban;
    return st1.so_luong > st2.so_luong;
}

int main() {
    ifstream inpf("mathang.inp");
    ofstream outpf("mathang.out");
    
    // Input
    int n; inpf >> n; 
    vector<thongtin> mathang(n);
    for (int i = 0; i < n; i++) {
        inpf.ignore();
        getline(inpf, mathang[i].ma_mathang);
        getline(inpf, mathang[i].ten_mathang);
        inpf >> mathang[i].so_luong;
        inpf >> mathang[i].gia_ban;
    }

    // Output
    /*
    sort(mathang.begin(), mathang.end(), sapxep);	// Sap xep
    for (int i = 0; i < n; i++) {
        outpf << mathang[i].ma_mathang << " " << mathang[i].ten_mathang << " " << mathang[i].so_luong << " " << mathang[i].gia_ban << "\n";
    }*/

    /* Cách 2 - Tuy nhiên cần khai báo thongtin mathang[n] vì sẽ chạy hết mảng mathang */
    for (const thongtin &out: mathang) {
        outpf << out.ma_mathang << " " << out.ten_mathang << " " << out.so_luong << " " << out.gia_ban << endl;
    }
    

    inpf.close();
    outpf.close();
    return 0;
}