#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<algorithm>
#include<string.h>
#include<stdlib.h>
#include<vector>
#include<math.h>
#include<stack>
#include<map>
#include<queue>
#include<deque>

using namespace std;

vector<int> pos;
vector<int> neg;
vector<int> ans;

bool compare(int i, int j) {
	return i > j;
}

int main(void) {
	int n, m, a;
	int answer = 0;
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> a;
		if (a > 0)
			pos.push_back(a);
		else
			neg.push_back(-a);
	}

	sort(pos.begin(), pos.end(), compare);
	sort(neg.begin(), neg.end(), compare);

	for (int i = 0; i < pos.size(); i = i + m) {
		ans.push_back(pos[i]);
	}
	for (int i = 0; i < neg.size(); i = i + m) {
		ans.push_back(neg[i]);
	}

	sort(ans.begin(), ans.end(), compare);

	answer += ans[0];

	for (int i = 1; i < ans.size(); i++) {
		answer += 2 * ans[i];
	}

	cout << answer;

	return 0;
}