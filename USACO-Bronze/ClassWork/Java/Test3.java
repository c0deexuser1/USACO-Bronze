import java.io.*;
import java.util.*;
public class Test3 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("../data/3.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/3.out")));

		// read number of buckets
		StringTokenizer st = new StringTokenizer(br.readLine());
		int MAX_ROWS = Integer.parseInt(st.nextToken());
		int MAX_COLS = Integer.parseInt(st.nextToken());

        char [][] pastures = new char [MAX_ROWS+4][MAX_COLS+4];

        // Initialize everything to some default value
        for ( int i=0; i < MAX_ROWS+4; i++)
        {
            for (int j=0; j < MAX_COLS+4; j++)
            {
                pastures[i][j] = 'T';
            }
        }

        for ( int i=0; i < MAX_ROWS; i++)
        {
            String s = br.readLine();
            for (int j=0; j < MAX_COLS; j++)
            {
                pastures[i+2][j+2] = s.charAt(j);
            }
        }

        // for ( int i=0; i < MAX_ROWS+4; i++)
        // {
        //     for (int j=0; j < MAX_COLS+4; j++)
        //     {
        //         System.out.print(pastures[i][j]);
        //     }
        //     System.out.println();
        // }

        int friends = 0;
        for (int i=2; i< MAX_ROWS+2; i++)
        {
            for (int j = 2; j < MAX_COLS+2; j++)
            {
                if (pastures[i][j] == 'C')
                {
                    System.out.println("cow at("+(i-1)+","+(j-1)+")");

                    // Horizontal to right
                    if ( pastures[i][j+1] == 'G' && pastures[i][j+2]=='C')
                    {
                        friends++;
                        pastures[i][j+1] = 'T';
                    }
                    //Diagonal backward
                    if ( pastures[i+1][j-1] == 'C')
                    {
                        if (pastures[i][j-1] == 'G')
                        {
                            friends ++;
                            pastures[i][j-1] = 'T';
                        }
                        else if (pastures[i+1][j] == 'G')
                        {
                            friends++;
                            pastures[i+1][j] = 'T';
                        }
                    }
                    //Diagonal forward
                    if ( pastures[i+1][j+1] == 'C')
                    {
                        if (pastures[i][j+1] == 'G')
                        {
                            friends++;
                            pastures[i][j+1] = 'T';
                        }
                        else if (pastures[i+1][j] == 'G')
                        {
                            pastures[i+1][j] = 'T';
                            friends++;
                        }
                    }

                    // Vertical down
                    if ( pastures[i+1][j] == 'G' && pastures[i+2][j]=='C')
                    {
                        friends++;
                        pastures[i+1][j] = 'T';
                    }
                }
            }
        }
        pw.println(friends);
		pw.close();
	}
}