#include <iostream>

#define MAX 300

using namespace std;

int N, M, R;
int arr[MAX][MAX];

int n;

void down(int x, int s, int e, int first) {
    int cur = first;
    for(int i = s; i < e; i++) {
        int temp = arr[i+1][x];
        arr[i+1][x] = cur;
        cur = temp;
    }
    n = cur;
}

void up(int x, int s, int e, int first) {
    int cur = first;
    for(int i = s; i >= e; i--) {
        int temp = arr[i-1][x];
        arr[i-1][x] = cur;
        cur = temp;
    }
    n = cur;
}

void right(int y, int s, int e, int first) {
    int cur = first;
    for(int i = s; i < e; i++) {
        int temp = arr[y][i+1];
        arr[y][i+1] = cur;
        cur = temp;
    }
    n = cur;
}

void left(int y, int s, int e, int first) {
    int cur = first;
    for(int i = s; i >= e; i--) {
        int temp = arr[y][i-1];
        arr[y][i-1] = cur;
        cur = temp;
    }
    n = cur;
}

void rotate() {
    int cnt = 0;

    while(cnt != M/2 && cnt != N/2) {
        down(cnt, cnt, N-cnt-1, arr[cnt][cnt]);
        right(N-cnt-1, cnt, M-cnt-1, n);
        up(M-cnt-1, N-cnt-1, cnt+1, n);
        left(cnt, M-cnt-1, cnt+1, n);
        cnt++;
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> M >> R;

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cin >> arr[i][j];
        }
    }

    for(int i = 0; i < R; i++) {
        rotate();
    }

    for(int i = 0; i < N; i++) {
        for(int j = 0; j < M; j++) {
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
}