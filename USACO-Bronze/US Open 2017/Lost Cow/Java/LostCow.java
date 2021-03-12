import java.io.*;
import java.util.*;
public class LostCow {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("../Data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/1.out")));

		// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x_in = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int d = 0;
		int unit = 1;
		int jump = 1;

		boolean found = false;

		int x = x_in;

		System.out.println(x);

		while(!found)
		{
			x = x_in +unit;
			if ( x > y)
			{
				d += Math.abs(y-x_in);
				found = true;
			}
			else
			{
				unit = unit * (-2);
				jump = Math.abs(x-x_in)*unit;
				d += 2*Math.abs(x-x_in);

			}

			System.out.println(x);
		}

		pw.println(d);
		pw.close();
	}
}