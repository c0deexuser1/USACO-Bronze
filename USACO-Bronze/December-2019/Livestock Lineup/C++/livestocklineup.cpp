#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> cows, beside_a, beside_b, answer;
int N;

int where(string c)
{
  for (int i=0; i<answer.size(); i++)
    if (answer[i]==c) return i;
  return 999;
}

bool can_go_first(string c)
{
  int n = answer.size(), nbrs=0;
  if (where(c)!=999) return false;
  for (int i=0; i<N; i++) {
    if (beside_a[i]==c && where(beside_b[i])==999) nbrs++;
    if (beside_b[i]==c && where(beside_a[i])==999) nbrs++;
  }
  if (nbrs == 2) return false;
  if (n>0) {
    string last_cow = answer[n-1];
    for (int i=0; i<N; i++) {
      if (beside_a[i]==last_cow && where(beside_b[i])==999 && beside_b[i]!=c) return false;
      if (beside_b[i]==last_cow && where(beside_a[i])==999 && beside_a[i]!=c) return false;
    }
  }
  return true;
}

int main(void)
{
  ifstream fin ("lineup.in");
  ofstream fout ("lineup.out");
  fin >> N;
  cows.push_back("Beatrice");
  cows.push_back("Belinda");
  cows.push_back("Bella");
  cows.push_back("Bessie");
  cows.push_back("Betsy");
  cows.push_back("Blue");
  cows.push_back("Buttercup");
  cows.push_back("Sue");
  string a, b, t;
  for (int i=0; i<N; i++) {
    fin >> a;
    fin >> t; // must
    fin >> t; // be
    fin >> t; // milked
    fin >> t; // beside
    fin >> b;
    beside_a.push_back(a);
    beside_b.push_back(b);
  }
  for (int i=0; i<8; i++) {
    int next_cow = 0;
    while (!can_go_first(cows[next_cow])) next_cow++;
    answer.push_back(cows[next_cow]);
    fout << cows[next_cow] << "\n";
  }
  return 0;
}