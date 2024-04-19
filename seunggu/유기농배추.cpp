#include <iostream>
#include <vector>
#include <queue>
#include <cstring>

#define MAX 50

using namespace std;

int M, N, K;

int map[MAX][MAX];
bool visited[MAX][MAX];

int dx[4] = {1, -1, 0, 0,};
int dy[4] = {0, 0, -1, 1};

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push({x, y});

    while(!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(!visited[ny][nx] && map[ny][nx] == 1) {
                q.push({nx, ny});
                visited[ny][nx] = true;
            }
        }
    }
}

int main() {
    int T;
    cin >> T;

    for(int i = 0; i < T; i++) {
        memset(map, 0, sizeof(map));
        memset(visited, false, sizeof(visited));
        cin >> M >> N >> K;
        int x, y, answer = 0;

        for(int j = 0; j < K; j++) {
            cin >> x >> y;
            map[y][x] = 1;
        }

        for(int j = 0; j < N; j++) {
            for(int k = 0; k < M; k++) {
                if(map[j][k] == 1 && !visited[j][k]) {
                    bfs(k, j);
                    answer++;
                }
            }
        }
        cout << answer << endl;
    }
}