#include <iostream>

using namespace std;

class FRACTION {
    int n;
    int d;

public:
    void simplify() {
        int uc;
        for (int i = 1; i < n; i++) {
            if (n % i == 0 and d % i == 0) {
                uc = i;
            }
        }
        this->n /= uc;
        this->d /= uc;
    } 

    FRACTION(int n, int d) {
        this->n = n;
        this->d = d;
    }

    FRACTION(FRACTION & a) {
        n = a.n;
        d = a.d;
    }

    friend istream & operator>>(istream &inp, FRACTION &x) {
        cout << "Nhap tu so: ";
        inp >> x.n;
        cout << "Nhap mau so: ";
        inp >> x.d;
        return inp;
    }

    friend ostream & operator<<(ostream &outp, FRACTION &x) {
        outp << "Phap so la: " << x.n << "/" << x.d << endl;
        return outp;
    }
};

int main() {

    return 0;
}