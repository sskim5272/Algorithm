#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;


long long b_search(vector<int>& times, long long l, long long r, long long ans, int& n)
{



    long long m = (l + r) / 2;
    long long sum = 0;

    for (auto& t : times)
    {
        sum += (m / t);
    }

    cout << l << " " << r << " " << sum << " " << ans << endl;

    if (l + 1 == r)
    {
        if (sum < n)
            return r;
        return l;
    }


    if (sum < n)
    {
        return b_search(times, m, r, ans, n);
    }
    else
    {
        return b_search(times, l, m, ans, n);
    }



}

long long solution(int n, vector<int> times)
{
    sort(times.begin(), times.end(), greater());

    long long answer = 0;
    long long left = 0;
    long long right = times[0] * n;
    cout << times[0] * n << " " << right << endl;
    answer = b_search(times, left, right, right, n);

    return answer;
}