#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<set>
#include<string.h>

using namespace std;

int main() {
    int n, m;
    int arr[10005];
    int max = 0;

    int left, right, mid, sum_2, ans;
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        if (max < arr[i])
            max = arr[i];
    }
    cin >> m;

  

    left = 1;
    right = max;
    while (left <= right) {
        sum_2 = 0;
        mid = (left + right) / 2;
        for (int i = 0; i < n; i++) {
            sum_2 += min(arr[i], mid);
        }
        if (m >= sum_2) {
            ans = mid;
            left = mid + 1;
        }
            
        else {
            right = mid - 1;
        }
    }    
    
    cout << ans;
    
    return 0;
}