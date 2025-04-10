import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    int N = Integer.parseInt(br.readLine());
    HashMap<String, Boolean> arr = new HashMap<>();
    for(int i = 0; i < N; i++)
    {
      StringTokenizer s = new StringTokenizer(br.readLine() , " ");
      String name = s.nextToken();
      boolean e;
      if(s.nextToken().equals("enter"))
      {
        e = true;
      }else{
        e = false;
      }
      arr.put(name, e);
    }

    ArrayList<String> a = new ArrayList<>();
    for(String s : arr.keySet())
    {
      a.add(s);
    }

    Collections.sort(a,Collections.reverseOrder());

    for(String s : a)
    {
      if(arr.get(s) == true)
      {
        bw.write(s+"\n");
      }
    }
    bw.flush();

  }
}