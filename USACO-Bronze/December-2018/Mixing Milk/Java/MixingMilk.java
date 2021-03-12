import java.io.*;
import java.util.*;
public class MixingMilk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../Data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/1.out")));

		// read 1st bucket
		StringTokenizer st = new StringTokenizer(br.readLine());

		int c1 = Integer.parseInt(st.nextToken());
		int a1 = Integer.parseInt(st.nextToken());


		// read 2nd bucket
		st = new StringTokenizer(br.readLine());

		int c2 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());

		// read 1st bucket
		st = new StringTokenizer(br.readLine());

		int c3 = Integer.parseInt(st.nextToken());
		int a3 = Integer.parseInt(st.nextToken());

		for (int i=0; i < 33; i++)
		{
			int transfer_amt1 = Math.min(a1, c2-a2 );
			a1 -= transfer_amt1;
			a2 += transfer_amt1;

			int transfer_amt2 = Math.min(a2, c3-a3 );
			a2 -= transfer_amt2;
			a3 += transfer_amt2;


			int transfer_amt3 = Math.min(a3, c1-a1 );
			a3 -= transfer_amt3;
			a1 += transfer_amt3;
		}

			int transfer_amt1 = Math.min(a1, c2-a2 );
			a1 -= transfer_amt1;
			a2 += transfer_amt1;

		pw.println(a1);
		pw.println(a2);
		pw.println(a3);

		pw.close();
	}
}