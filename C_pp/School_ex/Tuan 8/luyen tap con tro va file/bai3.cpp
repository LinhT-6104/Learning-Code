#include<iostream>
#include<fstream>

using namespace std;

struct thongtin {
    string tensv;
    string quequan;
    float toan, van, anh, dtb;
};

int main(){
    ifstream inpf("sinhvien.inp");
    ofstream outf("sinhvien.out");

    int n;
    inpf >> n;
    thongtin sv[n];

    // Nhap thong tin cac sinh vien
    int count = 0;
    for (int i = 0; i < n; i++) {
        inpf.ignore();
        getline(inpf, sv[i].tensv);
        getline(inpf, sv[i].quequan);
        inpf >> sv[i].toan;
        inpf >> sv[i].van;
        inpf >> sv[i].anh;

        sv[i].dtb = (sv[i].toan + sv[i].van + sv[i].anh) / 3;   // Tinh diem trung binh

        if (sv[i].dtb >= 8.5)   count++;    // Dem so luong sinh vien co diem trung binh >= 8.5
    }

    outf << count << endl;

    for (int i = 0; i < n; i++) {
        if (sv[i].dtb >= 8.5)   outf << sv[i].tensv << " " << sv[i].quequan << " " << sv[i].dtb << endl;
    }

    inpf.close();
    outf.close();
    return 0;
}