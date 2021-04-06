import java.io.*;
import java.util.*;
public class Bucket {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));

		// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_buckets = Integer.parseInt(st.nextToken());
		System.out.println("Number of Buckets: " + no_buckets);

		// read capacity of buckets
		st = new StringTokenizer(br.readLine());

		int [] bucket_cap;
		bucket_cap = new int[no_buckets];
		for ( int i=0; i < no_buckets; i++)
		{
			bucket_cap[i]= Integer.parseInt(st.nextToken());
		//	System.out.println(bucket_cap[i]);
		}

		// read amounts in buckets
		st = new StringTokenizer(br.readLine());

		int [] bucket_amounts;
		bucket_amounts = new int[no_buckets];

		for ( int i=0; i < no_buckets; i++)
		{
			bucket_amounts[i]= Integer.parseInt(st.nextToken());
		//	System.out.println(bucket_amounts[i]);
		}


		for ( int i=0; i< no_buckets -1; i++)
		{
			int transfer_amt = Math.min(bucket_amounts[i], bucket_cap[i+1]-bucket_amounts[i+1] );
			bucket_amounts[i] -= transfer_amt;
			bucket_amounts[i+1] += transfer_amt;
			pw.print(bucket_amounts[i] + " ");
		}

		pw.print(bucket_amounts[4]);


		pw.close();
	}
}