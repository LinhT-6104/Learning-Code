#include<iostream>

using namespace std;

int main(){
    // Nhap gia tri 3 so
    cout << "Nhap vao 3 so\n";
    float so1, so2, so3;
    cout << "So thu nhat la: "; 
    cin >> so1;
    cout << "So thu hai la: ";
    cin >> so2;
    cout << "So thu ba la: ";
    cin >> so3;

    // Tim ra so lon nhat
    // Gia su truong hop 3 so bang nhau
    if (so1 == so2 && so1 == so3) {
        cout << "3 so bang nhau";
    }
    // Neu 3 so khong bang nhau
    else if (so1 >= so2 && so1 >= so3) {
        cout << "So lon nhat la: so thu nhat";
    }
    else if (so2 >= so3) {
        cout << "So lon nhat la: so thu 2";
    } 
    else {
        cout << "So lon nhat la: so thu 3";
    }
    return 0;
}