#include<iostream>
#include<fstream>
#include<algorithm>

using namespace std;

struct high_tree {
    float high;
    int index;
};

bool sapxep(const high_tree &tree1, const high_tree &tree2) {
    return tree1.high <= tree2.high;
}

int main(){
    ifstream inpf("tree.inp");
    ofstream outf("tree.out");

    int n;
    inpf >> n;

    high_tree tree[n];  // Khai bao mang tree kieu du lieu high_tree

    for (int i = 0; i < n; i++) {
        inpf >> tree[i].high;
        tree[i].index = i+1;
    }

    sort(tree, tree + n, sapxep);   // Sap xep theo chieu tang dan cua chieu cao cay

    for (int i = 0; i < n; i++) {
        outf << tree[i].index << " ";
    }

    outf << endl;

    for (int i = 0; i < n; i++) {
        outf << tree[i].high << " ";
    }

    inpf.close();
    outf.close();
    return 0;
}