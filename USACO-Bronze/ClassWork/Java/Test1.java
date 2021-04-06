import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

public class Test1 {

  private static int fastesthindex(ArrayList<Integer> arr)
  {
      long start = System.currentTimeMillis();
      int maxhindex = arr.size();

      for(int i = arr.size()-1; i>=0; i--)
      {
        int no_above = arr.size()-i;
        //System.out.println(no_above);
        if (no_above >= arr.get(i))
        {
          //System.out.println("Found");
          maxhindex = arr.get(i);
          //System.out.println(maxhindex);
          break;
        }

      }
      long finish = System.currentTimeMillis();
      System.out.println("Time Taken:" + (finish-start));

      return maxhindex;
  }

  private static int calculatehindex(ArrayList<Integer> arr)
  {
      long start = System.currentTimeMillis();
      int maxhindex = arr.size();

      for (int i=maxhindex; i>=0; i--)
      {
          int counter = 0;
          for(int j=0; j < arr.size(); j++)
          {
              if(arr.get(j) >= i)
              counter++;
          }
          if(counter >= i)
          {
              maxhindex = i;
              break;
          }
      }
      long finish = System.currentTimeMillis();
      System.out.println(finish-start);
      return maxhindex;
  }

  public static void main (String [] args) throws IOException{

    long start = System.currentTimeMillis();
    BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    ArrayList<Integer> citationCounts = new ArrayList<Integer>();

    st = new StringTokenizer(br.readLine());
    Random rand = new Random();
    //N = 100000;
    //int upperBound = 100000;

    for(int i=0; i<N; i++){
    citationCounts.add(Integer.parseInt(st.nextToken()));
    //citationCounts.add(rand.nextInt(upperBound));
    }

    Collections.sort(citationCounts);

    //System.out.println(h);
    int h = fastesthindex(citationCounts);
    System.out.println("hindex before " + h);

    int e=0;
    for(int i=0; i<N; i++){
      if(citationCounts.get(i)>h){
        e=i;
        break;
      }
      else if (citationCounts.get(N-1)==h){
        e=N;
      }
    }

    System.out.println(e);
    int changes = Math.min(L, e);

    for(int i = e-1; i>e-changes-1; i--){
      int oldVal = citationCounts.get(i);
      int newVal = oldVal + 1;
      citationCounts.set(i, newVal);
    }

    for (int i=0; i < citationCounts.size(); i++)
    {
      System.out.print(citationCounts.get(i));
    }
    h = fastesthindex(citationCounts);

    System.out.println("hindex after " + h);
    long finish = System.currentTimeMillis();
    System.out.println("Total time taken" + (finish-start));
    }
  }