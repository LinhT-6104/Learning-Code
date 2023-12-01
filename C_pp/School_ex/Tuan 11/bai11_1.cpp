#include <iostream>
#include <cmath>

using namespace std;

class TDate {
private:   // Khai báo các thành phần thuộc tính 
    short day;
    short month;
    short year;

public:
    TDate() {
        this->day = 0;
        this->month = 0;
        this->year = 0;
    }

    // Hàm tạo có tham số mặc định
    TDate(short day, short month, short year) {
        this->day = day;
        this->month = month;
        this->year = year;
    }

    TDate(TDate &tdate) {}; // Hàm tạo sao chép

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

    // Hàm tính khoảng cách giữa 2 ngày
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

void soSanh(TDate &A, TDate &B) {   // Hàm so sánh ngày sớm hơn
    cout << "Ngay som hon: ";
    if (A.khoangCach() > B.khoangCach()) B.hienThi();
    else A.hienThi();
};

int main() {
    TDate A;
    TDate B;
    cout << "Nhap ngay 1: ";
    A.nhapDL();
    cout << "Nhap ngay 2: ";
    B.nhapDL();
    cout << "Date ngay 1: ";
    A.hienThi();
    cout << "Date ngay 2: ";
    B.hienThi();
    soSanh(A,B);
    cout << "Khoang cach giua 2 ngay: " << abs(A.khoangCach() - B.khoangCach()) << " days";
    return 0;
}