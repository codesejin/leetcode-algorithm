class Solution {
    private static final int MOD = 1000000007; // 모듈러 값
    private Integer[][][] memo; // 메모이제이션 테이블

    public int checkRecord(int n) {
        memo = new Integer[n + 1][2][3]; // n+1 길이의 메모이제이션 테이블 초기화
        return helper(n, 0, 0); // n 길이의 문자열 시작, 'A' 없음, 연속된 'L' 없음
    }

    private int helper(int n, int cntA, int concL) {
        if (n == 0) { // 기본 케이스: 문자열의 길이가 0일 때
            return 1;
        }
        if (memo[n][cntA][concL] != null) { // 메모이제이션 체크
            return memo[n][cntA][concL];
        }

        int result = 0;
        // 'P' (Present) 추가
        result = (result + helper(n - 1, cntA, 0)) % MOD;
        // 'A' (Absent) 추가
        if (cntA == 0) {
            result = (result + helper(n - 1, cntA + 1, 0)) % MOD;
        }
        // 'L' (Late) 추가
        if (concL < 2) {
            result = (result + helper(n - 1, cntA, concL + 1)) % MOD;
        }

        memo[n][cntA][concL] = result; // 결과를 메모 테이블에 저장
        return result;
    }
}
