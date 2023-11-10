// Trần Đức Linh - 725105115 - K72E3
#include <iostream>
#include <fstream>

using namespace std;

int main() {
    ifstream finp("news.inp");
    ofstream fout("news.out");

    if (finp.fail()) {
        cout << "Khong the mo file input";
        return 0;
    }
    if (fout.fail()) {
        cout << "Khong the mo file output";
        return 0;
    }

    int dem_chu = 0, dem_so = 0, dem = 0;
    
    string s;
    while (!finp.eof()) {
        finp >> s;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] >= 'a' and s[i] <= 'z') {
                dem_chu += 1;
            }
            if (s[i] >= '0' and s[i] <= '9') {
                dem_so += 1;
            }
        }
        dem += s.size();
    }

    fout << dem_chu << " " << dem_so << " " << dem - dem_chu - dem_so;

    finp.close();
    fout.close();
    return 0;
}