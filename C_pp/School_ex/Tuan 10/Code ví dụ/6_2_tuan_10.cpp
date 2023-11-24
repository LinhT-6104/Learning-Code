#include <iostream>
#include <string>
#include <cmath>

using namespace std;

class DIEM {
private:
    double x;
    double y;

public:
    DIEM();
    DIEM(double x, double y);
    double getX();
    double getY();
    void setX(double x);
    void setY(double y);
};

DIEM::DIEM() {
    x = 0;
    y = 0;
}

DIEM::DIEM(double x, double y) {
    this->x = x;
    this->y = y;
}

double DIEM::getX() {
    return x;
}

double DIEM::getY() {
    return y;
}

void DIEM::setX(double x) {
    this->x = x;
}

void DIEM::setY(double y) {
    this->y = y;
}

class hinhTron {
private:
    double banKinh;
    string mauSac;
    DIEM tam;

public:
    hinhTron();
    hinhTron(double banKinh);
    hinhTron(double banKinh, string mauSac, DIEM tam);
    void setBanKinh(double banKinh);
    void setMauSac(string mauSac);
    void setTam(DIEM tam);
    double layBanKinh();
    string layMauSac();
    DIEM layTam();
    hinhTron(const hinhTron &copyFunc);
    double dienTich();
    void hienThi();
    ~hinhTron();
};

hinhTron::hinhTron() {
    banKinh = 0;
}

hinhTron::hinhTron(double banKinh) {
    this->banKinh = banKinh;
}

hinhTron::hinhTron(double banKinh, string mauSac, DIEM tam) {
    this->banKinh = banKinh;
    this->mauSac = mauSac;
    this->tam = tam;
}

void hinhTron::setBanKinh(double banKinh) {
    this->banKinh = banKinh;
}

void hinhTron::setMauSac(string mauSac) {
    this->mauSac = mauSac;
}

void hinhTron::setTam(DIEM tam) {
    this->tam = tam;
}

double hinhTron::layBanKinh() {
    return banKinh;
}

string hinhTron::layMauSac() {
    return mauSac;
}

DIEM hinhTron::layTam() {
    return tam;
}

hinhTron::hinhTron(const hinhTron &copyFunc) {
    this->banKinh = copyFunc.banKinh;
    this->mauSac = copyFunc.mauSac;
    this->tam = copyFunc.tam;
}

double hinhTron::dienTich() {
    return 3.14 * banKinh * banKinh;
}

void hinhTron::hienThi() {
    cout << "THONG TIN HINH TRON: ";
    cout << "\n- Mau sac: " << mauSac;
    cout << "\n- Ban kinh: " << banKinh;
    cout << "\n- Tam hinh tron: (" << tam.getX() << ", " << tam.getY() << ")";
    cout << "\n- Dien tich: " << dienTich();
}

hinhTron::~hinhTron() {
    // Khong can delete cho cac bien co ban nhu double hay string
}

bool giaoNhau(hinhTron a, hinhTron b) {
    // Khoảng cách giữa hai tâm hình tròn
    double khoangCach = sqrt(pow(a.layTam().getX() - b.layTam().getX(), 2) + pow(a.layTam().getY() - b.layTam().getY(), 2));

    // Hai hình tròn giao nhau nếu khoảng cách giữa tâm nhỏ hơn tổng bán kính
    return khoangCach < (a.layBanKinh() + b.layBanKinh());
}

int main() {
    DIEM tam1(0, 0);
    hinhTron Circle(3.5, "Hong", tam1);

    DIEM tam2(1, 1);
    hinhTron Circle1(2.5, "Xanh", tam2);

    Circle.hienThi();
    cout << endl;

    Circle1.hienThi();
    cout << endl;

    if (giaoNhau(Circle, Circle1)) {
        cout << "Hai hinh tron giao nhau.";
    } else {
        cout << "Hai hinh tron khong giao nhau.";
    }

    return 0;
}
