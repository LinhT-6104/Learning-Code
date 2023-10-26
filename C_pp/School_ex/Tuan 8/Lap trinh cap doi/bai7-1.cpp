#include<iostream>
#include<fstream>
#include<vector>
#include<algorithm>

using namespace std;

int main() {
    ifstream inpf;
    ofstream outf;

    inpf.open("songuyen.inp");
    outf.open("songuyen.out");

    // Nhap day so thanh 1 vector
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
    if (a[0] == a[n-1]) outf << -1;
    else outf << a[n-2] << endl;


    inpf.close();
    outf.close();
    return 0;
}