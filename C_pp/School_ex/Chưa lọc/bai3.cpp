#include<iostream>
#include<string>

using namespace std;

string anagram(string a) {
    for (int i = 0; i < a.size(); i++) {
        for (int j = 0; j < i ; j++) {
            if (a[i] < a[j]) {
                swap(a[i], a[j]);
            }
        }
    }
    return a;
}

void output(string a, string b) {
    if (anagram(a) == anagram(b) && a.size() == b.size()) {
        cout << "a va b la anagram";
    } else {
        cout << "a va b khong la anagram";
    }
}

int main() {
    string a,b;
    cout << "Nhap chuoi a: "; getline(cin, a);
    cout << "Nhap chuoi b: "; getline(cin, b);
    output(a,b);
    return 0;
}

/* Cách 2:
#include<iostream>
#include<string>
#include<algorithm>

using namespace std;

bool anagram(string a, string b) {
    sort(a.begin(), a.end());
    sort(b.begin(), b.end());
    return a == b;
}

void output(string a, string b) {
    if (anagram(a, b)) {
        cout << "a va b la anagram";
    } else {
        cout << "a va b khong la anagram";
    }
}

int main() {
    string a,b;
    cout << "Nhap chuoi a: "; getline(cin, a);
    cout << "Nhap chuoi b: "; getline(cin, b);
    output(a,b);
    return 0;
}
*/