#include<iostream>

using namespace std;

int main(){
    cout << "Nhap so nguyen: ";
    int n; 
    cin >> n;
    if (n % 2 == 0) {
        cout << "So chan";
    } else {
        cout << "So le";
    }
    return 0;
}