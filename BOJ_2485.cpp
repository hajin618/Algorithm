#include<iostream>
#include<vector>
#include<algorithm>
#include<math.h>

using namespace std;

vector<int> tree;
vector<int> dis;
int ans = 0;
int gcd_result;
int sum = 0;

int gcd(int a, int b) {
	int tmp, n;

	// a에 큰 값 오도록
	if (a < b) {
		tmp = a;
		a = b;
		b = tmp;
	}

	while (b != 0) {
		n = a % b;
		a = b;
		b = n;
	}
	return a;
}
int main(void) {
	int n, a;
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a;
		tree.push_back(a);
	}
	sort(tree.begin(), tree.end());
	for (int i = 0; i < n - 1 ; i++) {
		dis.push_back(tree[i + 1] - tree[i]);
	}

	
	for (int i = 0; i < n - 1; i++) {
		gcd_result = gcd(dis[i], gcd_result);
	}
	//cout << ans;
	for (int i = 0; i < n - 1; i++) {
		dis[i] = dis[i] / gcd_result - 1;
		sum += dis[i];
	}
	cout << sum;
}