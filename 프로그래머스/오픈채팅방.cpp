#include <string>
#include <vector>
#include <map>
#include <sstream>
using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    map<string, string> idmap;
    
    for(vector<string>::iterator it = record.begin(); it != record.end(); ++it) {
        stringstream ss(*it);
        string cmd, id, name;
        ss >> cmd;
        if(cmd.compare("Enter") == 0) {
            ss >> id >> name;
            idmap[id] = name;
        }
        else if(cmd.compare("Change") == 0) {
            ss >> id >> name;
            idmap[id] = name;
        }
    }
    
    for(vector<string>::iterator it = record.begin(); it != record.end(); ++it) {
        stringstream ss(*it);
        string cmd, id;
        ss >> cmd;
        if(cmd.compare("Enter") == 0) {
            ss >> id ;
            answer.push_back(idmap[id] + "님이 들어왔습니다.");
        }
        else if(cmd.compare("Leave") == 0) {
            ss >> id;
            answer.push_back(idmap[id] + "님이 나갔습니다.");
        }
    }
    
    return answer;
}
