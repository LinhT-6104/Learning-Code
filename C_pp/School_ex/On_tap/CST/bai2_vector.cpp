#include <iostream>
#include <fstream>
#include <algorithm>
#include <vector>

using namespace std;

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

    vector<int> soLe, soChan;

    int check;
    while (!inpf.eof()) {
        inpf >> check;
        if (check % 2 != 0 and find(soLe.begin(), soLe.end(), check) == soLe.end()) soLe.push_back(check);
        if (check % 2 == 0 and find(soChan.begin(), soChan.end(), check) == soChan.end()) soChan.push_back(check);
    }

    sort(soLe.begin(), soLe.end());
    sort(soChan.begin(), soChan.end());

    outf << soLe.size() + soChan.size() << endl;
    for (int i = 0; i < soChan.size(); i++) {
        outf << soChan[i] << " ";
    }
    outf << endl;
    for (int i = 0; i < soLe.size(); i++) {
        outf << soLe[i] << " ";
    }
    
    inpf.close();
    outf.close();
    return 0;
}