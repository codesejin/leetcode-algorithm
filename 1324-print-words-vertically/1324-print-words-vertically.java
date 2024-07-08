class Solution {
    public List<String> printVertically(String s) {
        ArrayList<String> result = new ArrayList<>();

        String[] words = s.split(" ");
        int max= 0;

        for (String word : words) {
            max = Math.max(max,word.length());
        }

        for (int i = 0; i < max; i++) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(" ");
                }
            }
            result.add(sb.toString().stripTrailing());
        }

        return result;
    }
}