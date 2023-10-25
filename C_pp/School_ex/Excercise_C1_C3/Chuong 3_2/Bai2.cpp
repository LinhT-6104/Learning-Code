#include <iostream>
#include <string>

using namespace std;

int main() {
	cout << "Nhap chuoi: ";
	string s;
	getline(cin,s);
	
	// Dem so luong tu trong chuoi
	int count = 0;
	for (int i = 0; i < s.size(); i++) {
		if (s[i-1] == ' ' or i == 0) count++;
	}
	cout << "So luong tu trong chuoi: " << count << endl;
	
	// Capitalize Each Word
	for (int i = 0; i < s.size(); i++) {
		if (s[i-1] == ' ' or i == 0) {
			s[i] = toupper(s[i]);
		} else {
			s[i] = tolower(s[i]);
		}
	}
	cout << "Capitalize Each Word: " << s;
	return 0;
}
