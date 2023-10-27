#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

using namespace std;

struct thongtin {
    string ma;
    string ten;
    int soluong;
    float giaban;
};
thongtin mathang[50];

// Ham dua ra quy tac sap xep
bool sapxep(const thongtin &mh1, const thongtin &mh2) {
    if (mh1.soluong == mh2.soluong)
        return mh1.giaban > mh2.giaban;
    return mh1.soluong > mh2.soluong;
}

int main() {
    ifstream finp;
    finp.open("mathang.inp");
    ofstream fout;
    fout.open("mathang.out");
	
	// Kiem tra file output va input
	if (finp.fail()) {
	    cout << "Khong the mo file iutput";
	    return 0;
	}
	if (fout.fail()) {
	    cout << "Khong the mo file output";
	    return 0;
	}	

	// Nhap du lieu dau vao
	int n;
	finp >> n;
	
	string s;
	int a;
	float b;
	for (int i = 0; i < n; i++) {
		finp.ignore();
		getline(finp, s);   mathang[i].ma = s;
		getline(finp, s);   mathang[i].ten = s;
		finp >> a;          mathang[i].soluong = a;
		finp >> b;          mathang[i].giaban = b;
	}

	sort(mathang, mathang + n, sapxep);	// Sap xep 
	// In du lieu ra file  
	for (int i = 0; i < n; i++) {
	    fout << mathang[i].ma << " " << mathang[i].ten << " " << mathang[i].soluong << " " << mathang[i].giaban << "\n";
	}

	finp.close();
	fout.close();
    return 0;
}
