import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    long S = Long.parseLong(br.readLine());

    long N = 0;
    for(long i = 1; i <= Math.sqrt(2*S); i++)
    {
      long min = (i * (i + 1)) /2;
      long max = ((i+1) * (i+2)) / 2;
      if(S >= min && S <= max)
      {
        N = i;
      }
    }

    bw.write(N+"");
    bw.flush();

  }
}