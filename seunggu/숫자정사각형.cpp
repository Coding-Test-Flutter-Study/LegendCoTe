#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

#define MAX 50

using namespace std;

int map[MAX][MAX];

int main() {
    int N, M;
    string str;

    cin >> N >> M;

    vector<int> answer;

    for(int i = 0; i < N; i++) {
        cin >> str;
        for(int j = 0; j < M; j++) {
            map[i][j] = str[j] - '0';
        }
    }

    for(int i = 0; i < N-1; i++) {
        for(int j = 0; j < M-1; j++) {
            int w = 0, h = 0;
            for(int k = i+1; k < N; k++) {
                if(map[k][j] == map[i][j]) {
                    h = k - i + 1;
                    for(int l = j+1; l < M; l++) {
                        if(map[i][l] == map[i][j]) {
                            w = l - j + 1;
                            if(h == w) {
                                for(int m = j+1; m < M; m++) {
                                    if(map[k][m] == map[i][j] && w == (m - j + 1)) {
                                        answer.push_back(w*h);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    if(answer.empty()) cout << 1;
    else cout << *max_element(answer.begin(), answer.end());
}