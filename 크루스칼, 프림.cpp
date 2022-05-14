
#define _CRT_SECURE_NO_WARNINGS
#include<vector>
#include<iostream>
#include<algorithm>
#include<queue>



using namespace std;
int n, m;

int parent[100];
// adj에는 정점과 간선들의 정보 저장되어 있음
vector<pair<int, int>> adj[100];
bool visited[100];

// 부모 노드 찾기
int find(int x)
{
	if (parent[x] == x)
		return x;
	else
		return parent[x] = find(parent[x]);
}

// 합치기
void Union(int x, int y)
{
	x = find(x);	// x의 부모찾기
	y = find(y);	// y의 부모찾기

	if (x != y)		// 두 노드의 부모 다를 때
		parent[y] = x;
}

int prim(int start)
{
	int result = 0;			// 가중치 합
	// 선택된 정점들에 부속된 간선들 저장 {연결된 정점, 간선의 가중치}
	priority_queue <pair<int, int>> pq;

	// 시작 정점의 간선들 삽입
	for (int i = 0; i < adj[start].size(); i++) {
		pq.push({ -adj[start][i].first, adj[start][i].second });
	}
	
	while (!pq.empty()) {
		int nowVertex = pq.top().first;		
		int minCost = pq.top().second;
		pq.pop();

		if (visited[nowVertex])
			continue;		// 이미 방문한 정점이면 continue
		else {				// 방문하지 않은 정점이면
			visited[nowVertex] = true;
			result += minCost;

			for (int i = 0; i < adj[nowVertex].size(); i++) {
				// nowVertex에 부속된 간선들 pq에 삽입
				pq.push({ -adj[nowVertex][i].first, adj[nowVertex][i].second });
			}
		}
	}
	return result;
}

int kruskal(){
	int result = 0;			// 가중치 합
	
	// 가중치, 정점1, 정점2
	priority_queue<pair<int, pair<int, int>>> pq;

	// parent 자기 자신으로 초기화
	for (int i = 1; i <= n; i++)
		parent[i] = i;

	for (int i = 0; i < m; i++)
	{
		int a, b, c;
		cin >> a >> b >> c;

		/*
		priority_queue는 큰 값 부터 정렬되므로
		 최소값부터 정렬하기 위해 가중치 음수화

		pq 정의할 때 greater<> 사용도 가능
		*/
		pq.push({ -c, {a,b} });
	}
	while (!pq.empty())
	{
		int u = find(pq.top().second.first);
		int v = find(pq.top().second.second);
		int cost = -pq.top().first;

		pq.pop();

		// 부모가 같다면 사이클 -> continue
		if (u == v)
			continue;
		// 부모가 다르다면 union
		else {
			Union(u, v);
			result += cost;
		}
	}
	return result;
}


int main(void) {

	for (int i = 0; i < n; i++) {
		int a, b, c;
		// 정점1, 정점2, 간선 가중치
		cin >> a >> b >> c;

		adj[a].push_back({ b,-c });
		adj[b].push_back({ a,-c });
	}
}
