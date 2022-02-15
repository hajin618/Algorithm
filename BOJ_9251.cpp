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
#include<string>

using namespace std;

int arr[1005][1005];

int main(void) {
	string s1;
	string s2;
	cin >> s1 >> s2;
	
	// 계산상 편의를 위해 각 string 앞에 0 삽입
	s1.insert(0, "0");
	s2.insert(0, "0");

	
	for (int i = 1; i < s1.size()+1; i++) {
		for (int j = 1; j < s2.size(); j++) {
			// 비교하는 두 문자가 같은 경우
			if (s1[i] == s2[j]) {
				// 왼쪽 위 대각선의 dp 값 + 1
				arr[i][j] = arr[i - 1][j - 1] + 1;
			}
			// 비교하는 두 문자가 다른 경우
			else	
				// 왼쪽과 위쪽 중 최댓값
				arr[i][j] = max(arr[i][j - 1], arr[i - 1][j]);
		}
	}

	/*
	// dp 배열 값 확인
	for (int i = 1; i < s1.size(); i++) {
		for (int j = 1; j < s2.size(); j++) {
			cout << arr[i][j] << " ";
		}
		cout << "\n";
	}
	
	*/

	cout << arr[s1.size()-1][s2.size()-1];

	return 0;
}