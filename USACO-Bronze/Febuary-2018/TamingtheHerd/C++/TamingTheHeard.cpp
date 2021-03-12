//Notice that if the counter is a positive number i on some day, then the counter must be i−1 on the previous day.
//So we can sweep from the last day backwards in time, applying this rule to fill in missing entries. If we try to fill in an entry which was not missing,
//then either nothing happens (if we try to fill in some number n, and the entry is already n), or we get a contradiction (if we try to fill in a number n, but the entry contains a different nonnegative number).

//The first entry in the log is a special case, since Farmer John already knows the cows broke out on that day. So if it is a missing entry,
//we can set it to 0. If it is any positive number, then we have a contradiction.

//If we ever come across a contradiction, then the log is necessarily inconsistent, so we can just output −1.
//Otherwise, the log must consist of several streaks 0,1,2,…,k of various lengths, with possibly some −1s between streaks -
//entries which we could not uniquely deduce. We know that the first streak starts on the first day.

//Suppose there are s streaks and t entries that are still missing. Then to minimize the number of breakouts,
//each sequence of consecutive missing entries would be filled in so that it continues the streak preceding it
//(e.g. 0,1,2,3,−1,−1 would be filled in as 0,1,2,3,4,5). So the minimum number of breakouts is s.

//To maximize the number of breakouts, the cows would have broken out on each of the t days for which the entry is missing (e.g. 0,1,2,3,−1,−1 would be filled in as 0,1,2,3,0,0). So the maximum number of breakouts is s+t.

#include <iostream>
#include <algorithm>
using namespace std;
#define MAXN 100000

int N;
int A[MAXN];

int main()
{
	cin >> N;
	for(int i=0;i<N;i++)
		cin >> A[i];
	if(A[0] > 0)
	{
		cout << -1 << '\n';
		return 0;
	}
	A[0] = 0;
	int t = -1;
	int req = 0;
	int pos = 0;
	for(int i=N-1;i>=0;i--)
	{
		if(t != -1 && A[i] != -1 && A[i] != t)
		{
			cout << -1 << '\n';
			return 0;
		}
		if(t == -1)
			t = A[i];
		if(A[i] == -1)
			A[i] = t;
		if(A[i] == 0)
			req++;
		if(A[i] == -1)
			pos++;
		if(t > -1)
			t--;
	}
	cout << req << ' ' << req+pos << '\n';
}