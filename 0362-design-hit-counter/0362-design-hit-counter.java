// 최근 5분(300초) 동안 들어온 hit 수를 return하는 HitCounter class를 구현하세요.
// 지원하는 method는 timestamp x의 hit를 기록하는 hit(int x), timestamp y로부터 최근 5분간의 hit수를 반환하는 getHits(int y) 두 종류입니다.

// 각각의 method에서 파라미터로 받는 timestamp는 시간 순서대로 호출됩니다. (즉 input으로 들어오는 timestamp는 계속 증가하는 형태입니다.)
// timestamp의 값은 1부터 시작하고 hit 메소드 호출은 동시간대에 여러번 호출될 수도 있습니다. (예를 들어 counter.hit(1);이 연속으로 여러번 호출될 수 있음)

class HitCounter {
    int[] time = new int[300];
    int[] count = new int[300];
    public HitCounter() {
    
    }
    public void hit(int timestamp) {
       int idx = timestamp % 300;
       if (time[idx] != timestamp) {
            time[idx] = timestamp;
            count[idx] = 1;
       } else {
            count[idx]++;
       }
    }
    
    public int getHits(int timestamp) {
        int cnt = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time[i] < 300) {
                cnt += count[i];
            }
        }
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */