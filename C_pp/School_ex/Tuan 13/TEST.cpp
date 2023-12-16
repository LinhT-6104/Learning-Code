#include <iostream>
#include <cmath>

using namespace std;

class complex {
    double a,b;

public:
    complex() { a = 0; b = 0; }
    complex(double a, double b) {
        this->a = a;
        this->b = b;
    }
    complex operator+(complex x) {
        complex tmp;
        tmp.a = a + x.a;
        tmp.b = b + x.b;
        return tmp;
    }
    complex operator-(complex x) {

    }
    complex operator+=(complex x) {
        a = a + x.a;
        b = b + x.b;
        return *this;
    }
    complex operator+(double z ) {
        complex tmp;
        tmp.a = this->a + z;
        tmp.b = this->b;
    }
    friend istream & operator>>(istream &is, complex &x) {
        cout << "Cho biet a:";
        is >> x.a;
        cout << "Cho biet b:";
        is >> x.b;
        return is;
    }
    friend ostream & operator<<(ostream &os, complex &x) {
        os << "*****" << endl;
        os << x.a << " + " << x.b << " * i" << endl;
        os << "*****" << endl;
        return os;
    }
    friend complex operator+(double z, complex x) {
        complex tmp;
        tmp.a = x.a + z;
        tmp.b = x.a;
        return tmp;
    }
    void display() {
        cout << a << " + " << b << " * i " << endl;
    }
};

int main() {
    complex A(4, 8), B(3, 4), C;
    cout << "A = ";
    A.display();
    cout << "B = ";
    B.display();
    C = A + B;  // C = A.operator+(B);
    cout << "C = ";
    C.display();
    A += C;     // A = A.operator+=(C);
    A.display();
    A.display();
    complex D;
    cin >> D;   // Gọi hàm toán tử nhập
    cout << D;  // Gọi hàm toán tử xuất
    return 0;
}