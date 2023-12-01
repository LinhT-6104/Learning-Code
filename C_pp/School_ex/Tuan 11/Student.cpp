#include <iostream>
#include <string>
#include "Person.cpp"

using namespace std;

class Student:public Person{
	protected:
		string id;
		string major;
		string schoolName;
	public:
		Student();
		Student(string, string, string, string, int);
		void nhap();
		void xuat();
		string getId();
		void setId(string);
		string getMajor();
		void setMajor(string);
		string getSchoolName();
		void setSchoolName(string);
};

Student::Student():Person(){
}
Student::Student(string id, string m, string sn,
 string name, int age):Person(name, age){
	this->id = id;
	this->major = m;
	this->schoolName = sn;
}
void Student::nhap(){
	Person::nhap();
	cout << "Nhap ma sinh vien: ";
	cin >> this->id;
	cin.ignore();
	cout << "Nhap chuyen nganh: ";
	getline(cin, this->major);
	cout << "Nhap ten truong: ";
	getline(cin, this->schoolName);
}
void Student::xuat(){
	Person::xuat();
	cout << " - " << this->id << " - " << this->major 
	<< " - " << this->schoolName << endl;
}

int main(){
	Student st1 = Student();
	st1.nhap();
	st1.xuat();
}
