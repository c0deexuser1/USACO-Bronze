import java.io.*;
import java.util.*;
public class CowCross {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));

		// read number of cows
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_cows = Integer.parseInt(st.nextToken());

		int [] arrival_time = new int[no_cows];
		int [] questioning_time = new int[no_cows];

		String str = null;


	   for( int i=0; i < no_cows; i++ )
		{
			st = new StringTokenizer(br.readLine());
			arrival_time[i] =  Integer.parseInt(st.nextToken());
			questioning_time[i] = Integer.parseInt(st.nextToken());
		}

		boolean [] processed = new boolean[no_cows];

		int nextAvailableTime = 0;
		for ( int i=0; i < no_cows; i++)
		{

			int next_to_enter = -1;
			// 8  3  5 
			// next_to_enter = 0
			
			for ( int j = 0; j< no_cows; j++)
			{
				if ( !processed[j] && (next_to_enter == -1 || (arrival_time[j] < arrival_time[next_to_enter])))
				{
					next_to_enter = j;
				}
			}

			System.out.println("Next To Enter" + next_to_enter);

			// process that cow, tracking exactly when questioning ends
			processed[next_to_enter] = true;
			if(arrival_time[next_to_enter] > nextAvailableTime) {
				nextAvailableTime = arrival_time[next_to_enter] + questioning_time[next_to_enter];
			}
			else {
				nextAvailableTime = nextAvailableTime + questioning_time[next_to_enter];
			}
			System.out.println("Next Available Time" + nextAvailableTime);
		}

		pw.print(nextAvailableTime);
		pw.close();
	}
	}