class Solution {
    // g의 크기 : 자녀의 수
    // s의 크기 : 쿠키의 개수
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childrenIdx = 0; 
        int cookieIdx = 0; 
        
        while (childrenIdx < g.length && cookieIdx < s.length) {
            if (g[childrenIdx] <= s[cookieIdx]) { 
                childrenIdx++; 
            }
            cookieIdx++; 
        }
        
        return childrenIdx;
    }
}