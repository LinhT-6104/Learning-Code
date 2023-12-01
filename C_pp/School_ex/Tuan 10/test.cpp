#include<iostream>

using namespace std;

class Person {
private:
	string name;
public:
	Person(string name) {
		this->name = name;
	}
	string getName() {
		return name;
	}
	void setName(string name) {
		this->name = name;
	}
};

class Student : Person {

};

int main() {
	Student s;
	return 0;
}