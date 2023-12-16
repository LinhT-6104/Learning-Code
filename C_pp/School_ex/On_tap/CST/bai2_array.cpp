#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

bool check(int x, int a[100], int dem) {
    // Cach 1:
    for (int i = 0; i < dem; i++) {
        if (x == a[i])  return false;
    }
    return true;
    // Cach 2: 
    // return find(a, a + dem, x) == a + dem;
}

int main() {
    ifstream inpf("songuyen.inp");
    ofstream outf("songuyen.out");

    if (inpf.fail()) {
        cout << "Khong mo file input thanh cong";
        return 0;
    }
    if (outf.fail()) {
        cout << "Khong mo file output thanh cong";
        return 0;
    }

    int soLe[100], soChan[100]; // Tao 2 mang chua so chan va so le
    int demLe = 0, demChan = 0; // Dem so phan tu trong mang chan va mang le
    int iLe = 0, iChan = 0;     // Vi tri phan tu cua mang chan va mang le
    while (!inpf.eof()) {
        int num;
        inpf >> num;
        if (num % 2 != 0 and check(num, soLe, demLe)) {
            soLe[iLe] = num;
            demLe++;    // Dem them 1 phan tu trong mang chan
            iLe++;      // Di chuyen toi vi tri tiep theo trong mang chan
        }
        if (num % 2 == 0 and check(num, soChan, demChan)) {
            soChan[iChan] = num;
            demChan++;  // Dem them 1 phan tu trong mang le 
            iChan++;    // Di chuyen toi vi tri tiep theo trong mang le
        }
    }

    // Sap xep mang
    sort(soLe, soLe + demLe);
    sort(soChan, soChan + demChan);

    outf << demLe + demChan << endl;

    for (int i = 0; i < demChan; i++) {
        outf << soChan[i] << " ";
    }

    outf << endl;
    for (int i = 0; i < demLe; i++) {
        outf << soLe[i] << " ";
    }
    
    inpf.close();
    outf.close();
    return 0;
}