#include <iostream>

#define MAX 50

using namespace std;

int map[MAX][MAX];

int main() {
    int N, M;
    cin >> N >> M;

    int answer = 1;

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cin >> map[i][j];
        }
    }

    for(int i = 0; i < N-1; i++) {
        for(int j = 0; j < M-1; j++) {
            int w = 0, h = 0;
            for(int k = i+1; k < N; k++) {
                if(map[k][j] == map[i][j]) h = k - i + 1;
            }
            for(int k = j+1; k < M; k++) {
                if(map[i][k] == map[i][j]) w = k - j + 1;
            }
            if(answer < w*h) answer = w*h;
        }
    }
    cout << answer;
}