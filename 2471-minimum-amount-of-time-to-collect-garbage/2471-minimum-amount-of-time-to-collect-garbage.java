class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //  'M', 'P', 'G' -> 금속(Metal), 종이(Paper), 유리(Glass)
        // garbage = ["G","P","GP","GG"], travel = [2,4,3]
        int sum = 0;
        int lastMetal = 0, lastPaper = 0, lastGlass = 0;
        int metal = 0, paper = 0, glass = 0;
        for (int i = garbage.length-1; i >= 0; i--) {
            String area = garbage[i];
            if(area.indexOf("M") != -1 && lastMetal == 0) lastMetal = i;
            if(area.indexOf("P") != -1 && lastPaper == 0) lastPaper = i;
            if(area.indexOf("G") != -1 && lastGlass == 0) lastGlass = i;
            sum += area.length();
        }
        for (int i = 0; i < travel.length; i++) {
            if (i < lastMetal) metal += travel[i];
            if (i < lastPaper) paper += travel[i];
            if (i < lastGlass) glass += travel[i];
        }
        return metal + paper + glass + sum;
    }
}