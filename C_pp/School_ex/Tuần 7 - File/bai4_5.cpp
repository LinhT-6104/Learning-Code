#include<iostream>
#include<fstream>
#include<string>

using namespace std;

string tachten(string ten) {
    return ten.substr(ten.rfind(" ") + 1, ten.size());
}

main(){
    int n;
    ofstream fout;
    fout.open("sinhvien.txt");
    cout << "Nhap so sinh vien: "; cin >> n;
    string ten;
    float diem;
    for (int i = 0; i < n; i++) {
        cout << "Nhap ten sinh vien " << i << ": ";
        cin >> ten;
        
        cin.ignore();
        getline(cin, ten);

        cout << "Nhap diem tong ket sinh vien " << i << ": "; 
        cin >> diem;

        // Kiem tra dieu kien va in ket qua vao file sinhvien.txt
        if (tachten(ten) == "Hoang" and diem >= 8.0) {
            fout << ten << endl;
            fout << diem << endl;
        }
    }   
    fout.close(); 
    return 0;
}