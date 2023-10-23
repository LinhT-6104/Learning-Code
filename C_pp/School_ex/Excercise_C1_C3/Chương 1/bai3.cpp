#include<iostream>

using namespace std;

int main(){
    cout << "Nhap vao 3 canh cua tam giac\n";
    // Nhap vao 3 canh tam giac
    int canh1, canh2, canh3;
    cout << "Canh 1: ";
    cin >> canh1;
    cout << "Canh 2: ";
    cin >> canh2;
    cout << "Canh 3: ";
    cin >> canh3;

    // Tinh chu vi tam giac
    cout << "Chu vi tam giac tren la: " << canh1 + canh2 + canh3;
    return 0;
}