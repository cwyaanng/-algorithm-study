import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    TreeMap<String, Boolean> arr = new TreeMap<>(Collections.reverseOrder());
    for(int i = 0; i < N; i++)
    {
      StringTokenizer s = new StringTokenizer(br.readLine() , " ");
      String name = s.nextToken();
      boolean e;
      if(s.nextToken().equals("enter")) e = true;
      else e = false;
      arr.put(name, e);
    }
    for(String s : arr.keySet())
    {
      if(arr.get(s)) bw.write(s+"\n");
    }
    bw.flush();

  }
}