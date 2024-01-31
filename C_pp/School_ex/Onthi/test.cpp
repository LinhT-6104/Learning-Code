#include <iostream>
#include <cmath>

using namespace std;

class THIETBI {
private:
    string tenTB;
    int namSX;
    double GiaBan;

public:
    THIETBI() {
        tenTB = "";
        namSX = 0;
        GiaBan = 0;
    }
    THIETBI(string tenTB, int namSX, double GiaBan) {
        this->tenTB = tenTB;
        this->namSX = namSX;
        this->GiaBan = GiaBan;
    }
    virtual void nhapThongTin() {
        cout << "Nhap ten thiet bi: ";  
        cin.ignore();
        getline(cin, tenTB);
        cout << "Nhap nam san xuat: ";  cin >> namSX;
        cout << "Nhap gia ban: "; cin >> GiaBan;
    }
    virtual void hienThiThongTin() {
        cout << "- Ten thiet bi: " << tenTB << endl;
        cout << "- Nam san xuat: " << namSX << endl;
        cout << "- Gia ban: " << GiaBan << endl;
    }
    double getGiaBan(){
        return GiaBan;
    }
	friend bool soSanh (THIETBI A, THIETBI B);
};
bool soSanh(THIETBI A, THIETBI B) {
	return A.GiaBan < B.GiaBan;
}



int main() {
    THIETBI A, B;
	A.nhapThongTin();
	B.nhapThongTin();
	cout << soSanh(A, B);
    
    return 0;
}