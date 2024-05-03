#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
#include <string>

#define MAX 50

using namespace std;

int W, H;
int answer = 0;

char map[MAX][MAX];
bool visited[MAX][MAX];
int dist[MAX][MAX];

int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};

vector<pair<int, int>> vec;

void bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push({x, y});
    visited[y][x] = true;

    while(!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = dx[i] + cur.first;
            int ny = dy[i] + cur.second;

            if(nx < 0 || ny < 0 || nx >= W || ny >= H) continue;
            if(map[ny][nx] == 'L' && !visited[ny][nx]) {
                visited[ny][nx] = true;
                q.push({nx, ny});
                dist[ny][nx] = dist[cur.second][cur.first] + 1;
                if(dist[ny][nx] > answer) answer = dist[ny][nx];
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> H >> W;
    string str;

    for(int i = 0; i < H; i++) {
        cin >> str;
        for(int j = 0; j < W; j++) {
            map[i][j] = str[j];
            if(map[i][j] == 'L') vec.push_back({j, i});
        }
    }
    
    for(auto &i : vec) {
        memset(dist, 0, sizeof(dist));
        memset(visited, false, sizeof(visited));
        bfs(i.first, i.second);
    }

    cout << answer;
}