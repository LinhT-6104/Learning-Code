#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Person {
protected:
    string name;
    int age;

public:
    Person(const string& n, int a) : name(n), age(a) {}

    virtual void inputData() = 0; // Hàm ảo thuần túy
    virtual void displayInfo() const = 0; // Hàm ảo thuần túy
    virtual bool isExcellent() const = 0; // Hàm ảo thuần túy
};

class Student : public Person {
private:
    double gpa;

public:
    Student(const string& n, int a, double g) : Person(n, a), gpa(g) {}

    void inputData() override {
        cout << "Nhap diem trung binh cua sinh vien " << name << ": ";
        cin >> gpa;
    }

    void displayInfo() const override {
        cout << "Sinh vien: " << name << ", Tuoi: " << age << ", Diem trung binh: " << gpa << endl;
    }

    bool isExcellent() const override {
        return gpa > 9.5;
    }
};

class Professor : public Person {
private:
    int numOfPapers;

public:
    Professor(const string& n, int a, int papers) : Person(n, a), numOfPapers(papers) {}

    void inputData() override {
        cout << "Nhap so luong bai bao da xuat ban cua giang vien " << name << ": ";
        cin >> numOfPapers;
    }

    void displayInfo() const override {
        cout << "Giang vien: " << name << ", Tuoi: " << age << ", So bai bao xuat ban: " << numOfPapers << endl;
    }

    bool isExcellent() const override {
        return numOfPapers >= 100;
    }
};

int main() {
    int n;
    cout << "Nhap so luong nguoi: ";
    cin >> n;

    vector<Person*> people;

    for (int i = 0; i < n; ++i) {
        string type;
        cout << "Nhap loai nguoi (Student hoac Professor): ";
        cin >> type;

        if (type == "Student") {
            string name;
            int age;
            double gpa;

            cout << "Nhap ten sinh vien: ";
            cin >> name;
            cout << "Nhap tuoi: ";
            cin >> age;

            cout << "Nhap diem trung binh: ";
            cin >> gpa;

            people.push_back(new Student(name, age, gpa));
        } else if (type == "Professor") {
            string name;
            int age;
            int papers;

            cout << "Nhap ten giang vien: ";
            cin >> name;
            cout << "Nhap tuoi: ";
            cin >> age;

            cout << "Nhap so bai bao xuat ban: ";
            cin >> papers;

            people.push_back(new Professor(name, age, papers));
        } else {
            cout << "Loai nguoi khong hop le.\n";
            --i; // Nếu nhập sai, quay lại nhập lại
        }
    }

    cout << "\nNhung nguoi kiet xuat:\n";
    for (const auto& person : people) {
        if (person->isExcellent()) {
            person->displayInfo();
        }
    }

    // Giải phóng bộ nhớ
    for (const auto& person : people) {
        delete person;
    }

    return 0;
}
