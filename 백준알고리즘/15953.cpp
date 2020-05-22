#include <iostream>

using namespace std;

int main(int argc, const char * argv[]) {
    int n, f, s;
    
    cin >> n;
    
    while(n--) {
        cin >> f >> s;
        int sum = 0;
        
        if(f == 1) {
            sum += 5000000;
        }
        else if(f > 1 && f <= 3) {
            sum += 3000000;
        }
        else if(f >3 && f <= 6) {
            sum += 2000000;
        }
        else if(f >6 && f <= 10) {
            sum += 500000;
        }
        else if(f > 10 && f <= 15) {
            sum += 300000;
        }
        else if(f > 15 && f <= 21) {
            sum += 100000;
        }
        
        if(s == 1) {
            sum += 5120000;
        }
        else if(s > 1 && s <= 3) {
            sum += 2560000;
        }
        else if(s > 3 && s <= 7) {
            sum += 1280000;
        }
        else if(s > 7 && s <= 15) {
            sum += 640000;
        }
        else if (s > 15 && s <= 31) {
            sum += 320000;
        }
        
        cout << sum << endl;
    }
    
    return 0;
}
