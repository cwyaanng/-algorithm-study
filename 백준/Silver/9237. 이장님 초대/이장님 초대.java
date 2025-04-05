import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    ArrayList<Integer> arr = new ArrayList<>();
    for(int i = 0; i < N; i++)
    {
      arr.add(Integer.parseInt(st.nextToken()));
    }
    arr.sort(Collections.reverseOrder());
    int end = 1;
    int start = 1;
    for(int a : arr)
    {
      end = Math.max(start+a , end);
      start += 1;
    }



    bw.write(end+1+"\n");
    bw.flush();
  }
}