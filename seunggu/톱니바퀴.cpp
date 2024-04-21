#include <iostream>
#include <string>
#include <deque>
#include <vector>
#include <cmath>

using namespace std;

deque<int> vec[4];
int K;
int n, m;

void rotate(int t) {
    int temp;
    if(m == 1) {
        temp = vec[t-1].back();
        vec[t-1].pop_back();
        vec[t-1].push_front(temp);
    } else if(m == -1) {
        temp = vec[t-1].front();
        vec[t-1].pop_front();
        vec[t-1].push_back(temp);
    }
}

void init_rotate(int n) {
    m = (m == 1) ? -1 : 1;
    rotate(n);
}

void solution() {
    bool a = vec[0][2] != vec[1][6];
    bool b = vec[1][2] != vec[2][6];
    bool c = vec[2][2] != vec[3][6];

    switch(n) {
        case 1:
            rotate(1);
            if(a) init_rotate(2);
            if(a && b) init_rotate(3);
            if(a && b && c) init_rotate(4);
            break;
        case 2:
            rotate(2);
            if(a) init_rotate(1);
            if(b) init_rotate(3);
            if(b && c) init_rotate(4);
            break;
        case 3:
            rotate(3);
            if(c) init_rotate(4);
            if(b) init_rotate(2);
            if(a && b) init_rotate(1);
            break;
        case 4:
            rotate(4);
            if(c) init_rotate(3);
            if(b && c) rotate(2);
            if(a && b && c) rotate(1);
    }
}

int main() {
    string str;
    int answer = 0;

    for(int i = 0; i < 4; i++) {
        cin >> str;
        for(int j = 0; j < 8; j++) {
            vec[i].push_back(str[j] - '0');
        }
    }

    cin >> K;
    for(int i = 0; i < K; i++) {
        cin >> n >> m;
        solution();
    }
    
    for(int i = 0; i < 4; i++) answer += vec[i][0] * pow(2, i);
    cout << answer;
}