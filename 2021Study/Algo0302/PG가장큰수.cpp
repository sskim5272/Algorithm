#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(string str1,string  str2)
{
    for (int i = 0;i<4; i++)
    {
        if (str1[i] == str2[i]) continue;

        return str1[i] < str2[i];
    }

    return true;
}

string solution(vector<int> numbers)
{
    vector<string> stringNumbers;
    string answer = "";
    for (int x : numbers)
    {
        stringNumbers.push_back(to_string(x));
    }
    sort(stringNumbers.begin(), stringNumbers.end(), compare);

    for (string str : stringNumbers)
    {
        answer += str;
    }
    
    return answer;
}