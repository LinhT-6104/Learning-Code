#include<iostream>
#include<algorithm>

using namespace std;

// INPUT giá trị cho dãy
void input_array(int a[], int &n){
    cout << "Moi nhap n: ";
    cin >> n;
    for (int i = 0; i < n; i++) {
        cout << "So thu " << i + 1 << ": ";
        cin >> a[i];
    }
}

// Tìm max_st_2 và min_st_2
void max_min_2(int a[], int n) {
    sort(a, a + n, greater<int>());
    cout << "So nho thu 2 trong day: " << a[n-2] << endl;
    cout << "So lon thu 2 trong day: " << a[1] << endl;
}

// In dãy trước và sau khi nhân 
void nhan_doi(int a[], int n) {
    cout << "Chuoi truoc khi nhan: ";
    for (int i = 0; i < n; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
    cout << "Chuoi sau khi nhan: ";
    for (int i = 0; i < n; i++) {
        if (a[i] % 3 == 0) {
            a[i] *= 2;
        }
        cout << a[i] << " ";
    }
}
int main() {
    int n, a[100];
    input_array(a, n);
    max_min_2(a, n);
    nhan_doi(a, n);
    return 0;
}





