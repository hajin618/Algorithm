#include <string>
#include <vector>

using namespace std;

int solution(int number, int limit, int power) {
    int answer = 0;
    vector<int> v;
    v.push_back(1);
    for(int i=2;i<=number;i++){
        int cnt=2;
	// j<=i는 시간초과
        for(int j=2;j<=i/2;j++){
            if(i%j==0)
                cnt++;
        }
        if(cnt>limit)
            cnt=power;
        v.push_back(cnt);
    }
    for(int i=0;i<v.size();i++)
        answer+=v[i];
    
    return answer;
}