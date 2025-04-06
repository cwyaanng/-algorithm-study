import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long[] dp1 = new long[11];
        long[] dp2 = new long[11];

        long result = 0;

        dp1[0] = 0;
        for(int i = 1; i <10; i++)
        {
            dp1[i] = 1;
        }
        dp1[10] = 0;

        for(int j = 0; j < N-1; j ++)
        {
            for(int i = 0; i < 10; i++)
            {
                if(i == 0)
                {
                    dp2[i] += dp1[i+1];

                }else{
                    dp2[i] = dp1[i-1] % 1000000000  + dp1[i+1] % 1000000000 ;
                }
            }
            for(int i = 0; i < 10; i++)
            {
                dp1[i] = dp2[i] % 1000000000;
                dp2[i] = 0;
            }
            dp2[10] = 0;

        }
        for(int i = 0; i < 10; i++)
        {
            result += dp1[i] % 1000000000;
        }

        result = result % 1000000000;
        bw.write(result+"");
        bw.flush();
    }
}
