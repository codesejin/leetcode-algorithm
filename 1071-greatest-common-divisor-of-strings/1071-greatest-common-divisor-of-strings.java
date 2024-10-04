class Solution {
    public String gcdOfStrings(String str1, String str2) {
        // str1 + str2와 str2 + str1이 다르면 공통 패턴이 존재하지 않음
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // 두 문자열 길이의 최대 공약수 구하기
        int gcdLength = gcd(str1.length(), str2.length());
        
        // 최대 공약수 길이만큼의 문자열이 GCD
        return str1.substring(0, gcdLength);
    }

    // 두 숫자의 최대 공약수를 구하는 유클리드 알고리즘
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
