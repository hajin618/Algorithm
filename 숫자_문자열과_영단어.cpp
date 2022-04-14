/*
정규표현식 : 문자열에서 패턴을 찾는데 사용
- 문자열이 주어진 규칙에 맞는지 확인
- 문자열에서 원하는 패턴의 문자열을 검색
- 문자열에서 원하는 패턴의 문자열로 치환        같은 경우에 사용 가능

#include <regex> 사용
*/

#include <string>
#include <vector>
#include <regex>

using namespace std;

int solution(string s) {
    int answer = 0;
    
    s=regex_replace(s, regex("zero"), "0");
    s=regex_replace(s, regex("one"), "1");
    s=regex_replace(s, regex("two"), "2");
    s=regex_replace(s, regex("three"), "3");
    s=regex_replace(s, regex("four"), "4");
    s=regex_replace(s, regex("five"), "5");
    s=regex_replace(s, regex("six"), "6");
    s=regex_replace(s, regex("seven"), "7");
    s=regex_replace(s, regex("eight"), "8");
    s=regex_replace(s, regex("nine"), "9");
    answer=stoi(s);
    return answer;
}