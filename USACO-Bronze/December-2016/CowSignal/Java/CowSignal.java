import java.io.*;
import java.util.*;
public class CowSignal {
	public static void main(String[] args) throws IOException {
		// initialize file I/O
		BufferedReader br = new BufferedReader(new FileReader("../Data/1.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../Data/1.out")));

		// read number of cows
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] outputSignal = new char[K*M][K*N];

	   for( int i=0; i < M; i++ )
		{
			String s = br.readLine();
			char[] s_array = s.toCharArray();

            System.out.println(String.valueOf(s_array));

			for (int j=0; j < s_array.length; j++)
			{
			      outputSignal[2*i][2*j] =s_array[j];
			      outputSignal[2*i][2*j+1] =s_array[j];
			}
			 outputSignal[2*i+1] =outputSignal[2*i];
		}

         for( int i=0; i < K*M-1; i++ )
		{
			for (int j=0; j < K*N-1; j++)
			{
                pw.print(outputSignal[i][j]);
			}
			    pw.println();
		}
		pw.close();
    }
}