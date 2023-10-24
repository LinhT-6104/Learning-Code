#include <iostream>
#include <vector>

using namespace std;

// Nhap n va day so nguyen tu ban phim
void input(int &n, vector<int> &a) {
    cout << "Nhap n: "; cin >> n;
    int b;
    cout << "Nhap day so: ";
    for (int i = 0; i < n; i++) {
        cin >> b;
        a.push_back(b);
    }
}

// Ham dua ra day so da nhap
void show(int n, vector<int> a) {
    cout << "Ham vua nhap la: ";
    for (int b: a) {
        cout << b << " ";
    }
    cout << endl;
}

// Ham tinh tong cac so nguyen duong
int tong(int n, vector<int> a) {
    int sum = 0;
    for (int b: a) {
        if (b > 0)  sum += b;
    }
    return sum;
}

// Ham in ra vi tri cac phan tu co gia tri nho nhat
void min_index(int n, vector<int> a) {
    int min = a[0];
    for (int i = 1; i < n; i++) {
        if (a[i] < min) {
            min = a[i];
        }
    }
    cout << "Vi tri cac phan tu co gia tri nho nhat: ";
    for (int i = 0; i < n; i++) {
        if (a[i] == min) {
            cout << i << " ";
        }
    }
    cout << endl;
}

// Ham hien thi cac so nguyen khac nhau trong day so
bool check(vector<int> a, int i) {
    for (int j = 0; j < i; j++) {
        if (a[i] == a[j]) 
            return false;
    }
    return true;
}

void khac_nhau(int n, vector<int> a) {
    cout << "So nguyen khac nhau trong day so la: ";
    for (int i = 0; i < n; i++) {
        if (check(a, i)) {
            cout << a[i] << " ";
        }
    }
}

int main() {
    int n;
    vector<int> a;
    input(n, a);
    show(n, a);
    cout << "Tong cac so nguyen duong: " << tong(n, a) << endl;
    min_index(n, a);
    khac_nhau(n, a);
    return 0;
} 