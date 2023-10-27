#include<iostream>
#include<fstream>
#include<vector>
#include<algorithm>
#include<cmath>

using namespace std;

bool check_socp(int a) {
    int b = sqrt(a);
    if (pow(b,2) == a)  return true;
    return false;
}

int main() {
    ifstream inpf;
    ofstream outf;

    inpf.open("songuyen.inp");
    outf.open("songuyen.out");

    // Nhap day so 
    vector<int> a;
    int b;
    while(!inpf.eof()) {
        inpf >> b;
        a.push_back(b);
    }

    sort(a.begin(), a.end(), greater<int>());   // Sap xep cac so

    int n = a.size();

    outf << n << endl;  // So luong so

    // Tim so nho thu 2 trong day
    if (a[0] == a[n-1]) outf << -1 << endl;
    else outf << a[n-2] << endl;

    // Bien doi day so
    for (int i = 0; i < n; i++) {
        if (a[i] % 2 == 0) a[i] *= 2;
        else a[i] *= 3;
        if (check_socp(a[i]))   outf << a[i] << " ";
    }



    inpf.close();
    outf.close();
    return 0;
} 