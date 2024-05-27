class Solution {
    public int calPoints(String[] operations) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operations.length; i++) {
            String cur = operations[i];

            if (cur.equals("C")) {
                list.remove(list.size() - 1);
            } else if (cur.equals("D")) {
                list.add(list.get(list.size() - 1) * 2);
            } else if (cur.equals("+")) {
                list.add(list.get(list.size() - 1) + list.get(list.size() - 2));
            } else {
                list.add(Integer.parseInt(cur));
            }
        }
        return list.stream().mapToInt(i -> i).sum();
    }
}