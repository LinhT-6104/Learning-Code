#include<iostream>
#include<cmath>
#include<iomanip>

using namespace std;

// Tạo lập kiểu bản ghi biểu diễn vector trong hệ tọa độ trực chuẩn 2 chiều
struct toado {
    float x,y;
};

// Hàm nhập tọa độ vector
void input(toado &vector1, toado &vector2) {
    cout << "Toa do vector 1: \n";
    cout << "x1 = "; cin >> vector1.x;
    cout << "y1 = "; cin >> vector1.y;
    cout << "Toa do vector 2: \n";
    cout << "x2 = "; cin >> vector2.x;
    cout << "y2 = "; cin >> vector2.y;
    cout << endl;
}

// Hàm tính độ dài vector
float lengthvector(toado vector) {
    return sqrt(vector.x * vector.x + vector.y * vector.y);
}

// Hàm tính tổng 2 vector
toado sumvector(toado vector1, toado vector2) {
    toado sum;
    sum.x = vector1.x + vector2.x;
    sum.y = vector1.y + vector2.y;
    return sum;
}

// Hàm tính hiệu 2 vector
toado diffvector(toado vector1, toado vector2) {
    toado diff;
    diff.x = vector1.x - vector2.x;
    diff.y = vector1.y - vector2.y;
    return diff;
}


int main(){
    toado vector1, vector2;
    input(vector1, vector2);
    cout << "Do dai vector 1: " << fixed << setprecision(2) << lengthvector(vector1) << endl;
    cout << "Do dai vector 2: " << fixed << setprecision(2) << lengthvector(vector2) << endl << endl;
    toado sum = sumvector(vector1, vector2);
    toado diff = diffvector(vector1, vector2);
    cout << "Tong 2 vector: (" << sum.x << "," << sum.y << ")\n";
    cout << "Hieu 2 vector: (" << diff.x << "," << diff.y << ")";
    return 0;
}