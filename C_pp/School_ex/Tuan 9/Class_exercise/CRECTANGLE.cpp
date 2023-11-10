#include<iostream>

using namespace std;

class Cretangle {
private:
    int x,y;
public:
    void set_values(int c, int d);
    int area() {return x*y;}
};

void Cretangle::set_values(int a, int b) {
    x = a;
    y = b;
}

int main() {
    Cretangle rect;
    rect.set_values(3,4);
    cout << "area: " << rect.area();
    return 0;
}