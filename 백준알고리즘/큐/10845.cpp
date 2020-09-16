#include <iostream>
#include <queue>
#include <string>
using namespace std;

int main() {
	queue<int> q;
	int t;
	string str;
	cin >> t;
	while(t--) {
		cin >> str;
		if(str == "push") {
			int data;
			scanf("%d", &data);
			q.push(data);
		}
		else if(str == "pop") {
			if(!q.empty()) {
				cout << q.front() << endl;
				q.pop();
			}
			else cout << "-1" << endl;
		}
		else if(str == "size") {
			cout << q.size() << endl;
		}
		else if(str == "empty") {
			if(q.empty()) printf("1\n");
			else printf("0\n");
		}
		else if(str == "front") {
			if(!q.empty()) cout << q.front() << endl;
			else cout << "-1" << endl;
		}
		else if(str == "back") {
			if(!q.empty()) cout << q.back() << endl;
			else cout << "-1" << endl;
		}
	}
	return 0;
}
