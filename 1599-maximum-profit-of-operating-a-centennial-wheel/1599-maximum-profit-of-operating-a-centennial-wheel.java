import java.util.Arrays;

class Solution {
    // 4개 곤돌라
    // 각 곤돌라는 최대 4명까지 탑승 가능
    // 곤돌라를 반시계로 회전 시킬 수 있으며, 회전 당 runningCost 비용이 듭니다.

    // int[] customers : 각 customers[i]는 회전 직전에 도착하는 새로운 고객 수
    // 즉, i번째 회전 전에 customers[i]명 고객 도착
    // 각 고객은 boardingCost를 지불하고, 그 곤돌라가 다시 지상에 도착하면 하차합니다.

    // 언제든 모든 고객을 태우기 전에 곤돌라 멈출 수 있음 -> 멈추기로 결정하면 기존 고객들을 하차시키는 데까지 무료입니다.
    
    // 최대 이익을 얻기 위해 필요한 최소 회전수, 이익이 없다면 -1 리턴
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int totalCustomer = Arrays.stream(customers).sum();
        int curProfit = 0; // 현재 총 수익
        int maxProfit = 0; // 최대 총 수익
        int rotatingCnt = 0;
        int remainCustomer = 0;
        int maxProfitRotations = -1;
        int idx = 0;

        while (totalCustomer > 0) {
            int arrivedCustomer = (idx < customers.length) ? customers[idx++] : 0;
            int curWaiting = arrivedCustomer + remainCustomer;
            // 수익 구할때 정확히 몇명이 탔는지 필요
            int boardedCustomers = Math.min(4, curWaiting);
            remainCustomer = curWaiting - boardedCustomers;
            totalCustomer -= boardedCustomers;
            rotatingCnt++;

            // 현재 회전에서의 이익 계산
            curProfit += boardedCustomers * boardingCost - runningCost;

            // 현재 이익이 최대 이익보다 클 경우 -> 최대 이익과 그 때의 회전 수 갱신
            // 현재 이익이 최대 이익보다 크지 않으면 -> 갱신 안함
            if (curProfit > maxProfit) {
                maxProfit = curProfit;
                maxProfitRotations = rotatingCnt;
            }
        }

        return maxProfit > 0 ? maxProfitRotations : -1;
    }
}