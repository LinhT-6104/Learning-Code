#include<iostream>
#include<string>

using namespace std;

// Ham xoa dau cach thua trong chuoi
void xoa_daucach(string &s) {
    while (s[0] == ' ') s.erase(0,1);   // Xoa khoang trong truoc chuoi

    while (s[s.size() - 1] == ' ') s.erase(s.size() - 1,1);     // Xoa khoang trong sau chuoi

    for (int i = 0; i < s.size(); i++) {    // Xoa khoang trong thua trong chuoi
        while (s[i] == ' ' and s[i+1] == ' ')   s.erase((i), 1);
    }
}

// Ham in hoa chu cai dau va in thuong cac chu cai con lai
void upper(string &s) {
    s[0] = toupper(s[0]);
    for (int i = 1; i < s.size(); i++)  s[i] = tolower(s[i]);
}

int main() {
    string s;
    cout << "Nhap chuoi: ";
    getline(cin, s);
    xoa_daucach(s);
    upper(s);
    cout << s;
    return 0;
}