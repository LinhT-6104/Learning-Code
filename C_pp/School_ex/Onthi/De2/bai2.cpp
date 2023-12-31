#include <iostream>
#include <fstream>

using namespace std;

void nhapDuLieu(int &n, string tenTP[], int BNTang[], ifstream &inpf) {
    inpf >> n;
    for (int i = 0; i < n; i++) {
        int SL2022, SL2021;
        inpf >> tenTP[i] >> SL2021 >> SL2022;
        BNTang[i] = SL2022 - SL2021;
    }
}

int MinBNTang(int n, int BNTang[]) {
    int min = BNTang[0];
    for (int i = 1; i < n; i++) {
        if (min > BNTang[i])    min = BNTang[i];
    }
    return min;
}

void ShowMinBNTang(int n, string tenTP[], int BNTang[], ofstream &outpf) {
    int min = MinBNTang(n, BNTang);
    for (int i = 0; i < n; i++) {
        if (BNTang[i] == min)   outpf << tenTP[i] << endl;
    }
}

void ShowSameBNTang(int n, string tenTP[], int BNTang[], ofstream &outpf) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (BNTang[i] == BNTang[j]) outpf << tenTP[i] << " " << tenTP[j] << endl;
        }
    }
}

int main() {
    ifstream inpf("covid.inp");
    ofstream outpf("covid.out");

    if (inpf.fail()) {
        cout << "Khong the mo file input";
        return 0;
    }
     if (inpf.fail()) {
        cout << "Khong the mo file output";
        return 0;
    }
    
    // Nhap du lieu
    int n;
    string tenTP[100];
    int BNTang[100];
    nhapDuLieu(n, tenTP, BNTang, inpf);

    // Cau a:
    ShowMinBNTang(n, tenTP, BNTang, outpf);

    // Cau b:
    ShowSameBNTang(n, tenTP, BNTang, outpf);

    inpf.close();
    outpf.close();
    return 0;
}