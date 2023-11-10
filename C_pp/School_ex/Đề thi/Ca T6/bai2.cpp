#include<iostream>
#include<fstream>

using namespace std;

struct thongtin {
    int x;
    int w;
};

int main() {
    ifstream finp("hanghoa.inp");
    ofstream fout("hanghoa.out");

    if (finp.fail()) {
        cout << "Khong the mo file input";
        return 0;
    }
    if (fout.fail()) {
        cout << "Khong the mo file output";
        return 0;
    }


    int n;  finp >> n;
    thongtin mathang[n];
    int count = 0, max = 0;
    for (int i = 0; i < n; i++) {
        finp >> mathang[i].x;
        if (mathang[i].x >= 20)     count++;
        if (mathang[i].x > max)   max = mathang[i].x;
    }
    for (int i = 0; i < n; i++) {
        finp >> mathang[i].w;
    }

    fout << count << endl;
    for (int i = 0; i < n; i++) {
        if (mathang[i].x == max)    fout << mathang[i].w << " ";
    }

    finp.close();
    fout.close();

    return 0;
}