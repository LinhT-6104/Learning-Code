#include <iostream>

using namespace std;
class DFriend;
class Diem{
	private:
		int x, y;
	public:
		Diem(){
			x = 0;
			y = 1;
		}
		Diem(int x, int y){
			this->x = x;
			this->y = y;
		}
		
		Diem(Diem &d){
			this->x = d.x;
			this->y = d.y; 
		}
		
		void hienThi(){
			cout << "x = " << x;
			cout << "\ny = " << y;
		}
		~Diem(){}
	public:
		int compare(DFriend F);
};

class DFriend{
	private:
		int x1, y1;
	public:
		DFriend(int x1, int y1){
			this->x1 = x1;
			this->y1 = y1;
		}
		friend int Diem::compare(DFriend F);
};

int Diem::compare(DFriend F){
	if(x == F.x1 && y == F.y1){
		return 1;
	}
	else{
		return 0;
	}
}

int main(){
	Diem A(2, 3);
	DFriend B(2, 3);
	if(A.compare(B) == 1){
		cout << "Hai diem trung nhau!";
	}
	else{
		cout << "Hai diem khong trung nhau!";
	}

	return 0;
}




