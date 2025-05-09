import java.util.*;
import java.io.*;

public class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    //입력받은 모든 문자열에 대해 접두사 set을 만들어준다
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int result = 0;

    HashSet<String> set = new HashSet<>();

    for(int i = 0; i < N; i++)
    {
      String s = br.readLine();
      for(int j = 0; j < s.length(); j++){
        set.add(s.substring(0,j+1));
      }
    }

    for(int i = 0; i < M; i++)
    {
      String t = br.readLine().trim();
      if(set.contains(t)) result += 1;
    }

    bw.write(result+"\n");
    bw.flush();
  }
}