import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int r1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());
      int r2 = Integer.parseInt(st.nextToken());

      int dx = x1 - x2;
      int dy = y1 - y2;
      int d2 = dx * dx + dy * dy;

      int sum = r1 + r2;
      int diff = Math.abs(r1 - r2);
      int sum2 = sum * sum;
      int diff2 = diff * diff;

      if (d2 == 0) {
        if (r1 == r2) bw.write("-1\n");
        else bw.write("0\n");
      } else if (d2 == sum2 || d2 == diff2) {
        bw.write("1\n");
      } else if (diff2 < d2 && d2 < sum2) {
        bw.write("2\n");
      } else {
        bw.write("0\n");
      }
    }
    bw.flush();
  }
}
