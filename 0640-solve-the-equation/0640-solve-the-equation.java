class Solution {
        static int leftXSum;
        static int leftNumSum;
        static int rightXSum;
        static int rightNumSum;

    public String solveEquation(String equation) {
        String[] equationArray = equation.split("=");
        String left = equationArray[0];
        String right = equationArray[1];

        String[] leftArr = left.replace("+", " +").replace("-", " -").trim().split(" ");
        String[] rightArr = right.replace("+", " +").replace("-", " -").trim().split(" ");

        leftXSum = 0;
        leftNumSum = 0;
        for (int i = 0; i < leftArr.length; i++) {
            String cur = leftArr[i];
            // X라면
            if (cur.contains("x")) {
                if (cur.equals("x") || cur.equals("+x")) {
                    leftXSum += 1;
                    continue;
                }
                if (cur.equals("-x")) {
                    leftXSum -= 1;
                    continue;
                }
                String xNum = cur.replace("x", "");
                leftXSum += Integer.parseInt(xNum);
            // 숫자라면
            } else {
                leftNumSum += Integer.parseInt(cur);
            }
        }

        rightXSum = 0;
        rightNumSum = 0;
        for (int i = 0; i < rightArr.length; i++) {
            String cur = rightArr[i];
            // X라면
            if (cur.contains("x")) {
                if (cur.equals("x") || cur.equals("+x")) {
                    rightXSum += 1;
                    continue;
                }
                if (cur.equals("-x")) {
                    rightXSum -= 1;
                    continue;
                }
                String xNum = cur.replace("x", "");
                rightXSum += Integer.parseInt(xNum);
            // 숫자라면
            } else {
                rightNumSum += Integer.parseInt(cur);
            }
        }

        int xSum = leftXSum - rightXSum;
        int numSum = rightNumSum - leftNumSum;

        if (xSum == 0) {
            if (numSum == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }

        int solution = numSum / xSum;
        return "x=" + solution;
    }
}