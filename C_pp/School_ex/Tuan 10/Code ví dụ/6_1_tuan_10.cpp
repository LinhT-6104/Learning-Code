#include <iostream>
#include <string>   

using namespace std;

class hinhTron {
private:
    double banKinh;
    string mauSac;
        
public:
    hinhTron();                 // Ham tao 1
    hinhTron(double banKinh);   // Ham tao 2
    hinhTron(double banKinh, string mauSac);    // Ham tao 3
    void setBanKinh(double banKinh);
    void setMauSac(string mauSac);
    double layBanKinh();   // Ham lay ban ban kinh 
    string layMauSac(); // Ham lay mau sac 
    hinhTron(hinhTron &copyFunc);   // Ham sao chep
    double dienTich(); // Ham tinh dien tich
    void hienThi(); // Ham hien thi thong tin hinh tron
    ~hinhTron();
};

hinhTron::hinhTron() {
    banKinh = 0;
}

hinhTron::hinhTron(double banKinh) {
    this->banKinh = banKinh;
}

hinhTron::hinhTron(double banKinh, string mauSac) {
    this->banKinh = banKinh;
    this->mauSac = mauSac;
}

// Hàm thiết lập bán kính
void hinhTron::setBanKinh(double banKinh) {
    this->banKinh = banKinh;
}

// Hàm thiết lập màu sắc
void hinhTron::setMauSac(string mauSac) {
    this->mauSac = mauSac;
}

double hinhTron::layBanKinh() {
    return banKinh;
}

string hinhTron::layMauSac() {
    return mauSac;
}

hinhTron::hinhTron(hinhTron &copyFunc) {
    this->banKinh = copyFunc.banKinh;
    this->mauSac = copyFunc.mauSac;
}

double hinhTron::dienTich() {
    return 3.14*banKinh*banKinh;
}

void hinhTron::hienThi() {
    cout << "THONG TIN HINH TRON: ";
    cout << "\n- Mau sac: " << mauSac;
    cout << "\n- Ban kinh: " << banKinh;
    cout << "\n- Dien tich: " << dienTich();
}

hinhTron::~hinhTron() {
    // Khong can delete cho cac bien co ban nhu double hay string
}

int main() {
    hinhTron Circle(3.5, "Hong"), Circle1 = Circle;  
    Circle1.hienThi();
    return 0;
}