#include <iostream>

using namespace std;

class PHANSO {
    int a, b;
public:
    PHANSO() {
        a = 0;
        b = 0;
    }
    PHANSO(int a, int b) {
        this->a = a;
        this->b = b;
    }
    PHANSO operator+(PHANSO x) {
        PHANSO tmp;
        tmp.a = a + x.a;
        tmp.b = b + x.b;
        return tmp;
    }
    PHANSO operator-(PHANSO x) {
        PHANSO p;
        p.a = a - x.a;
        p.b = b - x.b;
        return p;
        // a = a - x.a;
        // b = b - x.b;
        // return *this;
    }   
    PHANSO operator*(PHANSO x) {
        PHANSO p;
        p.a = x.a * a;
        p.b = x.b * b;
        return p;
    }
    PHANSO operator/(PHANSO x) {
        a = a / x.a;
        b = b / x.b;
        return *this;
    }
    friend istream & operator>>(istream &is, PHANSO &x) {
        cout << "Nhap a: ";
        is >> x.a;
        cout << "Nhap b: ";
        is >> x.b;
        return is;
    }

    friend ostream & operator<<(ostream &os, PHANSO &x) {
        os << "a = " << x.a << endl;
        os << "b = " << x.b << endl;
        return os;
    }
};

int main() {
    PHANSO A(8,9), B(2,3), C;
    C = A + B;
    cout << "A + B:\n" << C << endl;
    C = A - B;
    cout << "A - B:\n" << C << endl;
    C = A * B;
    cout << "A * B:\n" << C << endl;
    C = A / B;
    cout << "A / B:\n" << C << endl;
    cin >> C;
    cout << C << endl;
    return 0;
}