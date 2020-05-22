#include <iostream>
#include <algorithm>
using namespace std;

int main(int argc, const char * argv[]) {
    
    
    int n, i;
    int array[1001];
    
    cin >> n;
    
    for(i = 0; i < n; i++) {
        scanf("%d",&array[i]);
    }
    
    sort(array, array+n);
    
    for(i = 0; i < n; i++) {
        printf("%d ",array[i]);
    }
    printf("\n");
    return 0;
}
