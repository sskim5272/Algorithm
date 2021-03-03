#include <vector>
#include <queue>
#include <iostream>
using namespace std;



const int dx[] = { 1,-1,0,0 };
const int dy[] = { 0,0,1,-1 };


struct Pos
{
	int x, y;
};


int bfs(const int m, const int n, const int y, const int x, const vector<vector<int>> picture, vector<vector<bool>> &grid)
{
	queue<Pos> q;
	Pos pos;
	pos.x = x;
	pos.y = y;
	q.push(pos);
	int cnt = 1;
	int color = picture[y][x];

	while (q.empty() == false)
	{
		Pos tempPos = q.front();
		q.pop();
		int xx = tempPos.x;
		int yy = tempPos.y;

		for (int dir = 0; dir < 4; dir++)
		{
			int xxx = xx + dx[dir];
			int yyy = yy + dy[dir];
			if (xxx >= 0 && yyy >= 0 && xxx < n && yyy < m && grid[yyy][xxx] == false && picture[yyy][xxx] == color)
			{
				cout << xxx << " " << yyy << endl;
				cout << grid[yyy][xxx] << xxx << " " << yyy << endl;
				tempPos.x = xxx;
				tempPos.y = yyy;
				grid[yyy][xxx] = true;
				q.push(tempPos);
				cnt++;
			}
		}


	}
	if (color == 0) return 0;

	return cnt;
}

vector<int> solution(int m, int n, vector<vector<int> > picture)
{
	int number_of_area = 0;
	int max_size_of_one_area = 0;
	vector<vector<bool>> grid = vector<vector<bool>>(m, vector<bool>(n, false));

	for (int row = 0; row < m; row++)
	{
		for (int col = 0; col < n; col++)
		{
			if (grid[row][col] == false)
			{
				if (grid[row][col] != 0)					
					number_of_area++;
				bfs(m, n, row, col, picture, grid);
			}

		}
	}



	vector<int> answer(2);
	answer[0] = number_of_area;
	answer[1] = max_size_of_one_area;
	return answer;
}




int main()
{
	solution(6, 4, {
				vector<int>({1, 1, 1, 0}),
				vector<int>({1, 1, 1, 0}),
				vector<int>({0, 0, 0, 1}),
				vector<int>({0, 0, 0, 1}),
				vector<int>({0, 0, 0, 1}),
				vector<int>({0, 0, 0, 1})
		}
	);
	return 0;
}