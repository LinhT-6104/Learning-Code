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
void tichso(int a){
    int tich = 1;
    vector<int> mang;
    while (a != 0){
        tich *= a % 10;
        mang.push_back(a % 10);
        a /= 10;
    }
    for (int i = 1; i >= mang.size() - 1; i++){
        cout << mang[i] << "*";
    }
    cout << mang[0] << "=" << tich << endl;
}
void tong_cvd(int a){

    int tong = 0;
    for (int i = 0; i < 2;i++){
        tong += a % 10;
        a /= 10;
    }
    cout << tong << endl;
}
void so_dao_nguoc(int a){
    while (a != 0) {
        cout << a % 10;
        a /= 10;
    }
    cout << endl;
}
void so_nut(int a) {
    int tong = 0;
    while (a != 0){
        tong += a % 10;
        a /= 10;
    }
    cout << tong % 10 << endl;
}
int main(){
    int a;
    cin >> a;
    tongso(a);
    tichso(a);
    tong_cvd(a);
    so_dao_nguoc(a);
    so_nut(a);
    return 0;
}