#include<iostream>
#include<climits>

using namespace std;

// Nhập n và dãy số có độ dài n
void input(int &n, int array[]) {
    cout << "n = "; cin >> n;
    cout << "Nhap day so: ";
    for (int i = 0; i < n; i++) {
        cin >> array[i];
    }
}

// In ra dãy số đã nhập
void dayso(int n, int a[]) {
    cout << "Day so da nhap: ";
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
}

// Hàm tính tổng các số nguyên dương của dãy số
int so_nguyen_duong(int n, int a[]) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
        if (a[i] > 0) {
            sum += a[i];
        }
    }
    return sum;
}

// Hàm in ra vị trí các phần tử có giá trị nhỏ nhất
void min(int n, int a[]) {
    cout << "Vi tri cac phan tu co gia tri nho nhat: ";
    int min = a[0];
    for (int i = 0; i < n; i++) {
        if (min > a[i]) {
            min = a[i];
        }
    }
    for (int i = 0; i < n; i++) {
        if (min == a[i]) {
            cout << i << ' ';
        }
    }
    cout << endl;
}

// Hàm kiểm tra số có phải duy nhất trong dãy không
bool check(int n, int a[], int b) {
    int count = 0; 
    for (int i = 0; i < n; i++) {
        if (a[i] == b) {
            count++;
        }
    }
    if (count > 1) return false;
    return true;
}

// Hàm hiển thị lên màn hình các số nguyên khác nhau trong dãy số
void different_number(int n, int a[]) {
    cout << "Cac so nguyen khac nhau trong day so: ";
    for (int i = 0; i < n; i++) {
        if (check(n, a, a[i])) {
            cout << a[i] << " ";
        }
    }
}

int main() {
    int n, array[100];
    input(n, array);
    dayso(n, array);
    cout << "Tong cac so nguyen duong trong day so: " << so_nguyen_duong(n, array) << endl;
    min(n, array);
    different_number(n, array);
    return 0;
}