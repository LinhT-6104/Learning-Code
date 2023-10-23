#include<iostream>
#include<string>

using namespace std;

// Hàm xóa bỏ khoảng trắng ở đầu và cuối chuỗi 
void delete_space(string &s) {
    cout << "Ham sau khi thay doi: ";
    while (s[0] == ' ') {
        s.erase(0, 1);
    }
    while (s[s.length()] == ' ') {
        s.erase(s.length() - 1, 1);
    }
    cout << s << endl;
}

// Hàm đếm số lượng từ trong chuỗi
int dem(string s) {
    cout << "So luong phan tu trong chuoi la: ";
    int count = 0;
    for (char b: s){
        if (isalpha(b)) {
            count++;
        }
    }
    return count;
}

// Hàm thực hiện viết chức năng “Capitalize Each Word”
void cew(string s) {
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 or s[i-1] == ' ') {
            s[i] = toupper(s[i]);
        } else {
            s[i] = tolower(s[i]);
        }
    }
    cout << s;
}

int main(){
    string s;
    getline(cin, s);
    delete_space(s);
    cout << dem(s) << endl;
    cew(s);
    return 0;
}