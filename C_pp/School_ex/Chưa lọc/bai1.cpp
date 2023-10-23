#include<iostream>
#include<string>

using namespace std;

string lowercase(string s) {
    for (int i = 0; i < s.size();i++) {
        s[i] = tolower(s[i]);
    }
    return s;
}

string uppercase(string s) {
    for (int i = 0; i < s.size();i++) {
        s[i] = toupper(s[i]);
    }
    return s;
}

string cew(string s) {
    for (int i = 0; i < s.length(); i++) {
        if (i == 0 || s[i-1] == ' ') {
            s[i] = toupper(s[i]);
        }
    }
    return s;
}

string tcase(string s) {
    s = cew(s);
    for (int i = 0; i < s.size(); i++) {
        if (isupper(s[i])) {
            s[i] = tolower(s[i]);
        } else {
            s[i] = toupper(s[i]);
        }
    }
    return s;   
}

int main() {
    string s;
    cout << "Moi nhap xau ky tu: ";
    getline(cin, s);
    cout << "Xau ky to goc: " << s << endl;
    cout << "Xau ky tu sau khi lower: " << lowercase(s) << endl;
    cout << "Xau ky tu sau khi upper: " << uppercase(s) << endl;
    cout << "Xau ky tu Captitalize Each Word: " << cew(s) << endl;
    cout << "Xau ky tu tOGGLE cASE: " << tcase(s);
    return 0;
}