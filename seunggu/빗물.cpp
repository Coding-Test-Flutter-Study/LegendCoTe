#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int H, W;
    int answer = 0;

    cin >> H >> W;

    int map[W];

    for(int i = 0; i < W; i++) {
        cin >> map[i];
    }

    for(int i = 1; i < W-1; i++) {
        int left = *max_element(map, map + i);
        int right = *max_element(map + i, map + W);
        if(left > map[i] && right > map[i]) answer += min(left, right) - map[i];
    }
    cout << answer;
}