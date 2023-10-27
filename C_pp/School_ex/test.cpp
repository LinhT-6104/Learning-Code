#include<iostream>
#include<algorithm>

using namespace std;

int sort_array(int a[]) {
    sort(a, a + 5);
    return a[0];
}

int main() {
    int a[] = {5,2,2,1,24};
    cout << sort_array(a) << endl;;
    cout << a[0];
    return 0;
}