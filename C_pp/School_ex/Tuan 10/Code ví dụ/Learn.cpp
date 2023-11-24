#include <iostream>

using namespace std;

// Dinh nghia lop
// Lop cha / lop co so
class Person {
	private:
		string name;
		int age;
		
	// Phuong thuc / hanh dong
	public:
		// 1. Ham tao
		// Ham tao khong tham so
		Person() {
			name = " ";
			age = 0;
		}
		
		// Ham tao co tham so
		Person(string name, int age) {
			this->name = name;
			this->age = age;
		}
		
		// 2. Phuong thuc nhap du lieu
		void nhapDL() {
			cin.ignore();
			cout << "Nhap ho ten: ";
			getline(cin, name);
			cout << "Nhap tuoi: ";
			cin >> age;
		}
		
		// 3. Phuong thuc hien thi du lieu
		void hienThi() {
			cout << "Ho ten: " << name << endl;
			cout << "Tuoi: " << age << endl;
		}
};

// Lop student ke thua lop person
class Student:public Person {
	// Dac trung / thuoc tinh / du lieu
	private:
		string major, schoolname;
	
	// Phuong thuc / hanh dong
	public:
		// 1. Ham tao
		// Ham tao khong tham so
		Student():Person() {
			major = schoolname = "";
		}
		
		// Ham tao co tham so
		Student(string name, int age , string major, string schoolname): Person(name, age) {
			this->major = major;
			this->schoolname = schoolname;
		}
		
		// 2. Ham nhap du lieu
		// Ghi de phuong thuc
		void nhapDL() {
			Person::nhapDL();	// Goi ham nhap du lieu cua 
			cout << "Nhap ten chuyen nghanh: ";
			getline(cin, major);
			cout << "Nhap ten truong: ";
			getline(cin, schoolname);
		}
		
		// 3. Ham hien thi
		void hienThi() {
			Person::hienThi();
			cout << ", chuyen nganh: " << major << ", ten truong: " << schoolname;
		}
};

int main() {
	Student dssv[100];
	cout << "Nhap so sinh vien can quan ly: ";
	int n; cin >> n;
	cout << "\nNhap thong tin cho " << n << " sinh vien\n\n";
	for (int i = 0; i < n; i++) {
		cout << "Nhap thong tin sinh vien thu " << i+1 << ":\n";
		dssv[i].nhapDL();
	}
	return 0;
}
