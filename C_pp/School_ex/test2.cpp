#include<iostream>

using namespace std;

void change(int a){
  a = a * 2;
  cout << a << endl; 
}

int main() {
  int n = 5;
  change(n);
  cout << n;
  return 0;
}
