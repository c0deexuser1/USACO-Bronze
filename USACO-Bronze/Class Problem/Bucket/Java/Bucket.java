import java.io.*;
import java.util.*;
public class Bucket {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../Data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/1.out")));

		// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_buckets = Integer.parseInt(st.nextToken());
		System.out.println("Number of Buckets: " + no_buckets);

		int capacity[];
		int amount [];

		capacity = new int[no_buckets];
		amount   = new int[no_buckets];

		// Read the next line which has capacities of the buckets
		st = new StringTokenizer(br.readLine());

		for ( int i=0; i< no_buckets; i++)
		{
			capacity[i] = 	Integer.parseInt(st.nextToken());
			System.out.println(capacity[i]);
		}

		st = new StringTokenizer(br.readLine());

		// Read the next line which has amount in the buckets
		for ( int i=0; i< no_buckets; i++)
		{
			amount[i] = 	Integer.parseInt(st.nextToken());
			System.out.println(amount[i]);
		}


		for ( int i=0; i<no_buckets-1; i++)
		{
			int transfer_amt = Math.min(amount[i], capacity[i+1]-amount[i+1]);
			amount[i] -= transfer_amt;
			amount[i+1] += transfer_amt;

		}
		for ( int i=0; i<no_buckets; i++)
		{
			pw.println(amount[i] + " ");
		}

		pw.close();
	}
}