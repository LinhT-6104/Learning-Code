#include<iostream>
#include<string>

using namespace std;

string change_to_num(string s) {
    string result = "";
    string num = "22233344455566677778889999";
    for (char a: s) {
        if (isalpha(a)) {
            a = toupper(a);
            result += num[a - 'A'];
        } else {
            result += a;
        }
    }
    return result;
}


int main() {
    string s;
    getline(cin, s);
    cout << change_to_num(s);
    return 0;
}