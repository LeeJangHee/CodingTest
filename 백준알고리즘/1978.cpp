#include <iostream>
using namespace std;

int main(void) {
	int n;
	int num;
	int count = 0;
	scanf("%d", &n);
	
	for(int i = 0; i < n; i++) {
		scanf("%d", &num);
		if(num > 2) {
			for(int j = 2; j < num; j++) {
				if(num % j == 0) {
					break;
				}
				if(j == num - 1) count++;
			}
		}
		else if (num == 2) count++;
	}

	cout << count << endl;
	
	return 0;
}
