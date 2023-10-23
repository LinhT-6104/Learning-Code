#include<iostream>
#include<string>
#include<cctype>

using namespace std;

int main(){
    string s;
    getline(cin,s);
    for (char a: s) {
        a = toupper(a);
        cout << a;
    }
    return 0;
}