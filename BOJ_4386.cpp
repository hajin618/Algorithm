#define _CRT_SECURE_NO_WARNINGS
#include<vector>
#include<iostream>
#include<algorithm>
#include<queue>
#include<math.h>

using namespace std;

int n;
int parent[10005];
// 가중치, 정점1, 정점2
priority_queue<pair<double, pair<int, int>>> pq;
vector<pair<double, double>> star;
double result = 0;

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

double kruskal() {
	
	while (!pq.empty()) {
		int u = find(pq.top().second.first);
		int v = find(pq.top().second.second);
		double cost = -pq.top().first;

		pq.pop();

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

double cal_dist(double x1, double y1, double x2, double y2) {
	return sqrt(pow(x2 - x1, 2) + pow(y2 - y1, 2));
}

int main(void) {
	cin >> n;

	for (int i = 1; i <= n; i++)
		parent[i] = i;

	for (int i = 0; i < n; i++) {
		double a, b;
		
		cin >> a >> b;
		star.push_back({ a, b });
	}

	for (int i = 0; i < n; i++) {
		for (int j = i + 1; j < n; j++) {
			double cost = cal_dist(star[i].first, star[i].second, star[j].first, star[j].second);

			pq.push({ -cost, {i,j} });
		}
	}


	cout << kruskal();

	return 0;
}