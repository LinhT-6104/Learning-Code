#include<iostream>
#include<fstream>

using namespace std;

int main()
{
//doc file

	ifstream finp;
	finp.open("mathang.inp");
	if(finp.fail()) cout << "Mo file khong thanh cong";
	cout << "Du lieu doc duoc tu file mahang.txt la: " ;
	string str;
	while(!finp.eof())
	{
		getline(finp,str);
		if(finp.eof()) break ;
		cout<<str<<endl;
	}
	cout << endl;
	
//ghi file

	ofstream fout;
	fout.open("mathang.out");
	if(fout.fail()) {
	cout <<"luu file khong thanh cong " ;
	return 0;
	}
		
	int n,sl,giaban,i=0;
	string ma_mh,ten_mh;
	
	cin >> n; // nhap so luong mat hang
	
	while(i<n)
	{
		getline(cin,ma_mh);
		cin.ignore();
		getline(cin,ten_mh);
		cin.ignore();
		cin >> sl;
		cin >> giaban;
		i++;
		fout << ten_mh << " " << sl << " " << giaban << endl;	
	}
	cout << "Chuong trinh da ket thuc !" << endl;
	cout <<"Mo file mathang.txt de xem ket qua !" <<endl;
	fout.close();
	return 0;

	
}
