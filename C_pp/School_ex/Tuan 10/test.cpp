#include <iostream>
#include <conio.h>

using namespace std;

class MangToaDo
{
public:
	int n;

	MangToaDo() 
	{
		n = 0;
	}

	class ToaDo
	{
	public:
		int x, y;

		ToaDo() {}
		ToaDo(int a, int b)
		{
			x = a;
			y = b;
		}
	};

	ToaDo mToaDo[10];

	void ThemToaDo(ToaDo td)
	{
		mToaDo[n] = td;
		n++;
	}
};

int main()
{
	MangToaDo mToaDo;
	ToaDo td(3, 2); //không truy cập được

	mToaDo.ThemToaDo(td);

	getch();
	return 0;
}