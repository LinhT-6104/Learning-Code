#include<iostream>
#include<cmath>

using namespace std;

int tuyet_doi_i() {
    int a; cin >> a;
    return abs(a);
}
float tuyet_doi_f() {
    float(a); cin >> a;
    return fabs(a);
}
int max_i() {
    int a,b,c; 
    cin >> a >> b >> c;
    if (a >= b and a >= c) {
        return a;
    } 
    else if (b >= c) {
        return b;
    } else return c;
}
float max_f() {
    float a,b,c; 
    cin >> a >> b >> c;
    if (a >= b and a >= c) {
        return a;
    } 
    else if (b >= c) {
        return b;
    } else return c;
}
int min_i() {
    int a,b,c;
    cin >> a >> b >> c;
    if (a <= b and a <= c) {
        return a;
    }
    else if (b <= c) {
        return b;
    } else return c;
}
float min_f() {
    float a,b,c;
    cin >> a >> b >> c;
    if (a <= b and a <= c) {
        return a;
    }
    else if (b <= c) {
        return b;
    } else return c;
}
int trbc_i() {
    int a,b,c;
    cin >> a >> b >> c;
    return (a + b + c) / 3;
}
float trbc_f() {
    float a,b,c;
    cin >> a >> b >> c;
    return (a + b + c) / 3.0;
}

int main(){
    
    cout << tuyet_doi_i() << endl;
    cout << tuyet_doi_f() << endl;
    cout << max_i() << endl;
    cout << max_f() << endl;
    cout << min_i() << endl;
    cout << min_f() << endl;
    cout << trbc_i() << endl;
    cout << trbc_f();
    return 0;
}