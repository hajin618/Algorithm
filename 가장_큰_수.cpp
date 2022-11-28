#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string s1, string s2){
    return s1+s2>s2+s1;
}
string solution(vector<int> numbers) {
    string answer = "";
    int a;
    vector<string> strings;
    
    int numSize=numbers.size();
    
    for(int i=0;i<numSize;i++){
        a=numbers[i];
        strings.push_back(to_string(a));
    }
    sort(strings.begin(), strings.end(), compare);
    
    for(int i=0;i<numSize;i++){
        answer+=strings[i];
    }
    
    if(answer[0]=='0')
        return "0";
    else
        return answer;
}