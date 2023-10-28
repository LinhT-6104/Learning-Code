#include <iostream>
#include <fstream>

using namespace std;

struct thongtin {
    string tensach;
    int namsx;
    int soluong;
    float giaban;
    float doanhthu; 
};

int main()
{
    ifstream inpf("book.inp");
    ofstream outf("book.out");
    
    int n;  
    inpf >> n;

    
    thongtin dausach[n];
    for (int i = 0; i < n; i++) {
        inpf.ignore();
        getline(inpf, dausach[i].tensach);
        inpf >> dausach[i].namsx;
        inpf >> dausach[i].soluong;
        inpf >> dausach[i].giaban;
        dausach[i].doanhthu = dausach[i].soluong * dausach[i].giaban;
    }
    
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (dausach[i].doanhthu >= 1000) {
            count++;
        }    
    }
    outf << count << endl;
    
    for (int i = 0; i < n; i++) {
        if (dausach[i].doanhthu >= 1000) {
            outf << dausach[i].tensach << endl;
        }
    }
    
    
    inpf.close();
    outf.close();
    return 0;
}

