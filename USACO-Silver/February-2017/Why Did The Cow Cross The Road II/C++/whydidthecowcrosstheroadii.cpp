#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> A;

int main() {
  int N, K, B;
  cin >> N >> K >> B;

  A.resize(B);
  for (int i = 0; i < B; i++) {
    cin >> A[i];
  }
  sort(A.begin(), A.end());

  int hia = 0;
  while (hia < B && A[hia] <= K) {
    hia++;
  }

  int result = hia;
  for (int i = 0; i < B; i++) {
    if (A[i] + K > N) {
      break;
    }
    while (hia < B && A[hia] <= A[i] + K) {
      hia++;
    }
    result = min(result, hia - i - 1);
  }
  cout << result << endl;

  return 0;
}