#include<iostream>
#include<map>
#include<string>

using namespace std;

int main(void) {
	int n, m;
	map<string, bool> ma;
	string s;
	int ans = 0;

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> s;
		ma[s] = true;
	}
	for (int i = 0; i < m; i++) {
		cin >> s;
		if (ma[s])
			ans++;
	}
	cout << ans;
	return 0;
}