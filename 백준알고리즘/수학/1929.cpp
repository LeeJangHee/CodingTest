#include <iostream>
using namespace std;

bool p[1000001];

int main() {
	int m, n;
	cin >> m >> n;
	
    p[0] = p[1] = true;
	for(int i = 2; i * i <= n; i++) {
		if(p[i] == true) continue;
		for(int j = i * i; j <= n; j = i + j)
		if(p[i] == false) {
			p[j] = true;
		}
	}
	
	for(int i = m; i <= n; i++) {
		if(p[i] == false)
			printf("%d\n", i);
	}
	return 0;
}
