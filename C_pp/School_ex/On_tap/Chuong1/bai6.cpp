#include <iostream>

using namespace std;

int main() {
    int n;
    cout << "Nhap n: "; cin >> n;

    // Cau 1:
    int a = 0, b = n;
    while (n != 0) {
        a = a * 10 + n % 10; // Lay phan du
        // a = 0 * 10 + 12345 % 10 = 5
        // a = 5 * 10 + 1234 % 10 = 50 + 4 = 54
        // a = 54 * 10 + 123 % 10 = 540 + 3 = 543
        // a = 543 * 10 + 12 % 10 = 5432
        // a = 5432 * 10 + 1 % 10 = 54321

        n = n / 10; // Lay phan nguyen
        // n = 12345 / 10 = 1234
        // n = 1234 / 10 = 123
        // n = 123 / 10 = 12
        // n = 12 / 10 = 1
        // n = 1 / 10 = 0
    }
    if (b == a) {
        cout << "So doi xung";
    }
    else {
        cout << "So khong doi xung";
    }
    return 0;
}