import java.io.*;
import java.util.*;
public class StuckInRut {
	public static void main(String[] args) throws IOException {

        // This is a shell that you can use for all your USACO problems.
        // Input is being read from System Input
        // Output is being written to System Output

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        // Read first line, Tokenize it and convert to Input.
        // In the example below, in the first line I have only one column of data input

		// read number of cows
		StringTokenizer st = new StringTokenizer(br.readLine());
		int no_cows = Integer.parseInt(st.nextToken());

        //Read the cow position and direction
		String [] direction = new String[no_cows];
		int [] x  = new int[no_cows];
		int [] y =  new int[no_cows];

		int max_x = -1;

		for (int i=0; i< no_cows; i++)
		{
		    st = new StringTokenizer(br.readLine());

		    direction[i] = st.nextToken();
		    x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());


		}

		pw.close();
	}
}
