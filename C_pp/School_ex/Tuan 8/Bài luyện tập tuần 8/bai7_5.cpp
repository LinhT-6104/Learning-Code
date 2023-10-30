#include<iostream>
#include<fstream>

using namespace std;

struct thongtin {
    string tensach;
    int namsx;
    int soluong;
    float giaban;
    float doanhthu;
};

int main() {
    ifstream inpf("book.inp");
    ofstream outf("book.out");

    // Nhap so dau sach
    int n;
    inpf >> n;

    // Nhap thong tin cac dau sach va dem so sach co doanh thu >= 1000
    thongtin sach[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
        inpf.ignore();
        getline(inpf, sach[i].tensach);
        inpf >> sach[i].namsx >> sach[i].soluong >> sach[i].giaban;
        sach[i].doanhthu = sach[i].soluong * sach[i].giaban;
        if (sach[i].doanhthu >= 1000)   count++;    // Dem so sach co doanh thu >= 1000
    }

    outf << count << endl;

    for (int i = 0; i < n; i++) {
        if (sach[i].doanhthu >= 1000) {
            outf << sach[i].tensach<< endl;
        }
    }

    inpf.close();
    outf.close();
    return 0;
}