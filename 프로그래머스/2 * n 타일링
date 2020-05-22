#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(int argc, const char * argv[]) {
    int n = 4;
    vector<int> dp(n+1);
    dp[1] = 1;
    dp[2] = 2;
    
    for(int i = 3; i <= n; i++) {
        dp[i] = (dp[i-2] + dp[i-1]);
    }
    
    cout << dp[n] % 1000000007 << endl;
    return 0;
}
