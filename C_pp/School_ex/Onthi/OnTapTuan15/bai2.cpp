#include <iostream>
#include <fstream>
#include <vector>

using namespace std;

int demTu(string &s) {
    int dem = 0;
    for (int i = 0; i < s.size() - 1; i++) {
        if (s[i] == ' ' && isalnum(s[i+1])) dem++;
    }
    return dem+1;
}

void nhanDuLieu(int &n, vector<int> &dem, int &tong, ifstream &inp) {
    inp >> n; 
    inp.ignore();
    for (int i = 0; i < n; i++) {
        string s;
        getline(inp, s);
        dem.push_back(demTu(s));
        tong += demTu(s);
    }  
}

void hienThi(int n, vector<int> dem, int tong, ofstream &outp) {
    // Dong 1
    outp << (tong % 2 == 0 ? 0 : 1) << endl;

    // Cac dong sau
    for (int i = 0; i < n; i++) {
        outp << dem[i] << endl;
    }
}

int main() {
    ifstream inp("STRING.INP");
    ofstream outp("STRING.OUT");

    if (inp.fail()) {
        cout << "Khong the mo file input";
        return 0;
    }
    if (outp.fail()) {
        cout << "Khong the mo file output";
        return 0;
    }

    int n, tong = 0;
    vector<int> dem;
    nhanDuLieu(n, dem, tong, inp);
    hienThi(n, dem, tong, outp);

    inp.close();
    outp.close();
    return 0;
}