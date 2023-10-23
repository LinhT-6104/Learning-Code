#include<iostream>
#include<string>

using namespace std;

struct thongtin {
    string ten, que_quan;
    float toan, van, anh;
};
thongtin sinhvien[100];

// Hàm nhập thông tin về n sinh viên
void input(int &n) {
    // Nhập số sinh viên
    cout << "Nhap so sinh vien: ";
    cin >> n;

    // Nhập thông tin mỗi sinh viên
    for (int i = 0; i < n; i++) {
        cin.ignore();
        cout << "\nSinh vien " << i+1 << endl;
        cout << "Ten: ";
        getline(cin, sinhvien[i].ten);
        cout << "Que quan: ";
        getline(cin, sinhvien[i].que_quan);
        cout << "Diem Toan: ";
        cin >> sinhvien[i].toan;
        cout << "Diem Van: ";
        cin >> sinhvien[i].van;
        cout << "Diem Anh: ";
        cin >> sinhvien[i].anh;
    }
    cout << endl << "------------------------------------------------------------------------" << endl;
}

// Hàm hiển thị thông tin n sinh viên vừa nhập
void showinf(int n) {
    for (int i = 0; i < n; i++) {
        cout << "Thong tin sinh vien " << i + 1 << endl;
        cout << "Ten: " << sinhvien[i].ten << endl;
        cout << "Que quan: " << sinhvien[i].que_quan << endl;
        cout << "Diem Toan: " << sinhvien[i].toan << endl;
        cout << "Diem Van: " << sinhvien[i].van << endl;
        cout << "Diem Anh: " << sinhvien[i].anh << endl;
        cout << endl;
    }
}

// Hàm nhập quê quán từ bàn phím và in ra những sinh viên (chỉ cần in ra tên sinh viên) thuộc vào quê quán đó
void showten(int n) {
    cin.ignore();
    string que; 
    cout << "Nhap que quan can tim: ";
    getline(cin, que);
    cout << "Sinh vien thuoc que " << que << " la:\n";
    for (int i = 0; i < n; i++) {
        if (sinhvien[i].que_quan == que) {
            cout << "- " << sinhvien[i].ten << endl;
        }
    }
    cout << endl;
}

// Hàm xếp loại sinh viên
void xeploai(int n) {
    for (int i = 0; i < n; i++) {
        // Tính điểm trung bình của mỗi sinh viên
        float diemtb = (sinhvien[i].toan + sinhvien[i].van + sinhvien[i].anh)/3;

        // Xếp loại cho sinh viên 
        cout << "Xep loai sinh vien\n";
        cout << "Sinh vien " << i + 1 << " xep loai: ";
        if (diemtb >= 8.5) cout << "Gioi";
        else if (diemtb >= 7) cout << "Kha";
        else if (diemtb >= 5) cout << "Trung binh";
        else cout << "Yeu";
        cout << endl;
    }
}

int main() {
    int n;
    input(n);
    showinf(n);
    showten(n);
    xeploai(n);
    return 0;
}