#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class TDate {
private:
    short day;
    short month;
    short year;

public:
    TDate() : day(0), month(0), year(0) {}

    void nhapDL() {
        cin >> day >> month >> year;
    }

    void hienThi() {
        cout << day << "/" << month << "/" << year;
    }

    int khoangCach() {
        int result = (year - 1) * 365 + day;
        for (int i = 1; i < month; i++) {
            switch (i) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    result += 31;
                    break;
                case 4: case 6: case 9: case 11:
                    result += 30;
                    break;
                case 2:
                    if ((year % 4 == 0 and year % 100 != 0) or (year % 100 == 0 and year % 400 == 0)) {
                        result += 29;
                    }
                    else {
                        result += 28;
                    }
                    break;
            }
        }

        return result;
    }
};

class Person {
private:
    string hoTen;
    TDate ngaySinh;
    string queQuan;

public:
    Person() {}

    Person(string hoTen, TDate ngaySinh, string queQuan)
        : hoTen(hoTen), ngaySinh(ngaySinh), queQuan(queQuan) {}

    Person(const Person &a)
        : hoTen(a.hoTen), ngaySinh(a.ngaySinh), queQuan(a.queQuan) {}

    void nhapDL() {
        cout << "Nhap ho ten: ";
        getline(cin, hoTen);

        cout << "Nhap ngay sinh: ";
        ngaySinh.nhapDL();

        cout << "Nhap que quan: ";
        getline(cin, queQuan);
    }

    void hienThi() {
        cout << "Ho ten: " << hoTen << endl;
        cout << "Ngay sinh: ";
        ngaySinh.hienThi();
        cout << endl;
        cout << "Que quan: " << queQuan << endl;
    }

    int layTuoi() {
        return ngaySinh.khoangCach() / 365;
    }

    string layHoTen() const {
        return hoTen;
    }
};

bool sapXepTheoTuoi(Person &nguoi1, Person &nguoi2) {
    return nguoi1.layTuoi() < nguoi2.layTuoi();
}

void inNguoiCoHoTenAnh(const vector<Person> &danhSach) {
    cout << "Nhung nguoi co ho ten chua tu 'Anh':\n";
    for (const Person &nguoi : danhSach) {
        if (nguoi.layHoTen().find("Anh") != string::npos) {
            nguoi.hienThi();
            cout << endl;
        }
    }
}

int main() {
    int n;
    do {
        cout << "Nhap so nguoi (n < 50): ";
        cin >> n;
        cin.ignore();
    } while (n >= 50);

    vector<Person> danhSachNguoi(n);

    for (int i = 0; i < n; i++) {
        cout << "Nhap thong tin cho nguoi thu " << i + 1 << ":\n";
        danhSachNguoi[i].nhapDL();
    }

    cout << "\nDanh sach nguoi vua nhap:\n";
    for (int i = 0; i < n; i++) {
        cout << "Nguoi thu " << i + 1 << ":\n";
        danhSachNguoi[i].hienThi();
        cout << endl;
    }

    sort(danhSachNguoi.begin(), danhSachNguoi.end(), sapXepTheoTuoi);

    cout << "\nDanh sach nguoi theo tuoi tang dan:\n";
    for (int i = 0; i < n; i++) {
        cout << "Nguoi thu " << i + 1 << ":\n";
        danhSachNguoi[i].hienThi();
        cout << endl;
    }

    inNguoiCoHoTenAnh(danhSachNguoi);

    return 0;
}
