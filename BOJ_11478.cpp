#include<iostream>
#include<vector>
#include<queue>
#include<algorithm>
#include<set>

using namespace std;

int main()
{
    set<string> sss;
    string s;
    string tmp="";
    cin >> s;

    for (int i = 0; i < s.size(); i++) {
        for (int j = i; j < s.size(); j++) {
            tmp += s[j];
            sss.insert(tmp);
        }
        tmp = "";
    }

    cout << sss.size();
    return 0;
}