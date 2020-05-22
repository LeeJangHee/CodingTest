#include <iostream>
using namespace std;

bool p[500000];
int main() {
	int count;
	int t, t2;

	p[0] = p[1] = true;
	do {
		cin >> t;
		if(t == 0) {
			break;
		}
		count = 0;
		t2 = t * 2;
		for(int i = 2; i * i <= t2; i++) {
			if(p[i] == true) continue;
			for(int j = i * i; j <= t2; j = i + j) {
				if(p[j] == false) p[j] = true;
			}
		}
		for(int i = t + 1; i <= t2; i++) {
			if(p[i] == false) count += 1;
		}
		printf("%d\n", count);
		
	}while (true);
	return 0;
}
