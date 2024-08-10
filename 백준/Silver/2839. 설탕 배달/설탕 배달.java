import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 파일명: Main.java
 * 작성자: ahkang
 * 작성일: 2024-08-10
 * 설명: 2839. 설탕 배달
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 상근이가 배달해야 하는 설탕의 킬로그램, N 입력
        int N = Integer.parseInt(br.readLine());

        // dp 배열을 충분히 큰 값으로 초기화
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 5001);

        // 3kg 봉지와 5kg 봉지를 각각의 무게에 대해 초기화
        if (N >= 3) dp[3] = 1;
        if (N >= 5) dp[5] = 1;

        // i 킬로그램을 만들기 위해 필요한 최소 봉지 수를 계산
        for (int i = 6; i <= N; i++) {
            dp[i] = Math.min(dp[i - 3] + 1, dp[i - 5] + 1);
        }

        // 만약 dp[N]이 초기화 값 그대로라면, N 킬로그램을 만들 수 없다는 의미이므로 -1 출력
        if (dp[N] >= 5001) {
            System.out.println(-1);
            
        } else {
            System.out.println(dp[N]);
            
        }
    }
}