#include <iostream>
#include <string>

using namespace std;

class Fraction {
    public:
        Fraction() {};

        Fraction(string b) {
            cout << b;
        }

        void inRa() {
            cout << "Hello";
        }
};

int main() {
    Fraction a;
    a.inRa();
    return 0;
}