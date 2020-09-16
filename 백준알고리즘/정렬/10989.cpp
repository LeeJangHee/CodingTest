#include <iostream>
using namespace std;

int count[10001];

int main(void) {
	
	int n;
	scanf("%d", &n);
	
	int arr;
	
	for(int i = 0; i < n; i++) {
		scanf("%d", &arr);
		count[arr] += 1;
	}
	
	for(int i = 1; i <= 10000; i++) {
		if(count[i] > 0) {
			for(int j = 0; j < count[i]; j++)
				printf("%d\n", i);
		}
	}
	return 0;
} 
