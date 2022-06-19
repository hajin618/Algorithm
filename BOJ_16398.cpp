#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
#include<queue>

using namespace std;

priority_queue <pair<int, pair<int, int>>> pq;
int arr[1001][1001];
int parent[1005];
long long int result = 0;

int Find(int x) {
    if (parent[x] == x)
        return x;
    else
        return parent[x] = Find(parent[x]);
}

void Union(int x, int y) {
    x = Find(x);
    y = Find(y);

    if (x != y)
        parent[y] = x;
}

long long int kruskal() {
    while (!pq.empty()) {
        int u = Find(pq.top().second.first);
        int v = Find(pq.top().second.second);
        int cost = -pq.top().first;

        pq.pop();

        if (u == v)
            continue;
        else {
            Union(u, v);
            result += cost;
        }
    }
    return result;

}
int main(void) {
    int n;
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            pq.push({ -arr[i][j],{ i, j } });
        }
    }

    for (int i = 0; i < n; i++) {
        parent[i] = i;
    }

    cout << kruskal();

    return 0;
}