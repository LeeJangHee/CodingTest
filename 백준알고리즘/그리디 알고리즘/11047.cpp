#include <iostream>
#include <vector>

using namespace std;
int main(int argc, const char * argv[]) {
    //동전문제
    int k, n;
    int answer = 0;
    cin >> n >> k;
    
    vector<int> coin(n, 0);
    
    for(int i = 0; i < n; i++) {
        scanf("%d", &coin[i]);
    }
    
    for(int i = n - 1; i >= 0; i--) {
        if(k == 0) break;
        if(k < coin[i]) continue;
        
        answer += k / coin[i];
        k = k % coin[i];
    }
    
    cout << answer << endl;
    return 0;
}
