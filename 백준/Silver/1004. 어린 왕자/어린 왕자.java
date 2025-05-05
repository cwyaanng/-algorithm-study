import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for(int i = 0; i < N; i++)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] start = new int[]{Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken())  };
      int[] end = new int[]{Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken())};
      int result = 0;
      int m = Integer.parseInt(br.readLine());
      for(int j = 0; j < m; j++)
      {
        StringTokenizer str = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(str.nextToken());
        int b = Integer.parseInt(str.nextToken());
        int r = (int)Math.pow(Integer.parseInt(str.nextToken()),2);

        int s = (int)(Math.pow(start[0]-a,2) + Math.pow(start[1]-b,2));
        int e = (int)(Math.pow(end[0]-a,2)+Math.pow(end[1]-b,2));

        if(s < r && !(e<r)) result += 1 ;
        else if(!(s<r) && e<r) result += 1;
      }
      bw.write(result+"\n");
    }

    bw.flush();
  }
}