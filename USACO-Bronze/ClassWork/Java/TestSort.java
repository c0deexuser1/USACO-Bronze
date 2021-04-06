import java.io.*;
import java.util.*;

public class TestSort {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

			// read number of cows
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_cows = Integer.parseInt(st.nextToken());

		pw.println(no_cows);

        ArrayList<Integer> arr = new ArrayList<Integer> ();

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        double N = Math.pow(10,7);

        long start = System.currentTimeMillis();

        for (int i=(int)N; i >=0; i--)
        {
            arr.add(i);
        }

        Collections.sort(arr);
        /*
        int maxValue = 0;



        for ( int i=0; i < arr.size(); i++)
        {
            int counter = 0;

            for ( int j =0;  j < arr.size(); j++)
            {
                if(arr.get(j) >= arr.get(i))
                 counter++;
            }

            maxValue = Math.max(maxValue, counter);

        }
        */
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        //System.out.println(maxValue);
        pw.close();

        System.out.println(timeElapsed);
    }
}