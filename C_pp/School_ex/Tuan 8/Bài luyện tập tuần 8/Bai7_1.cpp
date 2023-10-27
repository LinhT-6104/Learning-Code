#include<iostream>
#include<fstream>

using namespace std;

int main() {
    ifstream inpf("anh.dat");
    int m, n;
    inpf >> m;
    inpf >> n;
    
    int a[100][100], max = 0, min = 255, count = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            inpf >> a[i][j];
            if (a[i][j] > max)  max = a[i][j];
            if (a[i][j] < min)  min = a[i][j];
            if (a[i][j] < 70)   count++;
        }
    }   

    cout << "Diem toi nhat: " << min << endl;
    cout << "Diem sang nhat: " << max << endl;
    cout << "So diem anh nho hon 70: " << count;

    inpf.close();
    return 0;
}