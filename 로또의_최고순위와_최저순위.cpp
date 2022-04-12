#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    // lottos : 구매한 로또 번호
    // win_nums : 당첨 번호
    // 최고 순위와 최저 순위 배열에 담아 return
    vector<int> answer;
    int zero=0;
    int same=0;
    
    for(int i=0;i<6;i++){
        if(lottos[i]==0)
            zero++;
    }
    for(int i=0;i<6;i++){
        for(int j=0;j<6;j++){
            if(lottos[i]==0)
                continue;
            else{
                if(lottos[i]==win_nums[j])
                    same++;
            }
        }
    }
    if(same+zero>=2)
        answer.push_back(7-same-zero);
    else
        answer.push_back(6);
    
    if(same>=2)
        answer.push_back(7-same);
    else
        answer.push_back(6);
    
    return answer;
}