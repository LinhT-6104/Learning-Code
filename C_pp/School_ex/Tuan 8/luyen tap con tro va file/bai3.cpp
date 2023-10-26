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

    int count = 0;
    for (int i = 0; i < n; i++) {
        cin.ignore();
        getline(inpf, sv[i].tensv);
        getline(inpf, sv[i].quequan);
        inpf >> sv[i].toan;
        inpf >> sv[i].van;
        inpf >> sv[i].anh;
        sv[i].dtb = (sv[i].toan + sv[i].van + sv[i].anh) / 3;

        if (sv[i].dtb >= 8.5)   count++;
    }

    outf << count << endl;
    for (int i = 0; i < n; i++) {
        if (sv[i].dtb >= 8.5) {
            outf << sv[i].tensv << " ";
            outf << sv[i].quequan << " ";
            outf << sv[i].dtb << endl;
        }
    }

    



    return 0;
}