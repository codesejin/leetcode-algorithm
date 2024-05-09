class Solution {
    public String reverseVowels(String s) {
         char[] arr = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        List<Character> list = new ArrayList<>();
        for(char c : arr) {
            if(set.contains(c)) {
                list.add(c);
            }
        }
        int idx = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                arr[i] = list.get(idx++);
            }
        }

        return String.valueOf(arr);
    }
}