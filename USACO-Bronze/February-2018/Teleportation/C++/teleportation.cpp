//This problem is relatively straightforward -- we need to choose between three alternatives:

//- If Farmer John drives directly from a to b without teleporting, he travels a distance of |a−b|.

//- Farmer John could travel from a to x, teleport to y, then travel to b, for a distance of |a−x|+|b−y|.

//- Farmer John could travel from a to y, teleport to x, then travel to b, for a distance of |a−y|+|b−x|.

//Taking the smallest of these three yields the answer.

#include <iostream>
#include <algorithm>
using namespace std;

int main(void)
{
  int a, b, X[8], Y[8], x, y;
  cin >> a >> b;
  cin >> x >> y;
  int answer = abs(a-b); // no teleport
  answer = min(answer, abs(a-x) + abs(b-y));
  answer = min(answer, abs(a-y) + abs(b-x));
  cout << answer << "\n";
  return 0;
}