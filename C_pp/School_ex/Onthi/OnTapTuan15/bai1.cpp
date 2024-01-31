#include <iostream>
#include <cmath>
#include <algorithm>
#include <set>
#include <vector>

using namespace std;

// Ham nhap gia tri 
void inputArray(int a[], int &n) {
    // Nhap n
    do {
        cout << "Nhap n: ";
        cin >> n;
    } while (n >= 1000 or n < 0);

    // Nhap mang
    cout << "Nhap day gom " << n << " so nguyen duong: ";
    for (int i = 0; i < n; i++) cin >> a[i];
}

// Ham dem gia tri x
int countX(int a[], int n, int x) {
    int count = 0;
    for (int i = 0; i < n; i++) if (x == a[i])  count++;
    return count;
}

// Ham sap xep day so theo quy tac
void sapXepHam(int a[], int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = i + 1; j < n; j++) {
            if (a[j] % 2 == 0 and a[i] % 2 != 0) {
                swap(a[i], a[j]);
                break;
            }
        }
    }
}

// Ham hien thi toan bo day so
void hienThi(int a[], int n) {
    for (int i = 0; i < n; i++) cout << a[i] << " ";
    cout << endl;
}

// ham kiem tra so nguyen to
bool checkSNT(int x)  {
    for (int i = 2; i <= sqrt(x); i++) {
        if (x % i == 0 or x < 2) return false;
    }
    return true;
}

// Ham hien thi so nguyen to
void hienThiSNT(int a[], int n) {
    set<int> b; // Chua cac so nguyen to khac nhau
    for (int i = 0; i < n; i++) {
        if (checkSNT(a[i])) b.insert(a[i]);
    }

    // Hien thi cac so nguyen to
    cout << "\n- Cac so nguyen to trong day la: ";
    for (int soNT: b) cout << soNT << " ";
    cout << endl;
}

// Ham hien thi a,b,c thoa man a**2 = b**2 + c**2
void hienThiBoBa(int arr[], int n) {
    vector<int> boBa;   // Chua bo ba so a, b, c thoa man
    bool check = false; // Kiem tra co ton tai bo 3 so a,b,c thoa man
    for (int i = 0; i < n - 2; i++) {
        for (int j = i + 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                int a = arr[i];
                int b = arr[j]; 
                int c = arr[k];
                if (a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b) {
                    boBa.push_back(a);
                    boBa.push_back(b);
                    boBa.push_back(c);
                    check = true;
                }
            }
        }
    }

    if (check) {
        cout << "\n- Bo 3 so a, b, c thoa man la: ";
        for (int i = 0; i < boBa.size(); i+=3) {
            cout << boBa[i] << "-" << boBa[i+1] << "-" << boBa[i+2] << " ";
        }
    }
    else cout << "\n- Khong co 3 so a,b,c thoa man a**2 = b**2 + c**2";
}

int main() {
    // a
    int n;
    int arr[100];
    inputArray(arr, n); // Nhap n va day so

    // b
    int x;
    cout << "Nhap x: "; cin >> x;
    cout << "- So lan xuat hien " << x << " trong day la: " << countX(arr,n,x) << endl;

    // c
    sapXepHam(arr, n);
    cout << "\n- Day so sau khi sap xep la: ";
    hienThi(arr, n);

    // d
    hienThiSNT(arr, n);

    // e
    hienThiBoBa(arr, n);
    return 0;
}