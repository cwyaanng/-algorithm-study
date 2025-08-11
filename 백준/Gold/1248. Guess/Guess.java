import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] sign;   // S[i][j] in {'+','-','0'}
    static int[] a;
    static StringBuilder out = new StringBuilder();
    static boolean done = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        sign = new char[n][n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sign[i][j] = s.charAt(idx++);
            }
        }

        a = new int[n];
        dfs(0);
        System.out.print(out.toString());
    }

    static void dfs(int pos) {
        if (done) return;          // 이미 찾았으면 중단
        if (pos == n) {
            // 정답 출력
            for (int i = 0; i < n; i++) {
                out.append(a[i]).append(i+1==n ? '\n' : ' ');
            }
            done = true;
            return;
        }

        // 대각선으로 후보 도메인 좁히기
        if (sign[pos][pos] == '0') {
            a[pos] = 0;
            if (validUpTo(pos)) dfs(pos + 1);
        } else if (sign[pos][pos] == '+') {
            for (int v = 1; v <= 10; v++) {
                a[pos] = v;
                if (validUpTo(pos)) dfs(pos + 1);
                if (done) return;
            }
        } else { // '-'
            for (int v = -1; v >= -10; v--) {
                a[pos] = v;
                if (validUpTo(pos)) dfs(pos + 1);
                if (done) return;
            }
        }
    }

    // pos까지 채웠을 때, 모든 i<=pos에 대해 sum(i..pos)의 부호가 표와 일치하는지
    static boolean validUpTo(int pos) {
        int sum = 0;
        for (int i = pos; i >= 0; i--) {
            sum += a[i];
            char need = sign[i][pos];
            if (need == '+' && sum <= 0) return false;
            if (need == '-' && sum >= 0) return false;
            if (need == '0' && sum != 0) return false;
        }
        return true;
    }
}
