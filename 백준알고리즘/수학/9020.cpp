 #include <iostream>
using namespace std;

bool p[10001];

int main() {
	
	int t, n;
	cin >> t;
	
	p[0] = p[1] = true;
	while (t--) {
		cin >> n;
		for(int i = 2; i <= n; i++) {
			if(p[i] == true) continue;
			for(int j = i * i; j <= n; j = i + j) {
				if(p[j] == false) p[j] = true;
			}
		}
		//골드바흐의 추측  
		for(int i = n / 2; i > 0; i--) {
			if(p[i] == false && p[n - i] == false) {
				printf("%d %d\n", i, n - i);
				break;
			}
		}
	}
	return 0;
}
