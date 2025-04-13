import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine(), " ");
    for(int i = 0; i< N; i++)
    {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int sum = 0;
    for(int i = 0; i < N; i++)
    {
      for(int j = i+1; j < N; j++)
      {
        for(int k = j+1; k < N; k++)
        {
          int newsum = arr[i] + arr[j] + arr[k];
          if(newsum <= M)
          {
            sum = Math.max(sum, newsum);
          }
        }
      }
    }
    bw.write(sum+"");
    bw.flush();

  }
}