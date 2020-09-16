#include <iostream>
using namespace std;

int main(void){
	int t, h, w, n;
	
	cin >> t;
	while(t--){
		cin >> h >> w >> n;
		int count = 1;
		
		while(n > h){
			n = n - h;
			count++;
		}
		char str[10];
		sprintf(str, "%d%02d\n",n , count);
		printf(str);
	}
	
	return 0;
}
