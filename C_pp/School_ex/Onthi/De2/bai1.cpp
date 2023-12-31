#include <iostream>
#include <string>

using namespace std;

int count_upper(string s) {
    int count = 0;
    for (int i = 0; i < s.size(); i++) {
        if (isupper(s[i]))  count++;
    }
    return count;
}

int count_number(string s) {
    int count = 0;
    for (int i = 0; i < s.size(); i++) {
        if (isdigit(s[i]))  count++;
    }
    return count;
}

int count_special(string s) {
    int count = 0;
    for (int i = 0; i < s.size(); i++) {
        if (!isdigit(s[i]) && !isalpha(s[i]))  count++;
    }
    return count; 
}

int main() {
    string s;
    cout << "Nhap xau ky tu s: ";
    getline(cin, s);
    // Cau a:
    cout << "- So luong chu cai viet HOA co trong xau la: " << count_upper(s) << endl;
    // Cau b:
    cout << "- So luong chu so co trong xau la: " << count_number(s) << endl;
    // Cau c:
    cout << "- So luong ky tu dac biet co trong xau la: " << count_special(s) << endl;
    return 0;
}