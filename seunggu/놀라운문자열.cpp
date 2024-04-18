#include <iostream>
#include <string>
#include <set>

using namespace std;

int main() {
    string str;
    set<string> s;

    while(true) {
        cin >> str;
        if(str == "*") return;

        for(int i = 0; i < str.size() - 1; i++) {
            for(int j = i+1; j < str.size(); j++) {
                int size = s.size();
                string temp = str[i] + str[j];
                s.insert(temp);
                if(size == s.size()) {
                    cout << str << " is not surprising" << endl;
                    continue;    
                }
            }
        }
        cout << str << " is surprising" << endl;
    }
}