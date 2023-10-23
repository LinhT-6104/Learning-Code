#include<iostream>
#include<algorithm>

using namespace std;

void input_matrix(int &n, int &m, int a[][100]);
void show_matrix(int n, int m, int a[][100]);
int max_matrix(int n, int m, int a[][100]);
void index_max_matrix(int n, int m, int a[][100]);
void sap_xep_matrix(int n, int m, int a[][100]);
void dao_matrix(int n, int m, int a[][100]);

int main(){
    int n, m, a[100][100];
    input_matrix(n,m,a);
    show_matrix(n,m,a);
    cout << "Gia tri lon nhat trong ma tran la: " << max_matrix(n,m,a) << endl;
    index_max_matrix(n,m,a);
    sap_xep_matrix(n,m,a);
    dao_matrix(n,m,a);
    return 0;
}

void input_matrix(int &n, int &m, int a[][100]) {
    cout << "Nhap so hang: "; cin >> n;
    cout << "Nhap so cot: "; cin >> m;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cout << "[" << i <<"][" << j << "] = ";
            cin >> a[i][j];
        }
    }
}

void show_matrix(int n, int m, int a[][100]) {
    cout << "Ma tran vua nhap:" << endl;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}

int max_matrix(int n, int m, int a[][100]) {
    int max = 0;
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            if (max < a[i][j]) {
                max = a[i][j]; 
            }
        }
    }
    return max;
}

void index_max_matrix(int n, int m, int a[][100]) {
    cout << "Cac vi tri xuat hien max: ";
    for (int i = 0; i < n; i++){
        for (int j = 0; j < m; j++){
            if (a[i][j] == max_matrix(n,m,a)) {
                cout<<"["<<i<<","<<j<<"] ";
            }
        }
    }
    cout << endl;
}

void sap_xep_matrix(int n, int m, int a[][100]) {
    int k;
    cout << "Nhap dong k: ";
    cin >> k;
    sort(a[k-1], a[k-1] + m);
    cout << "Ma tran sau khi sap xep: " << endl;
    for (int i = 0; i < n; i++){
        for (int j = 0 ; j < m; j++){
            cout << a[i][j]<< " ";
        }
        cout << endl;
    }
}   

void dao_matrix(int n, int m, int a[][100]) {
    cout << "Ma tran sau khi dao dong va cot: " << endl;
    for (int j = 0; j < m; j++){
        for (int i = 0; i < n; i++){
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
}