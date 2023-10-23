#include<iostream>
#include<vector>

using namespace std;

void tongso(int a){
    int tong = 0;
    vector<int> mang;
    while (a != 0){
        tong += a % 10;
        mang.push_back(a % 10);
        a /= 10;
    }
    for (int i = 1; i >= mang.size() - 1; i++){
        cout << mang[i] << "+";
    }
    cout << mang[0] << "=" << tong << endl;
}
int main() {
    vector<int> a = {1,2,3,4};
    //if (string)a[-1]
    cout << a[a.size() - 1];
    return 0;
}
