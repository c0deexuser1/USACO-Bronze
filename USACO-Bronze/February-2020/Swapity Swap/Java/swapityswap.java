import java.io.*;
import java.util.*;
public class Solution {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("swap.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int a1 = Integer.parseInt(st.nextToken())-1;
    int a2 = Integer.parseInt(st.nextToken())-1;
    st = new StringTokenizer(br.readLine());
    int b1 = Integer.parseInt(st.nextToken())-1;
    int b2 = Integer.parseInt(st.nextToken())-1;
    int cycleSize = 0;
    int[] l = new int[n];
    for(int i = 0; i < n; i++) l[i] = i;
    boolean sorted = true;
    do {
      cycleSize++;
      reverse(l, a1, a2);
      reverse(l, b1, b2);
      sorted = true;
      for(int i = 0; sorted && i < n; i++) sorted = l[i] == i;
    }
    while(!sorted);
    k %= cycleSize;
    for(int i = 0; i < n; i++) l[i] = i+1;
    for(int i = 0; i < k; i++) {
      reverse(l, a1, a2);
      reverse(l, b1, b2);
    }
    for(int val: l) pw.println(val);
    pw.close();
  }
  private static void reverse(int[] l, int a, int b) {
    while(a < b) {
      int t = l[a];
      l[a] = l[b];
      l[b] = t;
      a++;
      b--;
    }
  }
}