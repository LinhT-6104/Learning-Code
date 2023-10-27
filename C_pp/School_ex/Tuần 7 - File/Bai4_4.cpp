#include<iostream>
#include<fstream>

using namespace std;

int main() {
    ifstream  inpf;
    inpf.open("dayso.txt");
    int x, count = 0;
    while (!inpf.eof()) {
        inpf >> x;
        if (x % 2 == 0) {
            count++;
        }
    }
    cout <<"So dau chan trong file dayso.txt la " << count;
}