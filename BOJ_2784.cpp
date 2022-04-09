// 순열
// 완전탐색
#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
#include<algorithm>
#include<string.h>
#include<stdlib.h>
#include<vector>
#include<stack>
#include<map>


using namespace std;
string str[6];	// 입력받은 문자열
string ans[3];	// 완성된 문자열

void func(void) {
    bool visited[6] = { 0 };
    int cnt = 0;

    for (int a = 0; a < 3; a++) {
        for (int b = 0; b < 6; b++) {
            if (!visited[b] && ans[a] == str[b]) {
                visited[b] = true;
                cnt++;
                break;
            }
        }
        for (int b = 0; b < 6; b++) {
            if (!visited[b] && ans[0][a] == str[b][0] && ans[1][a] == str[b][1] && ans[2][a] == str[b][2]) {
                visited[b] = true;
                cnt++;
                break;
            }
        }
    }
    if (cnt == 6) {
        for (int i = 0; i < 3; i++) {
            cout << ans[i] << "\n";
            
        }
        exit(0);
    }
}

int main() {
    for (int i = 0; i < 6; i++) {
        cin >> str[i];
    }

    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            for (int k = 0; k < 6; k++) {
                if (i == j || j == k || k == i)
                    continue;
                ans[0] = str[i];
                ans[1] = str[j];
                ans[2] = str[k];
                func();
            }
        }
    }
    cout << "0";

    return 0;
}