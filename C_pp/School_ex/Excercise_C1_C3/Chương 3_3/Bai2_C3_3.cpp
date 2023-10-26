#include<iostream>
#include<string>

using namespace std;

int main(){
    int n;
    cout << "Nhap so ban trong lop: ";  
    cin >> n;

    cin.ignore();   // Xoa dau cach thua tu cin

    // Nhap ho ten cac ban trong lop
    string s[n];
    for (int i = 0; i < n - 1; i++) {    
        getline(cin, s[i], ',');    // Nhap ho ten n-1 ban dau tien
        s[i] = s[i].substr(s[i].rfind(' ') + 1, s[i].size());   // Tach ten moi ban
    }

    getline(cin, s[n-1]);   // Nhap ho ten ban cuoi cung
    s[n-1] = s[n-1].substr(s[n-1].rfind(' ') + 1, s[n-1].size());   // Tach ten ban cuoi cung

    // Hiem thi ten cac ban
    for (int i = 0; i < n; i++) {
        cout << s[i];
        if (i < n - 1)   cout << ", ";
    }
    return 0;
}