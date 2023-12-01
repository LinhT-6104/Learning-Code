#include <iostream>
#include <vector>
#include <iomanip>

using namespace std;

class quanLy {
private:
    float chieuDai;
    float chieuRong;
    static quanLy loDatMax; // Thêm một biến tĩnh để lưu trữ thông tin lô đất có diện tích lớn nhất

public:
    static float maxArea;   // Biến tính maxArea tìm diện tích lớn nhất
    static float thue;      // Biến tính thuế tính theo diện tích

    void nhapDL() {
        cout << "Nhap chieu dai: "; cin >> chieuDai;
        cout << "Nhap chieu rong: "; cin >> chieuRong;
        if (dienTich() > maxArea) {
            maxArea = dienTich();   // Cập nhật diện tích lớn nhất
            // Đặt loDatMax là vị trí hiện tại trong mảng
            loDatMax = *this;
        }
        thue += dienTich() * 1000;  // Tính thuế
    }

    float dienTich() {
        return chieuDai * chieuRong;
    }

    void hienThi() {
        cout << "- Chieu dai: " << chieuDai << endl;
        cout << "- Chieu rong: " << chieuRong << endl;
        cout << "- Dien tich: " << dienTich() << endl;
    }

    // Thêm một hàm tĩnh để lấy loại có diện tích lớn nhất trả về trong main
    static quanLy getLoDatMax() {
        return loDatMax;
    }
};

float quanLy::maxArea = 0;
float quanLy::thue = 0;
quanLy quanLy::loDatMax;  // Khởi tạo biến tĩnh

main() {
    int n;
    do {
        cout << "Nhap so lo dat: ";
        cin >> n;
    } while (n >= 200);

    vector<quanLy> loDat(n);

    for (int i = 0; i < n; i++) {
        cout << "\nNhap thong tin lo dat " << i + 1 << endl;
        loDat[i].nhapDL();
    }

    cout << "\nCac lo dat co dien tich lon hon 200 m2:\n";
    for (int i = 0; i < n; i++) {
        if (loDat[i].dienTich() > 200) {
            cout << "Lo dat " << i + 1 << endl;
            loDat[i].hienThi();
        }
    }

    cout << "\nLo dat co gia tri lon nhat trong khu do thi An Binh\n";
    // Sử dụng hàm tĩnh để lấy loại có diện tích lớn nhất
    quanLy loDatMax = quanLy::getLoDatMax();
    loDatMax.hienThi();
    cout << "- Gia tri: " << fixed << setprecision(2) << quanLy::maxArea * 1000 << " trieu dong\n";

    cout << "\n- Tong so thue Ban quan ly khu do thi thu duoc trong nam 2020: " << fixed << setprecision(2) << quanLy::thue;
    return 0;
}
