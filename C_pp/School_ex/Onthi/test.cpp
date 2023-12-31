#include <iostream>

using namespace std;

class Color {
private:
    string TenMau;
    string MaMau;

public:
    // Ham tao khong tham so
    Color() {
        TenMau = "";
        MaMau = "";
    }
    // Ham tao co tham so
    Color(string TenMau, string MaMau) {
        this->TenMau = TenMau;
        this->MaMau = MaMau;
    }
    // Ham tra ve TenMau
    string getTenMau() {
        return TenMau;
    }
    // Toan tu nhap
    friend istream &operator>>(istream &inp, Color &x) {
        cout << "Nhap ten mau: ";
        getline(inp, x.TenMau);
        cout << "Nhap ma mau: ";
        getline(inp, x.MaMau);
        return inp;
    }
    // Toan tu xuat
    friend ostream &operator<<(ostream &outp, Color &x) {
        outp << "- Ten mau: " << x.TenMau << endl;
        outp << "- Ma mau: " << x.MaMau << endl;
        return outp;
    }
};

class Point {
private:
    int x;
    int y;

public:
    // Ham tao khong tham so
    Point() {
        x = y = 0;
    }
    // Ham tao co tham so
    Point(int x, int y) {
        this->x = x;
        this->y = y;
    }
    // Ham CheoChinh
    virtual bool CheoChinh() {
        return x == y;
    }
    // Toan tu nhap
    friend istream &operator>>(istream &inp, Point &diem) {
        cout << "Nhap x: "; inp >> diem.x;
        cout << "Nhap y: "; inp >> diem.y;
        return inp;
    }
    // Toan tu xuat
    friend ostream &operator<<(ostream &outp, Point &diem) {
        outp << "- x = " << diem.x << endl;
        outp << "- y = " << diem.y << endl;
        return outp;
    }
};

class Pixel: public virtual Color, public virtual Point {
public:
    // Ham tao khong tham so
    Pixel(): Color(), Point(){}

    // ham tao co tham so
    Pixel(string TenMau, string MaMau, int x, int y) : Color(TenMau, MaMau), Point(x, y) {}

    // Toan tu nhap
    friend istream& operator>>(istream& inp, Pixel& pixel) {
        inp >> pixel;
        inp >> pixel;
        return inp;
    }
    // Toan tu xuat
    friend ostream& operator<<(ostream& outp, Pixel& pixel) {
        outp << pixel;
        outp << pixel;
        return outp;
    }
    
    // Ham KiemTra
    bool KiemTra() {
        if (CheoChinh() && getTenMau() == "Xanh") return true;
        return false;
    }
};

int main() {
    Pixel pixel[100];   
    int n;
    cout << "Nhap so Pixel: ";  cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        cin >> pixel[i];
        cin.ignore();
    }
    cout << "Pixel thoa man la: ";
    for (int i = 0; i < n; i++) {
        if (pixel[i].KiemTra()) cout << pixel[i];
    }
    return 0;
}