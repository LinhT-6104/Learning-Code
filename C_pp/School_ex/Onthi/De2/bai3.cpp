#include <iostream>
#include <string>
#include <iomanip>

using namespace std;

class People {
private:
    string name;
    int age;
    string address;
public:
    // Ham nhap
    void input() {
        cin.ignore();
        cout << "Nhap ten: ";
        getline(cin, name);
        cout << "Nhap tuoi: ";
        cin >> age;
        cin.ignore();
        cout << "Nhap dia chi: ";
        getline(cin, address); 
    }
    // Ham xuat
    void output() {
        cout << "- Ten: " << name << endl;
        cout << "- Tuoi: " << age << endl;
        cout << "- Dia chi: " << address << endl;
    }
    // Ham tao khong tham so
    People() {
        name = "";
        age = 0;
        address = "";
    }
    // Ham tao co tham so
    People(string name, int age, string address) {
        this->name = name;
        this->age = age;
        this->address = address;
    }
};

class Student: public People {
private:
    string id;
    double math;
    double physical;
    double chemistry;
public:
    void input() {
        People::input();
        cout << "Nhap id: ";
        cin >> id;
        cout << "Nhap diem toan: ";
        cin >> math;
        cout << "Nhap diem ly: ";
        cin >> physical;
        cout << "Nhap diem hoa: ";
        cin >> chemistry;
        cout << endl;
    }
    double GPA() {
        return (math + physical + chemistry)/3.0;
    }
    void output() {
        People::output();
        cout << "- id: " << id << endl;
        cout << "- Diem Toan: " << math << endl;
        cout << "- Diem ly: " << physical << endl;
        cout << "- Diem Hoa: " << chemistry << endl;
        cout << "- Diem trung binh 3 mon: " << fixed << setprecision(1) << GPA() << endl << endl;
    }
};

void nhapDuLieu(int &n, Student a[]) {
    cout << "Nhap so sinh vien can quan ly: ";
    cin >> n;
    cout << "Nhap thong tin sinh vien:\n";
    for (int i = 0; i < n; i++) {
        cout << "Sinh vien " << i + 1 << endl;
        a[i].input();
    }
}   

void hienThi(int n, Student a[]) {
    cout << "\nThong tin cac sinh vien:\n";
    for (int i = 0; i < n ; i++) {
        cout << "Sinh vien " << i + 1 << endl;
        a[i].output();
    }
}

int main() {
    int n;
    Student a[100];
    nhapDuLieu(n, a);
    hienThi(n, a);
    return 0;
}