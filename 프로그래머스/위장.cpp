#include <string>
#include <vector>
#include <map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    map<string, int> spy;
    
    for(vector<string> s : clothes)
        spy[s[1]]++;
    
    int answer = 1;
    for(pair<string, int> it : spy) {
        answer *= (it.second + 1);
    }

    return (answer - 1);
}
