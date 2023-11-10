// Trần Đức Linh - 725105115 - K72E3
#include <iostream>
#include <fstream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

// Khai bao kieu du lieu 
// Nhap thong tin cac thanh pho
struct thongtin {
    string tentp;
    int chenhlech;
};

// Ham tim muc chenh lech lon nhat giua cac thanh pho
int find_max(int n, thongtin dan[]) {
    int max = 0;
    for (int i = 0; i < n; i++) {
        if (max < dan[i].chenhlech) {
            max = dan[i].chenhlech;
        }
    }
    return max;
};

int main() {
    ifstream finp("danso.inp");
    ofstream fout("danso.out");
    
    // Kiem tra file input co mo duoc khong
    if (finp.fail()) {
        cout << "Khong the mo file input";
        return 0;
    }
    // Kiem tra file output co mo duoc khong
    if (fout.fail()) {
        cout << "Khong the mo file output";
        return 0;
    }

    int n;  finp >> n;
    thongtin dan[100];
    int a,b;
    // Nhap thong tin cac thanh pho
    for (int i = 0; i < n; i++) {
        finp.ignore();  // Xoa khoang cach thua
        getline(finp, dan[i].tentp);
        finp >> a;
        finp >> b;
        dan[i].chenhlech = abs(a-b);
    }

    // In ten cac thanh pho co muc chenh lech dan so lon nhat
    for (int i = 0; i < n; i++) {
        if (find_max(n, dan) == dan[i].chenhlech) {
            fout << dan[i].tentp << endl;
        }
    }

    // In ra ten cac thanh pho co muc chenh lech bang nhau
    for (int i = 0; i < n-1; i++) {
        for (int j = i+1; j < n; j++) {
            if (dan[i].chenhlech == dan[j].chenhlech) {
                fout << dan[i].tentp << " " << dan[j].tentp << endl;
            }
        }
    }

    finp.close();
    fout.close();
    return 0;
}