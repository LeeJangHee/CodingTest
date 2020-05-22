#include <string>
#include <vector>
#include <stack>
using namespace std;

vector<int> solution(vector<int> heights) {
    vector<int> answer;
    stack<int> st;
	
	for(int i = heights.size() - 1; i >= 0; i--) {
        if(i == 0) {
            st.push(0);
            break;
        }
		for(int j = i - 1; j >= 0; j--) {
			if(heights[i] < heights[j]) {
				st.push(j + 1);
                break;
            }
            if (j == 0) {
                st.push(0);
                break;
            }
		}
	}
	
    for(int i = 1; i <= heights.size(); i++) {
	    answer.push_back(st.top());
	    st.pop();
	}
    return answer;
}
