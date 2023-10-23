#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Hàm nhập dữ liệu đầu vào
void input(int &n, int dinhduong[], int docto[]) {
    cout << "Nhap so loai nam: ";  
    cin >> n;
    cout << "Nhap muc dinh duong cua moi loai nam: ";
    for (int i = 0; i < n; i++) {
        cin >> dinhduong[i];
    } 
    cout << "Nhap muc doc to cua moi loai nam: ";
    for (int i = 0; i < n; i++) {
        cin >> docto[i];
    } 
}

// Hàm thông tin về các loại nấm mà người dân có thể hái về ăn được
void nam_an_duoc(int n, int dinhduong[], int docto[]) {
    cout << "Thong tin cac loai nam nguoi dan co the hai ve an: ";
    for (int i = 0 ; i < n; i++) {
        if (dinhduong[i] >= 2*docto[i]) {
            cout << "(" << dinhduong[i] << ", " << docto[i] << ") ";
        }
    }
    cout << endl;
}

// Hàm thông tin về các loại nấm có lượng độc tố cao nhất
void doc_to_max(int n, int dinhduong[], int docto[]) {
    cout << "Thong tin cac loai nam co luong doc to cao nhat: ";
    int max = 0;
    // Tìm lượng độc tố lớn nhất trong mảng docto
    for (int i = 0; i < n; i++) {
        if (max <= docto[i]) {
            max = docto[i];
        }
    }
    // In ra các thông tin ở vị trí có mức độc tố bằng max trong mảng docto
    for (int i = 0; i < n; i++) {
        if (docto[i] == max) {
            cout << "(" << dinhduong[i] << ", " << docto[i] << ") ";
        }
    }
    cout << endl;
}

// Hàm sắp xếp các loại nấm theo chiều không giảm của mức dinh dưỡng
void sapxep(int n, int dinhduong[], int docto[]) {
    cout << "Sap xep cac loai nam: ";

    // Tạo mảng chứa các giá trị dinh dưỡng sau khi sắp xếp
    vector<int> sapxep;
    for (int i = 0; i < n; i++) sapxep.push_back(dinhduong[i]);

    sort(sapxep.begin(), sapxep.end()); // Sắp xếp độ dinh dưỡng tăng dần của các loại nấm

    // In ra thông tin các loại nấm theo chiều tăng dần của mức dinh dưỡng
    for (int i = 0; i < sapxep.size(); i++) {
        for (int j = 0; j < sapxep.size(); j++) {
            if (dinhduong[j] == sapxep[i]) {
                cout << "(" << dinhduong[j] << ", " << docto[j] << ") ";
                //break;
            }
        }
    }
}

int main() {
    int n, dinhduong[100], docto[100];
    input(n, dinhduong, docto);
    nam_an_duoc(n, dinhduong, docto);
    doc_to_max(n, dinhduong, docto);
    sapxep(n, dinhduong, docto);
    return 0;
}