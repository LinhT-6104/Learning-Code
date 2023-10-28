#include <iostream>
#include <fstream>

using namespace std;

int main()
{
    ifstream inpf("chess.inp");
    ofstream outf("chess.out");
    
    int n,m;
    inpf >> n >> m;
    
    int a[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            inpf >> a[i][j];    
        }
    }
    
    int max, sum = 0;
    for (int i = 0; i < n; i++) {
        max = a[i][0];
        for (int j = 0; j < m; j++) {
            if (a[i][j] > max)  max = a[i][j];
        }
        sum += max;
    }
    outf << sum;    
    
    inpf.close();
    outf.close();
    return 0;
}
