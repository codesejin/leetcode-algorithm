import java.util.*;

class Solution {
    // orders[i] = [pricei, amounti, orderTypei] ->  가격과 주문 타입을 가진 독립적인 amounti 개의 주문의 묶음
    // pricei 에서 amounti 만큼의 orderTypei 타입의 주문이 이뤄짐
    // orderTypei : 0 매수 / 1 매도
    
    // 백로그 : 실행되지 않은 주문들로 구성되며, 초기에는 비어 있음

    // 매수 주문 : 가장 낮은 가격의 매도 주문을 봄 / 해당 매도 주문 가격이 현재 매수 주문보다 작거나 같으면 매칭
    // -> 매도 주문은 백로그에서 제거됨
    // -> 매칭이 안되면 매수 주문이 백로그에 추가 됨

    // 매도 주문 : 가장 높은 가격의 매수 주문을 봄 / 해당 매수 주문 가격이 현재 매도 주문보다 크거나 같으면 매칭
    // -> 매수 주문 : 백로그에서 제거됨
    // -> 매칭이 안되면  매도 주문은 백로그에 추가됨

    // 백로그에 남아있는 주문 총량 반환 -> MOD 
    static final int MOD = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        
        PriorityQueue<int[]> buyBacklog = new PriorityQueue<>((a, b) -> b[0] - a[0]); // 가장 높은 가격 우선
        PriorityQueue<int[]> sellBacklog = new PriorityQueue<>((a, b) -> a[0] - b[0]); // 가장 낮은 가격 우선

        for (int i = 0; i < orders.length; i++) {
            int price = orders[i][0];
            int amount = orders[i][1];
            int orderType = orders[i][2];

            if (orderType == 0) { // 매수일 경우 - 매도 주문 가격이 현재 매수 주문보다 작거나 같으면 매칭
                addToBuyBacklog(price, amount, sellBacklog, buyBacklog);
            } else { //  매도일 경우 - 매수 주문 가격이 현재 매도 주문보다 크거나 같으면 매칭
                addToSellBacklog(price, amount, buyBacklog, sellBacklog);
            }
        }

        long remainedBuyBacklog = 0;
        for (int[] order : buyBacklog) {
            remainedBuyBacklog = (remainedBuyBacklog + order[1]) % MOD;
        }

        long remainedSellBacklog = 0;
        for (int[] order : sellBacklog) {
            remainedSellBacklog = (remainedSellBacklog + order[1]) % MOD;
        }
        
        return (int)((remainedBuyBacklog + remainedSellBacklog) % MOD);
    }

    private void addToBuyBacklog(int price, int amount, PriorityQueue<int[]> sellBacklog, PriorityQueue<int[]> buyBacklog) {
        while (amount > 0 && !sellBacklog.isEmpty() && sellBacklog.peek()[0] <= price) {
            int[] sellOrder = sellBacklog.poll();
            // 매도 주문의 양이 매수 주문의 양보다 작거나 같으면
            if (sellOrder[1] <= amount) {
                amount -= sellOrder[1];
            // 매도 주문의 양이 더 크다면
            } else {
                sellOrder[1] -= amount;
                sellBacklog.add(sellOrder);
                amount = 0;
            }
        }
        if (amount > 0) {
            buyBacklog.add(new int[]{price, amount});
        }
    }

    private void addToSellBacklog(int price, int amount, PriorityQueue<int[]> buyBacklog, PriorityQueue<int[]> sellBacklog) {
        while (amount > 0 && !buyBacklog.isEmpty() && buyBacklog.peek()[0] >= price) {
            int[] buyOrder = buyBacklog.poll();
            // 매수 주문의 양이 매도 주문의 양보다 작거나 같으면
            if (buyOrder[1] <= amount) {
                amount -= buyOrder[1];
            // 매수 주문의 양이 더 크다면
            } else {
                buyOrder[1] -= amount;
                buyBacklog.add(buyOrder);
                amount = 0;
            }
        }
        if (amount > 0) {
            sellBacklog.add(new int[]{price, amount});
        }
    }
}