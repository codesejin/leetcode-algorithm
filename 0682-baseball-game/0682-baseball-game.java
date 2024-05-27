class Solution {
    public int calPoints(String[] operations) {

        List<String> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String cur = operations[i];

            if (cur.equals("C")) {
                list.remove(list.size() - 1);
            } else if (cur.equals("D")) {
                list.add(String.valueOf(Integer.parseInt(list.get(list.size() - 1)) * 2));
            } else if (cur.equals("+")) {
                list.add(String.valueOf(Integer.parseInt(list.get(list.size() - 1)) + Integer.parseInt(list.get(list.size() - 2))));
            } else {

                list.add(cur);
            }
        }
        return list.stream().mapToInt(Integer::parseInt).sum();
    }
}