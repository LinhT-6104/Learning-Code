#include<iostream>

using namespace std;

int main(){
    int a[5] = {12, 412, -5, 12, 4};
    for (int i = 0; i < 5 - 1; i++) {
        for (int j = i; j < 5; j++) {
            if (a[j] < a[i]) {
                swap(a[i], a[j]);
            }
        }
    }
    for (int i = 0; i < 5; i++) {
        cout << a[i] << " ";
    }
    return 0;
}

