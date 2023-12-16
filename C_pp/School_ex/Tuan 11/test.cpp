#include <iostream>
#include <cmath>

using namespace std;

class complex {
private:
    string name;
    int age;

public:
    complex() {
        name = "";
        age = 0;
    }
    void setName(string n) {
        name = n;
    }
    string getName() {
        return name;
    }
};

int main() {
    complex A;
    A.setName("Hong Anh");
    cout << A.getName();
    return 0;
}