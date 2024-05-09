class Solution {
    // 루프나 재귀 없이 O(1)
    public int addDigits(int num) {
        return num==0 ? 0 : num%9==0 ? 9 : num%9;
    } //38 % 9 = 2
}