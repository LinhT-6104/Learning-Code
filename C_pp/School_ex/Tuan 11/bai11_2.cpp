// Con bug e 
#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

class TDate {
private:   // Khai báo các thành phần thuộc tính 
    short day;
    short month;
    short year;

public:
    // Hàm nhập dữ liệu
    void nhapDL() {
        cin >> day;
        cin.ignore();
        cin >> month;
        cin.ignore();
        cin >> year;
    }

    // Hàm hiển thị dữ liệu ra màn hình dưới dạng dd/mm/yyyy
    void hienThi() {
        string d = to_string(day);
        string m = to_string(month);
        string y = to_string(year);
        if (d.length() == 1)    d = "0" + d;
        if (m.length() == 1)    m = "0" + m;
        cout << d << "/" << m << "/" << y << endl;
    }

    // Hàm tính khoảng cách 
    int khoangCach() {
        int result = (year - 1) * 365 + day;    // Tính số ngày từ ngày 1/1/1 tới hiện tại
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

        // Cộng thêm những năm nhuận trước năm hiện tại
        for (int i = 104; i < year; i++) {
            if ((i % 4 == 0 and i % 100 != 0) or (i % 100 == 0 and i % 400 == 0))   result++;
        }
        return result;
    }
};

class Person : public TDate {
private:     // Mô tả thông tin 
    string hoTen;
    string queQuan;

public:
    Person() : TDate() {}

    // Hàm tạo có tham số 
    Person(TDate ngaySinh, string hoTen,string queQuan) : TDate(ngaySinh) {
        this->hoTen = hoTen;
        this->queQuan = queQuan;
    }

    Person(const Person &a) : TDate(a) {}    // Hàm tạo sao chép

    // Hàm nhập của đối tượng thuộc lớp Person
    void nhapDL() { 
        cout << "- Nhap ho ten: ";   
        getline(cin, hoTen);

        cout << "- Nhap ngay sinh: ";
        TDate::nhapDL();

        cout << "- Nhap que quan: ";
        cin.ignore();
        getline(cin,queQuan);
        cout << endl;
    }

    // Hàm hiển thị thông tin của đối tượng thuộc lớp Person
    void hienThi() {
        cout << "- Ho ten: " << hoTen << endl;
        cout << "- Ngay sinh: "; TDate::hienThi();
        cout << "- Que quan: " << queQuan << endl << endl;
    }

    bool coTuAnh() {
        for (int i = 0; i < hoTen.length(); i++) {
            if (hoTen.substr(i, 3) == "Anh")    return true;
        }
        return false;
    }

    string getHoTen() {
        return hoTen;
    }
};

// Hàm sắp xếp danh sách theo chiều không giảm của tuổi
bool sapXep(Person &nguoi1, Person &nguoi2) {
    return nguoi1.khoangCach() < nguoi2.khoangCach();
}

int main() {
    int n;
    do {
        cout << "Nhap so doi tuong: ";
        cin >> n;   cin.ignore();
    } while (n >= 50);
        
    vector<Person> doiTuong(n);

    for (int i = 0; i < n; i++) {
        cout << "Nhap thong tin doi tuong " << i + 1 << ":\n";
        doiTuong[i].nhapDL();
    }

    cout << "Thong tin cac doi tuong vua nhap\n\n";
    for (int i = 0; i < n; i++) {
        cout << "Thong tin doi tuong " << i + 1 << "\n";
        doiTuong[i].hienThi();
    }

    sort(doiTuong.begin(), doiTuong.end(), sapXep); // Sap xep cac doi tuong theo tuoi

    // Hien thi danh sach các doi tuong theo chieu khong giam cua tuoi
    cout << "Danh sach cac doi tuong theo chieu khong giam cua tuoi\n\n";
    for (int i = 0; i < n; i++) {
        cout << "Doi tuong " << i + 1 << "\n";
        doiTuong[i].hienThi();
    }

    // Ham tim ra nhung nguoi trong ho ten co chua tu "Anh"
    cout << "Nhung nguoi trong ho ten co chua tu Anh:\n\n";
    for (int i = 0; i < n; i++) {
        if (doiTuong[i].coTuAnh()) {
            cout << "- " << doiTuong[i].getHoTen() << endl;
        }
    }
    return 0;
}