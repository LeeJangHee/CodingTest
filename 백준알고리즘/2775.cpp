#include <iostream>
using namespace std;

int main(void){
	int t, k, n;
	int apart[15][15];
	int num[1000];
	
	for(int i=0; i<15; i++){
		for(int j=0; j<15; j++){
			if(i==0) apart[i][j]=j+1;
			else if(j==0) apart[i][j] =1;
			else apart[i][j] = apart[i-1][j] + apart[i][j-1];
		}
	}
	
	cin >> t;
	
	for(int x=0; x<t; x++){
		cin >> k;
		cin >> n;
		
		num[x]=apart[k][n-1];
	}
	for(int y =0; y<t; y++){
		cout << num[y]<< endl;
	}
	return 0;
}
