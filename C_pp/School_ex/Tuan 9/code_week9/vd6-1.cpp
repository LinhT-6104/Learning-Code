// vi du: xay dung lop vector day du
#include <iostream>
#include <conio.h>
#include <math.h>
using namespace std;
// dinh nghia lop vector
class VECTOR{
public:
	int n;
	float *v;
	VECTOR();
	VECTOR(int n);
	VECTOR(int n, float *v1);
	VECTOR(VECTOR &a);
	float Timmax(int n, float *v1);
	void Hienthi();
	~VECTOR();
};
//trien khai cac ham thanh phan
VECTOR::VECTOR() { 
	n = 0;
	v = NULL;
}
VECTOR::VECTOR(int n) {
	this->n = n;
	v = new float [n];//xin cap phat bo nho
	for (int i = 0; i < n; i++) v[i] = 0;
}
VECTOR::VECTOR(int n, float *v1) {
	this->n = n;
	this->v = new float [n];
	for (int i = 0; i < n; i++) {
		v[i] = v1[i];
	}
}
void VECTOR::Hienthi() {
	cout << "So chieu: " << n << endl;
	cout << "Cac thanh phan: " << endl;
	cout << "	[" << v[0]; 
	for (int i = 1; i < n; i++) cout << ", " << v[i];
	cout << "]";
}

float VECTOR::Timmax(int n, float *v1){
	this->n = n;
	float max = v1[0];
	for (int i = 0; i < n; i++) {
		if(v1[i] > max){
			max = v1[i];
		}
	}
	return max;
}

VECTOR::~VECTOR() {
	delete v;
}
// chuong trinh chinh
int main() {
	float v[] = {3,4,2,1,4,6};
	VECTOR A(6, v), B;
	B = A;
	B.Hienthi();
	
	cout << "\nPhan tu max nhat: " << B.Timmax(6, v);
	cout << endl;
	return 0;
}

