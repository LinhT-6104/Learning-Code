#include<iostream>
#include<cmath>

using namespace std;

int ucln(int a,int b){
    if (a % b == 0)
        return b;
    else 
        return ucln(b, a%b);
}

int main(){
    int n,m;
    cin >> n >> m;
    if (n < m) { 
        swap(n,m);
    }
    cout << ucln(n,m);
    return 0;
}