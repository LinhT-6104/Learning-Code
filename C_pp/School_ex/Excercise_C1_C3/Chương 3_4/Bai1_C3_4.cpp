#include<iostream>
#include<string>

using namespace std;

struct thongtin {
    string masach;
    string tensach;
    string tacgia;
    float giasach;
    int soluong;
};

string tachten(string s) {
    return s.substr(s.rfind(" ") + 1, s.size());
}

int main() {
    cout << "Nhap so cuon sach: ";
    int n; cin >> n;

    cout << "1. Nhap thong tin sach\n";    // Nhap thong tin cac cuon sach
    thongtin sach[n];
    for (int i = 0; i < n; i++) {
        cout << "Sach " << i << endl;

        cout << "Ma sach: ";
        cin >> sach[i].masach;

        cin.ignore();

        cout << "Ten sach: ";
        getline(cin, sach[i].tensach);

        cout << "Tac gia: ";
        getline(cin, sach[i].tacgia);

        cout << "Gia sach: ";
        cin >> sach[i].giasach;

        cout << "So luong: ";
        cin >> sach[i].soluong;
        cout << endl;
    }

    cout << "2. Thong tin sach vua nhap\n"; // Xuat thong tin cac sach da nhap
    for (int i = 0; i < n; i++) {
        cout << "Ma sach: ";
        cout << sach[i].masach << endl;

        cout << "Ten sach: ";
        cout << sach[i].tensach << endl;

        cout << "Tac gia: ";
        cout << sach[i].tacgia << endl;

        cout << "Gia sach: ";
        cout << sach[i].giasach;

        cout << "So luong: ";
        cout << sach[i].soluong << endl;
    }

    cout << endl;

    cout << "3. Nhung sach co tac gia ten An:\n";   // Hien thi ten nhung cuon sach co tac gia ten An
    for (int i = 0; i < n; i++) {
        if (tachten(sach[i].tacgia) == "An")    cout << "- " << sach[i].tensach << endl;
    }

    cout << endl;

    cout << "4. So cuon sach co ten la \"Lap trinh\" va gia 100.000đ:\n";   // Hien thi ten nhung cuon sach "Lap trinh" va co gia 100.000đ
    string lt = "Lap trinh";
    for (int i = 0; i < n; i++) {
        if (sach[i].tensach.size() < lt.size()) {
            continue;
        } else {
            for (int j = 0; j <= sach[i].tensach.size() - lt.size(); j++) {
                if (sach[j].tensach == lt) {
                    cout << 
                }
            }
        }
    }


    return 0;
}