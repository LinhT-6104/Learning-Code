#include <iostream>

using namespace std;

class List {
private:
	int *arr;
	int size;
	int len;
	
public:
	List() {
		arr = new int[len];
		size = 0;	// So phan tu trong mang
		len = 0;	// So o nho max
	}
	
	int Len() {
		return size;
	}
	
	void Insert(int pos, int value) {
		if (pos < 0 || pos > size) {
			cerr << "Vi tri pos khong hop le" << endl;
			return;
		}
		
		// Dich sang phai 1 o nho neu mang full
		if (size == len) {
			// Tao mang dong moi co so o nho > mang ban dau
			int lenNew = 2*len;	
			int *arrNew = new int[len];
			
			// Nhap du lieu tu mang ban dau sang mang moi
			for (int i = 0; i < size; i++) {
				arrNew[i] = arr[i];
			}
			
			len = lenNew;	// Set so o nho max
			delete[] arr;	// Xoa mang ban dau
			arr = arrNew;	
		}
		
		// Chuyen dich giu lieu mang sang phai
		for (int i = size; i > pos; i--) {
			arr[i] = arr[i-1];
		}
		
		arr[pos] = value;
		++size;
	}
	
	void Delete(int pos) {
		if (pos < 0 || pos > size) {
			cerr << "Vi tri pos khong hop le";
			return;
		}
		
		// Dua cac gia tri ben phai pos lan luot sang trai
		for (int i = pos; i < size - 1; i++) {
			arr[i] = arr[i+1];
		}
		--size;
	}
	
	void show() {
		cout << "- Mang: ";
		for (int i = 0; i < size; i++) {
			cout << arr[i] << " ";
		}
		cout << endl;
	}
	
	~List() {
		delete[] arr;
	}
};

int main() {
	List a;
	a.Insert(0, 1);
	a.Insert(1, 5);
	a.Insert(2, 4);
	a.Insert(1, 3);
	a.show();
	cout << "-> So phan tu trong mang la: " << a.Len() << endl;
	a.Delete(3);
	a.show();
	cout << "-> So phan tu trong mang la: " << a.Len() << endl;
	return 0;
}
