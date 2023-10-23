#include<iostream>

using namespace std;

string ho(string s) {
    int fstn = s.find(' ');
    return s.substr(0, fstn);
}

string ten(string s) {
    int lstn = s.rfind(' ');
    return s.substr(lstn + 1, s.size());
}

int main() {
    string s;
    cout << "Moi nhap ten day du: ";
    getline(cin, s);
    cout << "Ho cua nguoi nay la: " << ho(s) << endl;
    cout << "Ten cua nguoi nay la: " << ten(s) << endl;
    return 0;
}