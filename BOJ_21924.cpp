#include<vector>
#include<iostream>
#include<algorithm>
#include<queue>

using namespace std;

int v, e;
int parent[100005];
// 가중치, 정점1, 정점2
priority_queue<pair<int, pair<int, int>>> pq;
long long int result = 0;
int line = 0;
long long int allCost = 0;

int find(int x)
{
	if (parent[x] == x)
		return x;
	else
		return parent[x] = find(parent[x]);
}

void Union(int x, int y)
{
	x = find(x);	// x의 부모찾기
	y = find(y);	// y의 부모찾기

	if (x != y)		// 두 노드의 부모 다를 때
		parent[y] = x;
}

long long int kruskal() {

	while (!pq.empty()) {
		int u = find(pq.top().second.first);
		int v = find(pq.top().second.second);
		int cost = -pq.top().first;

		pq.pop();

		if (u == v)
			continue;
		// 부모가 다르다면 union
		else {
			Union(u, v);
			result += cost;
			line += 1;
		}
	}
	return result;
}

int main(void) {
	cin >> v >> e;

	for (int i = 1; i <= v; i++)
		parent[i] = i;

	for (int i = 0; i < e; i++) {
		int a, b, c;
		// 정점 1, 정점2, 가중치
		cin >> a >> b >> c;
		pq.push({ -c, {a,b} });
		allCost += c;
	}
	result = kruskal();

	if (line == v - 1)
		cout << allCost - result;
	else
		cout << "-1";
	return 0;
}