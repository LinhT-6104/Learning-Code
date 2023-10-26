#include <iostream>
#include <string>

using namespace std;

int main() {
  string s1 = "Hello, world!";
  string s2 = "world";

  // Sử dụng hàm find() để kiểm tra
  int pos = s1.find(s2);

  // Nếu pos != string::npos thì chuỗi cần tìm nằm trong chuỗi ban đầu
  if (pos != npos) {
    cout << "co" << endl;
    return 0;
  }

  // Nếu pos == string::npos thì chuỗi cần tìm không nằm trong chuỗi ban đầu
  cout << "khong" << endl;
  return 0;
}
