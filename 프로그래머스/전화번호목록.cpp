#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

bool solution(vector<string> phone_book) {
    sort(phone_book.begin(), phone_book.end());
    string a = phone_book[0];
    
    for(int i = 1; i < phone_book.size(); i++) {
        if(a.length() <= phone_book[i].size()) {
            if(phone_book[i].find(a) == 0)
            return false;
        }
    }
    
    return true;
}
