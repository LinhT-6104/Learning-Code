#include<iostream>
#include<fstream>
#include<string>
using namespace std;

int main()
{
// doc du lieu tu file
	ifstream finp;
	finp.open("NEWS.INP");
	if(finp.fail())
	{
		cout << "Loi roi nhe " ;
		return 0;
	}

	string s;
	int chu_cai,chu_so,ki_tu;
	while(!finp.eof())
	{
		getline(finp,s);
		if(finp.eof())
		{
			break;
		}
	}
	
	// in du lieu ra file
	ofstream fout;
	fout.open("NEW.OUT");
	if(fout.fail())
	{
		cout << "Loi roi nhe ban oi" ;
		return 0;
	}

	
	for(int i = 0; i < s.length(); i++){
            if('a' <=  s[i] && s[i] <= 'z'){
                chu_cai++; 
            }
            else if('0' <= s[i] && s[i] <= '9'){
                chu_so++;
            }
            else{
                ki_tu++;
            }
        }
    
	
	fout << chu_cai << " " << chu_so << " " << ki_tu ;

	
	
	return 0;
}
