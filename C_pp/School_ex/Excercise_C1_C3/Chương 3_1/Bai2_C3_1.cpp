#include<iostream>
#include<cmath>

using namespace std;

void input(int a[][100], int &dong, int &cot);
void show(int dong, int cot, int a[][100]);
int sum_array(int dong, int cot, int a[][100]);
int sum_k_current(int cot, int a[][100]);
int sum_k_column(int dong, int a[][100]);
bool check_snt(int a);
int count_snt(int dong, int cot, int a[][100]);
void sap_xep_k_current(int dong, int cot, int a[][100]);
void swap_column_current(int dong, int cot, int a[][100]);

main(){
    int a[100][100], dong, cot;
    input(a, dong, cot);
    show(dong, cot ,a);
    cout << endl;
    cout << "Tong cac phan tu cua mang: " << sum_array(dong, cot, a) << endl << endl;
    cout << sum_k_current(cot, a) << endl << endl;
    cout << sum_k_column(dong, a) << endl << endl;
    cout << "So luong cac so la so nguyen to trong mang la: " << count_snt(dong, cot, a) << endl << endl;
    sap_xep_k_current(dong, cot, a);
    swap_column_current(dong, cot, a);
    return 0;
}

// Ham nhap gia tri mang 2 chieu
void input(int a[][100], int &dong, int &cot) {
    cout << "Nhap so dong: ";  cin >> dong;
    cout << "Nhap so cot: ";    cin >> cot;
    cout << "Nhap ma tran:\n";
    for (int i = 0; i < dong; i++) {
        for (int j = 0 ; j < cot; j++)
        cin >> a[i][j];
    }
    cout << endl;
}

// Ham hien tri mang vua nhap
void show(int dong, int cot, int a[][100] ) {
    cout << "Ma tran vua nhap la:\n";
    for (int i = 0; i < dong; i++) {
        for (int j = 0 ; j < cot; j++) {
            cout << a[i][j] << "\t";
        }
        cout << endl;
    }
}

// Ham tinh tong gia tri mang 2 chieu
int sum_array(int dong, int cot, int a[][100]) {
    int sum = 0;
    for (int i = 0; i < dong; i++) {
        for (int j = 0 ; j < cot; j++)
        sum += a[i][j];
    }
    return sum;
}

// Ham tinh tong dong thu k
int sum_k_current(int cot, int a[][100]) {
    int sum = 0, k;
    cout << "Nhap dong can tinh tong: ";
    cin >> k;
    cout << "Tong dong " << k << " la: ";
    for (int i = 0 ; i < cot; i++) {
        sum += a[k][i];
    }
    return sum;
}

// Ham tinh tong cot thu k
int sum_k_column(int dong, int a[][100]) {
    int k, sum = 0;
    cout << "Nhap cot can tinh tong: ";
    cin >> k;
    cout << "Tong cot " << k << " la: ";
    for (int i = 0; i < dong; i++) {
        sum += a[i][k];
    }
    return sum;
}

// Ham kiem tra so nguyen to
bool check_snt(int a) {
    for (int i = 2; i <= sqrt(a); i++) {
        if (a % i == 0) return false;
    }
    return true;
}

// Ham dem so nguyen to trong mang
int count_snt(int dong, int cot, int a[][100]) {
    int count = 0;
    for (int i = 0; i < dong; i++) {
        for (int j = 0; j < cot; j++) {
            if (check_snt(a[i][j])) {
                count++;
            }
        }
    }
    return count;
}

// Ham sap xep dong thu k
void sap_xep_k_current(int dong, int cot, int a[][100]) { 
    int k;
    cout << "Nhap dong can sap xep: ";
    cin >> k;
    for (int i = 0; i < cot - 1; i++) {
        for (int j = i; j < cot ; j++) {
            if (a[k][j] < a[k][i]) {
                swap(a[k][j], a[k][i]);
            }
        }
    }
    cout << "Ham sau khi sap xep dong " << k << endl;
    for (int i = 0; i < dong; i++) {
        for (int j = 0; j < cot; j++) {
            cout << a[i][j] << "\t";
        }
        cout << endl;
    }
    cout << endl;
}

// Ham doi dong voi cot
void swap_column_current(int dong, int cot, int a[][100]) {
    cout << "Hoan doi dong va cot:\n";
    for (int i = 0; i < cot; i++) {
        for (int j = 0; j < dong; j++) {
            cout << a[j][i] << "\t";
        }
        cout << endl;
    }
}