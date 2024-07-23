class Solution {
    // 1부터 n까지 숫자의 순열을 나타내는 배열 arr
    // 처음에 모든 비트가 0으로 설정된 크기 n의 이진 문자열이 있습니다
    // 각 단계 i(이진 문자열과 arr이 모두 1부터 시작한다고 가정)에서 arr[i]위치의 비트가 1로 설정됩니다.
    
    // 또한 정수 m이 주어집니다. 길이가 m인 1로 구성된 그룹이 존재하는 최신 단계를 찾아라.
    // 1로 구성된 그룹은 양쪽으로 확장할 수 없는 연속된 1의 부분 문자열이다
    
    // 길이가 정확히 m인 1로 구성된 그룹이 존재하는 최신 단계를 반환해라
    // 존재하지 않으면 -1을 반환해라
    public int findLatestStep(int[] arr, int m) {
        if (arr.length == m) {
            return m;  // 모든 비트가 1로 설정된 경우
        }
        int n = arr.length;
        int[] lengths = new int[n + 2];
        int[] count = new int[n + 1];
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            int left = lengths[pos - 1];
            int right = lengths[pos + 1];
            int newLength = left + right + 1;
            
            lengths[pos] = newLength;
            lengths[pos - left] = newLength;
            lengths[pos + right] = newLength;
            
            count[left]--;
            count[right]--;
            count[newLength]++;
            
            if (count[m] > 0) {
                result = i + 1;
            }
        }
        
        return result;
    }
}