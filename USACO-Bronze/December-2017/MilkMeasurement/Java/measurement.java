import java.io.*;
import java.util.*;
public class measurement {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("../Data/10.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/10.out")));

		int MAX_N = 100;
		// read in all of the notes
		int n = Integer.parseInt(br.readLine());
		int [][] quantity = new int[3][MAX_N+1];
		int[][] changes = new int[3][MAX_N+1];
		int cow_id=0;

		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int day = Integer.parseInt(st.nextToken());
			String cow = st.nextToken();
			int change = Integer.parseInt(st.nextToken());

			if(cow.equals("Bessie")) cow_id = 0;
			if(cow.equals("Elsie")) cow_id = 1;
			if(cow.equals("Mildred")) cow_id = 2;

			changes[cow_id][day] = change;


		}

		for ( int i=0; i<3; i++)
		{
			quantity[i][0] = 7;
		}

		for (int i=0; i <3; i++)
		{
			for (int j=1; j<= 100; j++)
			{
				quantity[i][j] = quantity[i][j-1] + changes[i][j];
			}
		}

		int num_changes = 0;

		for (int d=1; d<=100; d++) {

	    if (is_highest(0,d-1, quantity) != is_highest(0,d, quantity) ||
		      is_highest(1,d-1, quantity) != is_highest(1,d, quantity) ||
		      is_highest(2,d-1, quantity) != is_highest(2,d, quantity))

        	num_changes++;
		}


		/*
		// the milk variables track the amount of milk that each cows was last known to produce
		int bessieMilk = 7, elsieMilk = 7, mildredMilk = 7;
		// the on variables are true if that cow produced the highest amount of milk on the previous day
		boolean bessieOn = true, elsieOn = true, mildredOn = true;
		int dayAdjust = 0;

		for(int currDay = 1; currDay <= 100; currDay++) {
			// look through the notes to see if there were any changes on this day
			for(int i = 0; i < n; i++) {
				if(day[i] == currDay) {
					if(cow[i].equals("Bessie")) {
						bessieMilk += change[i];
					}
					if(cow[i].equals("Elsie")) {
						elsieMilk += change[i];
					}
					if(cow[i].equals("Mildred")) {
						mildredMilk += change[i];
					}
				}
			}
			// compute the highest milk total and see which cows produced the most milk
			int highestMilk = Math.max(bessieMilk, Math.max(elsieMilk, mildredMilk));
			boolean bessieOnNext = bessieMilk == highestMilk;
			boolean elsieOnNext = elsieMilk == highestMilk;
			boolean mildredOnNext = mildredMilk == highestMilk;
			if(bessieOn != bessieOnNext || elsieOn != elsieOnNext || mildredOn != mildredOnNext) {
				dayAdjust++;
			}
			bessieOn = bessieOnNext;
			elsieOn = elsieOnNext;
			mildredOn = mildredOnNext;

		} */

		// print the answer
		pw.println(num_changes);
		pw.close();
	}
		public static boolean is_highest(int cow_id, int d, int[][] quantity)
		{
			int highest = Math.max(Math.max(quantity[0][d], quantity[1][d]), quantity[2][d]);
			return quantity[cow_id][d] == highest;
		}
}