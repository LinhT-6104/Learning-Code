#include <iostream>
#include <fstream>

using namespace std; 

int main() {
    ifstream inpf("demtu.inp");
    ofstream outf("demtu.out");

    if (inpf.fail()) {
        cout << "Khong mo file input thanh cong";
        return 0;
    }
    if (outf.fail()) {
        cout << "Khong mo file output thanh cong";
        return 0;
    }

    int n;
    inpf >> n;
    inpf.ignore();

    int count = 0;
    string s;
    for (int i = 0; i < n; i++) {
        getline(inpf, s);
        for (int j = 0; j < s.size(); j++) {
            if ((j == 0 && isalpha(s[0]) || (s[j] == ' ' && isalpha(s[j+1]))))  count++;
        }
    }
    
    outf << count;

    inpf.close();
    outf.close();
    return 0;
}