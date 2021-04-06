import java.io.*;
import java.util.*;
public class Permute {

    public static void main(String[] args) throws IOException {

      String s = "AABC";

      permute(s);

    }

    public static void permute(String originalString)
    {
      if ( originalString == null || originalString.length()==0)
         System.out.println("Invalid String");
      else
         permute("", originalString);
    }

     public static void permute(String prefix, String remStr)
    {
        if(remStr.length() == 0)
        {
            System.out.println(prefix);
        }

        for ( int i=0; i < remStr.length(); i++)
        {
            permute(prefix + remStr.charAt(i), remStr.substring(0,i) + remStr.substring(i+1, remStr.length()) );
        }

    }
}