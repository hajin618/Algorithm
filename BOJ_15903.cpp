#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

priority_queue<long long int, vector<long long int>, greater<long long int>> pq1;
int main()
{
    long long int ans = 0;
    int n, m, a;
    cin >> n >> m;
    for (int i = 0; i < n; i++) {
        cin >> a;
        pq1.push(a);
    }
    for (int i = 0; i < m; i++) {
        long long int p = pq1.top();
        pq1.pop();
        long long int q = pq1.top();
        pq1.pop();
        pq1.push(p + q);
        pq1.push(p + q);
    }
    for (int i = 0; i < n; i++) {
        ans += pq1.top();
        pq1.pop();
    }
    cout << ans;
    return 0;
}