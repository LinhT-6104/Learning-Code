#include <iostream>
#include <string>

using namespace std;

class Person{
	protected:
		string name;
		int age;
	public:
		Person();
		Person(string, int);
		void nhap();
		void xuat();
		string getName();
		void setName(string);
		int getAge();
		void setAge(int);
};

Person::Person(){
}
Person::Person(string n, int a){
	this->name = n;
	this->age = a;
}
string Person::getName(){
	return this->name;
}
void Person::setName(string n){
	this->name = n;
}
int Person::getAge(){
	return this->age;
}
void Person::setAge(int a){
	this->age = a;
}
void Person::nhap(){
	cout << "Nhap vao ten: ";
	getline(cin, this->name);
	cout << "Nhap vao tuoi: ";
	cin >> this->age;
	cin.ignore();
}
void Person::xuat(){
	cout << this->name << " - " << this->age;
}

