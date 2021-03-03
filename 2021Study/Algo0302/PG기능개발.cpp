#include <string>
#include <vector>
#include <stack>
#include <iostream>
#include <string>
#include <math.h>

using namespace std;




vector<int> solution(vector<int> progresses, vector<int> speeds)
{
	vector<int> answer;
	int day = 0;


	while (day < speeds.size())
	{
		int head = progresses[day];
		int speed = speeds[day];
		int rest = ceil((100 - head) / speed);


		bool flag = true;

		for (int i = day + 1; i < speeds.size(); i++)
		{
			if (speeds.size() - 1 == i)
			{
				if (rest * speeds[i] + progresses[i] < 100)
				{
					answer.push_back(i - day);
					answer.push_back(1);

				}
				else
				{
					answer.push_back(i - day + 1);
				}
				return answer;
			}

			if (rest * speeds[i] + progresses[i] < 100)
			{

				answer.push_back(i - day);
				day = i;
				flag = false;



				break;
			}


		}

		if (flag)
		{
			day++;
			answer.push_back(1);
		}


	}


	return answer;
}



//
//int main()
//{
//	for (int x : solution({ 93, 30, 55 }, { 1, 30, 5 }))
//	{
//
//		cout << x << endl;
//	}
//
//	return 0;
//}