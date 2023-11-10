#include<iostream>
#include<cmath>

using namespace std;

bool check(int a) {
    if (abs(a % 10 - a / 1000) <= 2) 
        return true;
    return false;
}

int main() {
    int count = 0;  
    for (int i = 1000; i <= 9999; i++) {
        if (check(i)) {
            count++;
            cout << i << endl;
        }
    }
    cout << "So luong so tim duoc: " << count;
    return 0;
}