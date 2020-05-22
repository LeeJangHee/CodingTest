#include <iostream>
#include <stack>
#include <string>
using namespace std;

int main(void) {
	stack<int> st;
	int n;
	scanf("%d", &n);
	string str;
	
	for(int i = 0; i < n; i++) {
		cin >> str;
		
		if(str == "push") {
			int data;
			scanf("%d", &data);
			st.push(data);
		}
		else if(str == "pop") {
			if(st.empty() == 1) printf("-1\n");
			else {
				printf("%d\n", st.top());
				st.pop();	
			}
		}
		else if(str == "size") {
			printf("%d\n", st.size());
		}
		else if(str == "top") {
			if(st.empty() == 1) printf("-1\n");
			else printf("%d\n", st.top());
		}
		else if(str == "empty") {
			if(st.empty() == 1) printf("1\n");
			else printf("0\n");
		}
	}
	
	return 0;
}
