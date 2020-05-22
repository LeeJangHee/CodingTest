#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool comp(pair<double, int> i, pair<double, int> j) {
    if(i.first == j.first)
       return i.second < j.second;
    
       return i.first > j.first;
}
vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<double, int>> failpair;
    int total = stages.size();
    int users[501] ={0};
    
    for(vector<int>::iterator it = stages.begin(); it != stages.end(); ++it){
        users[*it-1]++;
    }
    for(int i=0; i<N; ++i){
        if(users[i]==0)
            failpair.push_back(make_pair(0, i+1));
        else {
            failpair.push_back(make_pair((double)users[i]/total, i+1));
            total -=users[i];
        }
    }
        
    sort(failpair.begin(), failpair.end(), comp);
    for(vector<pair<double, int>>::iterator it = failpair.begin(); it != failpair.end(); ++it) {
        answer.push_back(it->second);
    }
    return answer;
}
