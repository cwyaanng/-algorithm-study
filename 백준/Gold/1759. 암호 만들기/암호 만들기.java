import java.util.*;
import java.io.*;

public class Main{
  static int L;
  static int C;
  static char[] arr;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine(), " ");
    arr = new char[C];
    for(int i = 0; i <C; i++)
    {
      arr[i] = st.nextToken().charAt(0);
    }

    Arrays.sort(arr);
    dfs(0,0,"");
    bw.flush();
  }

  public static void dfs(int depth , int idx, String s) throws IOException
  {
    if(depth == L)
    {
      if(check(s)) bw.write(s+"\n");
      return;
    }

    for(int i = idx; i < C; i++)
    {
      dfs(depth+1, i+1 , s+arr[i]);
    }

  }

  //최소 한개 모음, 두개 자음 check
  public static boolean check(String s)
  {
    int m = 0;
    for(int i = 0; i < s.length(); i++)
    {
      if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') m += 1;
    }

    if(m >= 1 && L-m >=2) return true;
    else return false;

  }
}