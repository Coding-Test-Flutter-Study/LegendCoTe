#include <iostream>
#include <vector>
#include <tuple>
#include <algorithm>
#include <queue>
#include <cstring>
#define MAX 10

using namespace std;

typedef pair<int, int> coordinate;
typedef tuple<coordinate, coordinate, coordinate> combination;

int N, M;
int dx[4] = {1, -1, 0, 0};
int dy[4] = {0, 0, 1, -1};
int map[MAX][MAX];
int map_copy[MAX][MAX];
bool visited[MAX][MAX];

void combineUtil(vector<combination>& result, const vector<coordinate>& vec, int k, int start, vector<coordinate>& current) {
    if (k == 0) {
        result.push_back(make_tuple(current[0], current[1], current[2]));
        return;
    }

    for (int i = start; i < vec.size(); ++i) {
        current.push_back(vec[i]);
        combineUtil(result, vec, k - 1, i + 1, current);
        current.pop_back();
    }
}

vector<combination> combineCoordinates(const vector<coordinate>& vec, int k) {
    vector<combination> result;
    vector<coordinate> current;
    combineUtil(result, vec, k, 0, current);
    return result;
}

void bfs(int x, int y) {
    visited[y][x] = true;
    queue<coordinate> q;
    q.push({x, y});

    while(!q.empty()) {
        coordinate cur = q.front();
        q.pop();

        for(int i = 0; i < 4; i++) {
            int nx = cur.first + dx[i];
            int ny = cur.second + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(!visited[ny][nx] && map_copy[ny][nx] == 0) {
                q.push({nx, ny});
                visited[ny][nx] = true;
                map_copy[ny][nx] = 2;
            }
        }
    }
}
 
int main() {
    cin >> N >> M;
    vector<coordinate> vec;
    int answer = 0;

    memset(map, 0, sizeof(map));

    for(int i = 0; i < N; i++) {
        for(int j  = 0; j < M ; j++) {
            cin >> map[i][j];
            if(map[i][j] == 0) vec.push_back({i, j});
        }
    }

    vector<combination> result = combineCoordinates(vec, 3);

    for(auto &i: result) {
        coordinate coord1, coord2, coord3;
        tie(coord1, coord2, coord3) = i;
        int cnt = 0;

        for(int j = 0; j < N; j++) {
            for(int k = 0; k < M; k++) {
                map_copy[j][k] = map[j][k];
            }
        }

        memset(visited, false, sizeof(visited));
        map_copy[coord1.first][coord1.second] = 1;
        map_copy[coord2.first][coord2.second] = 1;
        map_copy[coord3.first][coord3.second] = 1;

        for(int j = 0; j < N; j++) {
            for(int k = 0; k < M; k++) {
                if(map_copy[j][k] == 2 && !visited[j][k]) bfs(k, j);
            }
        }

        for(int j = 0; j < N; j++) {
            for(int k = 0; k < M; k++) {
                if(map_copy[j][k] == 0) cnt++;
            }
        }
        if(cnt > answer) answer = cnt;
    }
    cout << answer;
}