import java.io.*;
import java.util.*;

public class Main{
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = Integer.parseInt(sc.next());

    int[] arr = new int[N+1];
    if(N >=2) arr[2]=3;
    if(N >= 4) arr[4]=11;
    for(int i = 6; i <= N; i+=2)
    {
      arr[i] += arr[i-2] * 3;
      for(int j = i - 4; j > 0; j-=2)
      {
        arr[i] += (arr[j] * 2);
      }
      arr[i] += 2;
    }

    System.out.println(arr[N]);

  }
}