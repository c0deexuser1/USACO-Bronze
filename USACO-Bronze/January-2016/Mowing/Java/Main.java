import java.io.*;
import java.util.*;

public class Main {
  public static void main (String [] args) throws IOException{
    //Setting Up the Reader and Writer
    BufferedReader br = new BufferedReader(new FileReader("../data/1.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("../data/1.out")));

    //Storing the Inputs
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String [] Direction = new String [N];
    int [] Steps = new int [N];

    for(int i=0; i<N; i++){
      st = new StringTokenizer(br.readLine());
      Direction[i] = st.nextToken();
      Steps[i] = Integer.parseInt(st.nextToken());
    }

    int x = 0;
    int y = 0;
    List<Integer> xcoord = new ArrayList<>();
    List<Integer> ycoord = new ArrayList<>();

    int nopositions = 0;
    int counter = 0;
    int maxcounter = 0;

    for(int i=0; i<N; i++){

      if(Direction[i] == "N"){
        for(int j=0; j<Steps[i]; j++)
        {
          y++;
          counter++;
          nopositions++;
          for(i=0; i<nopositions; i++)
          {
              if (x==xcoord.get(i) & y==ycoord.get(i)) // This means I have visited al
              {
                if (counter > maxcounter){
                  maxcounter = counter;
                  counter = 0;
                }
                else{
                  counter = 0;
                }
              }
          }
            ycoord.add(y);
        }
      }

      if(Direction[i] == "S"){
        for(int j=0; j<Steps[i]; j++){
          y--;
          counter++;
          nopositions++;
            for(i=0; i<nopositions; i++)
            {
                if (x==xcoord.get(i) & y==ycoord.get(i))
                {
                    if (counter > maxcounter)
                    {
                        maxcounter = counter;
                        counter = 0;

                    }
                      else
                      {
                        counter = 0;
                      }

                }

            }
          ycoord.add(y);

        }
      }

      if(Direction[i] == "E")
      {
        for(int j=0; j<Steps[i]; j++){
              x++;
              counter++;
              nopositions++;
        for(i=0; i<nopositions; i++)
        {
            if (x==xcoord.get(i) & y==ycoord.get(i))
            {
                if (counter > maxcounter)
                {
                    maxcounter = counter;
                    counter = 0;
                }
                else{
                    counter = 0;
                }
            }

        }
          xcoord.add(x);
        }
      }

      if(Direction[i] == "W")
      {
        for(int j=0; j<Steps[i]; j++)
        {
            x--;
            counter++;
            nopositions++;
            for(i=0; i<nopositions; i++)
            {
                if (x==xcoord.get(i) & y==ycoord.get(i))
                {
                    if (counter > maxcounter){
                    maxcounter = counter;
                    counter = 0;
                    }
                }
                 else{
                    counter = 0;
                }

            }
        }
          xcoord.add(x);
      }
    }
    System.out.println(maxcounter);

    pw.print(maxcounter);

    br.close();
    pw.close();
  }
}
