#include<iostream>
#include<fstream>
#include<cmath>

using namespace std;

bool ktra_sohh(int a) {
    int sum = 0;
    for (int i = 1; i <= a/2; i++) {
        if (a % i == 0) sum += i;
    }
    if (sum == a)   return true;
    return false;
}

int main(){
    ifstream inpf("number.inp");
    ofstream outf("number.out");
    int m;
    inpf >> m;

    for (int i = 1; i < m; i++) {
        if (ktra_sohh(i)) {
            outf << i << endl;
        }
    }

    inpf.close();
    outf.close();
    return 0;
}