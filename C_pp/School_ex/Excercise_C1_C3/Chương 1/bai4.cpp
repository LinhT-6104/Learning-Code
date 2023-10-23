#include<iostream>

using namespace std;

int main(){
    // Nhap diem 3 mon
    float toan, ly, hoa, dtb;
    cout << "Nhap diem toan: ";
    cin >> toan;
    cout << "Nhap diem ly: ";
    cin >> ly;
    cout << "Nhpa diem hoa: ";
    cin >> hoa;

    // Tinh diem trung binh
    dtb = (toan + ly + hoa)/3;
    
    // Xep loai hoc sinh dua tren diem trung binh
    if (dtb >= 8) {
        cout << "Xep loai gioi";
    }
    else if (dtb >= 7) {
        cout << "Xep loai kha";
    }
    else if (dtb >= 5) {
        cout << "Xep loai trung binh";
    } else {
        cout << "xep loai yeu";
    }
    return 0;
}