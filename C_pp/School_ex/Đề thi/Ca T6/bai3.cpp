#include<iostream>
#include<fstream>

using namespace std;

int main() {
    ifstream finp("kitu.inp");
    ofstream fout("kitu.out");

    if (finp.fail()) {
        cout << "Khong the mo file input";
        return 0;
    }
    if (fout.fail()) {
        cout << "Khong the mo file output";
        return 0;
    }

    string s;
    int chuhoa = 0, chuthuong = 0, so = 0;
    while (getline(finp, s)) {
        for (int i = 0; i < s.size(); i++) {
            if (isalpha(s[i])) {
                if (isupper(s[i]))  chuhoa++;
                else    chuthuong++;
            }
            else if (s[i] >= '0' and s[i] <= '9')   so++;
        }
    }
    fout << chuthuong << endl << chuhoa << endl << so;

    finp.close();
    fout.close();
    return 0;
}