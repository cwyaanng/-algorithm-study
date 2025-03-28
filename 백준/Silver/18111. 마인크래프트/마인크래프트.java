import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());

    HashMap<Integer, Integer> hashMap = new HashMap<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        int height = Integer.parseInt(st.nextToken());
        //높이와 높이 개수 저장
        hashMap.put(height, hashMap.getOrDefault(height, 0) + 1);
      }
    }

    ArrayList<Integer> arr = new ArrayList<>(hashMap.keySet());
    //모든 높이에 대해서 반복

    int result = Integer.MAX_VALUE;
    int h = 0;

    for (int i = 0; i <= 256; i++) {

      //높이 맞추기 위해 쌓아야 하는 블럭 총합
      int time = 0;
      int num_block = B;

      for (int j : arr) {
        //만약 기준보다 낮으면 낮은 만큼 블럭 쌓기
        if (j < i) {
          num_block -= hashMap.get(j) * (i - j);
          time += (i - j) * hashMap.get(j);
        }
        //만약 기준보다 높으면 블럭 부수기
        if (j > i) {
          time += (j - i) * hashMap.get(j) * 2;
          num_block += (j - i) * hashMap.get(j);
        }
      }

      if (num_block >= 0 && time <= result) {
        result = time;
        h = Math.max(h,i);
      }


    }

    bw.write(result + " " + h);
    bw.flush();
  }
}