import java.io.*;
import java.util.*;
public class Test2 {

	public static int getIndexOf(String[] strings, String item) {
    for (int i = 0; i < strings.length; i++) {
        if (item.equals(strings[i])) return i;
    }
    return -1;
  }

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

		// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

        String [][] authors = new String[K][N];
        String [] names = new String [N];

        // Effort for each paper across all researcher

        int [][] effort = new int [K][N];
        int [] totalEffort = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
        {
            names [i] = st.nextToken();
        }

        // Read the authors of the papers
        for ( int i=0; i < K; i++)
        {
            int j = 0;
            st = new StringTokenizer(br.readLine());
		    while(st.hasMoreTokens())
		    {
		        authors[i][j] = st.nextToken();
		        //System.out.println(authors[i][j]);
		        j++;
		    }
        }

        for (int i=0; i <K; i++)
        {
            //System.out.println(authors[i].length);

            for (int j=0; j < authors[i].length-1 ; j++)
            {
                if ( authors[i][j].compareTo(authors[i][j+1]) > 0)
                {
                    //System.out.println("Comparing out of order:" + authors[i][j] +"," + authors[i][j+1]);

                    effort[i][getIndexOf(names, authors[i][j+1])]
                        = effort[i][getIndexOf(names, authors[i][j])] -1;

                }else if( authors[i][j].compareTo(authors[i][j+1]) < 0)
                {
                    //System.out.println("Comparing in order:" + authors[i][j] +"," + authors[i][j+1]);

                    effort[i][getIndexOf(names, authors[i][j+1])] =
                    effort[i][getIndexOf(names, authors[i][j])] ;
                }
            }
        }
        for (int i=0; i <K; i++)
        {
            for ( int j=0; j < N; j++)
            {
                totalEffort[j] += effort[i][j];
            }
        }

        for(int j=0; j <N; j++)
        {
            //System.out.println(totalEffort[j]);
        }

        for ( int i=0; i <N; i++ )
          {
              for (int j=0; j <N; j++)
              {
                  if(i==j) pw.print ('B');
                  else if(totalEffort[i] == totalEffort[j]) pw.print('?');
                  else if(totalEffort[i] > totalEffort[j])  pw.print('0') ;
                  else if(totalEffort[i] < totalEffort[j]) pw.print('1');
              }
              pw.println();
          }

        pw.close();
	}
}