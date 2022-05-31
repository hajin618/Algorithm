#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>

using namespace std;

int main()
{
    int n, m, k;
    int ans;
    cin >> n >> m >> k;
    m = m - 3;
    k = k - 3;
    if (k == 0)
        cout << m+3;
    else if (k > 0) {
        ans = m + k + 3;
        while (ans < 0) {
            ans += n;
        }
        ans = ans % n;
        if (ans == 0)
            ans = n;
        cout << ans;
    }
    else if (k < 0) {
        ans = m + k + 3;
        while (ans < 0) {
            ans += n;
        }
        ans = ans % n;
        if (ans == 0)
            ans = n;
        cout << ans;
    }
    return 0;
}