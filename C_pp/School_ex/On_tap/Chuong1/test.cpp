#include <iostream>

using namespace std;

class point {
public:
    int x,y;
    point() {x = y = 0;}
    point(int x, int y) {
        this->x = x;
        this->y = y;
    }
    void pointDisplay(){
        cout << "x = " << x << endl;
        cout << "y = " << y << endl;
    }
};

class circle : public point {
    int r;

public:
    circle() {x = y = r = 0;};
    circle(int x, int y, int r) {
        this->x = x;
        this->y = y;
        this->r = r;
    }
    void circleDisplay() {
        pointDisplay();
        cout << "r = " << r << endl;
    }
};

int main() {
    circle A(10, 20, 5);
    A.pointDisplay();
    A.circleDisplay();
    return 0;
}