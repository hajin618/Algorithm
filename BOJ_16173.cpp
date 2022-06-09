#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<set>
#include<string.h>

using namespace std;

int m, n;
int row[2] = { 0,1 };
int col[2] = { 1,0 };
bool visited[4][4];
int arr[4][4];

queue<pair<int, int>> q;

int bfs(int now_row, int now_col) {
    visited[now_row][now_col] = true;
    q.push({ now_row, now_col });
    
    while (!q.empty()) {
        int a = q.front().first;
        int b = q.front().second;
        int move = arr[a][b];
        q.pop();

        for (int i = 0; i < 2; i++) {
            int next_row = a + row[i] * move;
            int next_col = b + col[i] * move;

            if (!visited[next_row][next_col] && next_row<n && next_col<n){
                if (arr[next_row][next_col] == -1)
                    return 1;
                q.push({ next_row, next_col });
                visited[next_row][next_col] = true;

            }
        }
    }
    return 0;
}
int main()
{
    cin >> n;
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    if (bfs(0, 0))
        cout << "HaruHaru";
    else
        cout << "Hing";
    
    return 0;
}