#include <iostream>
using namespace std;
class DIEM {
int x , y;
public:
// ham thanh phan cua lop
DIEM(int x, int y) {
	this->x = x;
	this->y = y;
}
void display() {
	cout << x << "  " << y << endl;
}
private:
// ham tu do compare la ham ban cua lop
friend int compare(DIEM A, DIEM B);
};
// ham tu do 
int compare(DIEM A, DIEM B) {
 // duoc phep truy xuat vao thanh phan du lieu
 if ((A.x == B.x)&&(A.y == B.y))  return 1;
  else  return 0;
}

main() {
	DIEM X(2, 3);
	DIEM Y(2, 3);
	if (compare(X, Y) == 1) cout << "Hai diem trung nhau !";
	else cout << "Hai diem khac nhau !";
	return 0;
}
