class Solution {
    // ../ : 현재 폴더의 부모 폴더로 이동(이미 최상위 폴더일 경우, 현재 유지)
    // ./ : 현재 폴더에 남기
    // x/ : 이름이 x인 자식 폴더로 이동(이 폴더는 항상 존재)
    // 파일 시스템은 메인 폴더에서 시작하고, logs의 연산작업을 수행
    // 연산이 끝난 이후 메인 폴더로 돌아가기 위한 오퍼레이션의 최소한의 숫자를 반환해라

    static final String GO_TO_PARENT_OR_REMAIN_NOW = "../";
    static final String REMAIN_NOW = "./";

    public int minOperations(String[] logs) {
        
        int location = 0;
        for (int i = 0; i < logs.length; i++) {
            String curLog = logs[i];
            if ((curLog.equals(GO_TO_PARENT_OR_REMAIN_NOW) && location == 0)
            || curLog.equals(REMAIN_NOW)) {
                location += 0;
            } else if (curLog.equals(GO_TO_PARENT_OR_REMAIN_NOW)) {
                location -= 1;
            } else {
                location += 1;
            }
        }
        return location;
    }
}