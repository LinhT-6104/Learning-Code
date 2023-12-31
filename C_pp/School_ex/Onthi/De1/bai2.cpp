#include <iostream>
#include <fstream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

void NhapDuLieu(int &n, string tenTP[], int CLDanSo[], ifstream &inpf) {
    inpf >> n;
    for (int i = 0; i < n; i++) {
        inpf >> tenTP[i];
        int a, b;
        inpf >> a >> b;
        CLDanSo[i] = abs(a - b);
    }
}

int maxCLDS(int n, int CLDanSo[]) {
    int max = CLDanSo[0];
    for (int i = 1; i < n; i++) {
        if (max < CLDanSo[i])   max = CLDanSo[i];
    }
    return max;
}

void ShowMaxCLDS(int n, int CLDanSo[], string tenTP[], ofstream &outf) {
    int max = maxCLDS(n, CLDanSo);
    for (int i = 0; i < n; i++) {
        if (CLDanSo[i] == max)  outf << tenTP[i] << endl;
    }
}

void ShowSameCLDS(int n, int CLDanSo[], string tenTP[], ofstream &outf) {
    for (int i = 0; i < n-1; i++) {
        for (int j = i + 1 ; j < n; j++) {
            if (CLDanSo[i] == CLDanSo[j])   outf << tenTP[i] << " " << tenTP[j] << endl;
        }
    }
}

int main() {
    ifstream inpf("danso.inp");
    ofstream outf("danso.out");

    // Kiem tra file input
    if (inpf.fail()) {
        cout << "Loi khong the mo file input";
    }
    // Kiem tra file output
    if (outf.fail()) {
        cout << "Loi khong the mo file output";
    }

    // Nhap du lieu
    int n;
    string tenTP[100];
    int CLDanSo[100];
    NhapDuLieu(n, tenTP, CLDanSo, inpf);

    // Hien thi chenh lech dan so max
    ShowMaxCLDS(n, CLDanSo, tenTP, outf);

    // Hien thi chenh lech dan so bang nhau
    ShowSameCLDS(n, CLDanSo, tenTP, outf);

    inpf.close();
    outf.close();
    return 0;
}