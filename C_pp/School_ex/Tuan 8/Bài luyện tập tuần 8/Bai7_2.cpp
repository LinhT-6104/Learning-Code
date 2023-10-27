#include<iostream>
#include<fstream>

using namespace std;

int main() {
    ifstream inpf("news.inp");
    ofstream outf("news.out");

    int count_alpha = 0, count_number = 0, sum = 0;
    string s;
    while (!inpf.eof()) {
        inpf >> s;
        for (int i = 0; i < s.size(); i++) {
            if (s[i] >= 'A' and s[i] <= 'z') {
                count_alpha++;
            } 
            else if (s[i] >= '1' and s[i] <= '9') {
                count_number++;
            }
            else    sum++;
        }
    }
    outf << count_alpha << " " << count_number << " " << sum;

    inpf.close();
    outf.close();
    return 0;
}