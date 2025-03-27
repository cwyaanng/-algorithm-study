import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine() , " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    HashMap<String,Integer> arr = new HashMap<>();

    for(int i = 0; i < N; i++)
    {
      String s = br.readLine();
      if(s.length() >= M) arr.put(s , arr.getOrDefault(s , 0)+1);
    }

    ArrayList<String> list = new ArrayList<>(arr.keySet());

    Collections.sort(list , new Comparator<String>(){

      public int compare(String arr1 , String arr2)
      {
        if(arr.get(arr1) != arr.get(arr2)) return arr.get(arr2) - arr.get(arr1);
        if(arr1.length() != arr2.length()) return arr2.length() - arr1.length();
        return arr1.compareTo(arr2);
      }
    });


    for(String s : list)
    {
      bw.write(s+"\n");
    }
    bw.flush();
  }


}