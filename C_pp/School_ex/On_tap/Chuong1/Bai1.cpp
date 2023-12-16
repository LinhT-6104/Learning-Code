#include <iostream>

using namespace std;

class ChanLe {
private:
    int n;

public:
    ChanLe() {
        n = 0;
    }
    ChanLe(int n) {
        this->n = n;
    }
    friend istream & operator>>(istream &is, ChanLe &x) {
        cout << "Nhap so: ";
        is >> x.n;
        return is;
    }
    friend ostream & operator<<(ostream &os, ChanLe &x) {
        if (x.n % 2 == 0)   os << x.n << " la so chan";
        else    os << x.n << " la so le";
    }
};

int main() {
    ChanLe so;
    cin >> so;
    cout << so;
    return 0;
}