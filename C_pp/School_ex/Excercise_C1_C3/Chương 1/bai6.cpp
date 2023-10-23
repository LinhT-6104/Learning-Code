#include<iostream>

using namespace std;

int main(){
    int n;
    do {
        cout << "Nhap n: ";
        cin >> n;
    } while (n < 3 or n > 9);

    // Hien thi tam giac ben trai
    for (int i = 1 ; i <= n; i++) {
        for (int j = 1; j <= i; j++) {
            cout << i;
        }
        cout << endl;
    }
    cout << endl;
    
    // Hien thi tam giac ben phai
    for (int i = 1 ; i <= n; i++) {
        cout << string(n - i, ' '); // Lui vao n - i dau cach
        for (int j = 1; j <= i; j++) { 
            cout << i;
        }
        cout << endl;
    }
    return 0;
}