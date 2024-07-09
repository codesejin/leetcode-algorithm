class Solution {
    public double averageWaitingTime(int[][] customers) {
        long curTime = 0;
        long totalWaitingTime = 0;

        for (int[] customer : customers) {
            int arriveTime = customer[0];
            int takeTime = customer[1];

            curTime = Math.max(curTime, arriveTime);
            curTime += takeTime;
            totalWaitingTime += (curTime - arriveTime);
        }

        return (double) totalWaitingTime / customers.length;
    }
}
