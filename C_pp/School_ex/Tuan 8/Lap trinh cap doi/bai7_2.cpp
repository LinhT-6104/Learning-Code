#include<iostream>
#include<algorithm>
#include<fstream>
#include<climits>

using namespace std;

struct thongtin {
    int c;
    int w;
};

int main() {
    ifstream inpf("thietbi.inp");
    ofstream outf("thietbi.out");

    int n;
    inpf >> n;
    thongtin tbi[n];

    int count = 0, min_c = INT_MAX;
    for (int i = 0; i < n; i++) {
        inpf >> tbi[i].c;   // Nhap cac gia tri c
        if (tbi[i].c >= 100)    count++;    // Dem cac thiet bi co gia tri c >= 100
        if (tbi[i].c < min_c)   min_c = tbi[i].c;   // Tim gia tri c nho nhat giua cac thiet bi
    }
    for (int i = 0; i < n; i++) {
        inpf >> tbi[i].w;   // Nhap cac gia tri w
    }

    outf << count << endl;

    for(int i = 0; i < n; i++) {
        if (tbi[i].c == min_c) {
            outf << tbi[i].w << " ";
        } 
    }

    inpf.close();
    outf.close();
    return 0;
}