#include<iostream>

using namespace std;

class Color {
private:
    string TenMau;
    string MaMau;
public:
    Color() {
        TenMau = MaMau = "";
    }
    Color(string TenMau, string MaMau) {
        this->TenMau = TenMau;
        this->MaMau = MaMau;
    }
    friend istream &operator>>(istream &inp, Color &x) {
        cout << "Nhap ten mau: ";
        getline(inp, x.TenMau);
        cout << "Nhap ma mau: ";
        getline(inp, x.MaMau);
        return inp;
    }
    friend ostream &operator<<(ostream &out, Color &x) {
        out << "- Ten mau: " << x.TenMau << endl;
        out << "- Ma mau: " << x.MaMau << endl;
        return out;
    }
    string getTenMau() {
        return TenMau;
    }
};

class Point {
private:
    int x;
    int y;
public:
    Point() {
        x = y = 0;
    }
    Point(int x, int y) {
        this->x = x;
        this->y = y;
    }
    friend istream &operator>>(istream &inp, Point &a) {
        cout << "Nhap toa do x: ";
        inp >> a.x;
        cout << "Nhap toa do y: ";
        inp >> a.y;
        return inp;
    }
    friend ostream &operator<<(ostream &out, Point &a) {
        out << "- x: " << a.x << endl;
        out << "- y: " << a.y << endl;
    }
    bool CheoChinh() {
        return x == y;
    }
};

class Pixel: public Color, public Point {
public:
    Pixel() : Color(), Point() {}
    Pixel(string TenMau, string MaMau, int x, int y) : Color(TenMau, MaMau), Point(x, y) {}
    friend istream &operator>>(istream &inp, Pixel &a) {
        inp >> static_cast<Color&>(a);
        inp >> static_cast<Point&>(a);
        return inp;
    }
    friend ostream &operator<<(ostream &out, Pixel &a) {
        out << static_cast<Color&>(a);
        out << static_cast<Point&>(a);
        return out;
    }
    bool KiemTra() {
        return CheoChinh() && getTenMau() == "Xanh";
    }
};

void nhapDL(int n, Pixel pixel[]) {
    cout << "Nhap n: "; cin >> n;
    cin.ignore();
    for (int i = 0; i < n; i++) {
        cout << "--- pixel " << i+1 << " ---\n";
        cin >> pixel[i];
        cin.ignore();
    }
}

void show(int n, Pixel pixel[]) {
    cout << "\nCac pixel thoa man\n";
    for (int i = 0; i < n; i++) {
        if (pixel[i].KiemTra()) cout << pixel[i] << endl;
    }
}

int main() {
    int n;
    Pixel pixel[100];
    nhapDL(n, pixel);
    show(n, pixel);
    return 0;
}