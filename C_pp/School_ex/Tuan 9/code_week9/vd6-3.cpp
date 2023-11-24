// vi du ham cua mot lop
// la ban cua lop khac
#include <iostream>
using namespace std;
class A;
class B {
 int x;
 public:
   B(int x0) { x = x0; }
   int  Cong(int , A);
};
class A {
 int y;
 public:
   A(int y0) { y = y0;}
   friend int B::Cong(int , A);  
};
int B::Cong(int h,A a) {
 return h*(x+a.y);
}
main() {
 A a(10);
 B b(20);
 cout<<"Ket qua: "<<b.Cong(2,a);
 return 0; 
}

