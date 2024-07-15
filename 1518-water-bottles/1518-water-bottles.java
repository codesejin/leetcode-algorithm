class Solution {
    // 마실 수 있는 물병 최대 개수 반환
    // numBottles : 원래 가득찬 물병 개수
    // numExchange :  가득 찬 물병으로 바꿀 수 있는 비어 있는 병의 개수
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles;

        while (numBottles / numExchange != 0) {
            cnt += numBottles / numExchange;
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return cnt;
    }
}