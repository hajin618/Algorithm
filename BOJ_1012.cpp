#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<set>
#include<string.h>

using namespace std;

int row[4] = { 0, 0, -1, 1 };
int col[4] = { -1, 1, 0, 0 };
bool arr[55][55];
bool visited[55][55];
queue<pair<int, int>> q;
int t, m, n, k;

void bfs(int now_row, int now_col) {
    
  
    visited[now_row][now_col] = 1;
    
    q.push(make_pair(now_row, now_col));
    while (!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int next_row = a + row[i];
            int next_col = b + col[i];
            if (next_row >= 0 && next_col >= 0 && next_row < m && next_col < n && !visited[next_row][next_col] && arr[next_row][next_col]) {
                visited[next_row][next_col] = 1;
                q.push(make_pair(next_row, next_col));
            }
        }
    }
}

int main()
{
    int a, b;
    cin >> t;
    for (int p = 0; p < t; p++) {
        memset(arr, 0, sizeof(arr));
        memset(visited, 0, sizeof(visited));
        cin >> m >> n >> k;
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            cin >> a >> b;
            arr[a][b] = 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && arr[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        cout << cnt << "\n";
    }
    return 0;
}